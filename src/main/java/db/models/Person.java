package db.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private int id;
    private int age;
    private String groupName;
    private String lastname;
    private String name;
}
