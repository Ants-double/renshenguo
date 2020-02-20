package com.ants.text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author lyy
 * @Description scaner text demo
 * @Date 2019-12-05
 **/
public class ScannerDemo {
	public static void main(String[] args) throws FileNotFoundException {
		long currentTimeMillis = System.currentTimeMillis();

		File file =
				new File("E:\\fzwork\\报文相关\\日志信息\\TypeA TypeB\\TypeA+TypeB\\TLH.2019120316.audit.001.log");
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		long l = System.currentTimeMillis();
		System.out.println(l - currentTimeMillis);
	}
}
