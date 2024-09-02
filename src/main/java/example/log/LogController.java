package example.log;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Log4j2
public class LogController {

    @Autowired private  LogService logService;

    @GetMapping("/")
    public void log(){
        // 1.
        log.info("LogController info log");  // This will print in the console log with the timestamp

        // 2.
        log.debug("LogController debug log"); // This will print in the console

        // 3.
        log.error("LogController error log"); // This will print in the console

        // 4.
        log.warn("LogController warn log"); // This will print in the console
        logService.log();
    }
}
