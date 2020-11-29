package javase.test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class EncodeDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {


        String name = "a";
        char[] chaa = name.toCharArray();
        byte[] nameByte = name.getBytes();
        byte[] unicodesByte = name.getBytes("unicode");
        System.out.println(intToHex(name.toCharArray()[0]));
        byteToInteger(unicodesByte, "UNICODE");


        byteToInteger(nameByte, "默认");
        char[] nameChar = name.toCharArray();
        System.out.println(intToHex(nameChar[0]));
        charToInteger(nameChar, "默认");
//        byte[] gbkByte = name.getBytes("GBK");
//        byteToInteger(gbkByte, "GBK");
//        byte[] utf8Byte = name.getBytes("utf-8");
//        byteToInteger(utf8Byte, "UTF-8");
//        byte[] unicodesByte = name.getBytes("unicode");
//        byteToInteger(unicodesByte, "UNICODE");
//        System.out.println("end" + name.getBytes().toString());
    }

    public static void charToInteger(char[] b, String encode) {

        System.out.println("编码:"+ encode + "输出char：");
        for (char test : b) {
            System.out.println(charToInteger(test) + ":" + intToHex(charToInteger(test)));
        }
    }

    public static void byteToInteger(byte[] b, String encode) {

        System.out.println("编码:"+ encode);
        for (byte test : b) {
            System.out.println(byteToInteger(test) + ":" + intToHex(byteToInteger(test)));
        }
    }
    public static Integer byteToInteger(Byte b) {
        return 0xff & b;
    }
    public static Integer charToInteger(char b) {
        return 0xff & b;
    }

    private static String intToHex(int n) {
        StringBuffer s = new StringBuffer();
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(n != 0){
            s = s.append(b[n%16]);
            n = n/16;
        }
        a = s.reverse().toString();
        return a;
    }
}
