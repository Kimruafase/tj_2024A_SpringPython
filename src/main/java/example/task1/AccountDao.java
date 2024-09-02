package example.task1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDao {

    // 1. create
    int create(AccountDto accountDto);

    // 2. read
    List<AccountDto> read();

    // 3. update
    int update(AccountDto accountDto);

    // 4. delete
    int delete(AccountDto accountDto);
}
