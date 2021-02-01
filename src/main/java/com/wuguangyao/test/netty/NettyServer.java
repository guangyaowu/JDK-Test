package com.wuguangyao.test.netty;

import com.wuguangyao.test.netty.handler.WGYServerChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    public static void main(String[] args) {
        Channel serverChannel = NettyServer.start(8089);
    }

    public static Channel start(int port) {
        // 创建mainReactor
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // 创建工作线程组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new WGYServerChannelInitializer());
        ChannelFuture future = null;
        try {
            future = serverBootstrap.bind(port).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert future != null;
        future.addListener((ChannelFutureListener) f -> {
            if(f.isSuccess()) {
                System.out.println("Netty Server 端口["+ port + "]绑定成功!");
            } else{
                System.err.println("端口["+ port + "]绑定失败!");
                f.cause().printStackTrace();
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
        });
        return future.channel();
    }

}
