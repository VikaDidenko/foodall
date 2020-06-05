package com.example.lenovo.food.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.lenovo.food.Model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo
 */

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME="database.db";
    private static final int DB_VER =1;

    public Database(Context context) {
        super(context, DB_NAME, null,DB_VER);
    }
    public List<Order> getCarts()
    {
        SQLiteDatabase dbs = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect={"ProductName","ProductId","Quantity","Price","Discount"};
        String sqlTables="OrderDetail";
        qb.setTables(sqlTables);
        Cursor c = qb.query(dbs,sqlSelect,null,null,null,null,null);

        final List<Order> result = new ArrayList<>();
        if(c.moveToFirst())
        {
            do {
                result.add(new Order(c.getString(c.getColumnIndex("ProductId")),
                        c.getString(c.getColumnIndex("ProductName")),
                        c.getString(c.getColumnIndex("Quantity")),
                        c.getString(c.getColumnIndex("Price")),
                        c.getString(c.getColumnIndex("Discount"))
                ));
            } while (c.moveToNext());
        }
        return result;
    }

    public void addToCart(Order order)
    {
        SQLiteDatabase dbs = getReadableDatabase();
        String query = String.format("INSERT INTO OrderDetail(ProductId,ProductName,Quantity,Price,Discount) VALUES('%s','%s','%s','%s','%s');",
                order.getProductId(),
                order.getProductName(),
                order.getQuantity(),
                order.getPrice(),
                order.getDiscount()
                );
        dbs.execSQL(query);
    }
    public void cleanToCart()
    {
        SQLiteDatabase dbs = getReadableDatabase();
        String query = String.format("DELETE FROM OrderDetail");
        dbs.execSQL(query);
    }
}
