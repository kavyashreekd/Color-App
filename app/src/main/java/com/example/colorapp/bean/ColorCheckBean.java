package com.example.colorapp.bean;

import java.io.Serializable;

public class ColorCheckBean implements Serializable {
    private boolean isClicked =false;
    private int count=0;
    private String color="";
    private String clickedColor="";
    private int randomNum=0;

    public int getPrePosition() {
        return prePosition;
    }

    public void setPrePosition(int prePosition) {
        this.prePosition = prePosition;
    }

    private int prePosition=0;

    public int getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(int randomNum) {
        this.randomNum = randomNum;
    }



    public String getClickedColor() {
        return clickedColor;
    }

    public void setClickedColor(String clickedColor) {
        this.clickedColor = clickedColor;
    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }



    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
