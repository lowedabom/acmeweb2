package com.acme.statusmgr.beans;

public abstract class DetailedStatusInterface {

    public boolean mockImplementation = false;
    public String detailDescription= "";
    public DetailedStatusInterface detailedStatusInterface;

    public abstract String getStatusInEnglish();

}
