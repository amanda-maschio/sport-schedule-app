package com.uniftec.sportscheduleapp.controller;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CadastroLocador extends AppCompatActivity {

    private static int RESULT_LOAD_IMAGE = 1;

    EditText txtNome;
    EditText txtEmail;
    EditText txtSenha;
    EditText txtCpf;
    EditText txtData;
    ImageView imagemPerfil;
    RadioButton rbConcordo;

    DatePickerDialog datePickerDialogDataNascimento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_locador);

        this.localization();

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtSenha = (EditText) findViewById(R.id.txtSenha);
        txtCpf = (EditText) findViewById(R.id.txtCpf);
        txtData = (EditText) findViewById(R.id.txtData);
        rbConcordo = (RadioButton) findViewById(R.id.rbConcordo);
        imagemPerfil = (ImageView) findViewById(R.id.imagemPerfil);
        imagemPerfil.setTag("default");

        List<EditText> listRequiredFields = Utils.determineMandatoryFields(txtNome, txtEmail, txtSenha, txtCpf);

        this.createDateEvent();

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        ImageView imagemPerfil = (ImageView) findViewById(R.id.imagemPerfil);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Utils.validateRequiredFields(listRequiredFields)) {

                    if (rbConcordo.isChecked()) {
                        try {
                            CadastrarUsuarioPessoa();
                            Intent telaLogin = new Intent(CadastroLocador.this, Login.class);
                            startActivity(telaLogin);
                        } catch (SQLiteException e) {
                            Alerts.registrationError(CadastroLocador.this);
                            e.printStackTrace();
                        }
                    } else {
                        Alerts.verifyLicenseTerms(CadastroLocador.this);
                    }

                } else {
                    Alerts.toastRequiredFields(CadastroLocador.this);
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
                    Alerts.noPermissionGranted(CadastroLocador.this);
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
            imagemPerfil = (ImageView) findViewById(R.id.imagemPerfil);
            imagemPerfil.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            imagemPerfil.setTag("other");
        }
    }

    private void CadastrarUsuarioPessoa() throws SQLiteException {

        Pessoa pessoaLocador = new Pessoa();

        if (imagemPerfil.getTag().equals("other")) {
            pessoaLocador.setFoto(Utils.imageToByteArray(imagemPerfil));
        } else {
            pessoaLocador.setFoto(null);
        }

        pessoaLocador.setNome(txtNome.getText().toString().trim());
        pessoaLocador.setCpf(txtCpf.getText().toString().trim());
        pessoaLocador.setDataNascimento(txtData.getText().toString().trim());

        long pessoaLocadorId = new PessoaRepository(CadastroLocador.this).insert(pessoaLocador);

        Usuario usuarioLocador = new Usuario();
        usuarioLocador.setPessoa(new PessoaRepository(CadastroLocador.this).findById((int) pessoaLocadorId));
        usuarioLocador.setEmail(txtEmail.getText().toString().trim());
        usuarioLocador.setSenha(txtSenha.getText().toString().trim());
        usuarioLocador.setIndTipoUsuario("LD");
        new UsuarioRepository(CadastroLocador.this).insert(usuarioLocador);

    }

    private void localization() {
        Locale locale = new Locale("pt", "BR");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, null);
    }

    private void createDateEvent() {

        final Calendar calendarDataAtual = Calendar.getInstance();
        int anoAtual = calendarDataAtual.get(Calendar.YEAR);
        int mesAtual = calendarDataAtual.get(Calendar.MONTH);
        int diaAtual = calendarDataAtual.get(Calendar.DAY_OF_MONTH);

        datePickerDialogDataNascimento = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int anoSelecionado, int mesSelecionado, int diaSelecionado) {

                String mes = (String.valueOf((mesSelecionado + 1)).length() == 1 ? "0" + (mesSelecionado + 1) : String.valueOf(mesSelecionado));
                txtData.setText(diaSelecionado + "/" + mes + "/" + anoSelecionado);

            }

        }, anoAtual, mesAtual, diaAtual);

        txtData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                datePickerDialogDataNascimento.show();
            }
        });

        txtData.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                datePickerDialogDataNascimento.show();
            }
        });
    }

}
