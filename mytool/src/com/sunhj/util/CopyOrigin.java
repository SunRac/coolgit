package com.sunhj.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/*
 * @把文件或文件夹复制到目标文件夹下，切记IO流只能访问文件，不能访问文件夹，否则决绝访问；
 */

public class CopyOrigin {

	public static void main(String[] args) throws IOException {
		System.out.println("第一步，录入源文件或文件夹；");
		File src = getSrcFile();
		System.out.println("第二步，录入目标文件夹；");
		File dest = getDestFile();
		copyAll(src,dest);

	}

	static /*
	 * 1，如果源文件是一个文件，直接复制； 2，如果源文件是一个文件夹，遍历文件夹；
	 */
	void copyAll(File src, File dest) throws IOException {
		
		File newdest = new File(dest, src.getName());
		newdest.mkdir();
		if (src.isFile()) {
			copy(src, newdest);
		} else {
			
			File[] files = src.listFiles();
			for (File f : files) {
				copyAll(f, newdest);
			}
		}
	}

	static void copy(File src, File dest) throws IOException {

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(dest,src.getName())));
		int i;
		while ((i = bis.read()) != -1) {
			bos.write(i);
		}
		bos.close();
		bis.close();

	}

	/*
	 * 把键盘录入路径包装成File对象，并且判断是否是文件夹
	 */
	private static File getSrcFile() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("请输入想要复制的文件或文件夹路径：");
			String path = in.nextLine();
			File file = new File(path);
			if (!file.exists()) {
				System.out.println("文件不存在，请重新录入");
			} else if (file.isFile() || file.isDirectory()) {
				return file;
			}
		}
	}

	private static File getDestFile() {
		Scanner in = new Scanner(System.in);
		while (true) {
			System.out.println("请输入一个文件夹路径：");
			String path = in.nextLine();
			File file = new File(path);
			if (!file.exists()) {
				System.out.println("文件不存在，请重新录入");
			} else if (file.isFile()) {
				System.out.println("您输入的是文件，请输入一个文件夹");
			} else if (file.isDirectory()) {
				return file;
			}
		}

	}

}
