package com.hospital.pat.register;

class Integer1
{
	public static int m1(char b){
		switch(b){
			case '1':
				return 1;
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
			case '0':
				return 0;
			default:


		}
		return 0;
	}
	public static int parseInt(String s){
		Integer1 in=new Integer1();
		char ch[]=s.toCharArray();
		int d=0;
		for(int i=0;i<ch.length;i++){
			d=d*10;
			d=d+in.m1(ch[i]);
		}
		return d;
	}
}
 class test
 {
	 public static void main(String [] args){
		String a="123";
		
		int b=Integer1.parseInt(a);
		System.out.println(b);
	 }
 }
