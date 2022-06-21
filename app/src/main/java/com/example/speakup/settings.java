package com.example.speakup;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.view.WindowManager;

public class settings extends AppCompatActivity{

        AppCompatButton logout_button;

        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            logout_button.setOnClickListener(view ->{
                startActivity(new Intent(com.example.speakup.settings.this, Login.class));
            });

        }

    }

