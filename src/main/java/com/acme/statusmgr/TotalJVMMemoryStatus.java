package com.acme.statusmgr;

import com.acme.statusmgr.beans.AbstractDetailedStatus;

public class TotalJVMMemoryStatus extends AbstractDetailedStatus {
    public TotalJVMMemoryStatus(AbstractDetailedStatus detailedStatusInterface) {
    }

    @Override
    public String getStatusInEnglish() {
        return String.format(", and there is a total of %s bytes of JVM memory",SystemDetailsFetcher.getTotalJVMMemory());
    }
}
