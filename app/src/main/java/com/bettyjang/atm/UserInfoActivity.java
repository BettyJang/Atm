package com.bettyjang.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {

    private Spinner ages;
    private String TAG = UserInfoActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ages = (Spinner) findViewById(R.id.ages);

        ArrayList<String> data = new ArrayList<>();
        for (int i = 15;i <= 40;i++){
            data.add(i+" ");
        } ArrayAdapter Adapter = new ArrayAdapter(this,android.
                R.layout.simple_list_item_1,databaseList());
        ages.setAdapter(Adapter);
    }
    public void ok(View view){
        Log.d(TAG, "ok: "+ages.getSelectedItem().toString());
        int age = Integer.parseInt(ages.getSelectedItem().toString());
        EditText edNickname = (EditText) findViewById(R.id.user_nickname);
        EditText edPhone = (EditText) findViewById(R.id.user_phone);
        String nickname = edNickname.getText().toString();
        String phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", nickname);
        getIntent().putExtra("c", phone);
        setResult(RESULT_OK, getIntent());
               finish();
            }
    }

