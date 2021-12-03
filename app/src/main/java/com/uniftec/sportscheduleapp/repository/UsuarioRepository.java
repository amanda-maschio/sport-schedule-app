package com.uniftec.sportscheduleapp.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import com.uniftec.sportscheduleapp.entities.Usuario;
import com.uniftec.sportscheduleapp.utils.DatabaseUtil;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    DatabaseUtil databaseUtil;

    public UsuarioRepository(Context context) {
        databaseUtil = new DatabaseUtil(context);
    }

    public Long insert(Usuario usuario) throws SQLiteException {

        Long retorno = null;

        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("cod_pessoa", usuario.getPessoa().getCodPessoa());
            contentValues.put("email", usuario.getEmail());
            contentValues.put("senha", usuario.getSenha());
            contentValues.put("ind_tp_usuario", usuario.getIndTipoUsuario());

            retorno = databaseUtil.GetConexaoDataBase().insertOrThrow("usuario", null, contentValues);

        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            databaseUtil.close();
        }

        return retorno;

    }

    public void update(Usuario usuario) {

        try {
            ContentValues contentValues = new ContentValues();

            contentValues.put("cod_pessoa", usuario.getPessoa().getCodPessoa());
            contentValues.put("email", usuario.getEmail());
            contentValues.put("senha", usuario.getSenha());
            contentValues.put("ind_tp_usuario", usuario.getIndTipoUsuario());

            databaseUtil.GetConexaoDataBase().update("usuario", contentValues, "cod_usuario = ?", new String[]{Integer.toString(usuario.getCodUsuario())});

        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            databaseUtil.close();
        }
    }

    public Integer delete(int codigo) {
        return databaseUtil.GetConexaoDataBase().delete("usuario", "cod_usuario = ?", new String[]{Integer.toString(codigo)});
    }

    public Usuario findById(int codigo) {

        Usuario usuario = new Usuario();

        try {
            Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery("SELECT * FROM usuario WHERE cod_usuario =" + codigo, null);

            cursor.moveToFirst();

            usuario.setCodUsuario(cursor.getInt(cursor.getColumnIndex("cod_usuario")));
            usuario.getPessoa().setCodPessoa(cursor.getInt(cursor.getColumnIndex("cod_pessoa")));
            usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            usuario.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
            usuario.setIndTipoUsuario(cursor.getString(cursor.getColumnIndex("ind_tp_usuario")));

        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            databaseUtil.close();
        }

        return usuario;
    }

    public List<Usuario> findAll() {

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();

        try {
            StringBuilder stringBuilderQuery = new StringBuilder();
            stringBuilderQuery.append("SELECT * ");
            stringBuilderQuery.append("FROM usuario ");
            stringBuilderQuery.append("INNER JOIN pessoa ON usuario.cod_pessoa = pessoa.cod_pessoa ");
            stringBuilderQuery.append("ORDER BY cod_usuario ");

            Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);
            cursor.moveToFirst();

            Usuario usuario;

            while (!cursor.isAfterLast()) {

                usuario = new Usuario();

                usuario.setCodUsuario(cursor.getInt(cursor.getColumnIndex("cod_usuario")));
                usuario.getPessoa().setCodPessoa(cursor.getInt(cursor.getColumnIndex("cod_pessoa")));
                usuario.getPessoa().setNome(cursor.getString(cursor.getColumnIndex("nome")));
                usuario.getPessoa().setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
                usuario.getPessoa().setDataNascimento(cursor.getString(cursor.getColumnIndex("data_nascimento")));
                usuario.getPessoa().setFoto(cursor.getBlob(cursor.getColumnIndex("foto")));
                usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                usuario.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
                usuario.setIndTipoUsuario(cursor.getString(cursor.getColumnIndex("ind_tp_usuario")));

                listaUsuarios.add(usuario);

                cursor.moveToNext();

            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        } finally {
            databaseUtil.close();
        }
        return listaUsuarios;
    }

    public List<Usuario> findByPessoa(int codPessoa) {

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();

        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append("SELECT * ");
        stringBuilderQuery.append("FROM usuario ");
        stringBuilderQuery.append("WHERE cod_pessoa = ");
        stringBuilderQuery.append(codPessoa);
        stringBuilderQuery.append(" ORDER BY cod_usuario");

        Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);
        cursor.moveToFirst();

        Usuario usuario;

        while (!cursor.isAfterLast()) {

            usuario = new Usuario();

            usuario.setCodUsuario(cursor.getInt(cursor.getColumnIndex("cod_usuario")));
            usuario.getPessoa().setCodPessoa(cursor.getInt(cursor.getColumnIndex("cod_pessoa")));
            usuario.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            usuario.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
            usuario.setIndTipoUsuario(cursor.getString(cursor.getColumnIndex("ind_tp_usuario")));

            listaUsuarios.add(usuario);

            cursor.moveToNext();
        }

        return listaUsuarios;
    }

}
