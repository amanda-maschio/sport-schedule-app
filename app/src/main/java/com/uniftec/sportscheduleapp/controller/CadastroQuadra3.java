package com.uniftec.sportscheduleapp.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
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

public class CadastroQuadra3 extends AppCompatActivity implements View.OnClickListener {

    String aux = "";
    private static int RESULT_LOAD_IMAGE = 1;

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

    private void getPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.MANAGE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MANAGE_EXTERNAL_STORAGE}, 1);
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

        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK) {

            String imageViewId = "imageView" + aux;
            int resultImgID = getResources().getIdentifier(imageViewId, "id", getPackageName());

            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(resultImgID);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            String imageButtonId = "imageButton" + aux;
            int resultBtnID = getResources().getIdentifier(imageButtonId, "id", getPackageName());

            ImageButton button = (ImageButton) findViewById(resultBtnID);
            button.setVisibility(View.INVISIBLE);
            aux = "";

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

    @Override
    public void onBackPressed (){
        Intent resultado = new Intent();
        setResult(99, resultado);
        finish();
    }


    protected Quadra ObjQuadra() {
        return new Quadra();
    }
}
