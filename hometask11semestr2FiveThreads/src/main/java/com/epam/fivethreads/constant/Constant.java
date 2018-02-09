package com.epam.fivethreads.constant;

public class Constant {
	public static final int GLOBAL_WAIT_TIME = 10;
	public static final int ALERT_WAIT_TIME = 3;

	public static final String CHROME_DRIVER_TYPE = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_PATH = "src/main/resources/chromedriver.exe";

	public static final String FIREFOX_DRIVER_TYPE = "webdriver.chrome.driver"; // !!! cHANGE
	public static final String FIREFOX_DRIVER_PATH = "src/main/resources/chromedriver.exe"; // !!! cHANGE

	public static final String IS_LOGGED_IN_URL = "https://accounts.google.com/signin/v2/sl/pwd?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward";

	public static final String INBOX_URL = "https://mail.google.com/mail/#inbox";
	public static final String DRAFTS_URL = "https://mail.google.com/mail/u/0/#drafts";
	public static final String SENTED_URL ="https://mail.google.com/mail/u/0/#sent";

	public static final String USERS_XML_FILE_PATH= "src/main/resources/users.xml";
	public static final String LETTERS_XML_FILE_PATH= "src/main/resources/letters.xml";
	private Constant() {
	}
}
