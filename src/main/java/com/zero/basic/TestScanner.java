package com.zero.basic;

import java.util.Scanner;

public class TestScanner {

	public static void main(String[] args) {
		System.out.println("录入个人信息：");

		System.out.print("姓名：");
		String name = new Scanner(System.in).nextLine();

		System.out.print("性别：");
		String gender = new Scanner(System.in).nextLine();

		System.out.print("年龄：");
		int age = new Scanner(System.in).nextInt();

		System.out.println("您录入的个人信息：");
		System.out.println(name + ", " + gender + ", " + age);

	}
}
