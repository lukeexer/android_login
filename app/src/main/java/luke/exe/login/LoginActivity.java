package luke.exe.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences pref;
    EditText account;
    CheckBox rememberAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        pref = getSharedPreferences("config", MODE_PRIVATE);
        account = LoginActivity.this.findViewById(R.id.account);
        rememberAccount = this.findViewById(R.id.rememberAccount);

        if (pref.getBoolean("RememberAccount", false)) {
            rememberAccount.setChecked(true);
            account.setText(pref.getString("Account", ""));
        }

        Button login = this.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = ((EditText)LoginActivity.this.findViewById(R.id.password)).getText().toString();
                pref.edit().putBoolean("RememberAccount", rememberAccount.isChecked()).commit();

                String accountStr = account.getText().toString();

                if (accountStr.equals("user") && password.equals("123456")) {
                    if (rememberAccount.isChecked()) {
                        pref.edit().putString("Account", account.getText().toString()).commit();
                    } else {
                        pref.edit().putString("Account", "").commit();
                    }

                    startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "帳號密碼錯誤", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}