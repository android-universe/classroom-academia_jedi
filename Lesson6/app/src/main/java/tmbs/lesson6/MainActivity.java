package tmbs.lesson6;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {


    private FrameLayout frameLayout;
    private EditText editTextLogin, editTextPassword;
    private String login, password;
    private Button buttonAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        editTextLogin = (EditText) findViewById(R.id.editText);
        editTextPassword = (EditText) findViewById(R.id.editText2);
        buttonAccess = (Button) findViewById(R.id.button);


        if(StoreData.getLoginSharedPreferences(this) != null && StoreData.getPasswordSharedPreferences(this) != null){
            editTextLogin.setText(StoreData.getLoginSharedPreferences(this));
            editTextPassword.setText(StoreData.getPasswordSharedPreferences(this));
        }


        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    frameLayout.setVisibility(View.VISIBLE);
                } else {
                    frameLayout.setVisibility(View.INVISIBLE);
                }
            }
        });

        buttonAccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_shared_preferences:
                if (checked)
                    StoreData.saveInSharedPreferences(MainActivity.this,editTextLogin.getText().toString(), editTextPassword.getText().toString());
                break;
            case R.id.radio_internal_store:
                if (checked)
                    StoreData.saveInInternalStore(MainActivity.this,editTextLogin.getText().toString(), editTextPassword.getText().toString());
                break;


        }
    }


}
