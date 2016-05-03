package proyecto.android.ingesis.uniquindio.edu.co.campusuq.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Cristian jojoa
 * Edwin tabares
 * maria fernanda
 */
public class Utilities {

    public final static String MY_PREFERENCES = "MisPreferencias";
    public final static String LANGUAGE_PREFERENCES = "languaje_preferences";
    public final static String LANGUAGE_ES = "es";
    public final static String LANGUAGE_EN = "en";

    public static void changeLanguage(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFERENCES, context.MODE_PRIVATE);
        String language = prefs.getString(LANGUAGE_PREFERENCES, LANGUAGE_EN);
        if (language.equals(LANGUAGE_ES)) {
            language = LANGUAGE_EN;
        } else if (language.equals(LANGUAGE_EN)) {
            language = LANGUAGE_ES;
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(LANGUAGE_PREFERENCES, language);
        editor.commit();
        //getLanguage(context);
    }
}
