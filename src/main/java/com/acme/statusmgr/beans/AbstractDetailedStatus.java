package com.acme.statusmgr.beans;

import com.acme.statusmgr.SystemDetailsFetcher;
import com.acme.statusmgr.SystemDetailsFetcherInterface;

public abstract class AbstractDetailedStatus {

    public String detailDescription= "";
    public AbstractDetailedStatus abstractDetailedStatus;
    static public SystemDetailsFetcherInterface systemDetailsFetcherInterface = new SystemDetailsFetcher();

    public abstract String getStatusInEnglish();

}
