package com.acme.statusmgr;

import com.acme.statusmgr.beans.AbstractDetailedStatus;

public class DetailedStatusDecoratorFactory extends AbstractDetailedStatus {
    String detailName;
    AbstractDetailedStatus decorator;

    public DetailedStatusDecoratorFactory(AbstractDetailedStatus abstractDetailedStatus, String detail) {
        detailName = detail;
        this.abstractDetailedStatus = abstractDetailedStatus;
        decorator = findDecorator();
    }

    @Override
    public String getStatusInEnglish() {
        return decorator.getStatusInEnglish();
    }

    public AbstractDetailedStatus findDecorator() {
        switch (detailName) {
            case "availableProcessors":
                return new AvailableProcessorsStatus(abstractDetailedStatus);
            case "freeJVMMemory":
                return new FreeJVMMemoryStatus(abstractDetailedStatus);
            case "totalJVMMemory":
                return new TotalJVMMemoryStatus(abstractDetailedStatus);
            case "jreVersion":
                return new JREVersionStatus(abstractDetailedStatus);
            case "tempLocation":
                return new TempLocationStatus(abstractDetailedStatus);
                default:
                return null;
        }
    }

}
