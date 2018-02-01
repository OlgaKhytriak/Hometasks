package com.epam.objectpattern.constant;

public class Constant {
	public static final int    GLOBAL_WAIT_TIME=20;
	
	public static final String DRIVER_TYPE = "webdriver.chrome.driver";
	public static final String DRIVER_PATH = "src/main/resources/chromedriver.exe";
	public static final String WEB_SITE_URL = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
	
	public static final String USER_LOGIN = "ForHometaskTest";
	public static final String USER_PASSWORD = "12345aKids";
	
	public static final String SENT_TO = "ForHometaskTest@gmail.com";
	public static final String MESSAGE_TEXT = "Message text. Massage text";
	
	public static final String IS_LOGGED_IN_URL="https://accounts.google.com/signin/v2/sl/pwd?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward";
	
	private Constant() {}
	
}