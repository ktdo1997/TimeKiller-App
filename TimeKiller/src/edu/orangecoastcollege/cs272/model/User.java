package edu.orangecoastcollege.cs272.model;

public class User
{
    private int mID;
    private String mUserName;
    private String mEmail;
    private String mPassword;
    public User(int iD, String userName, String email, String password)
    {
        super();
        mID = iD;
        mUserName = userName;
        mEmail = email;
        mPassword = password;
    }
    public int getID()
    {
        return mID;
    }
    public void setID(int iD)
    {
        mID = iD;
    }
    public String getUserName()
    {
        return mUserName;
    }
    public void setUserName(String userName)
    {
        mUserName = userName;
    }
    public String getEmail()
    {
        return mEmail;
    }
    public void setEmail(String email)
    {
        mEmail = email;
    }
    public String getPassword()
    {
        return mPassword;
    }
    public void setPassword(String password)
    {
        mPassword = password;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mEmail == null) ? 0 : mEmail.hashCode());
        result = prime * result + mID;
        result = prime * result + ((mPassword == null) ? 0 : mPassword.hashCode());
        result = prime * result + ((mUserName == null) ? 0 : mUserName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        User other = (User) obj;
        if (mEmail == null)
        {
            if (other.mEmail != null) return false;
        }
        else if (!mEmail.equals(other.mEmail)) return false;
        if (mID != other.mID) return false;
        if (mPassword == null)
        {
            if (other.mPassword != null) return false;
        }
        else if (!mPassword.equals(other.mPassword)) return false;
        if (mUserName == null)
        {
            if (other.mUserName != null) return false;
        }
        else if (!mUserName.equals(other.mUserName)) return false;
        return true;
    }
    @Override
    public String toString()
    {
        return "User [ID=" + mID + ", UserName=" + mUserName + ", Email=" + mEmail + ", Password=" + mPassword
                + "]";
    }

}
