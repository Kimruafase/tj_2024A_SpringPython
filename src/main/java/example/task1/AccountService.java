package example.task1;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    //  1. create
    public int create(AccountDto accountDto) {
        log.info("create success");
        return accountDao.create(accountDto);
    }

    //  2. read
    public List<AccountDto> read() {
        return accountDao.read();
    }

    //  3. update
    public int update(AccountDto accountDto) {
        log.info("update success");
        return accountDao.update(accountDto);
    }

    //  4. delete
    public int delete(AccountDto accountDto) {
        log.info("delete success");
        return accountDao.delete(accountDto);
    }
}
