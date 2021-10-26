package com.uniftec.sportscheduleapp.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Quadra;
import com.uniftec.sportscheduleapp.utils.Alerts;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CadastroQuadra3 extends AppCompatActivity implements View.OnClickListener {

    String aux = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_quadra_3);

        Button botaoConcluir = (Button) findViewById(R.id.btnConcluir);

        botaoConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent resultado = new Intent();
                resultado.putExtra("quadra", ObjQuadra());
                setResult(1, resultado);
                finish();

            }
        });

        ImageButton imagem1 = (ImageButton) findViewById(R.id.imageButton1);
        imagem1.setOnClickListener(this);

        ImageButton imagem2 = (ImageButton) findViewById(R.id.imageButton2);
        imagem2.setOnClickListener(this);

        ImageButton imagem3 = (ImageButton) findViewById(R.id.imageButton3);
        imagem3.setOnClickListener(this);

        ImageButton imagem4 = (ImageButton) findViewById(R.id.imageButton4);
        imagem4.setOnClickListener(this);

        ImageButton imagem5 = (ImageButton) findViewById(R.id.imageButton5);
        imagem5.setOnClickListener(this);

        ImageButton imagem6 = (ImageButton) findViewById(R.id.imageButton6);
        imagem6.setOnClickListener(this);

        ImageButton imagem7 = (ImageButton) findViewById(R.id.imageButton7);
        imagem7.setOnClickListener(this);

        ImageButton imagem8 = (ImageButton) findViewById(R.id.imageButton8);
        imagem8.setOnClickListener(this);

        ImageButton imagem9 = (ImageButton) findViewById(R.id.imageButton9);
        imagem9.setOnClickListener(this);

    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;
    static String mCurrentPhotoPath;

    private void getPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        } else
            dispatchTakePictureIntent();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent();
                } else {
                    Alerts.noPermissionGranted(CadastroQuadra3.this);
                }
                return;
            }
        }
    }

    private void dispatchTakePictureIntent() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null;
            try {
                File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                photoFile = File.createTempFile("PHOTOAPP", ".jpg", storageDir);
                mCurrentPhotoPath = "file:" + photoFile.getAbsolutePath();
            } catch (IOException ex) {
                ex.printStackTrace();
                Alerts.genericErrorInOut(CadastroQuadra3.this);
            }

            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            try {
                String imageViewId = "imageView" + aux;
                int resultImgID = getResources().getIdentifier(imageViewId, "id", getPackageName());

                ImageView imagem = (ImageView) findViewById(resultImgID);
                Bitmap bm1 = BitmapFactory.decodeStream(getContentResolver().openInputStream(Uri.parse(mCurrentPhotoPath)));
                imagem.setImageBitmap(bm1);

                String imageButtonId = "imageButton" + aux;
                int resultBtnID = getResources().getIdentifier(imageButtonId, "id", getPackageName());

                ImageButton button = (ImageButton) findViewById(resultBtnID);
                button.setVisibility(View.INVISIBLE);
                aux = "";

            } catch (FileNotFoundException fnex) {
                fnex.printStackTrace();
                Alerts.genericErrorFileNotFound(CadastroQuadra3.this, "Imagem");
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.imageButton1:
                aux = "1";
                getPermissions();
                break;

            case R.id.imageButton2:
                aux = "2";
                getPermissions();
                break;

            case R.id.imageButton3:
                aux = "3";
                getPermissions();
                break;

            case R.id.imageButton4:
                aux = "4";
                getPermissions();
                break;

            case R.id.imageButton5:
                aux = "5";
                getPermissions();
                break;

            case R.id.imageButton6:
                aux = "6";
                getPermissions();
                break;

            case R.id.imageButton7:
                aux = "7";
                getPermissions();
                break;

            case R.id.imageButton8:
                aux = "8";
                getPermissions();
                break;

            case R.id.imageButton9:
                aux = "9";
                getPermissions();
                break;
        }
    }

    protected Quadra ObjQuadra() {
        return new Quadra();
    }

}
