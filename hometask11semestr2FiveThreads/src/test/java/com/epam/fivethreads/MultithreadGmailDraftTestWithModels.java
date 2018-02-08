package com.epam.fivethreads;


import com.epam.fivethreads.businessobjects.DraftsBO;
import com.epam.fivethreads.businessobjects.GmailLogInBO;
import com.epam.fivethreads.businessobjects.SentMailBO;
import com.epam.fivethreads.propmodel.GmailData;
import com.epam.fivethreads.utils.jaxbadapter.model.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class MultithreadGmailDraftTestWithModels {

    private GmailLogInBO gmailLogInBO;
    private DraftsBO draftsBO;
    private SentMailBO sentMailBO;


    @DataProvider(parallel = true)
    public Object[][] initUsers() {
        UsersDataReader usersDataReader = new UsersDataReader();
        Users users = usersDataReader.getdata();
        LattersDataReader lattersDataReader = new LattersDataReader();
        Letters letters = lattersDataReader.getdata();

        return new Object[][]{
                {users.getUser(0), letters.getLetter(0)},
                {users.getUser(1), letters.getLetter(1)},
                {users.getUser(2), letters.getLetter(2)},
                {users.getUser(3), letters.getLetter(3)},
                {users.getUser(4), letters.getLetter(4)}
        };
    }

    @Test(dataProvider = "initUsers")
    public void draftSentLetterTest(User user, Letter letter) {

        draftsBO = new DraftsBO();
        sentMailBO = new SentMailBO();
        gmailLogInBO = new GmailLogInBO();

        gmailLogInBO.login(user.getUserLogin(), user.getUserPassword());
        assertTrue(gmailLogInBO.isUserLoggedIn());

        draftsBO.createDraft(letter.getSentTo(), letter.getMessageSubject(), letter.getMessageText());
        //assertTrue(draftsBO.isMessageInDrafts(letter.getMessageText()));

        sentMailBO.sendMessageFromDrafts(letter.getMessageText());
        assertTrue(sentMailBO.isMessageInSent(letter.getMessageText()));
    }

    @AfterMethod(description = "close browser")
    public void tearDownUserCanLogin() {

    }


}
