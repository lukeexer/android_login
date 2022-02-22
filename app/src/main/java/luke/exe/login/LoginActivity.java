package luke.exe.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = this.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = ((EditText)LoginActivity.this.findViewById(R.id.account)).getText().toString();
                String password = ((EditText)LoginActivity.this.findViewById(R.id.password)).getText().toString();

                if (account.equals("user") && password.equals("123456")) {
                    startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this,"帳號密碼錯誤", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}