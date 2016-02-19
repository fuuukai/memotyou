package com.lifeistech.android.techmemotyou;

import android.view.MenuItem;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by fukai on 16/02/19.
 */

@Table(name="")
public class MemoDB extends Model {

    @Column(name = "title")
    public String title;

    @Column(name = "memo")
    public String memo;

    @Column(name = "date")
    public String date;

    @Override
    public String toString(){
        return title;
    }


}
