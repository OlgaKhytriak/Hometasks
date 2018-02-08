package com.epam.fivethreads;


import com.epam.fivethreads.businessobjects.DraftsBO;
import com.epam.fivethreads.businessobjects.GmailLogInBO;
import com.epam.fivethreads.businessobjects.SentMailBO;
import com.epam.fivethreads.propmodel.GmailData;
import com.epam.fivethreads.utils.jaxbadapter.model.LattersDataReader;
import com.epam.fivethreads.utils.jaxbadapter.model.UsersDataReader;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertTrue;


public class GmailDraftTest {

    private GmailLogInBO gmailLogInBO;
    private DraftsBO draftsBO;
    private SentMailBO sentMailBO;
    private GmailData gmailData;

  @BeforeMethod(description = "init browser")
    public void setUp() {
        gmailLogInBO = new GmailLogInBO();
        draftsBO = new DraftsBO();
        sentMailBO = new SentMailBO();
        gmailData = new GmailData();
      //CreaterXMLDataFiles createrXML = new CreaterXMLDataFiles();
      //createrXML.createUsersXML();
      //createrXML.createLettersXML();
      LattersDataReader lattersDataReader = new LattersDataReader();
      lattersDataReader.getdata();
      UsersDataReader usersDataReader = new UsersDataReader();
      usersDataReader.getdata();
    }

    @Test
    public void draftSentLetterTest() {
        gmailLogInBO.login(gmailData.getUserLogin(), gmailData.getUserPassword());
        //assertTrue(gmailLogInBO.isUserLoggedIn());
        draftsBO.createDraft(gmailData.getMessageSentTo(), gmailData.getMessageSubject(), gmailData.getMessageText());
        assertTrue(draftsBO.isMessageInDrafts(gmailData.getMessageText()));
        sentMailBO.sendMessageFromDrafts(gmailData.getMessageText());
        assertTrue(sentMailBO.isMessageInSent(gmailData.getMessageText()));
    }

    @AfterClass(description = "close browser")
    public void tearDownUserCanLogin() {

    }
}
