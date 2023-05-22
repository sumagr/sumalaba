package com.solvd.lab4.connectionpool;

public class MockedConnection implements Connection {
    private final int id;
    private boolean acquired;

    public MockedConnection(int id) {
        this.id = id;
    }

    @Override
    public void reset() {
        acquired = false;
    }

    @Override
    public boolean isAcquired() {
        return acquired;
    }

    @Override
    public void setAcquired(boolean acquired) {
        this.acquired = acquired;
    }

    @Override
    public String toString() {
        return "MockedConnection [id=" + id + "]";
    }
}
