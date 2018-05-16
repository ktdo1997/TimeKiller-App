package edu.orangecoastcollege.cs272.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.orangecoastcollege.cs272.model.DBModel;
import edu.orangecoastcollege.cs272.model.User;
import edu.orangecoastcollege.cs272.view.MathScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller
{
    private static Controller theOne;

    private static final String DB_NAME = "User_Info";

    private static final String USER_TABLE_NAME = "user";
    private static final String[] USER_FIELD_NAMES = { "_id", "name", "email", "password" };
    private static final String[] USER_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT" };

    private static final String MATH_QUIZ_TABLE_NAME ="math_quiz";
    private static final String[] MATH_QUIZ_FIELD_NAMES = { "_id", "question", "choice_a", "choice_b", "choice_c", "choice_d", "answer"};
    private static final String[] MATH_QUIZ_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"};
    private static final String MATH_QUIZ_DATA_FILE = "math.csv";

    private static final String GUESSING_QUIZ_TABLE_NAME ="guessing_quiz";
    private static final String[] GUESSING_QUIZ_FIELD_NAMES = { "_id", "question", "choice_a", "choice_b", "choice_c", "choice_d", "answer"};
    private static final String[] GUESSING_QUIZ_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"};
    private static final String GUESSING_QUIZ_DATA_FILE = "guessing.csv";

    private User mCurrentUser;

    private DBModel mUserDB;
    private DBModel mMathQuizDB;
    private DBModel mGuessingQuizDB;

    private ObservableList<User> mAllUsersList;
    private ObservableList<MathScene> mAllMathQuizList;


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
                    String userName = values.get(1);
                    String email = values.get(2);
                    String password = values.get(3);
                    theOne.mAllUsersList.add(new User(id,userName,email,password));
                }
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return theOne;
    }

    public String signInUser(String userName, String password)
    {
        for (User u : theOne.mAllUsersList)
        {
            if (u.getUserName().equalsIgnoreCase(userName))
            {
                //retrieve password:
                try
                {
                    ArrayList<ArrayList<String>> userResults = theOne.mUserDB.getRecord(String.valueOf(u.getID()));
                    String storedPassword = userResults.get(0).get(3);
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

    public String signUpUser(String userName, String email, String password)
    {
        // Check email to see if valid
        if (!isValidEmail(email)) return "Email address not valid.  Please try different address.";

        // Check to see if email is already used
        // Loop through all users list
        for (User u : theOne.mAllUsersList)
            if (email.equalsIgnoreCase(u.getEmail()))
                return "Email address already used.  Please sign in or use different address.";


        String[] values = {userName, email, password };
        // Insert the new user into the database
        try
        {
            // Store the new id
            int id = theOne.mUserDB.createRecord(Arrays.copyOfRange(USER_FIELD_NAMES, 1, USER_FIELD_NAMES.length),
                    values);
            // Save the new user as the current user
            theOne.mCurrentUser = new User(id,userName, email, password);
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
    public ObservableList<MathScene> getGamesForCurrentUser()
    {
        ObservableList<MathScene> userGamesList = FXCollections.observableArrayList();
        //TODO: Implement this method
        // 1) With the user_games table (mUserGamesDB), get the records that match the current user's (mCurrentUser) id
        // Note: the records returned will only contain the user_id and game_id (both ints)
        try
        {
            //Fix getId
            ArrayList<ArrayList<String>> resultsList = theOne.mMathQuizDB.getRecord(String.valueOf(theOne.mCurrentUser.getId()));
            // Loop through the results
            int gameId;
            for (ArrayList<String> values : resultsList)
            {
                gameId = Integer.parseInt(values.get(1));
                // Loop through all the games, try to find a match
                for (MathScene vg : theOne.mAllMathQuizList)
                {
                    if(gameId == vg.getId())
                    {
                        userGamesList.add(vg);
                        break;
                    }
                }
            }

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


        // Loop through the all games list (mAllGamesList).  If any game in the list matches the game id, then:
        // 2) Add the matching game to the user games list
        // 3) Return the user games list.
        return userGamesList;
    }
}
