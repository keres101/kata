/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kata.main;

import com.google.gson.Gson;
import com.kata.main.Chat.Chat;
import java.io.IOException;
import javax.swing.JOptionPane;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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
            String res = response.body().string();
            Usuario usuario = new Usuario();
            if (status == 200) {
                Gson gson = new Gson();
                usuario = gson.fromJson(res, Usuario.class);

                return usuario;
            } else {
                return null;
            }

        } catch (IOException err) {
            System.out.println(err);
            return null;
        }
    }

    public static Chat[] chats(String token) {

        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://127.0.0.1:3000/api/v1/user/chat")
                    .get()
                    .addHeader("Content-type", "aplication/json")
                    .addHeader("Authorization", "Bearer " + token)
                    .build();

            Response response = client.newCall(request).execute();
            String data = response.body().string();

            if (response.code() == 200) {
                Gson gson = new Gson();
                Chat[] arrayChats = gson.fromJson(data, Chat[].class);

                return arrayChats;
            } else {
                return null;
            }

        } catch (IOException err) {
            System.out.println(err);
            return null;
        }

    }

    public static Chat obtenerMensajes(String chatId, String token) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("http://127.0.0.1:3000/api/v1/user/chat/" + chatId)
                    .get()
                    .addHeader("Content-type", "aplication/json")
                    .addHeader("Authorization", "Bearer " + token)
                    .build();

            Response response = client.newCall(request).execute();
            String data = response.body().string();

            System.out.println(data);
            if (response.code() == 200) {
                Gson gson = new Gson();
                Chat chat = gson.fromJson(data, Chat.class);
                return chat;
            } else {
                return null;
            }

        } catch (IOException err) {
            System.out.println(err);

            return null;
        }
    }

    public static boolean AgregarAmigoChat(String token, String email) {
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            String jbo = "{\n"
                    + "\"email\":\"" + email + "\"\n"
                    + "}";
            RequestBody body = RequestBody.create(mediaType,
                    jbo
            );
            Request req = new Request.Builder()
                    .url("http://localhost:3000/api/v1/user/friend/add")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            Response response = client.newCall(req).execute();

            if (response.code() == 200) {
                return true;
            } else {
                return false;
            }
        } catch (IOException err) {
            return false;
        }
    }

    public static boolean crearChat(String token, String name, String[] members) {
        try {

            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            String jbo = "[";
            for (int i = 0; i < members.length; i++) {
                String coma = ",";
                if (i == members.length - 1) {
                    coma = "";
                }
                jbo += "\"" + members[i] + "\"" + coma;
            }
            jbo += "]";
            jbo = "{\n"
                    + "\"name\":\"" + name + "\"\n,"
                    + "\"members\":" + jbo
                    + "}";
            System.out.println(jbo);

            RequestBody body = RequestBody.create(mediaType,
                    jbo
            );
            Request req = new Request.Builder()
                    .url("http://localhost:3000/api/v1/user/chat/create")
                    .method("POST", body)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            Response response = client.newCall(req).execute();
            System.out.println(response.body().string());
            if (response.code() == 200) {
                return true;
            } else {
                return false;
            }

        } catch(IOException err){
            return false;
        }
    }
}
