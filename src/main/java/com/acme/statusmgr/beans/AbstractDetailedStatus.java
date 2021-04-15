package com.acme.statusmgr.beans;

public abstract class AbstractDetailedStatus {

    public boolean mockImplementation = false;
    public String detailDescription= "";
    public AbstractDetailedStatus abstractDetailedStatus;

    public abstract String getStatusInEnglish();

}
