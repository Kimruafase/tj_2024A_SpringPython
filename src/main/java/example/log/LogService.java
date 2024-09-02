package example.log;


import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LogService {

    public void log(){
        // 1.
        log.info("LogController info log");  // This will print in the console log with the timestamp

        // 2.
        log.debug("LogController debug log"); // This will print in the console

        // 3.
        log.error("LogController error log"); // This will print in the console

        // 4.
        log.warn("LogController warn log"); // This will print in the console
    }
}
