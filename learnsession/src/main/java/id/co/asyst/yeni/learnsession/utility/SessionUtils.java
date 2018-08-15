package id.co.asyst.yeni.learnsession.utility;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionUtils {

    final String KEY_NAME = "name";
    final String KEY_ADDRESS = "address";
    final String KEY_GENDER = "gender";
    final String KEY_EDU = "edu";
    Context mContex;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    public SessionUtils(Context context) {
        this.mContex = context;

        preferences = context.getSharedPreferences("training", 0);

        editor = preferences.edit();
    }

    public void saveName(String name, String address, String gender, String edu) {
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_ADDRESS, address);
        editor.putString(KEY_GENDER, gender);
        editor.putString(KEY_EDU, edu);
        editor.commit();
    }


    public String loadName() {
        String name = preferences.getString(KEY_NAME, "");
        return name;
    }

    public String loadAddress() {
        String address = preferences.getString(KEY_ADDRESS, "");
        return address;
    }

    public String loadGender() {
        String gender = preferences.getString(KEY_GENDER, "");
        return gender;
    }

    public String loadEdu() {
        String edu = preferences.getString(KEY_EDU, "");
        return edu;
    }
}
