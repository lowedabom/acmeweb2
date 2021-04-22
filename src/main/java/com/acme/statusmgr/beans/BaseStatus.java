package com.acme.statusmgr.beans;

import com.acme.statusmgr.SystemDetailsFetcher;
import com.acme.statusmgr.SystemDetailsFetcherInterface;

/**
 * POJO general status for the server. contains id, content header, and status description for whether the server is up or not.
 * This class must return a pretty, english-like representation of the server status.
 * Can be used to generate JSON for that status
 */
public class BaseStatus {

    public String statusDesc = "";
    static public SystemDetailsFetcherInterface systemDetailsFetcherInterface = new SystemDetailsFetcher();
    private  long id;
    private String contentHeader;

    /**
     * Construct a BaseStatus using info passed in for identification, and obtaining current
     * server status from the appropriate facade class.
     *
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

    /**
     * sets default value for statusDesc
     */
    public void setDefaultStatusDesc(){
        setStatusDesc("Server is " + systemDetailsFetcherInterface.getServerStatus());
    }
}
