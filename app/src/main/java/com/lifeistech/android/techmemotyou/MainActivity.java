package com.lifeistech.android.techmemotyou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.activeandroid.query.Select;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.memo_list);

        @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            MemoDB data = (MemoDB)parent.getItemAtPosition(position);
            Intent i = new Intent(MainActivity.this.MemoDetailActivity.class);
            i.putExtra("date", data.date);
            startActivity(i);
        }
    }

    void setMemoList(){
        List<MemoDB> memoList = new Select().from(MemoDB.class).execute();
        ArrayAdapter<MemoDB> adapter = new ArrayAdapter<> {
            getApplicationContext(),
                    R.layout.memo_row,
                    memoList
        };
        mListView.setAdapter(adapter);
    }


    public boolean onOptionItemSelected(MenuItem item){
        int id = item.getItemId();

        if(R.id.main_create == id){
            Intent i = new Intent(MainActivity.this, MemoCreateActicity.class);
            startActivity();

            return true;
        }


        if(R.id.create_save == id){
            saveMemo();
            finish();

            return true;
        }
        return super.onOptionItemSelected(item);
    }

    void saveMemo(){
        mMemoData.title = mTitle.getText().toString();
        mMemoData.memo = mMemo.getText().toString();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.JAPANESE);
        mMemoData.date = sdf.format(date);
        mMemoData.save();
    }

    public void onResume(){
        super.onResume();

        setMemoList();
    }
}
