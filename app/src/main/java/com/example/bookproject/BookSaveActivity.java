package com.example.bookproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BookSaveActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText authorEditText;
    private EditText descriptionEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_save);

        Toolbar toolbar = findViewById(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        titleEditText = findViewById(R.id.titleEditText);
        authorEditText = findViewById(R.id.authorEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 책 정보 저장하기
                String bookTitle = titleEditText.getText().toString();
                String bookAuthor = authorEditText.getText().toString();
                String bookDescription = descriptionEditText.getText().toString();

                // SharedPreferences를 사용하여 책 정보 저장
                SharedPreferences sharedPreferences = getSharedPreferences("RecommendedBooks", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("bookTitle", bookTitle);
                editor.putString("bookAuthor", bookAuthor);
                editor.putString("bookDescription", bookDescription);
                editor.apply();

                // 저장 버튼 클릭 시 BookListActivity로 이동
                Intent intent = new Intent(BookSaveActivity.this, BookListActivity.class);
                startActivity(intent);


                finish(); // 액티비티 종료
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            finish(); // 현재 액티비티 종료
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
