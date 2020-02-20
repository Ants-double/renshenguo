package com.ants.text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @Author lyy
 * @Description buffer reader text
 * @Date 2019-12-05
 **/
public class BufferReaderDemo {

	public static void main(String[] args) throws IOException {
		long currentTimeMillis = System.currentTimeMillis();
		File file = new File("E:\\fzwork\\报文相关\\日志信息\\TypeA TypeB\\TypeA+TypeB\\TLH.2019120316.audit.001.log");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while ((st = br.readLine()) != null) {
			System.out.println(st);
		}
		long l = System.currentTimeMillis();
		System.out.println(l - currentTimeMillis);
	}
}


