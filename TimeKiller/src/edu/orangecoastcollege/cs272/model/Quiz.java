package edu.orangecoastcollege.cs272.model;

public class Quiz
{
    private String mQuestion;
    private String mChoiceA;
    private String mChoiceB;
    private String mChoiceC;
    private String mChoiceD;
    private String mCorrect;
    public Quiz(String question, String choiceA, String choiceB, String choiceC, String choiceD, String correct)
    {
        super();

        mQuestion = question;
        mChoiceA = choiceA;
        mChoiceB = choiceB;
        mChoiceC = choiceC;
        mChoiceD = choiceD;
        mCorrect = correct;
    }
    public void setQuestion(String question)
    {
    	mQuestion = question;
    }
    public String getQuestion()
    {
    	return mQuestion;
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
        result = prime * result + ((mQuestion == null) ? 0 : mQuestion.hashCode());
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
        if (mQuestion == null)
        {
            if (other.mQuestion != null) return false;
        }
        else if (!mQuestion.equals(other.mQuestion)) return false;
        return true;
    }
    @Override
    public String toString()
    {
        return "Quiz [Question= "+ mQuestion +",  ChoiceA=" + mChoiceA + ", ChoiceB=" + mChoiceB + ", ChoiceC=" + mChoiceC
                + ", ChoiceD=" + mChoiceD + ", Correct=" + mCorrect + "]";
        }

}
