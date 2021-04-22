package com.acme.statusmgr;

/**
 * returns data for system and runtime details
 */
public interface SystemDetailsFetcherInterface {
    int getAvailableProcessors();

    long getFreeJVMMemory();

    long getTotalJVMMemory();

    String getJREVersion();

    String getTempLocation();

    String getServerStatus();
}
