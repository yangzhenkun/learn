package com.yasin.no3learn.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

/**
 * @author yangzhenkun
 * @create 2018-10-10 15:56
 */
public class NettyClient {


    public static void main(String[] args){

        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(workerGroup)
                .channel(NioSocketChannel.class)

                .handler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4 ));
                        socketChannel.pipeline().addLast("frameEncoder",new LengthFieldPrepender(4));
                        socketChannel.pipeline().addLast("decoder",new ByteArrayDecoder());
                        socketChannel.pipeline().addLast("encoder",new ByteArrayEncoder());
                        socketChannel.pipeline().addLast("handler",new FirstClientHandler());
                    }
                });


        bootstrap.connect("127.0.0.1",8080);

    }


}
