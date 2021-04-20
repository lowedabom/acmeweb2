package com.acme.statusmgr;

public interface SystemDetailsFetcherInterface {
    int getAvailableProcessors();

    long getFreeJVMMemory();

    long getTotalJVMMemory();

    String getJREVersion();

    String getTempLocation();

    String getServerStatus();
}
