package com.example.mycities.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mycities.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //private TextInputEditText txt_email, txt_password;
    private AppCompatButton btn_create;

    //private View view;
    private FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViewId();
    }

    private void getViewId() {
        recyclerView = findViewById(R.id.id_post_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        floatingActionButton = findViewById(R.id.id_floating_new_post);
        floatingActionButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_floating_new_post:
                goToView(RegisterActivity.class, 1);
                break;
        }
    }

    private void goToView(Class activiyClass, int option) {
        Intent intent = new Intent(this, activiyClass);
        if (option == 1) {
            startActivity(intent);
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}