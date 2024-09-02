package example.task1;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acc")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // 1. create
    @PostMapping("/create")
    public int create(AccountDto accountDto) {
        return accountService.create(accountDto);
    }

    // 2. read
    @GetMapping("/read")
    public List<AccountDto> read() {
        return accountService.read();
    }

    // 3. update
    @PutMapping("/update")
    public int update(AccountDto accountDto) {
        return accountService.update(accountDto);
    }

    // 4. delete
    @DeleteMapping("/delete")
    public int delete(AccountDto accountDto) {
        return accountService.delete(accountDto);
    }
}
