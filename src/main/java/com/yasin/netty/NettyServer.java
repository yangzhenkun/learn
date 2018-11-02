package com.yasin.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

/**
 * @author yangzhenkun
 * @create 2018-10-10 16:00
 */
public class NettyServer {


    public static void main(String[] args){

        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(boss,worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline().addLast("frameDecoder",new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4));
//                        nioSocketChannel.pipeline().addLast("frameEncoder",new LengthFieldPrepender(4));
                        nioSocketChannel.pipeline().addLast("decoder",new ByteArrayDecoder());
                        nioSocketChannel.pipeline().addLast("encoder",new ByteArrayEncoder());
                        nioSocketChannel.pipeline().addLast("handler",new FirstServerHandler());
                    }
                });

        serverBootstrap.bind(8080);

    }

}
