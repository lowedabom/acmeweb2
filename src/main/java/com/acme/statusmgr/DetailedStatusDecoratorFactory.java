package com.acme.statusmgr;

import com.acme.statusmgr.beans.DetailedStatusInterface;

public class DetailedStatusDecoratorFactory extends DetailedStatusInterface {
    String detailName;
    DetailedStatusInterface decorator;

    public DetailedStatusDecoratorFactory(DetailedStatusInterface detailedStatusInterface, String detail) {
        detailName = detail;
        this.detailedStatusInterface = detailedStatusInterface;
        decorator = findDecorator();
    }

    @Override
    public String getStatusInEnglish() {
        return detailedStatusInterface.getStatusInEnglish() + decorator.getStatusInEnglish();
    }

    public DetailedStatusInterface findDecorator() {
        switch (detailName) {
            case "availableProcessors":
                return new AvailableProcessorsStatus(detailedStatusInterface);
            case "freeJVMMemory":
                return new FreeJVMMemoryStatus(detailedStatusInterface);
            default:
                return null;
        }
    }

}
