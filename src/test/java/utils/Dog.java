package utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Dog {

    private String name;
    private String breed;
    private  int age;


    public static void main(String[] args) {

        Dog dog =  new Dog();
        dog.setAge(45);
        System.out.println(dog.getAge());
        System.out.println(dog);
    }

}
