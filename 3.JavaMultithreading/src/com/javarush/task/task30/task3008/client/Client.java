package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    public class SocketThread extends Thread {
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник с именем " + userName + " присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Участник с именем " + userName + " покинул к чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
                Message msg = connection.receive();

//                switch (msg.getType()){
//                    case NAME_REQUEST:
//                        connection.send(new Message(MessageType.USER_NAME,getUserName())); break;
//                    case NAME_ACCEPTED:
//                        notifyConnectionStatusChanged(true); return;
//                    default: throw new IOException("Unexpected MessageType");
//                }
                if (msg.getType() == MessageType.NAME_REQUEST) { // Сервер запросил имя пользователя
                    // Запрашиваем ввод имени с консоли
                    String name = getUserName();
                    // Отправляем имя на сервер
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (msg.getType() == MessageType.NAME_ACCEPTED) { // Сервер принял имя пользователя
                    // Сообщаем главному потоку, что он может продолжить работу
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true) {
                Message msg = connection.receive();
//                switch (msg.getType()) {
//                    case TEXT:
//                        processIncomingMessage(msg.getData());
//                        break;
//                    case USER_ADDED:
//                        informAboutAddingNewUser(msg.getData());
//                        break;
//                    case USER_REMOVED:
//                        informAboutDeletingNewUser(msg.getData());
//                        break;
//                    default:
//                        throw new IOException("Unexpected MessageType");
//                }
                if (msg.getType() == MessageType.TEXT) { // Сервер прислал сообщение с текстом
                    processIncomingMessage(msg.getData());
                } else if (MessageType.USER_ADDED == msg.getType()) {
                    informAboutAddingNewUser(msg.getData());
                } else if (MessageType.USER_REMOVED == msg.getType()) {
                    informAboutDeletingNewUser(msg.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Client().run();
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
            return;
        }
        while (clientConnected) {
            String str = ConsoleHelper.readString();
            if (str.equals("exit")) break;
            if (shouldSendTextFromConsole()) sendTextMessage(str);
        }
    }

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт сервера");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка отправки сообщения");
            clientConnected = false;
        }
    }
}
