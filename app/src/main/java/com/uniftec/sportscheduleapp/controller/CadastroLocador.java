package com.uniftec.sportscheduleapp.controller;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.utils.Alerts;
import com.uniftec.sportscheduleapp.utils.Utils;

import java.util.List;

public class CadastroLocador extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_locador);

        EditText txtNome = (EditText) findViewById(R.id.txtNome);
        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText txtSenha = (EditText) findViewById(R.id.txtSenha);
        EditText txtCnpj = (EditText) findViewById(R.id.txtCnpj);

        //Passar por parametro os EditTexts para determineMandatoryFields() os torna obrigatórios
        List<EditText> listRequiredFields = Utils.determineMandatoryFields();
        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.validateRequiredFields(listRequiredFields)) {
                    Intent telaHomeLocador = new Intent(CadastroLocador.this, HomeLocador.class);
                    startActivity(telaHomeLocador);
                } else {
                    Alerts.toastRequiredFields(CadastroLocador.this);
                }
            }
        });
    }


    public void selectImageClick(View view) {

        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {

            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            ImageView imageView = (ImageView) findViewById(R.id.imagemPerfil);
            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
    }

}
