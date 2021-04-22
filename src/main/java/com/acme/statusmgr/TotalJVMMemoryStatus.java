package com.acme.statusmgr;

import com.acme.statusmgr.beans.BaseStatus;

public class TotalJVMMemoryStatus extends BaseStatus {
    BaseStatus baseStatus;

    public TotalJVMMemoryStatus(BaseStatus baseStatus) {
        super(baseStatus.getId(), baseStatus.getContentHeader());
        this.baseStatus = baseStatus;
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + String.format(", and there is a total of %s bytes of JVM memory", systemDetailsFetcherInterface.getTotalJVMMemory());
    }
}
