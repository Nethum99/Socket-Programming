/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week3_tute2;

//import necessary libraries

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.sql.ClientInfoStatus;



public class SimpleChatServer {
    public static void main(String[] args) {
        try {
            //Create a new instance of the Server Socket and pass port number
            int port = 12346;
            ServerSocket serverSocket = new ServerSocket(port);
            
            //print out a message to say Server is running 
            System.out.println("Server is running on port : "+port);

            // Wait for a client to connect and accept the client request
            Socket socket = serverSocket.accept();
            
            
            //print out a message to say client connected and get the IP ddress
            System.out.println("Client connected : "+socket.getInetAddress());

            // Input stream to receive messages from the client
            InputStream inputStream = socket.getInputStream();

            // Output stream to send messages to the client
            OutputStream outputStream = socket.getOutputStream();
            
            //Create a buffer array with type byte, the size must be 1024
             byte[] Buffer = new byte[1024];

            // Read messages from the client and print them
            int bytesRead;
            
            while((bytesRead = inputStream.read(Buffer))!=-1){
                
                String clientMessage = new String(Buffer, 0 ,bytesRead);
                System.out.println("Received from client : "+clientMessage);
                
                String response = "Server received message : "+clientMessage;
                
                outputStream.write(response.getBytes());
            }
            
            
            
           
            
            
            // Close the sockets
            serverSocket.close();
            socket.close();
        }
         catch(Exception e){   
             
             e.printStackTrace();
         }
    }
}
