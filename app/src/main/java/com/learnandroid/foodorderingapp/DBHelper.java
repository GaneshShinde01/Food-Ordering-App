package com.learnandroid.foodorderingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.learnandroid.foodorderingapp.Models.OrderModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBName = "mydatabase.db";
    final static int DBVersion = 1;


    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "create table orders "+
                        "(id integer primary key autoincrement," +
                        "name text,"+
                        "phone text," +
                        "price double," +
                        "quantity integer,"+
                        "image integer," +
                        "description text,"+
                        "foodname text)"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists orders");

        onCreate(db);
    }

    public boolean insertOrder(String name, String phone, double price,int quantity, int image, String description, String foodName){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();


        values.put("name",name); // 1
        values.put("phone",phone); // 2
        values.put("price",price); //3
        values.put("quantity",quantity); //4
        values.put("image",image); //5
        values.put("description",description); //6
        values.put("foodName",foodName); //7

        long id = database.insert("orders",null,values);

        if(id <= 0){
            return false;
        }else {
            return true;
        }

    }

    public ArrayList<OrderModel> getOrders(){

        ArrayList<OrderModel> orderModelArrayList = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.rawQuery("select id, foodname,image, price from orders",null);

        if (cursor.moveToFirst()){
            while (cursor.moveToNext()){

                OrderModel orderModel = new OrderModel();
                orderModel.setOrdered_number(cursor.getInt(0)+"");
                orderModel.setOrdered_food_name(cursor.getString(1));
                orderModel.setOrdered_food_image(Integer.parseInt(cursor.getString(2)));
                orderModel.setOrdered_food_price(cursor.getString(3)+"");

                orderModelArrayList.add(orderModel);
            }
        }

        cursor.close();
        database.close();

        return orderModelArrayList;
    }

    public Cursor getOrderById(int id){



        SQLiteDatabase database = this.getWritableDatabase();

        Cursor cursor = database.rawQuery("select * from orders where id = "+ id ,null);

        if(cursor != null){
            cursor.moveToFirst();
        }

       /* cursor.close();
        database.close();*/

        return cursor;
    }

    public boolean updateOrder(int id,String name, String phone, double price,int quantity, int image, String description, String foodName){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();

        /*
         * id = 0
         * name = 1
         * phone = 2
         * price = 3
         * quantity = 4
         * image = 5
         * description = 6
         * foodName = 7
         *
         * */
        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("quantity",quantity);
        values.put("image",image);
        values.put("description",description);
        values.put("foodName",foodName);

        long row = database.update("orders",values,"id = "+id, null);

        if(row <= 0){
            return false;
        }else {
            return true;
        }

    }

    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();

        return database.delete("orders","id="+id,null);
    }
}
