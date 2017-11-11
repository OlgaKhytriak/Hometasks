package com.epam.lab.task6.number4.constants;

public class CommentPatterns {
	public static final String SL = "//[^\r\n]*";
	public static final String ML = "/\\*[\\s\\S]*?\\*/";
	public static final String STR_LIT = "\"(?:\\\\.|[^\\\\\"\r\n])*\"";
	public static final String CH_LIT = "'(?:\\\\.|[^\\\\'\r\n])+'";
	public static final String ANY = "[\\s\\S]";

	private CommentPatterns() {}
}
