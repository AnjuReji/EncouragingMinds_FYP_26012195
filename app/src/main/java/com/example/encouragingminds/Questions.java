package com.example.encouragingminds;

public class Questions {

    public static final String CATEGORY_BEGINNER = "Beginner";
    public static final String CATEGORY_INTERMEDIATE = "Intermediate";
    public static final String CATEGORY_DIFFICULT = "Difficult";
    public static final String CATEGORY_DETECT_EMOTION = "Detect Emotion";


    public static final int LEVEL1 = 1;
    public static final int LEVEL2 = 2;
    public static final int LEVEL3 = 3;


    private String question;
    private int image;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int answerNr;
    private String category;
    private int levels;


    public Questions(){}

    public Questions(String question, int image, String option1, String option2, String option3, String option4, int answerNr, String category, int levels) {
        this.question = question;
        this.image = image;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answerNr = answerNr;
        this.category = category;
        this.levels = levels;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }


    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }


    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }


    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }


    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public int getLevels() {
        return levels;
    }

    public void setLevels(int levels) {
        this.levels = levels;
    }
}