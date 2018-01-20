package com.sunhj.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SuperCopy {
	/*
	 * 把给定文件夹子下的文件以及子文件夹下的所有文件都复制到目标路径 1，键盘录入，源目录和目标路径； 2，判断给定的路径是否是文件夹
	 * 3，遍历文件夹中的文件，是文件直接复制，是文件夹递归
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("先录入目标文件所在的文件夹");
		File src = getFile();
		System.out.println("接下来录入您想把文件复制到哪个文件夹");
		File dest = getFile();
		copy(src, dest);
	}

	private static void copy(File src, File dest) throws IOException {
		File[] filearr = src.listFiles();
		for (File f : filearr) {
			if (f.isFile()) {
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(dest, f.getName())));
				// new FileOutputStream(dest)拒绝访问，因为Io流只针对文件，不能访问文件目录
				int b;
				while ((b = bis.read()) != -1) {
					bos.write(b);
				}
				bos.close();
				bis.close();
			} else {
				copy(f, dest);
			}
		}
	}

	/*
	 * 把键盘录入路径包装成File对象，并且判断是否是文件夹
	 */
	private static File getFile() {
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
