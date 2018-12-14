package com.yasin.no3learn.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @author yangzhenkun
 * @create 2018-10-10 16:03
 */
public class FirstClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        ByteBuf byteBuf = ctx.alloc().buffer();
        byte[] data = "你好!".getBytes("utf-8");
        byte[] rd = new byte[4+data.length];
        for(int i=0;i<4;i++){
            rd[i]=0;
        }
        rd[3]=7;
        for(int i=0;i<data.length;i++){
            rd[i+4]=data[i];
        }

//        byteBuf.writeBytes(data);
        for (int i = 0; i < rd.length; i++) {

            System.out.print(rd[i]+",");
        }

        ctx.channel().writeAndFlush(rd);

        System.out.println("发送");
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;

        System.out.println("客户端收到的数据:"+buf.toString(Charset.forName("utf-8")));


    }
}
