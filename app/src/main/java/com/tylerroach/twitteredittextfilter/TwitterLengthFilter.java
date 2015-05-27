package com.tylerroach.twitteredittextfilter;

/**
 * Created by tylerroach on 5/26/15.
 */

import android.text.InputFilter;
import android.text.Spanned;

import com.twitter.Validator;

public class TwitterLengthFilter implements InputFilter {
    private int max;
    private Validator tweetValidator;

    public TwitterLengthFilter(int max, Validator tweetValidator) {
        this.max = max;
        this.tweetValidator = tweetValidator;
    }

    public CharSequence filter(CharSequence source, int start, int end, Spanned dest,
                               int dstart, int dend) {

        String destString = dest.subSequence(0, dstart).toString();
        String sourceString = source.subSequence(start, end).toString();
        String fullTextString = destString + sourceString;

        if (fullTextString.length() == 0) {
            return "";
        } else if (tweetValidator.getTweetLength(fullTextString) <= max) {
            return null; //keep original
        } else {
            CharSequence returnSource = "";
            for (int i=0; i<sourceString.length(); i++) {
                if (tweetValidator.getTweetLength(destString + source.subSequence(0, i + 1)) <= max) {
                    returnSource = source.subSequence(0, i + 1);
                }
            }
            return returnSource;
        }
    }

}