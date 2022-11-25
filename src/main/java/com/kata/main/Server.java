/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kata.main;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author keres
 */
public class Server {

    private static String url = "http://localhost:3000/api/v1";

    public static void crearUsuario(String fullName, String email, String nickname, String password) {
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            String jbo = "{\n"
                    + "\"full_name\":\"" + fullName + "\",\n"
                    + "\"email\":\"" + email + "\",\n"
                    + "\"nickname\":\"" + nickname + "\",\n"
                    + "\"password\":\"" + password + "\"\n"
                    + "}";
            RequestBody body = RequestBody.create(mediaType,
                    jbo
            );
            Request req = new Request.Builder()
                    .url(url + "/user/signin")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(req).execute();
            int status = response.code();
            String data = response.body().string();
            System.out.println(data);
            System.out.println(status);
            if (status == 200) {
                JOptionPane.showMessageDialog(null, "User created, please registration now", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            } else {
                throw new IOException();
            }
        } catch (IOException err) {
            System.out.println(err);
        }

    }

    public static Usuario iniciarSesion(String email, String password) {
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            String jbo = "{\n"
                    + "\"email\":\"" + email + "\",\n"
                    + "\"password\":\"" + password + "\"\n"
                    + "}";
            RequestBody body = RequestBody.create(mediaType,
                    jbo
            );
            Request req = new Request.Builder()
                    .url(url + "/user/login")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(req).execute();
            int status = response.code();
            String data = response.body().string();
            System.out.println(data);
            System.out.println(status);
            Usuario usuario=new Usuario();
            if (status == 200) {
                usuario.setFullName("das");

            }
            return usuario;
        } catch (IOException err) {
            System.out.println(err);
            return null;
        }
    }
}
