package com.example.encouragingminds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.encouragingminds.QuizContract.QuestionTable;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "EncouragingMinds";
    private static final int  DATABASE_VERSION = 3;

    private SQLiteDatabase db;

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionTable.TABLE_NAME + " ( " +
                QuestionTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionTable.COLUMN_QUESTION + " TEXT, " +
                QuestionTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionTable.COLUMN_IMAGE + " INTEGER,  "+
                QuestionTable.COLUMN_CATEGORY + " TEXT, " +
                QuestionTable.COLUMN_LEVELS_ID + " INTEGER " +
                " )";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);

        fillQuestionTable(); //inserting the data from inside the table
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE_NAME);
        onCreate(db);

    }

    private void addQuestions(Questions questions){
        ContentValues cv = new ContentValues();

        cv.put(QuestionTable.COLUMN_QUESTION,questions.getQuestion());
        cv.put(QuestionTable.COLUMN_IMAGE,questions.getImage());
        cv.put(QuestionTable.COLUMN_OPTION1,questions.getOption1());
        cv.put(QuestionTable.COLUMN_OPTION2,questions.getOption2());
        cv.put(QuestionTable.COLUMN_OPTION3,questions.getOption3());
        cv.put(QuestionTable.COLUMN_OPTION4,questions.getOption4());
        cv.put(QuestionTable.COLUMN_ANSWER_NR,questions.getAnswerNr());
        cv.put(QuestionTable.COLUMN_CATEGORY,questions.getCategory());
        cv.put(QuestionTable.COLUMN_LEVELS_ID,questions.getLevels());

        db.insert(QuestionTable.TABLE_NAME, null,cv);

    }

    private void fillQuestionTable(){

        // Beginner category levels below

        Questions q1 = new Questions(
                "What emotion is being displayed?",
                R.drawable.happy31,
                "Anger",
                "Happy",
                "Sad",
                "Neutral",
                2,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL1);
        addQuestions(q1);

        Questions q2 = new Questions(
                "What emotion is being displayed?",
                R.drawable.neutral39,
                "Happy",
                "Sad",
                "Neutral",
                "Anger",
                3,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL1);
        addQuestions(q2);

        Questions q3 = new Questions(
                "What emotion is being displayed?",
                R.drawable.sad11,
                "Sad",
                "Neutral",
                "Anger",
                "Happy",
                1,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL1);
        addQuestions(q3);

        Questions q4 = new Questions(
                "What emotion is being displayed?",
                R.drawable.angry5,
                "Neutral",
                "Happy",
                "Sad",
                "Anger",
                4,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL1);
        addQuestions(q4);

        Questions q5 = new Questions(
                "What emotion is being displayed?",
                R.drawable.neutral38,
                "Happy",
                "Neutral",
                "Anger",
                "Sad",
                2,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL1);
        addQuestions(q5);

        Questions q6 = new Questions(
                "What emotion is being displayed?",
                R.drawable.happy32,
                "Anger",
                "Sad",
                "Neutral",
                "Happy",
                4,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL1);
        addQuestions(q6);

        Questions q7 = new Questions(
                "What emotion is being displayed?",
                R.drawable.sad12,
                "Anger",
                "Happy",
                "Sad",
                "Neutral",
                3,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL1);
        addQuestions(q7);

        Questions q8 = new Questions(
                "What emotion is being displayed?",
                R.drawable.neutral33,
                "Neutral",
                "Sad",
                "Happy",
                "Anger",
                1,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL1);
        addQuestions(q8);

        Questions q9 = new Questions(
                "What emotion is being displayed?",
                R.drawable.angry6,
                "Happy",
                "Neutral",
                "Anger",
                "Sad",
                3,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL1);
        addQuestions(q9);

        Questions q10 = new Questions(
                "What emotion is being displayed?",
                R.drawable.happy33,
                "Neutral",
                "Happy",
                "Sad",
                "Anger",
                2,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL1);
        addQuestions(q10);

        Questions q11 = new Questions(
                "What emotion is being displayed?",
                R.drawable.happy34,
                "Happy",
                "Anger",
                "Neutral",
                "Sad",
                1,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL2);
        addQuestions(q11);

        Questions q12 = new Questions(
                "What emotion is being displayed?",
                R.drawable.neutral34,
                "Anger",
                "Happy",
                "Sad",
                "Neutral",
                4,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL2);
        addQuestions(q12);

        Questions q13 = new Questions(
                "What emotion is being displayed?",
                R.drawable.sad16,
                "Neutral",
                "Anger",
                "Sad",
                "Happy",
                3,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL2);
        addQuestions(q13);

        Questions q14 = new Questions(
                "What emotion is being displayed?",
                R.drawable.angry7,
                "Sad",
                "Anger",
                "Neutral",
                "Happy",
                2,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL2);
        addQuestions(q14);

        Questions q15 = new Questions(
                "What emotion is being displayed?",
                R.drawable.happy35,
                "Anger",
                "Neutral",
                "Sad",
                "Happy",
                4,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL2);
        addQuestions(q15);

        Questions q16 = new Questions(
                "What emotion is being displayed?",
                R.drawable.sad18,
                "Happy",
                "Anger",
                "Sad",
                "Neutral",
                3,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL2);
        addQuestions(q16);

        Questions q17 = new Questions(
                "What emotion is being displayed?",
                R.drawable.angry8,
                "Neutral",
                "Happy",
                "Anger",
                "Sad",
                3,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL2);
        addQuestions(q17);

        Questions q18 = new Questions(
                "What emotion is being displayed?",
                R.drawable.neutral36,
                "Anger",
                "Neutral",
                "Sad",
                "Happy",
                2,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL2);
        addQuestions(q18);

        Questions q19 = new Questions(
                "What emotion is being displayed?",
                R.drawable.happy37,
                "Happy",
                "Sad",
                "Anger",
                "Neutral",
                1,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL2);
        addQuestions(q19);

        Questions q20 = new Questions(
                "What emotion is being displayed?",
                R.drawable.neutral37,
                "Neutral",
                "Happy",
                "Sad",
                "Anger",
                1,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL2);
        addQuestions(q20);

        Questions q21 = new Questions(
                "What emotion is being displayed?",
                R.drawable.happy38,
                "Anger",
                "Happy",
                "Sad",
                "Neutral",
                2,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL3);
        addQuestions(q21);

        Questions q22 = new Questions(
                "What emotion is being displayed?",
                R.drawable.neutral38,
                "Neutral",
                "Sad",
                "Anger",
                "Happy",
                1,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL3);
        addQuestions(q22);

        Questions q23 = new Questions(
                "What emotion is being displayed?",
                R.drawable.sad19,
                "Happy",
                "Neutral",
                "Sad",
                "Anger",
                3,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL3);
        addQuestions(q23);

        Questions q24 = new Questions(
                "What emotion is being displayed?",
                R.drawable.anger12,
                "Sad",
                "Happy",
                "Neutral",
                "Anger",
                4,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL3);
        addQuestions(q24);

        Questions q25 = new Questions(
                "What emotion is being displayed?",
                R.drawable.happy39,
                "Neutral",
                "Anger",
                "Happy",
                "Sad",
                3,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL3);
        addQuestions(q25);

        Questions q26 = new Questions(
                "What emotion is being displayed?",
                R.drawable.neutral39,
                "Anger",
                "Neutral",
                "Sad",
                "Happy",
                2,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL3);
        addQuestions(q26);

        Questions q27 = new Questions(
                "What emotion is being displayed?",
                R.drawable.sad4,
                "Neutral",
                "Happy",
                "Anger",
                "Sad",
                4,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL3);
        addQuestions(q27);

        Questions q28 = new Questions(
                "What emotion is being displayed?",
                R.drawable.anger13,
                "Anger",
                "Sad",
                "Happy",
                "Neutral",
                1,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL3);
        addQuestions(q28);

        Questions q29 = new Questions(
                "What emotion is being displayed?",
                R.drawable.happy40,
                "Sad",
                "Happy",
                "Neutral",
                "Anger",
                2,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL3);
        addQuestions(q29);

        Questions q30 = new Questions(
                "What emotion is being displayed?",
                R.drawable.neutral4,
                "Anger",
                "Sad",
                "Neutral",
                "Happy",
                3,
                Questions.CATEGORY_BEGINNER,
                Questions.LEVEL3);
        addQuestions(q30);

        // Intermediate category levels below

        Questions q31 = new Questions(
                "What emotion is being displayed",
                R.drawable.neutral5,
                "Sad",
                "Happy",
                "Anger",
                "Neutral",
                4,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL1);
        addQuestions(q31);

        Questions q32 = new Questions(
                "What emotion is being displayed",
                R.drawable.sad5,
                "Neutral",
                "Sad",
                "Happy",
                "Anger",
                2,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL1);
        addQuestions(q32);

        Questions q33 = new Questions(
                "What emotion is being displayed",
                R.drawable.surprise1,
                "Neutral",
                "Sad",
                "Surprise",
                "Fear",
                3,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL1);
        addQuestions(q33);

        Questions q34 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear1,
                "Surprise",
                "Happy",
                "Anger",
                "Fear",
                4,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL1);
        addQuestions(q34);

        Questions q35 = new Questions(
                "What emotion is being displayed",
                R.drawable.happy4,
                "Happy",
                "Fear",
                "Surprise",
                "Sad",
                1,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL1);
        addQuestions(q35);

        Questions q36 = new Questions(
                "What emotion is being displayed",
                R.drawable.anger3,
                "Neutral",
                "Anger",
                "Fear",
                "Surprise",
                2,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL1);
        addQuestions(q36);

        Questions q37 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear2,
                "Surprise",
                "Neutral",
                "Anger",
                "Fear",
                4,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL1);
        addQuestions(q37);

        Questions q38 = new Questions(
                "What emotion is being displayed",
                R.drawable.surprise2,
                "Fear",
                "Sad",
                "Surprise",
                "Happy",
                3,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL1);
        addQuestions(q38);

        Questions q39 = new Questions(
                "What emotion is being displayed",
                R.drawable.neutral6,
                "Neutral",
                "Sad",
                "Happy",
                "Fear",
                1,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL1);
        addQuestions(q39);

        Questions q40 = new Questions(
                "What emotion is being displayed",
                R.drawable.surprise3,
                "Anger",
                "Surprise",
                "Fear",
                "Neutral",
                2,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL1);
        addQuestions(q40);

        Questions q41 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear3,
                "Neutral",
                "Sad",
                "Surprise",
                "Fear",
                4,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL2);
        addQuestions(q41);

        Questions q42 = new Questions(
                "What emotion is being displayed",
                R.drawable.surprise5,
                "Happy",
                "Neutral",
                "Surprise",
                "Anger",
                3,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL2);
        addQuestions(q42);

        Questions q43 = new Questions(
                "What emotion is being displayed",
                R.drawable.neutral7,
                "Neutral",
                "Fear",
                "Surprise",
                "Sad",
                1,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL2);
        addQuestions(q43);

        Questions q44 = new Questions(
                "What emotion is being displayed",
                R.drawable.happy5,
                "Neutral",
                "Happy",
                "Fear",
                "Anger",
                2,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL2);
        addQuestions(q44);

        Questions q45 = new Questions(
                "What emotion is being displayed",
                R.drawable.sad6,
                "Surprise",
                "Fear",
                "Sad",
                "Happy",
                3,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL2);
        addQuestions(q45);

        Questions q46 = new Questions(
                "What emotion is being displayed",
                R.drawable.anger4,
                "Fear",
                "Happy",
                "Surprise",
                "Anger",
                4,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL2);
        addQuestions(q46);

        Questions q47 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear4,
                "Fear",
                "Sad",
                "Surprise",
                "Happy",
                1,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL2);
        addQuestions(q47);

        Questions q48 = new Questions(
                "What emotion is being displayed",
                R.drawable.neutral8,
                "Neutral",
                "Sad",
                "Happy",
                "Fear",
                1,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL2);
        addQuestions(q48);

        Questions q49 = new Questions(
                "What emotion is being displayed",
                R.drawable.surprise6,
                "Fear",
                "Anger",
                "Surprise",
                "Sad",
                3,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL2);
        addQuestions(q49);

        Questions q50 = new Questions(
                "What emotion is being displayed",
                R.drawable.happy6,
                "Neutral",
                "Fear",
                "Surprise",
                "Happy",
                4,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL2);
        addQuestions(q50);

        Questions q51 = new Questions(
                "What emotion is being displayed",
                R.drawable.surprise7,
                "Surprise",
                "Sad",
                "Happy",
                "Anger",
                1,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL3);
        addQuestions(q51);

        Questions q52 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear5,
                "Neutral",
                "Sad",
                "Surprise",
                "Fear",
                4,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL3);
        addQuestions(q52);

        Questions q53 = new Questions(
                "What emotion is being displayed",
                R.drawable.neutral9,
                "Anger",
                "Neutral",
                "Happy",
                "Sad",
                2,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL3);
        addQuestions(q53);

        Questions q54 = new Questions(
                "What emotion is being displayed",
                R.drawable.happy7,
                "Neutral",
                "Sad",
                "Happy",
                "Surprise",
                3,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL3);
        addQuestions(q54);

        Questions q55 = new Questions(
                "What emotion is being displayed",
                R.drawable.sad7,
                "Neutral",
                "Sad",
                "Surprise",
                "Fear",
                2,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL3);
        addQuestions(q55);

        Questions q56 = new Questions(
                "What emotion is being displayed",
                R.drawable.angry5,
                "Happy",
                "Fear",
                "Sad",
                "Anger",
                4,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL3);
        addQuestions(q56);

        Questions q57 = new Questions(
                "What emotion is being displayed",
                R.drawable.neutral10,
                "Anger",
                "Neutral",
                "Fear",
                "Happy",
                1,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL3);
        addQuestions(q57);

        Questions q58 = new Questions(
                "What emotion is being displayed",
                R.drawable.surprise9,
                "Sad",
                "Happy",
                "Surprise",
                "Neutral",
                3,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL3);
        addQuestions(q58);

        Questions q59 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear6,
                "Surprise",
                "Fear",
                "Anger",
                "Sad",
                1,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL3);
        addQuestions(q59);

        Questions q60 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear7,
                "Surprise",
                "Happy",
                "Neutral",
                "Fear",
                4,
                Questions.CATEGORY_INTERMEDIATE,
                Questions.LEVEL3);
        addQuestions(q60);

        // Difficult category levels below

        Questions q61 = new Questions(
                "What emotion is being displayed",
                R.drawable.disgust2,
                "Happy",
                "Sad",
                "Surprise",
                "Disgust",
                4,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL1);
        addQuestions(q61);

        Questions q62 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear8,
                "Neutral",
                "Fear",
                "Anger",
                "Fear",
                2,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL1);
        addQuestions(q62);

        Questions q63 = new Questions(
                "What emotion is being displayed",
                R.drawable.sad8,
                "Surprise",
                "Sad",
                "Happy",
                "Fear",
                2,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL1);
        addQuestions(q63);

        Questions q64 = new Questions(
                "What emotion is being displayed",
                R.drawable.happy8,
                "Happy",
                "Disgust",
                "Fear",
                "Anger",
                1,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL1);
        addQuestions(q64);

        Questions q65 = new Questions(
                "What emotion is being displayed",
                R.drawable.neutral11,
                "Disgust",
                "Sad",
                "Neutral",
                "Happy",
                3,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL1);
        addQuestions(q65);

        Questions q66 = new Questions(
                "What emotion is being displayed",
                R.drawable.surprise1,
                "Sad",
                "Surprise",
                "Anger",
                "Fear",
                2,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL1);
        addQuestions(q66);

        Questions q67 = new Questions(
                "What emotion is being displayed",
                R.drawable.angry6,
                "Anger",
                "Neutral",
                "Happy",
                "Disgust",
                1,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL1);
        addQuestions(q67);

        Questions q68 = new Questions(
                "What emotion is being displayed",
                R.drawable.disgust3,
                "Neutral",
                "Sad",
                "Disgust",
                "Fear",
                3,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL1);
        addQuestions(q68);

        Questions q69 = new Questions(
                "What emotion is being displayed",
                R.drawable.happy9,
                "Fear",
                "Anger",
                "Surprise",
                "Happy",
                4,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL1);
        addQuestions(q69);

        Questions q70 = new Questions(
                "What emotion is being displayed",
                R.drawable.neutral12,
                "Neutral",
                "Happy",
                "Fear",
                "Anger",
                1,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL1);
        addQuestions(q70);

        Questions q71 = new Questions(
                "What emotion is being displayed",
                R.drawable.disgust4,
                "Sad",
                "Neutral",
                "Disgust",
                "Happy",
                3,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL2);
        addQuestions(q71);

        Questions q72 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear9,
                "Neutral",
                "Anger",
                "Surprise",
                "Fear",
                4,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL2);
        addQuestions(q72);

        Questions q73 = new Questions(
                "What emotion is being displayed",
                R.drawable.angry7,
                "Anger",
                "Sad",
                "Surprise",
                "Neutral",
                1,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL2);
        addQuestions(q73);

        Questions q74 = new Questions(
                "What emotion is being displayed",
                R.drawable.happy10,
                "Disgust",
                "Happy",
                "Sad",
                "Surprise",
                2,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL2);
        addQuestions(q74);

        Questions q75 = new Questions(
                "What emotion is being displayed",
                R.drawable.sad9,
                "Surprise",
                "Disgust",
                "Anger",
                "Sad",
                4,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL2);
        addQuestions(q75);

        Questions q76 = new Questions(
                "What emotion is being displayed",
                R.drawable.neutral13,
                "Sad",
                "Fear",
                "Neutral",
                "Happy",
                3,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL2);
        addQuestions(q76);

        Questions q77 = new Questions(
                "What emotion is being displayed",
                R.drawable.surprise2,
                "Anger",
                "Surprise",
                "Disgust",
                "Sad",
                2,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL2);
        addQuestions(q77);

        Questions q78 = new Questions(
                "What emotion is being displayed",
                R.drawable.surprise3,
                "Neutral",
                "Sad",
                "Surprise",
                "Fear",
                3,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL2);
        addQuestions(q78);

        Questions q79 = new Questions(
                "What emotion is being displayed",
                R.drawable.disgust5,
                "Happy",
                "Neutral",
                "Surprise",
                "Disgust",
                4,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL2);
        addQuestions(q79);

        Questions q80 = new Questions(
                "What emotion is being displayed",
                R.drawable.happy11,
                "Happy",
                "Sad",
                "Fear",
                "Neutral",
                1,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL2);
        addQuestions(q80);

        Questions q81 = new Questions(
                "What emotion is being displayed",
                R.drawable.disgust6,
                "Anger",
                "Surprise",
                "Happy",
                "Disgust",
                4,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL3);
        addQuestions(q81);

        Questions q82 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear10,
                "Neutral",
                "Sad",
                "Surprise",
                "Fear",
                4,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL3);
        addQuestions(q82);

        Questions q83 = new Questions(
                "What emotion is being displayed",
                R.drawable.happy12,
                "Sad",
                "Happy",
                "Disgust",
                "Anger",
                2,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL3);
        addQuestions(q83);

        Questions q84 = new Questions(
                "What emotion is being displayed",
                R.drawable.neutral14,
                "Surprise",
                "Disgust",
                "Sad",
                "Neutral",
                4,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL3);
        addQuestions(q84);

        Questions q85 = new Questions(
                "What emotion is being displayed",
                R.drawable.sad10,
                "Fear",
                "Anger",
                "Sad",
                "Disgust",
                3,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL3);
        addQuestions(q85);

        Questions q86 = new Questions(
                "What emotion is being displayed",
                R.drawable.angry8,
                "Neutral",
                "Surprise",
                "Anger",
                "Happy",
                3,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL3);
        addQuestions(q86);

        Questions q87 = new Questions(
                "What emotion is being displayed",
                R.drawable.suprised4,
                "Surprise",
                "Sad",
                "Disgust",
                "Fear",
                1,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL3);
        addQuestions(q87);

        Questions q88 = new Questions(
                "What emotion is being displayed",
                R.drawable.disgust10,
                "Sad",
                "Anger",
                "Disgust",
                "Happy",
                3,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL3);
        addQuestions(q88);

        Questions q89 = new Questions(
                "What emotion is being displayed",
                R.drawable.fear12,
                "Fear",
                "Neutral",
                "Happy",
                "Anger",
                1,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL3);
        addQuestions(q89);

        Questions q90 = new Questions(
                "What emotion is being displayed",
                R.drawable.happy13,
                "Disgust",
                "Anger",
                "Neutral",
                "Happy",
                4,
                Questions.CATEGORY_DIFFICULT,
                Questions.LEVEL3);
        addQuestions(q90);

    }


    public ArrayList<Questions> getAllQuestionsWithCategoryAndLevels(int levelsID, String category){

        ArrayList<Questions> questionsList = new ArrayList<>();

        db = getReadableDatabase();

        String projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_IMAGE,
                QuestionTable.COLUMN_CATEGORY,
                QuestionTable.COLUMN_LEVELS_ID
        };

        String selection = QuestionTable.COLUMN_LEVELS_ID + " = ? " +
                " AND " + QuestionTable.COLUMN_CATEGORY + " = ? ";

        String selectionArgs[] = {String.valueOf(levelsID),category};


        Cursor c = db.query(QuestionTable.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null

        );

        if (c.moveToFirst()){

            do{

                Questions questions = new Questions();
                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                questions.setImage(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_IMAGE)));
                questions.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                questions.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                questions.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                questions.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                questions.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                questions.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));
                questions.setLevels(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_LEVELS_ID)));

                questionsList.add(questions);

            }while (c.moveToNext());
        }
        c.close(); //closes the cursor
        return questionsList;
    }

    public ArrayList<Questions> getAllQuestions(){

        ArrayList<Questions> questionsList = new ArrayList<>();

        db = getReadableDatabase();

        String projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_IMAGE
        };

        Cursor c = db.query(QuestionTable.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null

        );

        if (c.moveToFirst()){

            do{

                Questions questions = new Questions();
                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                questions.setImage(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_IMAGE)));
                questions.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                questions.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                questions.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                questions.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                questions.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));

                questionsList.add(questions);

            }while (c.moveToNext());
        }
        c.close(); //closes the cursor
        return questionsList;
    }

    public ArrayList<Questions> getAllQuestionsWithCategory(String category){

        ArrayList<Questions> questionsList = new ArrayList<>();

        db = getReadableDatabase();

        String projection[] = {

                QuestionTable._ID,
                QuestionTable.COLUMN_QUESTION,
                QuestionTable.COLUMN_OPTION1,
                QuestionTable.COLUMN_OPTION2,
                QuestionTable.COLUMN_OPTION3,
                QuestionTable.COLUMN_OPTION4,
                QuestionTable.COLUMN_ANSWER_NR,
                QuestionTable.COLUMN_IMAGE,
                QuestionTable.COLUMN_CATEGORY
        };

        String selection = QuestionTable.COLUMN_CATEGORY + " = ? ";
        String selectionArgs[] = {category};

        Cursor c = db.query(QuestionTable.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null

        );

        if (c.moveToFirst()){

            do{

                Questions questions = new Questions();
                questions.setQuestion(c.getString(c.getColumnIndex(QuestionTable.COLUMN_QUESTION)));
                questions.setImage(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_IMAGE)));
                questions.setOption1(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION1)));
                questions.setOption2(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION2)));
                questions.setOption3(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION3)));
                questions.setOption4(c.getString(c.getColumnIndex(QuestionTable.COLUMN_OPTION4)));
                questions.setAnswerNr(c.getInt(c.getColumnIndex(QuestionTable.COLUMN_ANSWER_NR)));
                questions.setCategory(c.getString(c.getColumnIndex(QuestionTable.COLUMN_CATEGORY)));

                questionsList.add(questions);

            }while (c.moveToNext());
        }
        c.close(); //closes the cursor
        return questionsList;
    }


}
