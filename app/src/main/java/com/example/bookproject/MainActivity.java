package com.example.bookproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button submitButton;
    private RadioGroup optionsRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submitButton);
        optionsRadioGroup = findViewById(R.id.optionsRadioGroup);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
                String bookTitle = "";
                String bookAuthor = "";
                String bookDescription = "";
                int bookCoverResId = 0;

                switch (selectedOptionId) {
                    case R.id.option1RadioButton:
                        bookTitle = "날씨가 좋으면 찾아가겠어요";
                        bookAuthor = "이도우";
                        bookDescription = "This is a love story.";
                        bookCoverResId = R.drawable.book_cover;
                        break;
                    // 추가적인 선택지에 대한 처리를 여기에 추가하세요
                }

                Intent intent = new Intent(MainActivity.this, BookDetailsActivity.class);
                intent.putExtra(BookDetailsActivity.EXTRA_BOOK_TITLE, bookTitle);
                intent.putExtra(BookDetailsActivity.EXTRA_BOOK_AUTHOR, bookAuthor);
                intent.putExtra(BookDetailsActivity.EXTRA_BOOK_DESCRIPTION, bookDescription);
                intent.putExtra(BookDetailsActivity.EXTRA_BOOK_COVER_RES_ID, bookCoverResId);
                startActivity(intent);
            }
        });

        Button viewRecommendedBooksButton = findViewById(R.id.viewRecommendedBooksButton);
        viewRecommendedBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 추천 받은 책을 보는 창으로 이동
                Intent intent = new Intent(MainActivity.this, BookSaveActivity.class);
                startActivity(intent);
            }
        });
    }
}



