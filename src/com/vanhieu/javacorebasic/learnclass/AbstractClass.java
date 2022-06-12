package com.vanhieu.javacorebasic.learnclass;

public class AbstractClass<T> {

    private int id;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "AbstractClass{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                '}';
    }
}
