package com.jack.jackdawson.common.database;


public class DBContext {

    private static final ThreadLocal<Strategy> contextHolder = new ThreadLocal<>();

    private DBContext() {

    }

    public static void setDbType(Strategy dbType) {
        if (dbType == null) {
            throw new NullPointerException();
        }
        contextHolder.set(dbType);
    }

    public static Strategy getDbType() {
        if (contextHolder.get() == null) {
            return Strategy.MASTER;
        }

        return contextHolder.get();
    }

    public static void clearDbType() {
        contextHolder.remove();
    }
}
