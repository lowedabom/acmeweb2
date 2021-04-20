package com.acme.statusmgr;

import com.acme.statusmgr.beans.AbstractDetailedStatus;

public class TotalJVMMemoryStatus extends AbstractDetailedStatus {
    public TotalJVMMemoryStatus(AbstractDetailedStatus abstractDetailedStatus) {
        this.abstractDetailedStatus = abstractDetailedStatus;
    }

    @Override
    public String getStatusInEnglish() {
        return abstractDetailedStatus.getStatusInEnglish() + String.format(", and there is a total of %s bytes of JVM memory", systemDetailsFetcherInterface.getTotalJVMMemory());
    }
}
