package com.acme.statusmgr;

import com.acme.statusmgr.beans.AbstractDetailedStatus;

public class FreeJVMMemoryStatus extends AbstractDetailedStatus {
    public FreeJVMMemoryStatus(AbstractDetailedStatus abstractDetailedStatus) {
        this.abstractDetailedStatus = abstractDetailedStatus;
    }

    @Override
    public String getStatusInEnglish() {
        return abstractDetailedStatus.getStatusInEnglish() + String.format(", and there are %s bytes of JVM memory free", systemDetailsFetcherInterface.getFreeJVMMemory());
    }
}
