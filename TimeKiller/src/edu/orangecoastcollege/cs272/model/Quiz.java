package edu.orangecoastcollege.cs272.model;

public class Quiz
{
    private int mID;
    private String mChoiceA;
    private String mChoiceB;
    private String mChoiceC;
    private String mChoiceD;
    private String mCorrect;
    public Quiz(int iD, String choiceA, String choiceB, String choiceC, String choiceD, String correct)
    {
        super();
        mID = iD;
        mChoiceA = choiceA;
        mChoiceB = choiceB;
        mChoiceC = choiceC;
        mChoiceD = choiceD;
        mCorrect = correct;
    }
    public int getID()
    {
        return mID;
    }
    public void setID(int iD)
    {
        mID = iD;
    }
    public String getChoiceA()
    {
        return mChoiceA;
    }
    public void setChoiceA(String choiceA)
    {
        mChoiceA = choiceA;
    }
    public String getChoiceB()
    {
        return mChoiceB;
    }
    public void setChoiceB(String choiceB)
    {
        mChoiceB = choiceB;
    }
    public String getChoiceC()
    {
        return mChoiceC;
    }
    public void setChoiceC(String choiceC)
    {
        mChoiceC = choiceC;
    }
    public String getChoiceD()
    {
        return mChoiceD;
    }
    public void setChoiceD(String choiceD)
    {
        mChoiceD = choiceD;
    }
    public String getCorrect()
    {
        return mCorrect;
    }
    public void setCorrect(String correct)
    {
        mCorrect = correct;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mChoiceA == null) ? 0 : mChoiceA.hashCode());
        result = prime * result + ((mChoiceB == null) ? 0 : mChoiceB.hashCode());
        result = prime * result + ((mChoiceC == null) ? 0 : mChoiceC.hashCode());
        result = prime * result + ((mChoiceD == null) ? 0 : mChoiceD.hashCode());
        result = prime * result + ((mCorrect == null) ? 0 : mCorrect.hashCode());
        result = prime * result + mID;
        return result;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Quiz other = (Quiz) obj;
        if (mChoiceA == null)
        {
            if (other.mChoiceA != null) return false;
        }
        else if (!mChoiceA.equals(other.mChoiceA)) return false;
        if (mChoiceB == null)
        {
            if (other.mChoiceB != null) return false;
        }
        else if (!mChoiceB.equals(other.mChoiceB)) return false;
        if (mChoiceC == null)
        {
            if (other.mChoiceC != null) return false;
        }
        else if (!mChoiceC.equals(other.mChoiceC)) return false;
        if (mChoiceD == null)
        {
            if (other.mChoiceD != null) return false;
        }
        else if (!mChoiceD.equals(other.mChoiceD)) return false;
        if (mCorrect == null)
        {
            if (other.mCorrect != null) return false;
        }
        else if (!mCorrect.equals(other.mCorrect)) return false;
        if (mID != other.mID) return false;
        return true;
    }
    @Override
    public String toString()
    {
        return "Quiz [ID=" + mID + ", ChoiceA=" + mChoiceA + ", ChoiceB=" + mChoiceB + ", ChoiceC=" + mChoiceC
                + ", ChoiceD=" + mChoiceD + ", Correct=" + mCorrect + "]";
        }

}