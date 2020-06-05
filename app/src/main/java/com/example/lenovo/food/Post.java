package com.example.lenovo.food;

public class Post {
    private String name, phone, time, number;
    public Post(){}
    public Post (String name, String phone, String time, String number){
        this.name=name;
        this.phone=phone;
        this.time=time;
        this.number=number;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }

    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time=time;
    }

    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number=number;
    }

}
