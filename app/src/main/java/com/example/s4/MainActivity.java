package com.example.s4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import me.anwarshahriar.calligrapher.Calligrapher;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    TextView signup;
    Button button;
    FirebaseAuth mfirebase;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calligrapher calligrapher = new Calligrapher(this);
        calligrapher.setFont(this, "ubuntulight.ttf", true);

        email = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText3);
        button = (Button) findViewById(R.id.button);
        signup = (TextView) findViewById(R.id.textView);
        mfirebase = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailid = email.getText().toString();
                String pwd = password.getText().toString();

                if (emailid.isEmpty() || pwd.isEmpty()) {
                    Toast.makeText(MainActivity.this, "fields are empty", Toast.LENGTH_LONG).show();
                } else {
                    mfirebase.signInWithEmailAndPassword(emailid, pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Error log in", Toast.LENGTH_LONG).show();

                            } else {
                                startActivity(new Intent(MainActivity.this, Main3Activity.class));

                            }
                        }
                    });

                }

            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mfirebase.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(MainActivity.this, "fields are empty", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, Main3Activity.class));


                } else {
                    Toast.makeText(MainActivity.this, "Please log in", Toast.LENGTH_LONG).show();

                }
            }
        };
    }

    public void onClick1(View view) {
        Intent i = new Intent(MainActivity.this, Main2Activity.class);

        startActivity(i);


    }

}
