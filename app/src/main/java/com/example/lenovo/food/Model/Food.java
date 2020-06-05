package com.example.lenovo.food.Model;

import android.support.annotation.StringDef;

/**
 * Created by Lenovo
 */

public class Food {
   private String Name,Image,Description,Price,Discount,Textdatetime,MenuId;
   public Food(){}
   public Food(String name, String image, String description, String price, String discount, String menuId, String textdatetime){
       Name=name;
       Image=image;
       Description=description;
       Price=price;
       Discount=discount;
       MenuId=menuId;
       Textdatetime = textdatetime;
   }
   public String getName(){
       return Name;
   }
   public void setName(String name){
       Name=name;
   }
    public String getDescription(){
        return Description;
    }
    public void setDescription(String description){
        Description=description;
    }
    public String getImage(){
        return Image;
    }
    public void setImage(String image){
        Image=image;
    }
    public String getPrice(){
        return Price;
    }
    public void setPrice(String price){
        Price=price;
    }
    public String getDiscount(){
        return Discount;
    }
    public void setDiscount(String discount){
        Discount=discount;
    }
    public String getMenuId(){
        return MenuId;
    }
    public void setMenuId(String menuId){
        MenuId=menuId;
    }
    public String getTextdatetime(){
       return Textdatetime;
   }
    public void getTextdatetime(String textdatetime){
       Textdatetime=textdatetime;
   }
}
