package com.wuguangyao.test.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * <p>TODO</p>
 *
 * @author guangyao.wu@ucarinc.com
 * @date 2019-08-24 13:59
 **/
public class ReadNio {


    public static void main(String[] args) {
        readNio();
    }


    private static void readNio() {
        String filePath = "D:\\ideaIU-2018.2.6\\code\\JDK-Test\\src\\com\\wuguangyao\\test\\nio\\zzz-test.txt";
        try {
            //1、开启文件读取流
            FileInputStream fileInputStream = new FileInputStream(filePath);

            //2、获取fileChannel
            FileChannel channel = fileInputStream.getChannel();

            //3、设置ByteBuffer大小，一次能容纳capacity字节
            int capacity = 300;
            ByteBuffer bf = ByteBuffer.allocate(capacity);

            //4、当read返回-1时，表示文件读取完毕
            int length = -1;
            while ((length = channel.read(bf)) != -1) {

                byte[] bytes = bf.array();
                System.out.println(new String(bytes, 0, length));
                //4、将bf position置为0，方便下次读取
                bf.clear();
            }
            channel.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
