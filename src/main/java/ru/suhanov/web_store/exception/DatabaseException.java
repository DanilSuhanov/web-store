package ru.suhanov.web_store.exception;

public class DatabaseException extends Exception {
    public DatabaseException() {
        super("Ошибка работы с базой данных!");
    }
    public DatabaseException(String message) {
        super(message);
    }
}
