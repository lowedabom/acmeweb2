package com.acme.statusmgr;

public class SystemDetailsFetcher {
    public static int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static long getFreeJVMMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    public static long getTotalJVMMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    public static String getJREVersion() {
        return Runtime.version().toString();
    }
}
