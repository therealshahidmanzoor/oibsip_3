package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import  org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
MaterialButton buttonc,buttonac;
MaterialButton buttonopenbracket,buttonclosedbracket;
MaterialButton buttondiv,buttonmul,buttonplus,buttonminus,buttonequalto;
MaterialButton buttonseven,buttoneight,buttonnine,buttonfour,buttonfive,buttonsix,buttonone,buttontwo,buttonthree,buttonzero,buttondot;
TextView resultTextView,solutionTextView;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTextView=findViewById(R.id.resultTextView);
        solutionTextView=findViewById(R.id.soltionTextView);
        buttonc=findViewById(R.id.buttonc);
        buttonc.setOnClickListener(this);
        buttonac=findViewById(R.id.buttonac);
        buttonac.setOnClickListener(this);
        buttonopenbracket=findViewById(R.id.buttonopenbracket);
        buttonopenbracket.setOnClickListener(this);
        buttonclosedbracket=findViewById(R.id.buttonclosedbracket);
        buttonclosedbracket.setOnClickListener(this);
        buttondiv=findViewById(R.id.buttondiv);
        buttondiv.setOnClickListener(this);
        buttonmul=findViewById(R.id.buttonmul);
        buttonmul.setOnClickListener(this);
        buttonplus=findViewById(R.id.buttonplus);
        buttonplus.setOnClickListener(this);
        buttonminus=findViewById(R.id.buttonminus);
        buttonminus.setOnClickListener(this);
        buttonequalto=findViewById(R.id.buttonequalto);
        buttonequalto.setOnClickListener(this);
        buttonseven=findViewById(R.id.buttonseven);
        buttonseven.setOnClickListener(this);
        buttoneight=findViewById(R.id.buttoneight);
        buttoneight.setOnClickListener(this);
        buttonnine=findViewById(R.id.buttonnine);
        buttonnine.setOnClickListener(this);
        buttonfour=findViewById(R.id.buttonfour);
        buttonfour.setOnClickListener(this);
        buttonfive=findViewById(R.id.buttonfive);
        buttonfive.setOnClickListener(this);
        buttonsix=findViewById(R.id.buttonsix);
        buttonsix.setOnClickListener(this);
        buttonone=findViewById(R.id.buttonone);
        buttonone.setOnClickListener(this);
        buttontwo=findViewById(R.id.buttontwo);
        buttontwo.setOnClickListener(this);
        buttonthree=findViewById(R.id.buttonthree);
        buttonthree.setOnClickListener(this);
        buttonzero=findViewById(R.id.buttonzero);
        buttonzero.setOnClickListener(this);
        buttondot=findViewById(R.id.buttondot);
        buttondot.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        MaterialButton button=(MaterialButton) view;
        String buttonText=button.getText().toString();
       String DatatoCalculate=solutionTextView.getText().toString();

        if(buttonText.equals("AC")){
            solutionTextView.setText("");
            resultTextView.setText("0");
            return;
        }
        if(buttonText.equals("=")){
            solutionTextView.setText(resultTextView.getText());
            return;
        }
         if(buttonText.equals("C")){
             String s=solutionTextView.getText().toString();
             if(s.length()<=1){
                 solutionTextView.setText("");
                 return;
             }
                     DatatoCalculate=DatatoCalculate.substring(0,DatatoCalculate.length()-1);
        }
        else{
            if(DatatoCalculate.endsWith("+") && (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/"))){

            }
          else    if(DatatoCalculate.endsWith("-") && (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/"))){

             }
          else   if(DatatoCalculate.endsWith("*") && (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/"))){

             }
           else   if(DatatoCalculate.endsWith("/")  && (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/"))){

             }
             else{
                 DatatoCalculate+=buttonText;
             }

        }
        solutionTextView.setText(DatatoCalculate);
        String finalResult=getResult(DatatoCalculate);
        if(!finalResult.equals("Error")){
            resultTextView.setText(finalResult);
        }

    }
    String getResult(String string){
        try{
    Context context=Context.enter();
    context.setOptimizationLevel(-1);
    Scriptable scriptable=context.initSafeStandardObjects();
            String string1 = context.evaluateString(scriptable, string, "javascript", 1, null).toString();
            if(string1.endsWith(".0")){
                string1=string1.replace(".0","");
            }
            if(string1.equals("org.mozilla.javascript.Undefined")){
                string1="";
            }
            return string1;
        }
        catch (Exception e){
            return "Error";
        }
    }
}