package com.yasin.no3learn.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

/**
 * @author yangzhenkun
 * @create 2018-10-10 17:41
 */
public class SecondServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        ByteBuf buf = (ByteBuf) msg;
        String data = buf.toString(Charset.forName("utf-8"))+"经过加工的";
        buf.clear();
        buf.writeBytes(data.getBytes());
        ctx.fireChannelRead(buf);

//        super.channelRead(ctx,msg);
    }

}
