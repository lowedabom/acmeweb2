package com.acme.statusmgr.beans;

import com.acme.statusmgr.SystemDetailsFetcher;
import com.acme.statusmgr.SystemDetailsFetcherInterface;

public class BaseStatus {

    public String statusDesc = "";
    public BaseStatus baseStatus;
    static public SystemDetailsFetcherInterface systemDetailsFetcherInterface = new SystemDetailsFetcher();
    private  long id;
    private String contentHeader;

    /**
     * Construct a BaseStatus using info passed in for identification, and obtaining current
     * server status from the appropriate facade class.
     * This class must return a pretty, english-like representation of the server status.
     *
     * @param id                a numeric identifier/counter of which request this
     * @param contentHeader     info about the request
     */
    public BaseStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;
    }

    public String getContentHeader() {
        return contentHeader;
    }

    public long getId() {
        return id;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String s){ statusDesc = s;}

    public void setDefaultStatusDesc(){
        setStatusDesc("Server is " + systemDetailsFetcherInterface.getServerStatus());
    }
}
