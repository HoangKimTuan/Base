package com.tuanhk.utils;

import android.util.Log;

public class AndroidUtils {

    public static float density = 1;
    private static final int INT_EMPTY = 0;

    public static int dp(float value) {
        try {
            if (value == 0)
                return 0;

            return (int) Math.ceil(density * value);
        } catch (Exception e) {
            Log.d( "dp exception [%s]", e.getMessage());
        }
        return INT_EMPTY;
    }
}