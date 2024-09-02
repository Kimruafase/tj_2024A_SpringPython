package example.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyDao {

    // [1] 추상 메소드
    //  1. 등록
    int save(UserDto userDto);

    //  2. 전체 출력
    List<UserDto> findAll();

    //  2 - 1. 개별 조회 출력
    List<UserDto> findById(UserDto userDto);

    //  3. 수정
    int update(UserDto userDto);

    //  4. 삭제
    int delete(UserDto userDto);

}
