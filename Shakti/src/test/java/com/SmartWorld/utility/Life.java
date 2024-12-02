package com.SmartWorld.utility;

public class Life {
	public static void main(String [] args) {
		int count=0;
		String s="janahaajanaieaojaneoaajan";
		int M=s.length();
		String pattern="jan";
		int N=pattern.length();
		for(int i=0; i<=M-N; i++) {
			int j=0;
			for(j=0; j<N; j++) {
				if(s.charAt(i+j)!=pattern.charAt(j)) {
					break;
				}
			}
			if(j==N) {
				count++;
				j=0;
			}
		}
		System.out.println(count);
	}

}
