package com.uniftec.sportscheduleapp.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import com.uniftec.sportscheduleapp.entities.Pessoa;
import com.uniftec.sportscheduleapp.utils.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {

    DatabaseUtil databaseUtil;

    public PessoaRepository(Context context) {
        databaseUtil = new DatabaseUtil(context);
    }

    public Long insert(Pessoa pessoa) throws SQLiteException {

        Long retorno = null;

        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("nome", pessoa.getNome());
            contentValues.put("cpf", pessoa.getCpf());
            contentValues.put("data_nascimento", pessoa.getDataNascimento());
            contentValues.put("foto", pessoa.getFoto());

            return databaseUtil.GetConexaoDataBase().insertOrThrow("pessoa", null, contentValues);
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            databaseUtil.close();
        }

        return retorno;
    }

    public void update(Pessoa pessoa) {
        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("nome", pessoa.getNome());
            contentValues.put("cpf", pessoa.getCpf());
            contentValues.put("data_nascimento", pessoa.getDataNascimento());
            contentValues.put("foto", pessoa.getFoto());

            databaseUtil.GetConexaoDataBase().update("pessoa", contentValues, "cod_pessoa = ?", new String[]{Integer.toString(pessoa.getCodPessoa())});

        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            databaseUtil.close();
        }
    }

    public Integer delete(int codigo) {
        return databaseUtil.GetConexaoDataBase().delete("pessoa", "cod_pessoa = ?", new String[]{Integer.toString(codigo)});
    }

    public Integer deletePessoaUsuario(int codigo) {
        return databaseUtil.GetConexaoDataBase().delete("usuario", "cod_pessoa = ?", new String[]{Integer.toString(codigo)});
    }

    public Pessoa findById(int codigo) {

        Pessoa pessoa = new Pessoa();

        try {

            Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery("SELECT * FROM pessoa WHERE cod_pessoa =" + codigo, null);

            cursor.moveToFirst();

            pessoa.setCodPessoa(cursor.getInt(cursor.getColumnIndex("cod_pessoa")));
            pessoa.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            pessoa.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
            pessoa.setDataNascimento(cursor.getString(cursor.getColumnIndex("data_nascimento")));
            pessoa.setFoto(cursor.getBlob(cursor.getColumnIndex("foto")));
            return pessoa;

        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            databaseUtil.close();
        }

        return pessoa;
    }

    public List<Pessoa> findAll() {

        List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT * ");
        stringBuilderQuery.append("FROM pessoa ");
        stringBuilderQuery.append("ORDER BY nome");

        Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);
        cursor.moveToFirst();

        Pessoa pessoa;

        while (!cursor.isAfterLast()) {

            pessoa = new Pessoa();

            pessoa.setCodPessoa(cursor.getInt(cursor.getColumnIndex("cod_pessoa")));
            pessoa.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            pessoa.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
            pessoa.setDataNascimento(cursor.getString(cursor.getColumnIndex("data_nascimento")));
            pessoa.setFoto(cursor.getBlob(cursor.getColumnIndex("foto")));
            listaPessoas.add(pessoa);

            cursor.moveToNext();
        }

        return listaPessoas;
    }

}
