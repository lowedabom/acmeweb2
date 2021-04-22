package com.acme.statusmgr;

import com.acme.statusmgr.beans.BaseStatus;
/**
 * Decorator that adds JRE version Status to the base class passed in.
 */
public class JREVersionStatus extends BaseStatus {
    BaseStatus baseStatus;

    /**
     * simple constructor which takes the fields from the base class and adds it to this class
     * @param baseStatus thing that will be decorated
     */
    public JREVersionStatus(BaseStatus baseStatus) {
        super(baseStatus.getId(), baseStatus.getContentHeader());
        this.baseStatus = baseStatus;
    }
    /**
     * Adds JRE version status data on top of the base class's statusDesc.
     * Uses SystemDetailsFetcherInterface to get the data.
     * @return String representing the new and improved statusDesc value
     */
    @Override
    public String getStatusDesc() {
        return baseStatus.getStatusDesc() + String.format(", and the JRE version is %s", systemDetailsFetcherInterface.getJREVersion());
    }
}
