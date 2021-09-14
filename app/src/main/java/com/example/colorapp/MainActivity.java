package com.example.colorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.colorapp.bean.ColorCheckBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private GridView simpleGrid;
    private  boolean isFirstTime =true;
    private ArrayList<Integer> randomNum = new ArrayList<>();
    private ArrayList<ColorCheckBean> check = new ArrayList<>();
    private ColorCheckBean firstPosition = new ColorCheckBean();
    private int countRed = 0;

    int logos[] = {R.color.green, R.color.white, R.color.white, R.color.white,
            R.color.white, R.color.white, R.color.white, R.color.white,
            R.color.white, R.color.white, R.color.white, R.color.white,
            R.color.white, R.color.white, R.color.white, R.color.white,
            R.color.white, R.color.white, R.color.white, R.color.white,
            R.color.white, R.color.white, R.color.white, R.color.white};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNum = genRandomNum();

        setUi();

    }

    private void setUi() {
        simpleGrid = (GridView) findViewById(R.id.simpleGridView);

        System.out.println(randomNum);

        CustomGridAdapter customAdapter = new CustomGridAdapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);

                setOnClickFunction();



    }

    private void setOnClickFunction() {



            check.clear();
                simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                        if (check.size()!=24) {
                            if (isFirstTime == true) {

                                isFirstTime = false;
                                view.setBackgroundColor(MainActivity.this.getColor(R.color.red));
                                ColorCheckBean bean = new ColorCheckBean();

                                bean.setCount(countRed);
                                bean.setClicked(true);
                                bean.setClickedColor("red");
                                bean.setPrePosition(position);

                                HashMap<String, String> hashMap = new HashMap<>();
                                hashMap.put(String.valueOf(position), "red");

                                simpleGrid.getChildAt(randomNum.get(countRed)).setBackgroundColor(MainActivity.this.getColor(R.color.green));
                                bean.setColor("green");
                                bean.setRandomNum(randomNum.get(countRed));



                                HashMap<String, String> hashMapsel = new HashMap<>();
                                hashMapsel.put(String.valueOf(randomNum), "green");
                                check.add(bean);


                            } else {

                                try {
                                    ColorCheckBean bean = new ColorCheckBean();


                                    if (check.get(countRed).getPrePosition() != position && check.get(countRed).getColor().equalsIgnoreCase("green")
                                            && check.get(countRed).getRandomNum() == position) {
                                        view.setBackgroundColor(MainActivity.this.getColor(R.color.red));
                                        bean.setCount(countRed + 1);
                                        bean.setClicked(true);
                                        bean.setClickedColor("red");
                                        bean.setPrePosition(position);



                                        if (check.get(countRed).getPrePosition() != position && check.get(countRed).getRandomNum() == position) {
                                            simpleGrid.getChildAt(randomNum.get(countRed + 1)).setBackgroundColor(MainActivity.this.getColor(R.color.green));
                                            bean.setColor("green");
                                            bean.setRandomNum(randomNum.get(countRed + 1));


                                            check.add(bean);


                                        }

                                        countRed = countRed + 1;

                                    }


                                } catch (Exception e) {
                                    e.printStackTrace();
                                }


                            }
                        }else {
                            simpleGrid.getChildAt(randomNum.get(countRed)).setBackgroundColor(MainActivity.this.getColor(R.color.red));

                            Toast.makeText(MainActivity.this, "Tutorial is over", Toast.LENGTH_SHORT).show();
                        }


                    }
                });


    }



    private ArrayList<Integer> genRandomNum() {
        int max=24;
        int numNeed = 24;
        Random random = new Random();
        ArrayList<Integer> generate = new ArrayList();
        while (generate.size()<numNeed){
            int randomNum =random.nextInt(24);
            if (!generate.contains(randomNum)) {
                generate.add(randomNum);
            }


        }
        return generate;

    }
}
