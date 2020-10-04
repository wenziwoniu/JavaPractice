package javase.test.file.createfile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

public class FileReadWriteDemo {
	
	private static final String LINE_SEPARATE = System.getProperty("line.separator");
	
	public static void main(String[] args) {
//		fileWriteTest();
//		bufferedWriteTest();
//		fileStreamDemo();
//		bufferedFileStreamDemo();
//		readFileByChars();
		fileStreamDemo();
//		bufferedReaderTest();
//		inputReaderTest();
//		fileCopy();
		
	}
	
	/**
	 * 功能 : 读取文件中内容
	 * 开发：zwwang 2015-12-28 下午5:50:04
	 */
	public static void fileReaderTest() {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("D:\\test");
//			int ch = fileReader.read();
//			System.out.println((char) ch);
			int number = 0;
			while ((number = fileReader.read()) != -1) {
				System.out.print((char) number);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (Exception e2) {
			}
		}
	}
	
	/**
	 * 功能 : 文件中写入字符串  此种方式不推荐 效率低
	 * 开发：zwwang 2015-12-28 下午5:06:14
	 */
	public static void fileWriteTest() {
		FileWriter fileWriter = null;
		try {
			//写入内容会追加到test文件内容之后
//			fileWriter = new FileWriter("D:\\test", true);
			//写入的内容会覆盖文件已有的内容
			fileWriter = new FileWriter("D:\\test1");
			fileWriter.write("wa");
			fileWriter.write(LINE_SEPARATE);
//			fileWriter.write("z");
//			fileWriter.write(LINE_SEPARATE);
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void fileCopy() {
		FileReader fileReader = null;
		FileWriter fileWriter = null;
		try {
			fileReader = new FileReader("D:\\test1");
			fileWriter = new FileWriter("D:\\test2");
			//读一个字符，写一个字符方法
			int ch = 0;
			while ((ch = fileReader.read()) != -1) {
				System.out.println(ch);
				fileWriter.write(ch);
			}
			//读一个字符数组，写一个字符数组方法
			/*char[] buf = new char[1024];
			int len = 0;
			while ((len = fileReader.read(buf)) != -1) {
				System.out.println(len);
				fileWriter.write(buf, 0, len);
			}*/
		} catch (Exception e) {
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
				if (fileWriter != null) {
					fileWriter.close();
				}
			} catch (Exception e2) {
			}
		}
	}
	
	/**
	 * 功能 : 推荐此种方式  效率高
	 * 开发：zwwang 2015-12-28 下午5:11:24
	 */
	public static void bufferedWriteTest() {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter("E:\\test\\test"));
			bufferedWriter.write("王子文也");
			bufferedWriter.flush();
		} catch (Exception e) {
		} finally {
			try {
				if (bufferedWriter != null) {
					bufferedWriter.close();
				}
			} catch (Exception e2) {
			}
		}
	}
	
	/**
	 * 功能 : 读文件 推荐此种方式 效率高
	 * 开发：zwwang 2015-12-30 上午9:44:45
	 */
	public static void bufferedReaderTest() {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("E:\\test\\test.doc"));
			bufferedWriter = new BufferedWriter(new FileWriter("E:\\test\\test1.doc"));
		/*	int ch = 0;
			while ((ch = bufferedReader.read()) != -1) {
				System.out.println((char) ch);
			}*/
			/*int ln = 0;
			char[] buffer = new char[1024];
			while ((ln = bufferedReader.read(buffer)) != -1) {
				bufferedWriter.write(buffer, 0, ln);
				bufferedWriter.flush();
			}*/
			String lineString = bufferedReader.readLine();
			while (lineString != null) {
				System.out.println(lineString);
				lineString = bufferedReader.readLine();
			}
		} catch (Exception e) {
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedWriter != null) {
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void fileStreamDemo() {
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream("E:\\test\\test");
			outputStream = new FileOutputStream("E:\\test\\test3");
			int ch = 0;
			while ((ch = inputStream.read()) != -1) {
				System.out.println( (char) ch);
				outputStream.write(ch);
			}
			System.out.println( (char) ch);
			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
				}
			}
		}
	}
	
	public static void bufferedFileStreamDemo() {
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		try {
			bufferedInputStream = new BufferedInputStream(new FileInputStream("E:\\test\\test"));
			bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("E:\\test\\test6"));
			int len = 0;
			byte[] bytes = new byte[1024];
			while ((len = bufferedInputStream.read(bytes)) != -1) {
				bufferedOutputStream.write(bytes, 0, len);
			}
			bufferedOutputStream.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedInputStream != null) {
				try {
					bufferedInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedOutputStream != null) {
				try {
					bufferedOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void readFileByChars() {
		Reader reader = null;
		try {
			reader = new InputStreamReader(new FileInputStream("E:\\test\\test"));
			int len;
			while ((len = reader.read()) != -1) {
				System.out.println((char) len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
