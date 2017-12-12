package com.bettyjang.atm;

import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edUserid;
    private EditText edPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edUserid = (EditText) findViewById(R.id.userid);
        edPasswd = (EditText) findViewById(R.id.passwd);
        String Userid =  getSharedPreferences("atm",MODE_PRIVATE).getString("USER"," ");
        edUserid.setText(Userid);
    }
    public void login (View view){

        String userid = edUserid.getText().toString();
        String passwd = edPasswd.getText().toString();
        

        if ("jack".equals(userid) && "1234".equals(passwd)){
            Toast.makeText(this,"登入成功",Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_USERID",userid);
            getIntent().putExtra("LOGIN_PASSWD",passwd);
            getIntent().putExtra("EXTRA_Userid",userid);
            setResult(RESULT_OK,getIntent());
            finish();
        }else {
            new AlertDialog.Builder(this).setTitle("登入").setMessage("登入失敗")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
    public void cancel (View view){

    }
}
