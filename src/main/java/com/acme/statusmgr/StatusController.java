package com.acme.statusmgr;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.acme.statusmgr.beans.BaseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for all web/REST requests about the status of servers
 *
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 *    All start with /server
 *    /status  will give back status of server
 *    a param of 'name' specifies a requestor name to appear in response
 *
 * Examples:
 *    http://localhost:8080/server/status
 *
 *    http://localhost:8080/server/status?name=Noach
 *
 *
 *
 */
@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();


    
    @RequestMapping("/status")
    public BaseStatus serverStatusRequestHandler(@RequestParam(value="name", defaultValue="Anonymous") String name, @RequestParam(required = false) List<String> details) {
        StringBuilder sb = new StringBuilder();
        for (String s: details ) {
            sb.append(s+", ");
        }
        System.out.println("*** DEBUG INFO *** details = " + sb);

        return new BaseStatus(counter.incrementAndGet(),
                            String.format(template, name));
    }

    /**
     * request handler which returns JSON of a status object representing the status of several details as request by the user.
     * @param name name of requester
     * @param details list of details requested
     * @return BaseStatus representing status of all details requested
     */

    @RequestMapping("/status/detailed")
    public BaseStatus serverStatusDetailedRequestHandler(@RequestParam(value="name", defaultValue="Anonymous") String name, @RequestParam List<String> details) {
        BaseStatus detailedStatus = new BaseStatus(counter.incrementAndGet(),
                String.format(template, name));
        detailedStatus.setDefaultStatusDesc();
        for (String detail:details) {
            detailedStatus = new DetailedStatusDecoratorFactory(detailedStatus,detail).createDecorator();
        }
        return detailedStatus;
    }

}
