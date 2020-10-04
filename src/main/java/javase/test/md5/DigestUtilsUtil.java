package javase.test.md5;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;

public class DigestUtilsUtil {

	/**
	 * 功能 : 获取字符串和文件的MD5值
	 * 开发：zwwang 2015-12-19 下午7:54:23
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(stringMD5("ab"));
		System.out.println(fileMD5("D:\\USER.sql"));
	}
	
	/**
	 * 功能 : 获取字符串的md5值
	 * 开发：zwwang 2015-12-19 下午7:56:53
	 * @param input
	 * @return
	 */
	public static String stringMD5(String input) {
		String md5String = DigestUtils.md5Hex(input);
		return md5String;
	}
	
	/**
	 * 功能 : 获取文件的md5值  只适合读取小文件
	 * 开发：zwwang 2015-12-19 下午8:01:09
	 * @param path
	 * @return
	 */
	public static String fileMD5(String path) {
		FileInputStream fileInputStream = null;
		String md5String = null;
		try {
			fileInputStream = new  FileInputStream(path);
			md5String = DigestUtils.md5Hex(IOUtils.toByteArray(fileInputStream));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return md5String;
	}

}
