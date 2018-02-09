package com.epam.fivethreads;


import com.epam.fivethreads.businessobjects.BasicBO;
import com.epam.fivethreads.businessobjects.DraftsBO;
import com.epam.fivethreads.businessobjects.GmailLogInBO;
import com.epam.fivethreads.businessobjects.SentMailBO;
import com.epam.fivethreads.propmodel.GmailData;
import com.epam.fivethreads.utils.jaxbadapter.model.LattersDataReader;
import com.epam.fivethreads.utils.jaxbadapter.model.Letters;
import com.epam.fivethreads.utils.jaxbadapter.model.Users;
import com.epam.fivethreads.utils.jaxbadapter.model.UsersDataReader;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertTrue;


public class MultithreadGmailDraftTest {
    private BasicBO steps;
    private GmailLogInBO gmailLogInBO;
    private DraftsBO draftsBO;
    private SentMailBO sentMailBO;
    private GmailData gmailData;


    @DataProvider(parallel = true)
    public Object[][] initUsers() {
        UsersDataReader usersDataReader = new UsersDataReader();
        Users users = usersDataReader.getdata();
        LattersDataReader lattersDataReader = new LattersDataReader();
        Letters letters=lattersDataReader.getdata();

        return new Object[][]{
                {"ForHometaskTest1@gmail.com", "12345aKids"},
                {"ForHometaskTest2@gmail.com","12345aKids"},
                {"ForHometaskTest@gmail.com","12345aKids"}
        };
    }

    @Test(dataProvider = "initUsers")
    public void draftSentLetterTest(String login, String password) {
        steps = new BasicBO();
        draftsBO = new DraftsBO();
        sentMailBO = new SentMailBO();
        gmailLogInBO = new GmailLogInBO();
        gmailLogInBO.login(login, password);
        gmailData = new GmailData();
        //assertTrue(gmailLogInBO.isUserLoggedIn());
        draftsBO.createDraft(gmailData.getMessageSentTo(), gmailData.getMessageSubject(), gmailData.getMessageText());
        assertTrue(draftsBO.isMessageInDrafts(gmailData.getMessageText()));
        sentMailBO.sendMessageFromDrafts(gmailData.getMessageText());
        assertTrue(sentMailBO.isMessageInSent(gmailData.getMessageText()));
    }

    @AfterMethod(description = "close browser")
    public void tearDownUserCanLogin() {
        steps.closeBrowser();
    }



}
