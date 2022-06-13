package com.vanhieu.javacorebasic.usermanagement;

import java.util.Objects;

public class UsernameAndAge {

    private String username;
    private int age;

    public UsernameAndAge(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsernameAndAge that = (UsernameAndAge) o;
        return age == that.age && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, age);
    }
}
