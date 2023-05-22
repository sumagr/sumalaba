package com.solvd.lab4.connectionpool;

public interface Connection {
    void reset();

    boolean isAcquired();

    void setAcquired(boolean acquired);
}


