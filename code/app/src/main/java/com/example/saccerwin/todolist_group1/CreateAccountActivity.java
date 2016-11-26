package com.example.saccerwin.todolist_group1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by saccerwin on 26/11/2016.
 */

public class CreateAccountActivity extends AppCompatActivity {
    ImageView imgViewUploadAvatar;
    ImageView imgViewActionBack;
    ImageView imgViewActionDoneRegister;
    RadioGroup radioGroupGender;
    RadioButton rbFemale;
    RadioButton rbMale;
    EditText edtFullName;
    EditText edtEmail;
    EditText edtPassword;
    EditText edtBirthday;
    TextView tvSignIn;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        // mapping control

        imgViewActionBack = (ImageView)findViewById(R.id.imgViewBack);
        imgViewActionDoneRegister = (ImageView)findViewById(R.id.imgViewDoneRegister);
        imgViewUploadAvatar = (ImageView)findViewById(R.id.imgViewUploadAvatar);
        edtFullName = (EditText)findViewById(R.id.edtFullName);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        edtBirthday = (EditText)findViewById(R.id.edtBirthDay);
        tvSignIn = (TextView)findViewById(R.id.tvSignIn);
        rbFemale = (RadioButton)findViewById(R.id.radioButtonFemale);
        rbMale = (RadioButton)findViewById(R.id.radioButtonMale);

        onClinkActions();
    }


    public void onClinkActions() {

        imgViewActionBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        imgViewActionDoneRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imgViewActionDoneRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        if(rbFemale.isChecked()) {
            rbMale.setChecked(false);
        }
        if(rbMale.isChecked()) {
            rbFemale.setChecked(false);
        }


    }
}
