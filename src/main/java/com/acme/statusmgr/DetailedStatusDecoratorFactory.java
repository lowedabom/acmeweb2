package com.acme.statusmgr;

import com.acme.statusmgr.beans.AbstractDetailedStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

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
                    throw new InvalidDetailException("Invalid details option: " + detailName);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public class InvalidDetailException extends RuntimeException {
        public InvalidDetailException(String message) {
            super(message);
        }
    }
}
