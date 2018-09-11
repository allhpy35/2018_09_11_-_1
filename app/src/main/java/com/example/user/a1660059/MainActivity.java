package com.example.user.a1660059;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final int ARRAY_SIZE =  1000;
    protected int[] arrayData;                       //int array
    protected Button btCalc;
    protected TextView tvAvg, tvVar, tvStd;


    protected  void makeArray(int nSize){
            arrayData = new int[nSize];

    }

    protected void fillArray(int nSize){
        for(int i = 0; i < nSize; i++){
            arrayData[i]= i+1;
        }
    }

    protected double getAvg(int nSize){            //평균계산

        double sum = 0;
        for(int i  =0; i < nSize; i++){
            sum += arrayData[i];
        }
        return sum/nSize;
    }

    protected double getvar(int nSize){            //분산
        double sumSquare = 0;
        for(int i =0; i <nSize; i++){
            sumSquare += arrayData[i]*arrayData[i];
        }
        double avg = getAvg(nSize);
        return sumSquare / nSize - avg*avg;


    }

    protected double getStd(int  nSize){               //표준편차


        return Math.sqrt(getvar(nSize));
    }



    protected void PrintTextview(double avg , double var, double std) {
        String sAvg = String.format("평균 = %g", avg);
        tvAvg.setText(sAvg);
        String sVar = String.format("분산 = %g", var);
        tvVar.setText(sVar);
        String sStd = String.format("표준펺파 = %g", std);
        tvStd.setText(sStd);
    }

    protected void calcArrayStart(){
        makeArray(ARRAY_SIZE);
        fillArray(ARRAY_SIZE);
        double x1 = getAvg(ARRAY_SIZE);
        double x2 = getvar(ARRAY_SIZE);
        double x3 = getStd(ARRAY_SIZE);
        printTextView(avg,var,stdDev);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {         //UI 코드만 들어있다
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btCalc = (Button)findViewById(R.id.btn1);

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    calcArrayStart();

            }
        });

        tvAvg = (TextView)findViewById(R.id.avgText);
        tvVar = (TextView)findViewById(R.id.BunText);
        tvStd = (TextView)findViewById(R.id.PText);

    }
}
