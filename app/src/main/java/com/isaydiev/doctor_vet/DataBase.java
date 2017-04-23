package com.isaydiev.doctor_vet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.isaydiev.doctor_vet.Models.Item;
import com.isaydiev.doctor_vet.Models.News;
import com.isaydiev.doctor_vet.Models.Pic;

import java.util.ArrayList;

/**
 * Created by USER on 08.04.2017.
 */

public class DataBase extends SQLiteOpenHelper{

    private SQLiteDatabase db;

    public  DataBase(Context context){
        super(context, "doctorvet_app_db", null, 2);
        db = getWritableDatabase();
    }

    private static String CREATE_TABLE_NEWS =
            "CREATE TABLE news (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "id INTEGER UNIQUE," +
                    "title TEXT," +
                    "name TEXT," +
                    "announce TEXT," +
                    "date TEXT," +
                    "url TEXT," +
                    "src TEXT);";
    private static String CREATE_TABLE_SERVICES =
            "CREATE TABLE services (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "id INTEGER UNIQUE," +
            "title TEXT," +
            "price TEXT);";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NEWS);
        db.execSQL(CREATE_TABLE_SERVICES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < newVersion){
            db.execSQL("DROP TABLE IF EXISTS news");
            db.execSQL("DROP TABLE IF EXISTS services");
            onCreate(db);
        }
    }

    private void insertNews(News news){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id" , news.getId());
        contentValues.put("name", news.getName());
        contentValues.put("title", news.getTitle());
        contentValues.put("url", news.getUrl());
        contentValues.put("date", news.getDate());
        contentValues.put("announce", news.getAnnounce());
        contentValues.put("src", news.getPic().getPreview().getSrc());
        db.insertWithOnConflict("news", null, contentValues,
                SQLiteDatabase.CONFLICT_REPLACE);
    }

    public void insertServices(Item item){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", item.getId());
        contentValues.put("title", item.getTitle());
        contentValues.put("price", item.getPrice());
        db.insertWithOnConflict("services", null, contentValues,
                SQLiteDatabase.CONFLICT_REPLACE);
    }

    public void insertNewsList(ArrayList<News> newsList){
        for(News s: newsList){
            insertNews(s);
        }
    }
    public void insertServicesList(ArrayList<Item> servicesList){
        for (Item i: servicesList) {
            insertServices(i);
        }
    }

    public ArrayList<News> getNewsList(){
        ArrayList<News> list = new ArrayList<>();
        Cursor cursor = db.query("news", null, null, null, null, null, null);
        if(cursor != null && cursor.moveToFirst()){
            while (cursor.moveToNext()){
                News news = new News();
                news.setId(cursor.getInt(cursor.getColumnIndex("id")));
                news.setName(cursor.getString(cursor.getColumnIndex("name")));
                news.setDate(cursor.getString(cursor.getColumnIndex("date")));
                news.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                news.setAnnounce(cursor.getString(cursor.getColumnIndex("announce")));
                news.setUrl(cursor.getString(cursor.getColumnIndex("url")));


                Pic pic = new Pic();
                Pic.Preview preview = new Pic.Preview();
                preview.setSrc(cursor.getString(cursor.getColumnIndex("src")));
                pic.setPreview(preview);
                news.setPic(pic);
                list.add(news);
            }
            cursor.close();
        }
        return list;
    }

    public ArrayList<Item> getServicesList(){
        ArrayList<Item> itemList = new ArrayList<>();
        Cursor cursor = db.query("services", null, null, null, null, null, null);
        if(cursor != null && cursor.moveToFirst()){
            while (cursor.moveToNext()){
                Item item = new Item();
                item.setId(cursor.getInt(cursor.getColumnIndex("id")));
                item.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                item.setPrice(cursor.getString(cursor.getColumnIndex("price")));
                itemList.add(item);
            }
            cursor.close();
        }
        return itemList;
    }

}
