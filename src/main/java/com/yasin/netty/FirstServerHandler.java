package com.yasin.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @author yangzhenkun
 * @create 2018-10-10 16:26
 */
public class FirstServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        byte[] recevieData = (byte[]) msg;

//        ByteBuf buf = (ByteBuf) msg;

//        byte[] recevieData = buf.array();

        for(byte r:recevieData){
            System.out.print(r);
            System.out.print(",");
        }





//        ctx.channel().writeAndFlush();

    }
}
