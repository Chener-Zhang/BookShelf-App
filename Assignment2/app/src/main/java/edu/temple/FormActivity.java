package edu.temple;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormActivity extends AppCompatActivity {


    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        save_press();


    }

    public int check_input() {

        TextView check_name = findViewById(R.id.User_Name);
        TextView check_email = findViewById(R.id.Email);
        TextView password_1 = findViewById(R.id.Password_1);
        TextView password_2 = findViewById(R.id.Password_2);


        String user_enter_name = check_name.getText().toString();
        this.username = user_enter_name;
        String user_enter_email = check_email.getText().toString();
        String user_enter_password1 = password_1.getText().toString();
        String user_enter_password2 = password_2.getText().toString();


        if (user_enter_name.matches("")) {
            Toast.makeText(this, "you must enter name", Toast.LENGTH_SHORT).show();
            return 0;
        } else if (user_enter_email.matches("")) {
            Toast.makeText(this, "you must enter email", Toast.LENGTH_SHORT).show();

            return 0;
        } else if (user_enter_password1.matches("")) {
            Toast.makeText(this, "you must enter password", Toast.LENGTH_SHORT).show();
            return 0;
        } else if (user_enter_password1.matches("")) {
            Toast.makeText(this, "you must enter password to comfirm", Toast.LENGTH_SHORT).show();
            return 0;
        }

        if (!user_enter_password1.matches(user_enter_password2)) {
            Toast.makeText(this, "password you enter does not match, Please re-enter again", Toast.LENGTH_SHORT).show();
            return 0;
        }

        return 1;

    }

    public void save_press() 
    {
        Button save_bottom = findViewById(R.id.save_button);
        save_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check_input() == 1) {
                    Toast.makeText(FormActivity.this, "Welcome come " + username, Toast.LENGTH_SHORT).show();
                    System.out.println();
                }
            }
        });


    }

}
