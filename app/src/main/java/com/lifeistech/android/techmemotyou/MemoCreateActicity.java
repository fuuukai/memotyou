package com.lifeistech.android.techmemotyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.SimpleTimeZone;

public class MemoCreateActicity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    MemoDB mMemoDB;
    EditText mTitle;
    EditText mMemo;

    ListView mListView;

    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_create);

        mTitle = (EditText)findViewById(R.id.create_title);
        mMemo = (EditText)findViewById(R.id.create_memo);
        mMemoDB = new MemoDB();
        mListView = (ListView)findViewById(R.id.memo_list);
    }

}
