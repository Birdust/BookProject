package com.example.bookproject;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Map;

public class BookListActivity extends AppCompatActivity {

    private ListView bookListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        bookListView = findViewById(R.id.bookListView);

        // 저장된 책 정보 가져오기
        SharedPreferences sharedPreferences = getSharedPreferences("RecommendedBooks", MODE_PRIVATE);
        Map<String, ?> bookMap = sharedPreferences.getAll();
        ArrayList<String> bookList = new ArrayList<>();

        // 책 정보를 리스트에 추가
        for (Map.Entry<String, ?> entry : bookMap.entrySet()) {
            String bookTitle = entry.getKey();
            String bookInfo = entry.getValue().toString();
            bookList.add(bookTitle + ": " + bookInfo);
        }

        // 리스트를 어댑터에 연결하여 표시
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bookList);
        bookListView.setAdapter(adapter);
    }
}
