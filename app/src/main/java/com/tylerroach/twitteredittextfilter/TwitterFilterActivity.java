package com.tylerroach.twitteredittextfilter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.twitter.Validator;


public class TwitterFilterActivity extends AppCompatActivity {

    protected EditText twitterEditText;
    protected TextView textCounter;
    protected Toolbar toolbar;

    Validator tweetValidator = new Validator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twitter_filter);


        textCounter = (TextView) findViewById(R.id.text_counter);
        twitterEditText = (EditText) findViewById(R.id.twitter_edit_text);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        textCounter.setText("140");
        twitterEditText.setFilters(new InputFilter[] {new TwitterLengthFilter(140, tweetValidator)});

        twitterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int length = 140 - tweetValidator.getTweetLength(s.toString());
                textCounter.setText(Integer.toString(length));
            }
        });

    }

}
