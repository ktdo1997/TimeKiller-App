package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class MathScene {
	@FXML
	private Button easyBT;
	@FXML
	private Button hardBT;
	@FXML
	private Button extremelyBT;
	@FXML
	private Button backBT;
	@FXML
	private Label mathLevelLabel;
	@FXML
	public void loadQuizScene(ActionEvent event) {
		ViewNavigator.loadScene("Quiz", ViewNavigator.QUIZ_SCENE);
	}
    private int mId;
    private String mQuestion;
    private String mChoice_a;
    private String mChoice_b;
    private String mChoice_c;
    private String mChoice_d;
    private String mAnswer;
    public String getQuestion;

	
	

    public MathScene(int id, String question, String choice_a, String choice_b, String choice_c, String choice_d, String answer)
    {
        super();
        mId = id;
        mQuestion = question;
        mChoice_a = choice_a;
        mChoice_b = choice_b;
        mChoice_c = choice_c;
        mChoice_d = choice_d;
        mAnswer = answer;
    }

    public void setQuestion(String question)
    {
        mQuestion = question;
    }
    public String getChoice_a()
    {
        return mChoice_a;
    }
    public void setChoice_a(String choice_a)
    {
        mChoice_a = choice_a;
    }
    public String getChoice_b()
    {
        return mChoice_b;
    }
    public void setChoice_b(String choice_b)
    {
        mChoice_b = choice_b;
    }
    public String getChoice_c()
    {
        return mChoice_c;
    }
    public void setChoice_c(String choice_c)
    {
        mChoice_c = choice_c;
    }
    public String getChoice_d()
    {
        return mChoice_d;
    }
    public void setChoice_d(String choice_d)
    {
        mChoice_d = choice_d;
    }
    public String getAnswer()
    {
        return mAnswer;
    }
    public void setAnswer(String answer)
    {
        mAnswer = answer;
    }
    public int getId()
    {
        return mId;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((backBT == null) ? 0 : backBT.hashCode());
        result = prime * result + ((easyBT == null) ? 0 : easyBT.hashCode());
        result = prime * result + ((extremelyBT == null) ? 0 : extremelyBT.hashCode());
        result = prime * result + ((getQuestion == null) ? 0 : getQuestion.hashCode());
        result = prime * result + ((hardBT == null) ? 0 : hardBT.hashCode());
        result = prime * result + ((mAnswer == null) ? 0 : mAnswer.hashCode());
        result = prime * result + ((mChoice_a == null) ? 0 : mChoice_a.hashCode());
        result = prime * result + ((mChoice_b == null) ? 0 : mChoice_b.hashCode());
        result = prime * result + ((mChoice_c == null) ? 0 : mChoice_c.hashCode());
        result = prime * result + ((mChoice_d == null) ? 0 : mChoice_d.hashCode());
        result = prime * result + mId;
        result = prime * result + ((mQuestion == null) ? 0 : mQuestion.hashCode());
        result = prime * result + ((mathLevelLabel == null) ? 0 : mathLevelLabel.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        MathScene other = (MathScene) obj;
        if (backBT == null)
        {
            if (other.backBT != null) return false;
        }
        else if (!backBT.equals(other.backBT)) return false;
        if (easyBT == null)
        {
            if (other.easyBT != null) return false;
        }
        else if (!easyBT.equals(other.easyBT)) return false;
        if (extremelyBT == null)
        {
            if (other.extremelyBT != null) return false;
        }
        else if (!extremelyBT.equals(other.extremelyBT)) return false;
        if (getQuestion == null)
        {
            if (other.getQuestion != null) return false;
        }
        else if (!getQuestion.equals(other.getQuestion)) return false;
        if (hardBT == null)
        {
            if (other.hardBT != null) return false;
        }
        else if (!hardBT.equals(other.hardBT)) return false;
        if (mAnswer == null)
        {
            if (other.mAnswer != null) return false;
        }
        else if (!mAnswer.equals(other.mAnswer)) return false;
        if (mChoice_a == null)
        {
            if (other.mChoice_a != null) return false;
        }
        else if (!mChoice_a.equals(other.mChoice_a)) return false;
        if (mChoice_b == null)
        {
            if (other.mChoice_b != null) return false;
        }
        else if (!mChoice_b.equals(other.mChoice_b)) return false;
        if (mChoice_c == null)
        {
            if (other.mChoice_c != null) return false;
        }
        else if (!mChoice_c.equals(other.mChoice_c)) return false;
        if (mChoice_d == null)
        {
            if (other.mChoice_d != null) return false;
        }
        else if (!mChoice_d.equals(other.mChoice_d)) return false;
        if (mId != other.mId) return false;
        if (mQuestion == null)
        {
            if (other.mQuestion != null) return false;
        }
        else if (!mQuestion.equals(other.mQuestion)) return false;
        if (mathLevelLabel == null)
        {
            if (other.mathLevelLabel != null) return false;
        }
        else if (!mathLevelLabel.equals(other.mathLevelLabel)) return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "GameScene [mId=" + mId + ", mQuestion=" + mQuestion + ", mChoice_a=" + mChoice_a + ", mChoice_b="
                + mChoice_b + ", mChoice_c=" + mChoice_c + ", mChoice_d=" + mChoice_d + ", mAnswer=" + mAnswer
                + ", getQuestion=" + getQuestion + "]";
    }
}



