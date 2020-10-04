package javase.test.md5;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;

public class MessageDigestUtil {
	//参考资料 http://my.oschina.net/shootercn/blog/159839?fromerr=BMLZanfc
	
	/**
	 * 功能 : 获取字符串和文件的MD5值
	 * 开发：zwwang 2015-12-19 下午5:41:22
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringMD5("ab"));
		System.out.println(fileMD5("D:\\USER.sql"));
	}
	
	/**
	 * 功能 :获取字符串的MD5值
	 * 开发：zwwang 2015-12-19 下午6:56:17
	 * @param input
	 * @return
	 */
	public static String stringMD5(String input) {
		try {
			//获取MD5转换器 (如果想要SHA1值，参数换成"SHA1")
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			//输入的字符串转换为字节数组
			byte[] inputByteArray = input.getBytes();
			
			messageDigest.update(inputByteArray);
			
			//转换并返回结果，也是字节数组，包含16个元素
			byte[] resultByteArray = messageDigest.digest();
			
			//字符数组转换成字符串返回
			return byteArrayToHex(resultByteArray);
			
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 功能 : 将字节数组转换为16进制的字符串
	 * 开发：zwwang 2015-12-19 下午5:49:32
	 * @param byteArray MD5值的字节数组
	 * @return
	 */
	public static String byteArrayToHex(byte[] byteArray) {
		//首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		
		//new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制数，也就是2位十六进制字符）
		char[] resultCharArray = new char[byteArray.length*2];
		
		//遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}
		
		//字符数组组合成字符串返回
		return new String(resultCharArray);
	}
	
	/**
	 * 功能 : 获取文件的MD5值
	 * 开发：zwwang 2015-12-19 下午7:01:58
	 * @param inputFile 文件路径
	 * @return
	 */
	public static String fileMD5(String inputFile) {
		
		//缓冲区大小
		int bufferSize = 1024*1024;
		
		FileInputStream fileInputStream = null;
		
		DigestInputStream digestInputStream = null;
		
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			//使用DigestInputStream
			fileInputStream = new FileInputStream(inputFile);
			
			digestInputStream = new DigestInputStream(fileInputStream, messageDigest);
			
			//read的过程进行MDT处理，直到读完文件
			byte[] buffer = new byte[bufferSize];
			
			while (digestInputStream.read(buffer) > 0);
			
			//获取最终的MessageDigest
			messageDigest = digestInputStream.getMessageDigest();
			
			//拿到结果，也是字节数组，包含16个元素
			byte[] resultByteArray = messageDigest.digest();
			
			//把字节数组转换成字符串
			return byteArrayToHex(resultByteArray);
			
		} catch (Exception e) {
			return null;
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (digestInputStream != null) {
				try {
					digestInputStream.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
