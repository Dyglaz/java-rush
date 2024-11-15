package com.javarush.task.task30.task3008;

import java.io.Console;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        try(ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())){
            ConsoleHelper.writeMessage("Чат сервер запущен.");
            while(true){
                new Handler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Произошла ошибка при запуске или работе сервера.");
        }
    }

    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> entry : connectionMap.entrySet()){
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Произошла ошибка отправки сообщения.");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while(true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();

                if (message.getType() != MessageType.USER_NAME) continue;

                String userName = message.getData();
                if(userName.isEmpty()) continue;

                if(connectionMap.containsKey(userName)) continue;

                connectionMap.put(userName, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));

                return userName;
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while(true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT) {
                    message = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(message);
                } else {
                    ConsoleHelper.writeMessage("Тип сообщения не соответствует протоколу.");
                }
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for(Map.Entry<String, Connection> entry : connectionMap.entrySet()){
                if(entry.getKey().equals(userName)) continue;
                connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
            }

        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage(socket.getRemoteSocketAddress() + ".");

            String userName = null;
            try(Connection connection = new Connection(socket)){
                userName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));

                notifyUsers(connection, userName);

                serverMainLoop(connection, userName);

                if(!userName.isEmpty()){
                    connectionMap.remove(userName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
                }

                ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто.");

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом.");
            }

        }
    }
}
