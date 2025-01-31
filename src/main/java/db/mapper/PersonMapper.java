package db.mapper;
import db.models.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface PersonMapper {
    @Select("SELECT * FROM person WHERE group_name = #{groupName}")
    List<Person> selectPersonByGroup(String groupName);

    @Select("SELECT * FROM person WHERE age BETWEEN #{minAge} AND #{maxAge}")
    List<Person> selectByAgeDiapason(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

    @Select("SELECT * FROM person WHERE group_name = #{groupName} AND age < #{age}")
    List<Person> selectPersonsWithGrouNameAndAge(@Param("groupName") String groupName, @Param("age") int age);

    @Insert("INSERT INTO person (name, lastname, group_name, age) VALUES (#{name}, #{lastname}, #{groupName}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertPerson(Person person);

    @Select("SELECT * FROM person")
    List<Person> selectAll();

    @Select("SELECT * FROM person WHERE id = #{id}")
    Person selectById(int id);

    @Select("UPDATE person SET name = #{name}, lastname = #{lastname}, group_name = #{groupName}, age = #{age} WHERE id = #{id}")
    void updatePerson(Person person);

    @Select("DELETE FROM person WHERE id = #{id}")
    void deletePerson(int id);

    @Select("SELECT * FROM person WHERE name = #{name}")
    List<Person> selectByName(String name);

    @Select("SELECT COUNT(*) FROM person")
    int count();

    @Select("SELECT TOP 1 * FROM person")
    Map<String, String> selectAllAsMap();

    @Select("SELECT TOP 100 * FROM person")
    List<Map<String, String>> selectTop100AsListMap();
}
