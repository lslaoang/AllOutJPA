package io.lao.alloutjpa.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "STUDENT")
@Getter
@Setter
public class User {
    @Id
    @Column
    private long id;

    @Column
    private UserType userType;

    @Column
    private String name;
    @Column
    private Department department;
    @Column
    private String address;

    @Column(name = "BOOKS")
    @OneToMany
   private List<Aklat> aklatList;

    public User(long id, UserType userType, String name, Department department, String address) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.department = department;
        this.address = address;
    }

    public User(){}
}
