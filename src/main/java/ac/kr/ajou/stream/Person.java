package ac.kr.ajou.stream;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {
    private String name;
    private String address;
    private int age;
}
