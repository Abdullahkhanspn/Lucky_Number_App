package com.example.luckynumberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView welcomeView =findViewById(R.id.welcomeView);
        EditText hintView =findViewById(R.id.hintView);
        Button wishButton =findViewById(R.id.wishButton);
        wishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String userName = hintView.getText().toString();

                Intent intent =new Intent(getApplicationContext(), SecondActivity.class);
                // When we pass name or string ,int , boolean or any other we use putExtra method .
                intent.putExtra("name",userName);
                startActivity(intent);
            }
        });
    }
}