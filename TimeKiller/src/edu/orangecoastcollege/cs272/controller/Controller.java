package edu.orangecoastcollege.cs272.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.orangecoastcollege.cs272.model.DBModel;
import edu.orangecoastcollege.cs272.model.Quiz;
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
    //MATH QUIZ DB
    private static final String MATH_QUIZ_EASY_TABLE_NAME ="math_easy_quiz";
    private static final String[] MATH_QUIZ_EASY_FIELD_NAMES = { "_id", "question", "choice_a", "choice_b", "choice_c", "choice_d", "answer"};
    private static final String[] MATH_QUIZ_EASY_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"};
    private static final String MATH_QUIZ_EASY_DATA_FILE = "MathEasy.csv";

    private static final String MATH_QUIZ_NORMAL_TABLE_NAME ="math_normal_quiz";
    private static final String[] MATH_QUIZ_NORMAL_FIELD_NAMES = { "_id", "question", "choice_a", "choice_b", "choice_c", "choice_d", "answer"};
    private static final String[] MATH_QUIZ_NORMAL_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"};
    private static final String MATH_QUIZ_NORMAL_DATA_FILE = "MathNormal.csv";

    private static final String MATH_QUIZ_HARD_TABLE_NAME ="math_hard_quiz";
    private static final String[] MATH_QUIZ_HARD_FIELD_NAMES = { "_id", "question", "choice_a", "choice_b", "choice_c", "choice_d", "answer"};
    private static final String[] MATH_QUIZ_HARD_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"};
    private static final String MATH_QUIZ_HARD_DATA_FILE = "MathHard.csv";
    //end of MATH QUIZ DB
    //GAME QUIZ DB
    private static final String GAME_QUIZ_EASY_TABLE_NAME ="game_quiz_easy";
    private static final String[] GAME_QUIZ_EASY_FIELD_NAMES = { "_id", "question", "choice_a", "choice_b", "choice_c", "choice_d", "answer"};
    private static final String[] GAME_QUIZ_EASY_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"};
    private static final String GAME_QUIZ_EASY_DATA_FILE = "GameQuizEasy.csv";

    private static final String GAME_QUIZ_NORMAL_TABLE_NAME ="game_quiz_normal";
    private static final String[] GAME_QUIZ_NORMAL_FIELD_NAMES = { "_id", "question", "choice_a", "choice_b", "choice_c", "choice_d", "answer"};
    private static final String[] GAME_QUIZ_NORMAL_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"};
    private static final String GAME_QUIZ_NORMAL_DATA_FILE = "GameQuiznORMAL.csv";

    private static final String GAME_QUIZ_HARD_TABLE_NAME ="game_quiz_hard";
    private static final String[] GAME_QUIZ_HARD_FIELD_NAMES = { "_id", "question", "choice_a", "choice_b", "choice_c", "choice_d", "answer"};
    private static final String[] GAME_QUIZ_HARD_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"};
    private static final String GAME_QUIZ_HARD_DATA_FILE = "GameQuizHard.csv";
    //end of GAME QUIZ DB
    //RANDOM QUIZ DB
    private static final String RANDOM_QUIZ_TABLE_NAME ="random_quiz";
    private static final String[] RANDOM_QUIZ_FIELD_NAMES = { "_id", "question", "choice_a", "choice_b", "choice_c", "choice_d", "answer"};
    private static final String[] RANDOM_QUIZ_FIELD_TYPES = { "INTEGER PRIMARY KEY", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT", "TEXT"};
    private static final String RANDOM_QUIZ_DATA_FILE = "Random.csv";
    private User mCurrentUser;
    //end of    RANDOM QUIZ DB

    private DBModel mUserDB;
    private DBModel mGameQuizDB;
    private DBModel mMathQuizDB;
    private DBModel mRandomQuizDB;

    private ObservableList<User> mAllUsersList;
    private ObservableList<Quiz> mAllQuizList;

	private Controller() {
	}

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

                // Math quiz easy
				theOne.mMathQuizDB = new DBModel(DB_NAME, MATH_QUIZ_EASY_TABLE_NAME, MATH_QUIZ_EASY_FIELD_NAMES, MATH_QUIZ_EASY_FIELD_TYPES);
				theOne.initializeEasyMathDBFromFile();
				resultsList = theOne.mMathQuizDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String question = values.get(0);
					String choiceA = values.get(1);
					String choiceB = values.get(2);
					String choiceC = values.get(3);
					String choiceD = values.get(4);
					String correct = values.get(5);
					theOne.mAllQuizList.add(new Quiz(id, question, choiceA, choiceB, choiceC, choiceD, correct));
				}

				// Math quiz normal
				theOne.mMathQuizDB = new DBModel(DB_NAME, MATH_QUIZ_NORMAL_TABLE_NAME, MATH_QUIZ_NORMAL_FIELD_NAMES, MATH_QUIZ_NORMAL_FIELD_TYPES);
				theOne.initializeNormalMathDBFromFile();
				resultsList = theOne.mMathQuizDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String question = values.get(0);
					String choiceA = values.get(1);
					String choiceB = values.get(2);
					String choiceC = values.get(3);
					String choiceD = values.get(4);
					String correct = values.get(5);
					theOne.mAllQuizList.add(new Quiz(id, question, choiceA, choiceB, choiceC, choiceD, correct));
				}

				// Math quiz hard
				theOne.mMathQuizDB = new DBModel(DB_NAME, MATH_QUIZ_HARD_TABLE_NAME, MATH_QUIZ_HARD_FIELD_NAMES, MATH_QUIZ_HARD_FIELD_TYPES);
				theOne.initializeHardMathDBFromFile();
				resultsList = theOne.mMathQuizDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String question = values.get(0);
					String choiceA = values.get(1);
					String choiceB = values.get(2);
					String choiceC = values.get(3);
					String choiceD = values.get(4);
					String correct = values.get(5);
					theOne.mAllQuizList.add(new Quiz(id, question, choiceA, choiceB, choiceC, choiceD, correct));
				}

				// Game quiz easy
				theOne.mGameQuizDB = new DBModel(DB_NAME, GAME_QUIZ_EASY_TABLE_NAME, GAME_QUIZ_EASY_FIELD_NAMES, GAME_QUIZ_EASY_FIELD_TYPES);
				theOne.initializeEasyGameDBFromFile();
				resultsList = theOne.mGameQuizDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String question = values.get(0);
					String choiceA = values.get(1);
					String choiceB = values.get(2);
					String choiceC = values.get(3);
					String choiceD = values.get(4);
					String correct = values.get(5);
					theOne.mAllQuizList.add(new Quiz(id, question, choiceA, choiceB, choiceC, choiceD, correct));
				}

				// Game quiz normal
				theOne.mGameQuizDB = new DBModel(DB_NAME, GAME_QUIZ_NORMAL_TABLE_NAME, GAME_QUIZ_NORMAL_FIELD_NAMES, GAME_QUIZ_NORMAL_FIELD_TYPES);
				theOne.initializeNormalGameDBFromFile();
				resultsList = theOne.mGameQuizDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String question = values.get(0);
					String choiceA = values.get(1);
					String choiceB = values.get(2);
					String choiceC = values.get(3);
					String choiceD = values.get(4);
					String correct = values.get(5);
					theOne.mAllQuizList.add(new Quiz(id, question, choiceA, choiceB, choiceC, choiceD, correct));
				}

				// Game quiz hard
				theOne.mGameQuizDB = new DBModel(DB_NAME, GAME_QUIZ_HARD_TABLE_NAME, GAME_QUIZ_HARD_FIELD_NAMES, GAME_QUIZ_HARD_FIELD_TYPES);
				theOne.initializeHardGameDBFromFile();
				resultsList = theOne.mGameQuizDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String question = values.get(0);
					String choiceA = values.get(1);
					String choiceB = values.get(2);
					String choiceC = values.get(3);
					String choiceD = values.get(4);
					String correct = values.get(5);
					theOne.mAllQuizList.add(new Quiz(id, question, choiceA, choiceB, choiceC, choiceD, correct));
				}

				// Random quiz
				theOne.mRandomQuizDB = new DBModel(DB_NAME, RANDOM_QUIZ_TABLE_NAME, RANDOM_QUIZ_FIELD_NAMES, RANDOM_QUIZ_FIELD_TYPES);
				theOne.initializeRandomQuizDBFromFile();
				resultsList = theOne.mRandomQuizDB.getAllRecords();
				for (ArrayList<String> values : resultsList)
				{
					int id = Integer.parseInt(values.get(0));
					String question = values.get(0);
					String choiceA = values.get(1);
					String choiceB = values.get(2);
					String choiceC = values.get(3);
					String choiceD = values.get(4);
					String correct = values.get(5);
					theOne.mAllQuizList.add(new Quiz(id, question, choiceA, choiceB, choiceC, choiceD, correct));
				}
				theOne.mUserDB= new DBModel(DB_NAME, USER_TABLE_NAME, USER_FIELD_NAMES, USER_FIELD_TYPES);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return theOne;
    }

 // Random quiz DB From File
    private int initializeRandomQuizDBFromFile() throws SQLException{
		int recordsCreated = 0;

		if (theOne.mUserDB.getRecordCount() > 0)
			return 0;

		try {
			Scanner fileScanner = new Scanner(new File(RANDOM_QUIZ_DATA_FILE));

			fileScanner.nextLine();

			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[RANDOM_QUIZ_FIELD_NAMES.length - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
				values[5] = data[6];
				theOne.mRandomQuizDB.createRecord(Arrays.copyOfRange(RANDOM_QUIZ_FIELD_NAMES, 1, RANDOM_QUIZ_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
	}

	// Game quiz DB From File
	private int initializeHardGameDBFromFile() throws SQLException{
		int recordsCreated = 0;

		if (theOne.mUserDB.getRecordCount() > 0)
			return 0;

		try {
			Scanner fileScanner = new Scanner(new File(GAME_QUIZ_HARD_DATA_FILE));

			fileScanner.nextLine();

			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[GAME_QUIZ_HARD_FIELD_NAMES.length - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
				values[5] = data[6];
				theOne.mGameQuizDB.createRecord(Arrays.copyOfRange(GAME_QUIZ_HARD_FIELD_NAMES, 1, GAME_QUIZ_HARD_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
	}

	private int initializeNormalGameDBFromFile() throws SQLException{
		int recordsCreated = 0;

		if (theOne.mUserDB.getRecordCount() > 0)
			return 0;

		try {
			Scanner fileScanner = new Scanner(new File(GAME_QUIZ_NORMAL_DATA_FILE));

			fileScanner.nextLine();

			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[GAME_QUIZ_NORMAL_FIELD_NAMES.length - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
				values[5] = data[6];
				theOne.mGameQuizDB.createRecord(Arrays.copyOfRange(GAME_QUIZ_NORMAL_FIELD_NAMES, 1, GAME_QUIZ_NORMAL_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
	}

	private int initializeEasyGameDBFromFile() throws SQLException{
		int recordsCreated = 0;

		if (theOne.mUserDB.getRecordCount() > 0)
			return 0;

		try {
			Scanner fileScanner = new Scanner(new File(GAME_QUIZ_EASY_DATA_FILE));

			fileScanner.nextLine();

			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[GAME_QUIZ_EASY_FIELD_NAMES.length - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
				values[5] = data[6];
				theOne.mGameQuizDB.createRecord(Arrays.copyOfRange(GAME_QUIZ_EASY_FIELD_NAMES, 1, GAME_QUIZ_EASY_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
	}

    // Math quiz DB From File
    private int initializeHardMathDBFromFile() throws SQLException{
		int recordsCreated = 0;

		if (theOne.mUserDB.getRecordCount() > 0)
			return 0;

		try {
			Scanner fileScanner = new Scanner(new File(MATH_QUIZ_HARD_DATA_FILE));

			fileScanner.nextLine();

			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");
				String[] values = new String[MATH_QUIZ_HARD_FIELD_NAMES.length - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
				values[5] = data[6];
				theOne.mMathQuizDB.createRecord(Arrays.copyOfRange(MATH_QUIZ_HARD_FIELD_NAMES, 1, MATH_QUIZ_HARD_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;

	}

	private int initializeNormalMathDBFromFile() throws SQLException{
		int recordsCreated = 0;

		if (theOne.mUserDB.getRecordCount() > 0)
			return 0;

		try {

			Scanner fileScanner = new Scanner(new File(MATH_QUIZ_NORMAL_DATA_FILE));

			fileScanner.nextLine();

			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");

				String[] values = new String[MATH_QUIZ_NORMAL_FIELD_NAMES.length - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
				values[5] = data[6];
				theOne.mMathQuizDB.createRecord(Arrays.copyOfRange(MATH_QUIZ_NORMAL_FIELD_NAMES, 1, MATH_QUIZ_NORMAL_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
	}

	private int initializeEasyMathDBFromFile() throws SQLException{
		int recordsCreated = 0;

		if (theOne.mUserDB.getRecordCount() > 0)
			return 0;

		try {

			Scanner fileScanner = new Scanner(new File(MATH_QUIZ_EASY_DATA_FILE));

			fileScanner.nextLine();

			while (fileScanner.hasNextLine()) {
				String[] data = fileScanner.nextLine().split(",");

				String[] values = new String[MATH_QUIZ_EASY_FIELD_NAMES.length - 1];
				values[0] = data[1].replaceAll("'", "''");
				values[1] = data[2];
				values[2] = data[3];
				values[3] = data[4];
				values[4] = data[5];
				values[5] = data[6];
				theOne.mMathQuizDB.createRecord(Arrays.copyOfRange(MATH_QUIZ_EASY_FIELD_NAMES, 1, MATH_QUIZ_EASY_FIELD_NAMES.length), values);
				recordsCreated++;
			}

			fileScanner.close();
		} catch (FileNotFoundException e) {
			return 0;
		}
		return recordsCreated;
	}

	public ObservableList<Quiz> getAllQuiz() {
		return theOne.mAllQuizList;
	}

    public String[] getAccountInfo(String email)
    {
        String[] results = {"Invalid Email"};
        for( User u : theOne.mAllUsersList)
        {
            if(u.getEmail().equalsIgnoreCase(email))
            {
                results = new String[2];
                results[0] = u.getUserName();
                results[1] = u.getPassword();
            break;
            }
        }
        return results;
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
    public String changeUserName(String currentUserName, String newUserName)   {
        for(User u : theOne.mAllUsersList)
        {
            if (currentUserName.equalsIgnoreCase(u.getUserName()))
            {
                for(User j : theOne.mAllUsersList)
                {
                    if(newUserName.equalsIgnoreCase(j.getUserName()))
                        return "FAILURE";
                    else
                    {
                        j.setUserName(newUserName);
                        // Update the database
                        String key = String.valueOf(j.getID());
                        String[] fields = {"name", "email", "password" };
                        String[] values = {j.getUserName(), j.getEmail(), j.getPassword()};
                        try {
							theOne.mUserDB.updateRecord(key, fields, values);
						} catch (SQLException e) {
							return "FAILURE";
						}
                        return "SUCCESS";
                    }
                }
            }
        }
        return "FAILURE";
    }
    public String changePassword(String currentPassword, String newPassword)
    {
    	  for(User u : theOne.mAllUsersList)
          {
              if (currentPassword.equalsIgnoreCase(u.getPassword()))
              {
                  for(User j : theOne.mAllUsersList)
                  {
                      if(newPassword.equalsIgnoreCase(j.getPassword()))
                          return "FAILURE";
                      else
                      {
                          j.setPassword(newPassword);
                          String key = String.valueOf(j.getPassword());
                          String[] fields = {"name","email","password"};
                          String[] values = {j.getUserName(), j.getEmail(), j.getPassword()};
                          try
                        {
                            theOne.mUserDB.updateRecord(key, fields, values);
                        }
                        catch (SQLException e)
                        {
                            return "FAILURE";
                        }
                          return "SUCCESS";
                      }
                  }
              }
          }
		return "FAILURE";

    }
    public String changeEmail(String currentEmail, String newEmail)
    {
  	  for(User u : theOne.mAllUsersList)
        {
            if (currentEmail.equalsIgnoreCase(u.getEmail()))
            {
                for(User j : theOne.mAllUsersList)
                {
                    if(newEmail.equalsIgnoreCase(j.getEmail()))
                        return "FAILURE";
                    else
                    {
                        j.setEmail(newEmail);
                        return "SUCCESS";
                    }
                }
            }
        }
		return "FAILURE";

    }

}
