package com.example.sharif.textfield;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText user, pass;
    RelativeLayout relativeLayout;
    TextInputLayout userLayout ;
    public static final String TAG ="SHARIF";

    TextInputLayout passLayout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.activity_main);

        userLayout = findViewById(R.id.username_text_inputlayout);

        passLayout = findViewById(R.id.username_password_inputlayout);

        user = findViewById(R.id.username_text);
        pass = findViewById(R.id.username_password);

        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                System.out.println("before text change: "+s);
                Log.i(TAG, "beforeTextChanged: " +s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                System.out.println("On text change: " +s);
                Log.i(TAG, "On text change: " +s);
            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println("After text change: " + s);
                Log.i(TAG, "After text change: " +s);
            }
        });
// focus change
        user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(user.getText().toString().isEmpty()){
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("Please enter your username");
                }else{
                    userLayout.setErrorEnabled(false);
                }
            }
        });


        user.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(user.getText().toString().isEmpty()){
                    userLayout.setErrorEnabled(true);
                    userLayout.setError("Please enter your username");
                }else{
                    userLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(8);

// this line of code is to make focus on none field
        relativeLayout.setOnClickListener(null);

    }

}
