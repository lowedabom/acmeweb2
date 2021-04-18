package com.acme.statusmgr;

import com.acme.statusmgr.beans.AbstractDetailedStatus;

public class TempLocationStatus extends AbstractDetailedStatus {
    public TempLocationStatus(AbstractDetailedStatus abstractDetailedStatus) {
        this.abstractDetailedStatus = abstractDetailedStatus;
    }

    @Override
    public String getStatusInEnglish() {
        return abstractDetailedStatus.getStatusInEnglish() + String.format(", and the server's temp file location is %s",SystemDetailsFetcher.getTempLocation());
    }
}
