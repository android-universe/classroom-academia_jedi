package tmbs.lesson6;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


/**
 * Created by thaisamirely on 9/26/15.
 */
public class StoreData {


    public static void saveInSharedPreferences(Context context, String login, String password){
        // Cria ou abre.
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREFERENCES_ID, Context.MODE_PRIVATE);

        // Precisamos utilizar um editor para alterar Shared Preferences.
        Editor editor = sharedPreferences.edit();

        saveLoginSharedPreferences(editor, login);

        savePasswordSharedPreferences(editor, password);
    }

    public static String getLoginSharedPreferences(Context context){
        // Acesso às Shared Preferences usando o nome definido.
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREFERENCES_ID, Context.MODE_PRIVATE);

        // Acesso às informações de acordo com o tipo.
        String login = sharedPreferences.getString(Constant.LOGIN, null);

        return login;
    }

    public static String getPasswordSharedPreferences(Context context){
        // Acesso às Shared Preferences usando o nome definido.
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.SHARED_PREFERENCES_ID, Context.MODE_PRIVATE);

        // Acesso às informações de acordo com o tipo.
        String password = sharedPreferences.getString(Constant.PASSWORD, null);

        return password;
    }


    public static void saveInInternalStore(Context context,String login, String password){

    }
    private static void saveLoginSharedPreferences(SharedPreferences.Editor editor, String login){
        editor.putString(Constant.LOGIN, login);
        editor.commit();
    }
    private static void savePasswordSharedPreferences(SharedPreferences.Editor editor, String password){
        editor.putString(Constant.PASSWORD, password);
        editor.commit();
    }




}
