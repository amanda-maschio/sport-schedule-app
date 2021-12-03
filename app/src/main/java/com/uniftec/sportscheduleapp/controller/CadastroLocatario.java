package com.uniftec.sportscheduleapp.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.uniftec.sportscheduleapp.R;
import com.uniftec.sportscheduleapp.entities.Pessoa;
import com.uniftec.sportscheduleapp.entities.Usuario;
import com.uniftec.sportscheduleapp.repository.PessoaRepository;
import com.uniftec.sportscheduleapp.repository.UsuarioRepository;
import com.uniftec.sportscheduleapp.utils.Alerts;
import com.uniftec.sportscheduleapp.utils.Utils;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class CadastroLocatario extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;

    EditText txtNome;
    EditText txtEmail;
    EditText txtSenha;
    EditText txtCpf;
    EditText txtData;
    ImageView imagemPerfil;
    RadioButton rbConcordo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_locatario);

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtCpf = (EditText) findViewById(R.id.txtCpf);
        txtData = (EditText) findViewById(R.id.txtData);
        rbConcordo = (RadioButton) findViewById(R.id.rbConcordo);
        imagemPerfil = (ImageView) findViewById(R.id.imagemPerfil);

        List<EditText> listRequiredFields = Utils.determineMandatoryFields(txtNome, txtEmail, txtSenha, txtCpf);

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        ImageView imagemPerfil = (ImageView) findViewById(R.id.imagemPerfil);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.validateRequiredFields(listRequiredFields)) {

                    if (rbConcordo.isChecked()) {
                        try {
                            CadastrarUsuarioPessoa();
                            Intent telaLogin = new Intent(CadastroLocatario.this, Login.class);
                            startActivity(telaLogin);
                        } catch (SQLiteException e) {
                            Alerts.registrationError(CadastroLocatario.this);
                            e.printStackTrace();
                        }
                    } else {
                        Alerts.verifyLicenseTerms(CadastroLocatario.this);
                    }
                } else {
                    Alerts.toastRequiredFields(CadastroLocatario.this);
                }
            }
        });

        imagemPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPermissions();
            }
        });
    }

    private void getPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.MANAGE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.MANAGE_EXTERNAL_STORAGE}, 1);
        } else
            dispatchTakePictureIntent();
    }

    private void dispatchTakePictureIntent() {

        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, RESULT_LOAD_IMAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    dispatchTakePictureIntent();
                } else {
                    Alerts.noPermissionGranted(CadastroLocatario.this);
                }
                return;
            }
        }
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

    private void CadastrarUsuarioPessoa() throws SQLiteException {

        imagemPerfil.buildDrawingCache();
        Bitmap bmap = imagemPerfil.getDrawingCache();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        bmap.recycle();

        Pessoa pessoaLocatario = new Pessoa();
        pessoaLocatario.setNome(txtNome.getText().toString().trim());
        pessoaLocatario.setCpf(txtCpf.getText().toString().trim());
        pessoaLocatario.setDataNascimento(txtData.getText().toString().trim());
        pessoaLocatario.setFoto(byteArray);
        long pessoaLocadorId = new PessoaRepository(CadastroLocatario.this).insert(pessoaLocatario);

        Usuario usuarioLocatario = new Usuario();
        usuarioLocatario.setPessoa(new PessoaRepository(CadastroLocatario.this).findById((int) pessoaLocadorId));
        usuarioLocatario.setEmail(txtEmail.getText().toString().trim());
        usuarioLocatario.setSenha(txtSenha.getText().toString().trim());
        usuarioLocatario.setIndTipoUsuario("LT");
        new UsuarioRepository(CadastroLocatario.this).insert(usuarioLocatario);
    }

}
