package com.example.encouragingminds;

import android.provider.BaseColumns;

//final class means that after this has been implemented it cannot be changed
public final class QuizContract {

    public QuizContract(){}

    public static class QuestionTable implements BaseColumns{

        //Initialise the variables with capital letters followed by small
        public static final String TABLE_NAME = "quiz_questions";
        //below is used to store the questions
        public static final String COLUMN_QUESTION = "questions";
        public static final String COLUMN_IMAGE = "image";
        //below is used to store the options
        public static final String COLUMN_OPTION1 = "option1";
        public static final String COLUMN_OPTION2 = "option2";
        public static final String COLUMN_OPTION3 = "option3";
        public static final String COLUMN_OPTION4 = "option4";
        public static final String COLUMN_ANSWER_NR = "answer_nr";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_LEVELS_ID = "levels_id";

    }

    //  public static class QuestionTable2 implements BaseColumns {

    //Initialise the variables with capital letters followed by small
    //   public static final String TABLE_NAME = "quiz_questions";

    //  }

    //  public static class QuestionTable3 implements BaseColumns {

    //Initialise the variables with capital letters followed by small
    //      public static final String TABLE_NAME = "quiz_questions";

    // }

}
