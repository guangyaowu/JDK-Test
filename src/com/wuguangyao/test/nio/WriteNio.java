package com.wuguangyao.test.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>TODO</p>
 *
 * @author guangyao.wu@ucarinc.com
 * @date 2019-08-24 14:01
 **/
public class WriteNio {


    public static void main(String[] args) {
        writeNio();
    }


    private static void writeNio() {
        String filePath = "D:\\ideaIU-2018.2.6\\code\\JDK-Test\\src\\com\\wuguangyao\\test\\nio\\zzz-test.txt";
        try {
            //1、打开文件写入流
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);

            //2、获取fileChannel
            FileChannel channel = fileOutputStream.getChannel();

            //3、初始化byteBuffer
            String str = "写入文件测试";
            ByteBuffer bf = ByteBuffer.allocate(1024);

            //4、将bf position置为0，方便下次读取
            bf.clear();


            //5、从byteBuffer的position位置填充byte
            bf.put(str.getBytes());

            //6、将bf position置为0，limit设置为position避免写入内容过多
            bf.flip();

            int length = 0;

            //7、如果position小于limit即未写入完毕
            while (bf.hasRemaining()) {
                //8、将buffer内容写入channel
                channel.write(bf);
                System.out.println(bf);
            }
            channel.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
