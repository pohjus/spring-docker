package fi.saranen.restfulapi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Customer {
    private static int numberOfCustomers = 0;

    private int id;
    private String name;

    public Customer(String name) {
        this.name = name;
        this.id = ++numberOfCustomers;
    }
    public Customer() {
        this.id = ++numberOfCustomers;
    }
}
