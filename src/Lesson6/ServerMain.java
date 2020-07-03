package Lesson6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {

        ServerSocket server = null;
        Socket socket = null;

        //оберну в try catch для отлова экспешнов в потоках
        try {
            server = new ServerSocket(5657);
            System.out.println("Сервер работает.");

            socket = server.accept();
            System.out.println("Новый клиент добавлен.");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner console = new Scanner(System.in);

            //поток для получения сообщений от клиента
            Thread t1 = new Thread(() -> {
                while (true) {
                    String str = in.nextLine();
                    System.out.println("Сообщение с клиента: " + str);
                }
            });
            t1.start();

            //поток для отправки сообщений из консоли сервера
            Thread t2 = new Thread(() -> {
                while (true) {
                    System.out.println("Введите новое сообщение: ");
                    String str = console.nextLine();
                    System.out.println("Сообщение отправлено!");
                    out.println(str);
                }
            });
            t2.start();

            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert socket != null;
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}