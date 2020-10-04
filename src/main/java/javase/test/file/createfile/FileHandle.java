package javase.test.file.createfile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

public class FileHandle {
	
	public static final int STREAM_BUFFER_LENGTH = 1024;

	/*public static String getFileMd51(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		String md5 = DigestUtils.md5Hex(IOUtils.toByteArray(fis));
		IOUtils.closeQuietly(fis);
		return md5;
	}*/
	
	/**
	 * 功能：获取文件的MD5值
	 * 开发：v_wbzwwang 2015年10月15日 上午11:21:50
	 * @param path
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 * @throws Exception
	 */
	public static String getFileMd5(String path) throws IOException{
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(path);
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] resultByteArray = digest(messageDigest, inputStream);
			return byteArrayToHex(resultByteArray);
		} catch (Exception e) {
			return null;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	
	private static byte[] digest(MessageDigest digest, InputStream data) throws IOException {
		byte[] buffer = new byte[STREAM_BUFFER_LENGTH];
		int read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);
		while (read > -1) {
			digest.update(buffer, 0, read);
			read = data.read(buffer, 0, STREAM_BUFFER_LENGTH);
		}
		return digest.digest();
	}
	
	/**
	 * 功能：字节数组转换为十六进制32位的字符串
	 * 开发：v_wbzwwang 2015年10月15日 上午11:20:27
	 * @param byteArray
	 * @return
	 */
	public static String byteArrayToHex(byte[] byteArray) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','a', 'b', 'c', 'd', 'e', 'f' };
		// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
		char[] resultCharArray = new char[byteArray.length * 2];
		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}
		// 字符数组组合成字符串返回
		return new String(resultCharArray);
	}


	public static String getStrMd5(String context) {
		String md5Str = DigestUtils.md5Hex(context);
		return md5Str;
	}

	public static void writeKeyToFile(String fileName, String content) throws IOException {
		FileOutputStream fos = new FileOutputStream(fileName);
		FileChannel outChannel = fos.getChannel();

		outChannel.write(ByteBuffer.wrap(content.getBytes()));
		fos.close();
	}

	public static String readKeyFromFile(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String s = br.readLine();
		br.close();
		return s;
	}

	public static boolean verifyFile(String dataFileName, String keyFileName, String signKey) throws Exception {
		// 读取验证文件内容
		String verifyKey = readKeyFromFile(keyFileName);
		if (verifyKey == null) {
			return false;
		}

		// 计算key
		String fileMd5 = getFileMd5(dataFileName);
		String acturalkey = getStrMd5(fileMd5 + signKey);

		// 验证
		if (!verifyKey.equals(acturalkey)) {
			return false;
		}

		return true;
	}


}
