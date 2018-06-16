package com.akashaarcher.android.healthcarenyc.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.akashaarcher.android.healthcarenyc.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.set_up_btn)
    Button setUpBtn;

    @BindView(R.id.home_find_service_btn)
    Button homeFindServiceBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ButterKnife.bind(this);

//        setUpBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent(SignUpActivity.this, UserProfileActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        homeFindServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
