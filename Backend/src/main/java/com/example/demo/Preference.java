package com.example.demo;

import org.json.*;

public class Preference {
	private static Job job1;
	private static Job job2;
	private static Job job3;
	private static String reason;
	private static String notes;

	public Preference() {
		job1 = new Job();
		job2 = new Job();
		job3 = new Job();
		this.setReason("default");
		this.setNotes("default");
	}

	public Preference(Job a, Job b, Job c, String one, String n) {
		this.setJob1(a);
		this.setJob2(b);
		this.setJob3(b);
		this.setNotes(n);
		this.setReason(one);
	}

	public static Job getJob1() {
		return job1;
	}

	public static void setJob1(Job job1) {
		Preference.job1 = job1;
	}

	public static Job getJob2() {
		return job2;
	}

	public static void setJob2(Job job2) {
		Preference.job2 = job2;
	}

	public static Job getJob3() {
		return job3;
	}

	public static void setJob3(Job job3) {
		Preference.job3 = job3;
	}

	public static String getReason() {
		return reason;
	}

	public static void setReason(String reason1) {
		Preference.reason = reason1;
	}

	public static String getNotes() {
		return notes;
	}

	public static void setNotes(String notes) {
		Preference.notes = notes;
	}

}
