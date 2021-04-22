package com.acme.statusmgr;

import com.acme.statusmgr.beans.BaseStatus;

public class FreeJVMMemoryStatus extends BaseStatus {
    BaseStatus baseStatus;
    public FreeJVMMemoryStatus(BaseStatus baseStatus) {
        super(baseStatus.getId(), baseStatus.getContentHeader());
        this.baseStatus = baseStatus;
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + String.format(", and there are %s bytes of JVM memory free", systemDetailsFetcherInterface.getFreeJVMMemory());
    }
}
