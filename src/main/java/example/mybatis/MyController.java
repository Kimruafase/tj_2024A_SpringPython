package example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class MyController {

    @Autowired private MyService myService;

    // 1. [C] 등록
    @PostMapping("/save")
    public int save(UserDto userDto){
        return myService.save(userDto);
    }

    // 2. [R] 전체 출력
    @GetMapping("/findall")
    public List<UserDto> findAll(){
        return myService.findAll();
    }

    // 2 - 1. [R] 개별 조회 출력
    @GetMapping("/findbyid")
    public List<UserDto> findById(UserDto userDto){
        return myService.findById(userDto);
    }

    // 3. [U] 수정
    @PutMapping("/update")
    public int update(UserDto userDto){
        return myService.update(userDto);
    }

    // 4. [D] 삭제
    @DeleteMapping("/delete")
    public int delete(UserDto userDto){
        return myService.delete(userDto);
    }
}
