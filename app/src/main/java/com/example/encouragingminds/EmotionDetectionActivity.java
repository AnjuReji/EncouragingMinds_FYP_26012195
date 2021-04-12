package com.example.encouragingminds;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.File;
import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

public class EmotionDetectionActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar mClassificationProgressBar;

    private ImageView mImageView;

    private Button mPickImageButton;
    private Button mTakePhotoButton;

    private ExpandableListView mClassificationExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotiondetection);

        mClassificationProgressBar = findViewById(R.id.classification_progress_bar);

        mImageView = findViewById(R.id.image_view);

        mPickImageButton = findViewById(R.id.pick_image_button);
        mPickImageButton.setOnClickListener(v -> pickFromGallery());
    }

    private void pickFromGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");

    }

    private void takePhoto() {

    }

    private void createImageFile() {
    }


    @Override
    public void onClick(View v) {

    }
}

