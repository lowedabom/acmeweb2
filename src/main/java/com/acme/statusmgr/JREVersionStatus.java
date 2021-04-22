package com.acme.statusmgr;

import com.acme.statusmgr.beans.BaseStatus;

public class JREVersionStatus extends BaseStatus {
    BaseStatus baseStatus;
    public JREVersionStatus(BaseStatus baseStatus) {
        super(baseStatus.getId(), baseStatus.getContentHeader());
        this.baseStatus = baseStatus;
    }

    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + String.format(", and the JRE version is %s", systemDetailsFetcherInterface.getJREVersion());
    }
}
