package com.wuguangyao.test.netty;

import com.wuguangyao.test.netty.handler.WGYClientChannelInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public static void main(String[] args) {
        Channel clientChannel = NettyClient.connect("127.0.0.1", 8089);
        clientChannel.writeAndFlush("客户端发送的消息");
    }

    public static Channel connect(String host,int port) {
        final EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new WGYClientChannelInitializer());
        ChannelFuture future = null;
        try {
            future = bootstrap.connect(host, port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert future != null;
        future.addListener((ChannelFutureListener) f -> {
            if (f.isSuccess()) {
                System.out.println("连接服务器成功");
            } else {
                System.out.println("连接服务器失败");
                f.cause().printStackTrace();
                group.shutdownGracefully();
            }
        });
        return future.channel();
    }

}
