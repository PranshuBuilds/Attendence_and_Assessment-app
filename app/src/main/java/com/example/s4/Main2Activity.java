package com.example.s4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import me.anwarshahriar.calligrapher.Calligrapher;

public class Main2Activity extends AppCompatActivity {
    ImageView bt;
    Button signup;
    EditText name;
    EditText sysid;
    EditText password;
    EditText email;
    FirebaseAuth mFirebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Calligrapher calligrapher=new Calligrapher(this);
        calligrapher.setFont(this,"ubuntulight.ttf",true);
        bt=(ImageView)findViewById(R.id.imageView2);
        name=(EditText) findViewById(R.id.editText2);
        password=(EditText) findViewById(R.id.editText6);
        sysid=(EditText) findViewById(R.id.editText4);
        email=(EditText) findViewById(R.id.editText5);
        signup=(Button) findViewById(R.id.button2);
        mFirebaseAuth=FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid=email.getText().toString();
                String pwd=password.getText().toString();
                String nm=name.getText().toString();
                String systemid=sysid.getText().toString();
                if(emailid.isEmpty()||pwd.isEmpty()||nm.isEmpty()||systemid.isEmpty()){
                    Toast.makeText(Main2Activity.this,"fields are empty",Toast.LENGTH_LONG).show();
                }
                else{
                    mFirebaseAuth.createUserWithEmailAndPassword(emailid,pwd).addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Main2Activity.this,"Sign-up unsuccessful",Toast.LENGTH_LONG).show();

                            }
                            else {
                                startActivity(new Intent(Main2Activity.this,Main3Activity.class));
                            }

                        }
                    });
                }

            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
