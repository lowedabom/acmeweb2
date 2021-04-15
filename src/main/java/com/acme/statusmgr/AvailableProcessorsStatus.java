package com.acme.statusmgr;

import com.acme.statusmgr.beans.AbstractDetailedStatus;

public class AvailableProcessorsStatus extends AbstractDetailedStatus {
    public AvailableProcessorsStatus(AbstractDetailedStatus abstractDetailedStatus) {
    }

    @Override
    public String getStatusInEnglish() {
        return String.format(", and there are %s processors available",SystemDetailsFetcher.getAvailableProcessors());
    }

}
