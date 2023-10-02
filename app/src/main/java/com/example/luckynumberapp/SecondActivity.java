package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView luckyView = findViewById(R.id.luckyView);
        TextView displayText = findViewById(R.id.displayText);
        Button shareButton = findViewById(R.id.shareButton);
//Receiving the data or name from the main activity so use this.
        Intent intent=getIntent();
//Now store the key of the main activity in the String so make new string and store the key.
        String userName=intent.getStringExtra("name");

//Now generating the Random number
        int random_num= generateRandomNumber();
        displayText.setText(""+random_num);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,random_num);
            }
        });
    }
    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit=1000;
        int randomNumberGenerated=random.nextInt(upper_limit);
        return randomNumberGenerated;
    }
    public void shareData(String username,int randomNum){
      //Using Implicit Intent
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
      //Additional Information
        intent.putExtra(Intent.EXTRA_SUBJECT,username +"got Lucky today");
        intent.putExtra(Intent.EXTRA_TEXT,"His Lucky number is"+randomNum);

        startActivity(Intent.createChooser(intent,"Choose a Platform"));
    }
}