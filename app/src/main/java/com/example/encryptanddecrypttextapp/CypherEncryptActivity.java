package com.example.encryptanddecrypttextapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CypherEncryptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cypher_encrypt);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Encrypted cypher Activity");

        Intent intent =getIntent();
        String cypher =intent.getStringExtra("encrypted_cypher");

        TextView result=findViewById(R.id.result_encypt_cypher);

        result.setText("Cypher encrypt text :"+ cypher);

    }
}