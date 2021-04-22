package com.acme.statusmgr;

import com.acme.statusmgr.beans.BaseStatus;
import com.acme.statusmgr.beans.ServerStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * simple factory class which creates decorators for the base class BaseStatus
 */
public class DetailedStatusDecoratorFactory extends BaseStatus {
    String detailName;
    BaseStatus decorator;
    BaseStatus baseStatus;

    /**
     * constructs factory taking the base class and a detail type to add
     * @param baseStatus thing that will be decorated
     * @param detail name of detail to be added
     */
    public DetailedStatusDecoratorFactory(BaseStatus baseStatus, String detail) {
        super(baseStatus.getId(), baseStatus.getContentHeader());
        detailName = detail;
        this.baseStatus = baseStatus;
    }

    @Override
    public String getStatusDesc() {
        return decorator.getStatusDesc();
    }

    /**
     * uses detailName to find the correct decorator
     * @return decorator of subclass of BaseStatus
     */
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

    /**
     * exception called when a detail which is unsupported is requested
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "invalid detail requested")
    public class InvalidDetailException extends RuntimeException {
        public InvalidDetailException(String message) {
            super(message);
        }
    }
}
