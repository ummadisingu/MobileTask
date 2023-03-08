package com.mobileProgramming.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
	
	public static void main(String[] args) throws Throwable {
		
		List<String> data1 = new ArrayList<String>();
		data1.add("hello");
		data1.add("wel");
		List<String> data2 = new ArrayList<String>() ;
		File f=new File(System.getProperty("user.dir")+"//Output//Output.txt");
		BufferedWriter f1 = new BufferedWriter(new FileWriter(f, true));
		for (String s : data1) {
			f1.write(s);
			f1.newLine();
			
		}
		f1.close();
		
		
	}

}
