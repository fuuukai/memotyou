package com.lifeistech.android.techmemotyou;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MemoDetailActivity extends AppCompatActivity {

    MemoDB mMemoDB;
    EditText mTitle;
    EditText mMeomo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_detail);

        mTitle = (EditText)findViewById(R.id.detail_title);
        mMeomo = (EditText)findViewById(R.id.detail_memo);
        setMemo();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    void setMemo(){
        Intent i = getIntent();
        List<MemoDB> memoList = new Select().from(MemoDB.class).where("data = ?", i.getStringExtra("data")).execute();
        mMemoDB = memoList.get(0);
        mTitle.setText(mMemoDB.title);
        mMemo.setText(mMemoDB.memo);
    }

    void updateMemo(){
        mMemoData.title = mTitle.getText().toString();
        mMemoDB.memo = mMeomo.getText().toString();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        mMemoDB.date = sdf.format(date);
        mMemoDB.save();
    }

    public boolean onOptionItemSelected(MenuItem item){
        int id = item.getItemId();

        if(R.id.detail_save == id) {
            updateMemo();
            finish();

            return true;
        }

        return super.onOptionsItemSelected();
    }

}
