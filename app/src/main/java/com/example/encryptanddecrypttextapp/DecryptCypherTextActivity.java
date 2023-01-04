package com.example.encryptanddecrypttextapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DecryptCypherTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt_cypher_text);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Decryption cypher Activity");

        Intent intent =getIntent();
        String decypher =intent.getStringExtra("decrypted_cypher");

        TextView result=findViewById(R.id.result_decrypt_cypher);

        result.setText("Cypher decyption text :"+ decypher);
    }
}