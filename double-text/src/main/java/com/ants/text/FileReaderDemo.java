package com.ants.text;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author lyy
 * @Description file read text demo
 * @Date 2019-12-05
 **/
public class FileReaderDemo {
	public static void main(String[] args) throws IOException {
		long currentTimeMillis = System.currentTimeMillis();

		// pass the path to the file as a parameter
		FileReader fr =
				new FileReader("E:\\fzwork\\报文相关\\日志信息\\TypeA TypeB\\TypeA+TypeB\\TLH.2019120316.audit.001.log");

		int i;
		while ((i=fr.read()) != -1) {
			System.out.print((char) i);
		}
		long l = System.currentTimeMillis();
		System.out.println(l - currentTimeMillis);
	}
}

