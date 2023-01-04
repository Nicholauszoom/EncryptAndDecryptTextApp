package com.example.encryptanddecrypttextapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
          // declaring all essential variables
                private Button encrypt, decrypt;
                private EditText message, cipher, key;
                private TextView screen_output;
                private static final String alphabetString = "abcdefghijklmnopqrstuvwxyz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home Activity");

        // findViewById is the method that
        // finds the View by the ID it is given
        encrypt = findViewById(R.id.btnencrypt);
        decrypt = findViewById(R.id.btndecrypt);
        screen_output = findViewById(R.id.tV1);
        message = findViewById(R.id.inputMessage);
        cipher = findViewById(R.id.ciphEdt);
        key = findViewById(R.id.key_dt);


        // setting onCLickListener on encrypt button
        encrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                encrypt12(message.getText().toString(), Integer.parseInt(key.getText().toString()));

//                //get encrypted text of cypher algorithm
//                String encrypted_cypher=encrypt.getText().toString();
//
//                Intent intent =new Intent(MainActivity.this,CypherEncryptActivity.class);
//                intent.putExtra("encrypted_cypher",encrypted_cypher);
//                startActivity(intent);


            }
        }
        );
        //setting onClickListerner on decrypt button
        decrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrypt12(cipher.getText().toString(), Integer.parseInt(key.getText().toString()));

            }
        }
        );
    }
        // method to show the final output on the output
        // textView when decrypt button is clicked
        public void decrypt12(String cipher, int key) {
        screen_output.setText((Utility.decrypt1(cipher, key).toLowerCase()));

            //get encrypted text of decrypt algorithm
            String decrypted_cypher=screen_output.getText().toString();

            Intent intent =new Intent(MainActivity.this,DecryptCypherTextActivity.class);
            intent.putExtra("decrypted_cypher",decrypted_cypher);
            startActivity(intent);

        }

        // method to show the final output on the output
        // textView when encrypt button is clicked
     public void encrypt12(String message, int shiftkey) {


        message = message.toLowerCase();
        String cipherText = "";
        for (int i = 0; i < message.length(); i++) {
        int charPosition = alphabetString.indexOf(message.charAt(i));
        int keyval = (shiftkey + charPosition) % 26;
        char replaceVAL = alphabetString.charAt(keyval);
        cipherText += replaceVAL;
        screen_output.setText(cipherText);
        cipher.setText(cipherText);


                            //get encrypted text of cypher algorithm
                String encrypted_cypher=cipher.getText().toString();

                Intent intent =new Intent(MainActivity.this,CypherEncryptActivity.class);
                intent.putExtra("encrypted_cypher",encrypted_cypher);
                startActivity(intent);

}

// returning the final ciphertext
     }
}