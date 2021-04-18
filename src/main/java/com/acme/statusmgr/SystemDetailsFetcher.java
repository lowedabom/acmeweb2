package com.acme.statusmgr;

import com.acme.servermgr.ServerManager;

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

    public static String getTempLocation() {
        return System.getenv("TEMP");
    }
    public static String getServerStatus(){
        return ServerManager.getCurrentServerStatus();
    }
}
