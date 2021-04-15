package com.acme.statusmgr.beans;

public class DetailedStatus extends DetailedStatusInterface {
    @Override
    public String getStatusInEnglish() {
        return detailDescription;
    }
}
