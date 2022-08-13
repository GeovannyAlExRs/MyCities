package com.example.mycities.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.FileProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mycities.R;
import com.google.android.material.textfield.TextInputEditText;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_post1;
    private TextInputEditText txt_title_post, txt_description_post, txt_reference_post;
    private AppCompatButton btn_save;
    private CircleImageView imageViewBack;
    private AlertDialog.Builder builderSelect;

    // Foto 1
    String absolutePhotoPath1;
    String photoPath1;
    File filePhoto1;
    CharSequence options[];

    private static final int NUM_GALLERY_REQUEST_CODE1 = 1;
    private static final int NUM_CAMERA_REQUEST_CODE2 = 2;

    File fileImage1;
    File fileImage2;

    String title = "";
    String description = "";
    String teperature = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        builderSelect = new AlertDialog.Builder(this);
        builderSelect.setTitle("Selecciona una opcion");
        options = new CharSequence[]{"Imagen de galeria", "Tomar una foto"};

        getViewId();

    }

    private void getViewId() {
        imageViewBack = findViewById(R.id.id_circleBack);
        imageViewBack.setOnClickListener(this);

        txt_title_post = findViewById(R.id.id_txt_title_post);
        txt_description_post = findViewById(R.id.id_txt_description_post);
        txt_reference_post = findViewById(R.id.id_txt_reference_post);

        img_post1 = findViewById(R.id.id_img_post1);
        img_post1.setOnClickListener(this);

        btn_save = findViewById(R.id.id_btn_save);
        btn_save.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int option1 = 1;
        int option2 = 2;
        switch (view.getId()) {
            case R.id.id_circleBack:
                finish();
                break;
            case R.id.id_img_post1:
                Log.w("OPCION", "Seleccionaste 1 xD");
                selectOptionImg(option1);
                break;
            case R.id.id_btn_save:
                //band = 1;
                newPost();
                break;
        }
    }

    private void selectOptionImg(final int numbreImg) {
        builderSelect.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    if (numbreImg == 1) {
                        openGallery(NUM_GALLERY_REQUEST_CODE1);
                    }
                } else if (i == 1) {
                    if (numbreImg == 1) {
                        cameraImg(NUM_CAMERA_REQUEST_CODE2);
                    }
                }
            }
        });
        builderSelect.show();
    }

    private void openGallery(int requestCode) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, requestCode);
    }

    private void cameraImg(int requestCode) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            File photoF = null;
            try {
                photoF = createPhotoFile(requestCode);
            } catch (Exception e) {
                Toast.makeText(this, "Error " + e.getMessage(), Toast.LENGTH_LONG).show();
            }

            if (photoF != null) {
                Uri uri = FileProvider.getUriForFile(RegisterActivity.this, "com.app.dtk.redsocialturistico", photoF);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                startActivityForResult(intent, requestCode);
            }
        }
    }

    private File createPhotoFile(int requestCode) throws IOException {
        File fileDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        File file = File.createTempFile(new Date() + "_photo", ".jpg", fileDir);

        if (requestCode == NUM_CAMERA_REQUEST_CODE2) {
            photoPath1 = "file: " + file.getAbsolutePath();
            absolutePhotoPath1 = file.getAbsolutePath();
        }

        return file;
    }

    private void newPost() {
        title = txt_title_post.getText().toString();
        description = txt_description_post.getText().toString();

        if (!title.isEmpty() && !description.isEmpty()) {
            // Seleccion de ambas imagenes de galeria MIN 07:32
            if (fileImage1 != null) {
                saveImageStorage(fileImage1);
            }
            // Seleccion de ambas imagenes de camara
            else if (filePhoto1!= null) {
                saveImageStorage(filePhoto1);
            }
            else {
                Toast.makeText(RegisterActivity.this, "Selecciona una imagen", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(RegisterActivity.this, "Completa todos los campos", Toast.LENGTH_LONG).show();
        }
    }
    private void saveImageStorage(File file1) {
        /*if (isSuccessful()) {
            Toast.makeText(RegisterActivity.this, "Guardo la imagen con EXITO", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(RegisterActivity.this, "ERROR al guardar la imagen", Toast.LENGTH_LONG).show();
        }*/
    }
}