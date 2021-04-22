package com.acme.statusmgr;

import com.acme.statusmgr.beans.BaseStatus;

public class TempLocationStatus extends BaseStatus {
    public TempLocationStatus(BaseStatus baseStatus) {
        super(baseStatus.getId(), baseStatus.getContentHeader());
        this.baseStatus = baseStatus;
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + String.format(", and the server's temp file location is %s", systemDetailsFetcherInterface.getTempLocation());
    }
}
