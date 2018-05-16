package edu.orangecoastcollege.cs272.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.orangecoastcollege.cs272.model.DBModel;
import edu.orangecoastcollege.cs272.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller
{
    private static Controller theOne;

    private static final String DB_NAME = "User_Info";

    private static final String USER_TABLE_NAME = "user";
    private static final String[] USER_FIELD_NAMES = { "_id", "name", "email", "password" };
    private static final String[] USER_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT" };


    private User mCurrentUser;

    private DBModel mUserDB;
    private ObservableList<User> mAllUsersList;


    public static Controller getInstance()
    {
        if (theOne == null)
        {
            theOne = new Controller();
            theOne.mAllUsersList = FXCollections.observableArrayList();

            try
            {
                theOne.mUserDB = new DBModel(DB_NAME, USER_TABLE_NAME, USER_FIELD_NAMES, USER_FIELD_TYPES);
                ArrayList<ArrayList<String>> resultsList = theOne.mUserDB.getAllRecords();
                for (ArrayList<String> values : resultsList)
                {
                    int id = Integer.parseInt(values.get(0));
                    String name = values.get(1);
                    String email = values.get(2);
                    theOne.mAllUsersList.add(new User(id, name, email));
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return theOne;
    }

    public String signInUser(String iD, String password)
    {
        for (User u : theOne.mAllUsersList)
        {
            if (u.getEmail().equalsIgnoreCase(iD))
            {
                //retrieve password:
                try
                {
                    ArrayList<ArrayList<String>> userResults = theOne.mUserDB.getRecord(String.valueOf(u.getId()));
                    String storedPassword = userResults.get(0).get(4);
                    // Check the passwords
                    if (password.equals(storedPassword))
                    {
                        mCurrentUser = u;
                        return "SUCCESS";
                    }
                    else
                        break;

                }
                catch (SQLException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return "Incorrect ID and/or password.  Please try again.";
    }
    public boolean isValidPassword(String password)
    {
        // Valid password must contain (see regex below):
        // At least one digit
        // At least one lower case letter
        // At least one upper case letter
        // At least one special character !@#$%^&*()_+\-=[]{};':"\|,.<>/?
        // At least 8 characters long, but no more than 16
        return password.matches(
                "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\\\|,.<>\\/?]).{8,16}$");
    }
    public boolean isValidEmail(String email)
    {
        return email.matches(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }
    public String signUpUser(String name, String email, String password)
    {
        // Check email to see if valid
        if (!isValidEmail(email)) return "Email address not valid.  Please try different address.";

        // Check to see if email is already used
        // Loop through all users list
        for (User u : theOne.mAllUsersList)
            if (email.equalsIgnoreCase(u.getEmail()))
                return "Email address already used.  Please sign in or use different address.";

        // Check password to see if valid
        // if (!isValidPassword(password))
        // return "Password must be at least 8 characters, including 1 upper
        // case letter, 1 number and 1 symbol.";

        // Made it through all the checks, create the new user in the database
        String[] values = { name, email, "user", password };
        // Insert the new user into the database
        try
        {
            // Store the new id
            int id = theOne.mUserDB.createRecord(Arrays.copyOfRange(USER_FIELD_NAMES, 1, USER_FIELD_NAMES.length),
                    values);
            // Save the new user as the current user
            theOne.mCurrentUser = new User(id, name, email);
            // Add the new user to the observable list
            theOne.mAllUsersList.add(theOne.mCurrentUser);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return "Error creating user, please try again.";
        }

        return "SUCCESS";
    }
}