package com.acme.statusmgr;

import com.acme.statusmgr.beans.BaseStatus;

public class AvailableProcessorsStatus extends BaseStatus {
    BaseStatus baseStatus;

    public AvailableProcessorsStatus(BaseStatus baseStatus) {
        super(baseStatus.getId(), baseStatus.getContentHeader());
        this.baseStatus = baseStatus;
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + String.format(", and there are %s processors available", systemDetailsFetcherInterface.getAvailableProcessors());
    }

}
