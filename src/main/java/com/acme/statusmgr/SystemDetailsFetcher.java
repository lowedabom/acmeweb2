package com.acme.statusmgr;

public class SystemDetailsFetcher {
    public static int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static Object getFreeJVMMemory() {
        return Runtime.getRuntime().freeMemory();
    }
}
