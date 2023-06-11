package com.example.bookproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BookDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_BOOK_TITLE = "book_title";
    public static final String EXTRA_BOOK_AUTHOR = "book_author";
    public static final String EXTRA_BOOK_DESCRIPTION = "book_description";
    public static final String EXTRA_BOOK_COVER_RES_ID = "book_cover_res_id";

    private ImageView coverImageView;
    private TextView titleTextView;
    private TextView authorTextView;
    private TextView descriptionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        coverImageView = findViewById(R.id.coverImageView);
        titleTextView = findViewById(R.id.titleTextView);
        authorTextView = findViewById(R.id.authorTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);


        Toolbar toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Intent에서 전달된 데이터 받기
        String bookTitle = getIntent().getStringExtra(EXTRA_BOOK_TITLE);
        String bookAuthor = getIntent().getStringExtra(EXTRA_BOOK_AUTHOR);
        String bookDescription = getIntent().getStringExtra(EXTRA_BOOK_DESCRIPTION);
        int bookCoverResId = getIntent().getIntExtra(EXTRA_BOOK_COVER_RES_ID, 0);

        // 텍스트뷰에 데이터 표시
        titleTextView.setText(bookTitle);
        authorTextView.setText(bookAuthor);
        descriptionTextView.setText(bookDescription);

        // 이미지 표시
        coverImageView.setImageResource(bookCoverResId);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) { // 뒤로가기 버튼을 눌렀을 때
            onBackPressed(); // 기본 뒤로가기 동작 수행
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

