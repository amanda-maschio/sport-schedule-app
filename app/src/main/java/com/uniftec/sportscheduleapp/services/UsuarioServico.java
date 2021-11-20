package com.uniftec.sportscheduleapp.services;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.uniftec.sportscheduleapp.entities.Usuario;
import com.uniftec.sportscheduleapp.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class UsuarioServico {

    public static Usuario getRandomUser(String url) {

        String json;
        Usuario usuario;
        json = Utils.getJsonFromApi(url);
        usuario = parseJsonToUsuario(json);

        return usuario;
    }

    private static Usuario parseJsonToUsuario(String json) {

        try {
            Usuario usuario = new Usuario();

            JSONObject jsonObj = new JSONObject(json);
            JSONArray array = jsonObj.getJSONArray("results");

            JSONObject objArray = array.getJSONObject(0);

            JSONObject nome = objArray.getJSONObject("name");
            usuario.getPessoa().setNome((nome.getString("first")));
            usuario.getPessoa().setSobrenome((nome.getString("last")));
            usuario.setEmail(objArray.getString("email"));

            JSONObject foto = objArray.getJSONObject("picture");
            usuario.getPessoa().setFoto(baixarImagem(foto.getString("large")));

            return usuario;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Bitmap baixarImagem(String url) {

        try {

            URL endereco;
            InputStream inputStream;
            Bitmap imagem;
            endereco = new URL(url);
            inputStream = endereco.openStream();
            imagem = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return imagem;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
