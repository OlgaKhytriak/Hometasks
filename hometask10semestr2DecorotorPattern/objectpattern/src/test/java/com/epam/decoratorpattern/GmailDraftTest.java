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
import com.epam.decoratorpattern.steps.SentMailBO;
import com.epam.decoratorpattern.steps.BasicBO;
import com.epam.decoratorpattern.steps.DraftsBO;

import junit.framework.TestCase;


public class GmailDraftTest extends TestCase {
	private BasicBO steps;
	private  GmailLogInBO gmailLogInBO;
	private  DraftsBO draftsBO;
	private SentMailBO sentMailBO;
	// Business objects
		//private final GmailLoginBO loginBO = new GmailLoginBO();
		//private final GmailSearchBO gmailSearchBO = new GmailSearchBO();

	
	@BeforeClass(description = "init browser")
	public void setUp() {
		steps = new BasicBO();
		gmailLogInBO = new GmailLogInBO();
		draftsBO=new DraftsBO();
		sentMailBO=new SentMailBO();
		steps.initBrowser(DriverType.CHROME);
	}

	@Test
	public void draftSentLetterTest() {
		gmailLogInBO.login(USER_LOGIN, USER_PASSWORD);
		assertTrue(gmailLogInBO.isUserLoggedIn());
		draftsBO.createDraft(MESSAGE_SENT_TO, MESSAGE_SUBJECT, MESSAGE_TEXT);
		assertTrue(draftsBO.isMessageInDrafts(MESSAGE_TEXT));
		sentMailBO.sendMessageFromDrafts(MESSAGE_TEXT); 
		assertTrue(sentMailBO.isMessageInSent(MESSAGE_TEXT));
	}

	@AfterClass(description = "close browser")
	public void tearDownUserCanLogin() {
		steps.closeBrowser();
	}

}
