package com.acme.statusmgr;

import com.acme.statusmgr.beans.AbstractDetailedStatus;

public class FreeJVMMemoryStatus extends AbstractDetailedStatus {
    public FreeJVMMemoryStatus(AbstractDetailedStatus detailedStatusInterface) {
    }

    @Override
    public String getStatusInEnglish() {
        return String.format(", and there are %s bytes of JVM memory free",SystemDetailsFetcher.getFreeJVMMemory());
    }
}
