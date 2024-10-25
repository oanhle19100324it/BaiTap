package com.example.baitap;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    private EditText edtPhoneNumber, edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPhoneNumber = findViewById(R.id.editTextText);
        edtPassword = findViewById(R.id.editTextText2);
        btnLogin = findViewById(R.id.btn_loginuser);


        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String savedPhoneNumber = sharedPreferences.getString("phoneNumber", "");
        String savedPassword = sharedPreferences.getString("password", "");

        edtPhoneNumber.setText(savedPhoneNumber);
        edtPassword.setText(savedPassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = edtPhoneNumber.getText().toString();
                String password = edtPassword.getText().toString();

                if (!phoneNumber.isEmpty() && !password.isEmpty()) {
                    // Lưu thông tin vào SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("phoneNumber", phoneNumber);
                    editor.putString("password", password);
                    editor.apply();

                    Toast.makeText(MainActivity.this, "Thông tin đã được lưu", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}