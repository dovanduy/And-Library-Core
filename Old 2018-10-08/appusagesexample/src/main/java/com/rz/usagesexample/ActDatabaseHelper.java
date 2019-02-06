package com.rz.usagesexample;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rz.librarycore.log.LogWriter;
import com.rz.librarycore.storage.SQLiteDBCopyHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ActDatabaseHelper extends AppCompatActivity {
    //|------------------------------------------------------------|
    private Activity activity;
    private Context context;
    //|------------------------------------------------------------|
    private SQLiteDBCopyHelper sqLiteDBCopyHelper = null;
    private SQLiteDatabase sqLiteDatabase;
    private String sqlQuery = "";

    //|------------------------------------------------------------|
    //private final String SQLITE_DB_NAME = "app_test_db.sqlite3";
    private final String SQLITE_DB_NAME = "db_cmdss.sqlite3";
    private final String SQLITE_DB_DIR = "/database/";

    //|------------------------------------------------------------|
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //|------------------------------------------------------------|
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_database_helper);
        //|------------------------------------------------------------|
        activity = this;
        context = this;
        //|------------------------------------------------------------|
        onInsert();
        sqLiteDBCopyHelper = new SQLiteDBCopyHelper(context, SQLITE_DB_NAME, SQLITE_DB_DIR);
        if (sqLiteDBCopyHelper != null) {
            sqLiteDBCopyHelper.onOpenDatabase();
            sqlQuery = " SELECT * FROM tbl_draft_message ";
            System.out.println("SQL_SELECT: " + sqlQuery);
            Cursor cursor = sqLiteDBCopyHelper.getSqlQueryResults(sqlQuery);
            System.out.println("CURSOR_COUNT: " + cursor.getCount());
            while (cursor.moveToNext()) {
                String msgId = cursor.getString(cursor.getColumnIndex("tdm_id"));
                String msgSubject = cursor.getString(cursor.getColumnIndex("tdm_subject"));
                System.out.println("ID: " + msgId);
                System.out.println("Subject: " + msgSubject);
            }
            cursor.close();
        }
        sqLiteDBCopyHelper.onCloseDatabase();
        //|------------------------------------------------------------|
    }

    //|------------------------------------------------------------|
    private void onInsert() {
        sqLiteDBCopyHelper = new SQLiteDBCopyHelper(context, SQLITE_DB_NAME, SQLITE_DB_DIR);
        if (sqLiteDBCopyHelper != null) {
            sqLiteDBCopyHelper.onOpenDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("tdm_id", System.currentTimeMillis() + "");
            contentValues.put("tdm_subject", "Subject Subject Subject Subject " + System.currentTimeMillis());
            contentValues.put("tdm_body", "Body Body Body Body " + System.currentTimeMillis());
            contentValues.put("tdm_sender", "Mobile Number " + System.currentTimeMillis());
            contentValues.put("tdm_receiver_type", System.currentTimeMillis());
            contentValues.put("tdm_receiver", System.currentTimeMillis());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            contentValues.put("tdm_create_date", simpleDateFormat.format(date));
            LogWriter.Log("DATE: " + simpleDateFormat.format(date));
            boolean isInserted = sqLiteDBCopyHelper.onInsert("tbl_draft_message", contentValues);
            sqLiteDBCopyHelper.onCloseDatabase();
            if (isInserted)
                Toast.makeText(context, "Message saved", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context, "Can't save message, please try again", Toast.LENGTH_LONG).show();
        }
    }
    //|------------------------------------------------------------|
}
/*
sqLiteDBCopyHelper = new SQLiteDBCopyHelper(context, APPConstants.DB_SQLITE.DB_NAME, APPConstants.DB_SQLITE.DB_DIR);
if (sqLiteDBCopyHelper != null) {
    sqLiteDBCopyHelper.onOpenDatabase();
    String whereClause = "tdm_id = '" + argDraftsItems.get("tdm_id") + "'";
    sqLiteDBCopyHelper.onDelete("tbl_draft_message", whereClause);
    sqLiteDBCopyHelper.onCloseDatabase();
    onGetSetDraftsData();
    dialogMsgSend.dismiss();
}
*/