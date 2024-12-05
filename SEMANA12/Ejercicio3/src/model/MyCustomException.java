package model;

public class MyCustomException extends Exception{
    public MyCustomException(String msg) {
        super(msg);
    }

    public MyCustomException(String msg, Throwable throwable) {
        super(msg, throwable);
    }
}