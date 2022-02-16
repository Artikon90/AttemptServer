package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        // Создаю серверный сокет на порт 8080
	try (ServerSocket serverSocket = new ServerSocket(8080)) {
        System.out.println("Server started!");
while (true) {
    Socket socket = serverSocket.accept(); // создал получение данных от юзера


    try (BufferedReader reader = new BufferedReader
            (new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
         PrintWriter writer = new PrintWriter(socket.getOutputStream())
    ) {
        while (!reader.ready()) ;
        System.out.println();
        while (reader.ready()) {
            System.out.println(reader.readLine());
        }
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=utf-8");
        writer.println();
        writer.println("<h1><body text=#FF0000>Hello World!!! </body></h1>");
        writer.println("<table><tbody><thead>Table</thead><td><th>First</th></td><td><th>Second</th></td></tbody></table>");
    }
}

    } catch (IOException e) {
        e.printStackTrace();
    }
    }

}
