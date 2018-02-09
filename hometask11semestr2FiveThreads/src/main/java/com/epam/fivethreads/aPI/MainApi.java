package com.epam.fivethreads.aPI;

import com.epam.fivethreads.utils.jaxbadapter.model.Users;
import com.epam.fivethreads.utils.jaxbadapter.model.UsersDataReader;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Draft;
import com.google.api.services.gmail.model.Message;

import java.io.IOException;

public class MainApi {


    public static void main(String[] args) {
        UsersDataReader usersDataReader = new UsersDataReader();
        Users users = usersDataReader.getdata();
        for (int i=0; i<5; i++) {
            String currentUser = users.getUser(i).getUserLogin();
            Sender tlsSender = new Sender(currentUser, "12345aKids");
            tlsSender.send("Mail from API ", "This is my text!", "ForHometaskTest@gmail.com");
        }
    }


}
