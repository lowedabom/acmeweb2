package com.acme.statusmgr.beans;

public class DetailedStatus extends AbstractDetailedStatus {
    @Override
    public String getStatusInEnglish() {
        return detailDescription;
    }
}
