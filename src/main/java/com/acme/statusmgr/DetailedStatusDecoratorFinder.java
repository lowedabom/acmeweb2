package com.acme.statusmgr;

import com.acme.statusmgr.beans.DetailedStatusInterface;

public class DetailedStatusDecoratorFinder extends DetailedStatusInterface {
    String detailName;
    DetailedStatusInterface decorator;

    public DetailedStatusDecoratorFinder(DetailedStatusInterface detailedStatusInterface, String detail) {
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
            default:
                return null;
        }
    }

}
