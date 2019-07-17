package com.example.demo;

import org.json.*;

public class Survey {
	private static String Q1;
	private static String Q2;
	private static String Q3;
	private static String current_role;
	private static String department;
	private static final String DEFAULT = "default";

	public Survey() {
		this.setQ1(DEFAULT);
		this.setQ2(DEFAULT);
		this.setQ3(DEFAULT);
		this.setDepartment(DEFAULT);
		this.current_role = DEFAULT;
	}

	public Survey(String q1, String q2, String q3, String cur, String d) {
		this.setQ1(q1);
		this.setQ2(q2);
		this.setQ3(q3);
		this.setCurrent(cur);
		this.setDepartment(d);
	}

	public static String getQ1() {
		return Q1;
	}

	public static void setQ1(String q1) {
		Q1 = q1;
	}

	public static String getQ2() {
		return Q2;
	}

	public static void setQ2(String q2) {
		Q2 = q2;
	}

	public static String getQ3() {
		return Q3;
	}

	public static void setQ3(String q3) {
		Q3 = q3;
	}

	public static String getCurrent() {
		return current_role;
	}

	public static void setCurrent(String current) {
		Survey.current_role = current;
	}

	public static String getDepartment() {
		return department;
	}

	public static void setDepartment(String department) {
		Survey.department = department;
	}

}
