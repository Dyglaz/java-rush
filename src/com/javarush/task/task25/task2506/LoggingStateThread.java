package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        thread.setDaemon(true);
    }

    @Override
    public void run() {
        State currentState = thread.getState();
        System.out.println(currentState);
        State newState;

        do {
            if((newState = thread.getState()) != currentState) {
                System.out.println(newState);
                currentState = newState;
            }

        } while (!currentState.equals(State.TERMINATED));
    }
}
