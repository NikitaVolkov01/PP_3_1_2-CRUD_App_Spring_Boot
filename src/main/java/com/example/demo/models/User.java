package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;

    @NotBlank(message = "Name should not be empty")
    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    @Column(name = "name", nullable = false)
    private String userName;

    @NotBlank(message = "Surname should not be empty")
    @Size(min = 1, max = 30, message = "Surname should be between 1 and 30 characters")
    @Column(name = "surname", nullable = false)
    private String userSurname;

    @Min(value = 0, message = "Age should be greater than or equal 0")
    @Column(name = "age")
    private int userAge;

    public User() {
    }

    public User(String name, int age) {
        this.userName = name;
        this.userAge = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int age) {
        this.userAge = age;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String surname) {
        this.userSurname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && userAge == user.userAge && Objects.equals(userName, user.userName) && Objects.equals(userSurname, user.userSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userSurname, userAge);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
