package com.Rahul;

public class QueueEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }
}
