package com.acme.statusmgr;

import com.acme.servermgr.ServerManager;

/**
 * returns System and Runtime details using Runtime class and System class
 */
public class SystemDetailsFetcher implements SystemDetailsFetcherInterface {

    @Override
    public int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }

    @Override
    public long getFreeJVMMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    @Override
    public long getTotalJVMMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    @Override
    public String getJREVersion()  {
        return Runtime.version().toString();
    }

    @Override
    public String getTempLocation() {
        return System.getenv("TEMP");
    }

    @Override
    public String getServerStatus() {
        return ServerManager.getCurrentServerStatus();
    }
}
