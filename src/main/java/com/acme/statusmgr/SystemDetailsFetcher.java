package com.acme.statusmgr;

public class SystemDetailsFetcher {
    public static int getAvailableProcessors() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.availableProcessors();
    }
}
