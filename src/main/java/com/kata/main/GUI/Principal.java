/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.kata.main.GUI;

import javax.swing.JButton;
import com.kata.main.Chat.Chat;
import com.kata.main.Server;
import com.kata.main.Usuario;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
/**
 *
 * @author ERIC
 */
public class Principal extends javax.swing.JFrame {

    public Usuario usuario;
    Socket socket;
    public String chatId;
    
    public Principal(Usuario user) {
        initComponents();
        usuario = user;
        MostrarBotonesChats(usuario);
        
        URI uri=URI.create("http://127.0.0.1:3000");
        IO.Options options=IO.Options.builder().build();
        socket=IO.socket(uri,options);  
        socket.connect();
        
        socket.on("message",new Emitter.Listener(){
            @Override
            public void call(Object... args){
                String message=args[0].toString();
                String beforeText=txtChat.getText();
                txtChat.setText(beforeText+message+"\n");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        inputMessage = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        AddFriend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtChat.setColumns(20);
        txtChat.setRows(5);
        jScrollPane1.setViewportView(txtChat);

        jButton1.setText("Enviar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        panelBotones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 419, Short.MAX_VALUE)
        );

        AddFriend.setText("Agregar Amigo");
        AddFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFriendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddFriend))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(inputMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                            .addComponent(inputMessage)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(AddFriend, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFriendActionPerformed
        
        AddFriendChat add = new AddFriendChat(usuario);   
        add.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddFriendActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        System.out.println(inputMessage.getText());
        String message=inputMessage.getText();
        if(!message.equals("")){
            socket.emit("message", usuario.getToken(),chatId,message);
            inputMessage.setText("");
        } 
    }//GEN-LAST:event_jButton1MouseClicked

    
    public void MostrarBotonesChats(Usuario user){
        Chat[] arrayChats = Server.chats(user.getToken());
        if(arrayChats !=null && arrayChats.length != 0){
            JButton []arrayBotones = new JButton[arrayChats.length];
            for(int i = 0; i < arrayChats.length;i++){
                    
                    if(arrayChats[i].isDuo()){
                        String member1 = arrayChats[i].getMembers()[0].getNickname();
                        if(member1.equals(user.getNickname())){
                            arrayChats[i].setName(arrayChats[i].getMembers()[1].getNickname());
                        }else{
                            arrayChats[i].setName(member1);
                        }
                    }
             }
            int ejex = 10, ejey = 10; 
            for(int i = 0; i < arrayChats.length;i++){
                
                arrayBotones[i] = new JButton();
                arrayBotones[i].setBounds(ejex, ejey, 100, 100);
                arrayBotones[i].setText(arrayChats[i].getName());
                arrayBotones[i].setActionCommand(arrayChats[i].getId());
                ejex += 120;
                if((i+1)%3==0){
                    ejex = 10;
                    ejey = 120;
                }
                panelBotones.add(arrayBotones[i]);
                
                arrayBotones[i].addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ObtenerIdChat(e);
                    }
                });
            }
 
        }else{
            System.out.println("No hay chats");
        }
        
    }
    
    public void ObtenerIdChat(ActionEvent e)
    {
        System.out.println("Consultando chatId : " + e.getActionCommand());
        chatId=e.getActionCommand();
        Chat chat=Server.obtenerMensajes(e.getActionCommand(), usuario.getToken());
        if(chat.getMessages() !=null && chat.getMessages().length >0){
            for(int i=0;i<chat.getMessages().length;i++){
                String textBefore=txtChat.getText();
                String newMessage=chat.getMessages()[i].getContent();
                txtChat.setText(textBefore+newMessage+"\n");
            }
        }
        if(chat.getMessages()==null){
            txtChat.setText("");
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddFriend;
    private javax.swing.JTextField inputMessage;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JTextArea txtChat;
    // End of variables declaration//GEN-END:variables
}
