package com.solvd.lab4.connectionpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConnectionPool {
    private final BlockingQueue<Connection> availableConnections;

    public ConnectionPool(int poolSize) {
        availableConnections = new ArrayBlockingQueue<>(poolSize);
        initializePool(poolSize);
    }

    private void initializePool(int poolSize) {
        for (int i = 0; i < poolSize; i++) {
            availableConnections.offer(new MockedConnection(i));
        }
    }

    public Connection acquireConnection() throws InterruptedException {
        return availableConnections.take();
    }

    public void releaseConnection(Connection connection) {
        connection.reset();
        availableConnections.offer(connection);
    }
}
