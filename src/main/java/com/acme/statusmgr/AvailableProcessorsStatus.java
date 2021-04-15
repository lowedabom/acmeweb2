package com.acme.statusmgr;

import com.acme.statusmgr.beans.DetailedStatusInterface;

public class AvailableProcessorsStatus extends DetailedStatusInterface {
    public AvailableProcessorsStatus(DetailedStatusInterface detailedStatusInterface) {
    }

    @Override
    public String getStatusInEnglish() {
        return String.format(", and there are %s processors available",SystemDetailsFetcher.getAvailableProcessors());
    }

}
