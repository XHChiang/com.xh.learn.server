package com.xh.learn.sdk.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileUtil {

	/**
	 * 获取项目路径
	 * 
	 * @return
	 * @throws IOException
	 */
	public static String getCanonicalPath() throws IOException {
		File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();
		return courseFile;
	}

	/**
	 * 复制文件
	 * 
	 * @param srcFile
	 * @param destFile
	 */
	public static void copyFile(File srcFile, File destFile) {
		FileInputStream ins = null;
		FileOutputStream out = null;
		try {
			ins = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);

			byte[] b = new byte[1024];
			int n = 0;
			while ((n = ins.read(b)) != -1) {
				out.write(b, 0, n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 读取JSON格式文件
	 * 
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public static String readJsonFile(String filePath, String fileName) {
		// 拼接文件完整路径
		String fullPath = filePath + File.separator + fileName + ".json";

		BufferedReader reader = null;
		FileInputStream fileInputStream = null;
		InputStreamReader inputStreamReader = null;

		StringBuffer laststr = new StringBuffer();
		try {
			fileInputStream = new FileInputStream(fullPath);
			inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);

			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				laststr.append(tempString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStreamReader != null) {
				try {
					inputStreamReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return laststr.toString();
	}

	/**
	 * 生成JSON格式文件
	 * 
	 * @param text
	 * @param filePath
	 * @param fileName
	 * @return
	 */
	public static boolean createJsonFile(String text, String filePath, String fileName) {
		// 标记文件生成是否成功
		boolean flag = true;

		// 拼接文件完整路径
		String fullPath = filePath + File.separator + fileName + ".json";

		// 生成json格式文件
		try {
			// 保证创建一个新文件
			File file = new File(fullPath);
			if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
				file.getParentFile().mkdirs();
			}
			if (file.exists()) { // 如果已存在,删除旧文件
				file.delete();
			}
			file.createNewFile();

			// 格式化json字符串
			text = StringUtil.formatJson(text);

			// 将格式化后的字符串写入文件
			Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
			write.write(text);
			write.flush();
			write.close();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}

		// 返回是否成功的标记
		return flag;
	}

	public static void renameFile(File file) {
		boolean exists = file.exists();
		if (exists) {
			File[] listFiles = file.listFiles();
			for (File fitem : listFiles) {
				String newname = fitem.getName();

				String parent = fitem.getParent();
				fitem.renameTo(new File(parent + File.separator + newname));
			}
		}
	}

	public static void renameFile(String filePath) {
		renameFile(new File(filePath));
	}

	public static void main(String[] args) {
		renameFile("D:/C_TEMP/PART2/PART2");
	}
}
