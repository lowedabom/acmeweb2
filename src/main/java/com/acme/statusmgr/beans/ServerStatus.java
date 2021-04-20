package com.acme.statusmgr.beans;

/**
 * A POJO that represents Server Status and can be used to generate JSON for that status
 */
public class ServerStatus extends AbstractDetailedStatus {

    private  long id;
    private String contentHeader;
    private String statusDesc = "Unknown";

    /**
     * Construct a ServerStatus using info passed in for identification, and obtaining current
     * server status from the appropriate facade class.
     * This class must return a pretty, english-like representation of the server status.
     *
     * @param id                a numeric identifier/counter of which request this
     * @param contentHeader     info about the request
     */
    public ServerStatus(long id, String contentHeader) {
        this.id = id;
        this.contentHeader = contentHeader;

        // Obtain current status of server
        this.statusDesc = "Server is " + systemDetailsFetcherInterface.getServerStatus();
    }

    public ServerStatus() {

    }

    public long getId() {
        return id;
    }

    public String getContentHeader() {

        return contentHeader;
    }

    @Override
    public String getStatusInEnglish() {return getStatusDesc();
    }


    public String getStatusDesc() {
        return statusDesc;
    }

public void setStatusDesc(String s){ statusDesc = s;}
}
