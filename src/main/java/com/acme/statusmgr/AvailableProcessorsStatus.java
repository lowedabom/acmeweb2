package com.acme.statusmgr;

import com.acme.statusmgr.beans.AbstractDetailedStatus;

public class AvailableProcessorsStatus extends AbstractDetailedStatus {
    public AvailableProcessorsStatus(AbstractDetailedStatus abstractDetailedStatus) {
        this.abstractDetailedStatus = abstractDetailedStatus;
    }

    @Override
    public String getStatusInEnglish() {
        return abstractDetailedStatus.getStatusInEnglish() + String.format(", and there are %s processors available", systemDetailsFetcherInterface.getAvailableProcessors());
    }

}
