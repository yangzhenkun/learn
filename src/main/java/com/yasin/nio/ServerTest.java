package com.yasin.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

public class ServerTest {

	public static void main(String[] args) throws Exception {
		server();
	}

	public static void server() {
		ServerSocketChannel channel = null;
		try {

			Selector selector = Selector.open();
			channel = ServerSocketChannel.open();
			channel.configureBlocking(false);
			channel.socket().setReuseAddress(true);
			channel.bind(new InetSocketAddress(8020));
			channel.register(selector, SelectionKey.OP_ACCEPT, new Integer(1));

			while (true) {
				if (selector.select() > 0) {
					Set<SelectionKey> sets = selector.selectedKeys();
					Iterator<SelectionKey> keys = sets.iterator();
					while (keys.hasNext()) {
						SelectionKey key = keys.next();
						keys.remove();

						if (key.isAcceptable()) {
							key.attach(new Integer(1));
							SocketChannel schannel = ((ServerSocketChannel) key.channel()).accept();
							schannel.configureBlocking(false);
							schannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
						}

						if (key.isReadable()) {
							SocketChannel schannel = (SocketChannel) key.channel();
							ByteBuffer buf = ByteBuffer.allocate(1024);
							ByteOutputStream output = new ByteOutputStream();
							int len = 0;
							while ((len = schannel.read(buf)) != 0) {
								buf.flip();
								byte by[] = new byte[buf.remaining()];
								buf.get(by);
								output.write(by);
								buf.clear();
							}
							String str = new String(output.getBytes());
							key.attach(str);
						}

						if (key.isWritable()) {

							Object object = key.attachment();
							String attach = object != null ? "server replay: " + object.toString() : "server replay: ";
							SocketChannel schannel = (SocketChannel) key.channel();
							schannel.write(ByteBuffer.wrap(attach.getBytes()));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (channel != null) {
				try {
					channel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
