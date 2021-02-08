package com.wuguangyao.test.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

public class QRCodeUtil {

    /**
     *
     * @param content 二维码内容
     * @param width 宽度 pixels
     * @param height 高度 pixels
     * @return 二维码图片的Base64编码字符串
     */
    public static String createQRCode(String content,int width,int height){
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(outputStream.toByteArray());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
