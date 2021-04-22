package com.acme.statusmgr.beans;

/**
 * A POJO that represents Server Status and can be used to generate JSON for that status
 */
public class ServerStatus extends BaseStatus {

    public ServerStatus(BaseStatus baseStatus) {
        super(baseStatus.getId(), baseStatus.getContentHeader());
        this.baseStatus = baseStatus;
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + ", and server is " + systemDetailsFetcherInterface.getServerStatus();
    }
}
