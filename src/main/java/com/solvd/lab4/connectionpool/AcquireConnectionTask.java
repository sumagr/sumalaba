package com.solvd.lab4.connectionpool;

public class AcquireConnectionTask implements Runnable {
    private final ConnectionPool connectionPool;

    public AcquireConnectionTask(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        try {
            Connection connection = connectionPool.acquireConnection();
            System.out.println("Acquired connection: " + connection);
            Thread.sleep(1000);
            connectionPool.releaseConnection(connection);
            System.out.println("Released connection: " + connection);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
