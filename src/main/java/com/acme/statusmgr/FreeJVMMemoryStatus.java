package com.acme.statusmgr;

import com.acme.statusmgr.beans.DetailedStatusInterface;

public class FreeJVMMemoryStatus extends DetailedStatusInterface {
    public FreeJVMMemoryStatus(DetailedStatusInterface detailedStatusInterface) {
    }

    @Override
    public String getStatusInEnglish() {
        return String.format(", and there are %s bytes of JVM memory free",SystemDetailsFetcher.getFreeJVMMemory());
    }
}
