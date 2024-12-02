package com.SmartWorld.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class King {
	public static void main(String [] args ) {
		String text="janmainhuterajanhunajanbsterihijan";
		Pattern p=Pattern.compile("jan");
		Matcher m=p.matcher(text);
		int count=0;
		while(m.find()) {
			count++;
		}
		System.out.println(count);
	}

}
