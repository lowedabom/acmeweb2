package com.acme.statusmgr;

import com.acme.statusmgr.beans.DetailedStatusInterface;

public class TotalJVMMemoryStatus extends DetailedStatusInterface {
    public TotalJVMMemoryStatus(DetailedStatusInterface detailedStatusInterface) {
    }

    @Override
    public String getStatusInEnglish() {
        return String.format(", and there is a total of %s bytes of JVM memory",SystemDetailsFetcher.getTotalJVMMemory());
    }
}
