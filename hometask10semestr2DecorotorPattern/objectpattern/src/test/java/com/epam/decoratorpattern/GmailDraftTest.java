package com.epam.decoratorpattern;

import static com.epam.decoratorpattern.constant.Constant.MESSAGE_SENT_TO;
import static com.epam.decoratorpattern.constant.Constant.MESSAGE_SUBJECT;
import static com.epam.decoratorpattern.constant.Constant.MESSAGE_TEXT;
import static com.epam.decoratorpattern.constant.Constant.USER_LOGIN;
import static com.epam.decoratorpattern.constant.Constant.USER_PASSWORD;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.decoratorpattern.driverfactory.DriverType;
import com.epam.decoratorpattern.steps.GmailLogInBO;
import com.epam.decoratorpattern.steps.Steps;

import junit.framework.TestCase;


public class GmailDraftTest extends TestCase {
	private Steps steps;
	private GmailLogInBO gmailLogInBO;
	// Business objects
		//private final GmailLoginBO loginBO = new GmailLoginBO();
		//private final GmailSearchBO gmailSearchBO = new GmailSearchBO();

	
	@BeforeClass(description = "init browser")
	public void setUp() {
		steps = new Steps();
		gmailLogInBO = new GmailLogInBO();
		steps.initBrowser(DriverType.CHROME);
	}

	@Test
	public void draftSentLetterTest() {
		gmailLogInBO.loginGmail(USER_LOGIN, USER_PASSWORD);
		assertTrue(gmailLogInBO.isUserLoggedIn());
		steps.createDraft(MESSAGE_SENT_TO, MESSAGE_SUBJECT, MESSAGE_TEXT);
		assertTrue(steps.isMessageInDrafts(MESSAGE_TEXT));
		steps.sendMessageFromDrafts(MESSAGE_TEXT); 
		assertTrue(steps.isMessageInSent(MESSAGE_TEXT));
	}

	@AfterClass(description = "close browser")
	public void tearDownUserCanLogin() {
		steps.closeBrowser();
	}

}
