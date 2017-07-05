package com.epam.cdp.bdd_task.core;

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();
        try {
            runner.run();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
