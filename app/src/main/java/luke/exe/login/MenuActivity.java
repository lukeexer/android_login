package luke.exe.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button function1 = this.findViewById(R.id.function1);
        Button function2 = this.findViewById(R.id.function2);
        Button function3 = this.findViewById(R.id.function3);
        Button function4 = this.findViewById(R.id.function4);
        Button function5 = this.findViewById(R.id.function5);
        function1.setOnClickListener(this);
        function2.setOnClickListener(this);
        function3.setOnClickListener(this);
        function4.setOnClickListener(this);
        function5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.function1:
                startActivity(new Intent(this, FinActivity.class));
                break;

            case R.id.function2:
                Toast.makeText(this,"function2 is triggered", Toast.LENGTH_SHORT).show();
                break;

            case R.id.function3:
                Toast.makeText(this,"function3 is triggered", Toast.LENGTH_SHORT).show();
                break;

            case R.id.function4:
                Toast.makeText(this,"function4 is triggered", Toast.LENGTH_SHORT).show();
                break;

            case R.id.function5:
                Toast.makeText(this,"function5 is triggered", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}