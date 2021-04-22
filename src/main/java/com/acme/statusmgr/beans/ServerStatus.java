package com.acme.statusmgr.beans;

/**
 * Decorator that adds Server Status to the base class passed in.
 */
public class ServerStatus extends BaseStatus {
    BaseStatus baseStatus;

    /**
     * simple constructor which takes the fields from the base class and adds it to this class
     * @param baseStatus thing that will be decorated
     */
    public ServerStatus(BaseStatus baseStatus) {
        super(baseStatus.getId(), baseStatus.getContentHeader());
        this.baseStatus = baseStatus;
    }

    /**
     * Adds server status data on top of the base class's statusDesc.
     * Uses SystemDetailsFetcherInterface to get the data.
     * @return String representing the new and improved statusDesc value
     */
    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + ", and server is " + systemDetailsFetcherInterface.getServerStatus();
    }
}
