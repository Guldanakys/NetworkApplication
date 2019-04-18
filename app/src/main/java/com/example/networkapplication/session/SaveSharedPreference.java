package com.example.networkapplication.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static com.example.networkapplication.session.PreferencesUtility.LOGGED_IN_PREF;
import static com.example.networkapplication.session.PreferencesUtility.USER_TOKEN_PREF;

public class SaveSharedPreference {

    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setLoggedIn(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.apply();
    }

    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false);
    }

    public static void setUserToken(Context context, String token) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(USER_TOKEN_PREF, token);
        editor.apply();
    }

    public static String getUserToken(Context context) {
        return getPreferences(context).getString(USER_TOKEN_PREF, "");
    }
}
