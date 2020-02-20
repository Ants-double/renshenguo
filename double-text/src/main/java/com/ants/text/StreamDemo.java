package com.ants.text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @Author lyy
 * @Description
 * @Date 2019-12-05
 **/
public class StreamDemo {
	public static void main(String[] args) {

		long currentTimeMillis = System.currentTimeMillis();

		try (FileInputStream fstream = new FileInputStream("E:\\fzwork\\报文相关\\日志信息\\TypeA TypeB\\TypeA+TypeB\\TLH.2019120316.audit.001.log")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			String strLine;

//Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				System.out.println(strLine);
			}

//Close the input stream
			fstream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		long l = System.currentTimeMillis();
		System.out.println(l - currentTimeMillis);
	}
}
