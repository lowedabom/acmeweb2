package com.acme.statusmgr;

import com.acme.statusmgr.beans.AbstractDetailedStatus;

public class JREVersionStatus extends AbstractDetailedStatus {
    public JREVersionStatus(AbstractDetailedStatus abstractDetailedStatus) {
        this.abstractDetailedStatus = abstractDetailedStatus;
    }

    @Override
    public String getStatusInEnglish() {
        return abstractDetailedStatus.getStatusInEnglish() + String.format(", and the JRE version is %s",SystemDetailsFetcher.getJREVersion());
    }
}
