package com.example.octavian.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String name, mutter, tier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences prefs= getPreferences(MODE_PRIVATE);

        name = prefs.getString("name", "");
        mutter = prefs.getString("mutter", "");
        tier = prefs.getString("tier", "");

        ((EditText) findViewById(R.id.editText)).setText(name);
        ((EditText) findViewById(R.id.editText2)).setText(mutter);
        ((EditText) findViewById(R.id.editText3)).setText(tier);


        findViewById(R.id.commitButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ((EditText) findViewById(R.id.editText)).getText().toString();
                mutter = ((EditText) findViewById(R.id.editText2)).getText().toString();
                tier = ((EditText) findViewById(R.id.editText3)).getText().toString();

                SharedPreferences.Editor e = prefs.edit();
                e.putString("name", name);
                e.putString("mutter", mutter);
                e.putString("tier", tier);
                e.commit();
            }
        });
    }
}
