package org.example;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Main {

    final static String MESSAGE_TEMPLATE = "%s : %s";

    final static Thread main = currentThread();

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            try {
                main.join(2000);
                System.out.println(showState(currentThread()));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });
        thread.start();

        thread.sleep(1000);

        System.out.println(showState(thread));

    }

    public static String showState(final Thread thread) {
        return String.format(MESSAGE_TEMPLATE, thread.getName(), thread.getState());
    }
}