package com.acme.statusmgr;

import com.acme.statusmgr.beans.BaseStatus;
import com.acme.statusmgr.beans.ServerStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DetailedStatusDecoratorFactory extends BaseStatus {
    String detailName;
    BaseStatus decorator;
    BaseStatus baseStatus;

    public DetailedStatusDecoratorFactory(BaseStatus baseStatus, String detail) {
        super(baseStatus.getId(), baseStatus.getContentHeader());
        detailName = detail;
        this.baseStatus = baseStatus;
    }

    @Override
    public String getStatusDesc() {
        return decorator.getStatusDesc();
    }

    public BaseStatus createDecorator() {
        switch (detailName) {
            case "server":
                return new ServerStatus(baseStatus);
            case "availableProcessors":
                return new AvailableProcessorsStatus(baseStatus);
            case "freeJVMMemory":
                return new FreeJVMMemoryStatus(baseStatus);
            case "totalJVMMemory":
                return new TotalJVMMemoryStatus(baseStatus);
            case "jreVersion":
                return new JREVersionStatus(baseStatus);
            case "tempLocation":
                return new TempLocationStatus(baseStatus);
            default:
                    throw new InvalidDetailException("Invalid details option: " + detailName);
        }
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "invalid detail requested")
    public class InvalidDetailException extends RuntimeException {
        public InvalidDetailException(String message) {
            super(message);
        }
    }
}
