package com.vanhieu.javacorebasic.usermanagement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class UserManagement {

    private final List<String> CHARACTER_NAME = Arrays.asList("f", "r", "u", "i", "t");
    private final List<String> GENDER_LIST = Arrays.asList("female", "male");

    public UserManagement() {
    }

    public List<User> createListUser(int numOfUser) {
        List<User> userList = new ArrayList<>();
        List<String> characterOfUsername = CHARACTER_NAME.parallelStream().collect(Collectors.toList());
        for (int i = 1; i <= numOfUser; i++) {
            User user = createUserInfo(i);
            setUsernameOfUser(user, characterOfUsername);
            userList.add(user);
        }
        return userList;
    }

    private User createUserInfo(int i) {
        User user = new User();
        user.setId(i);
        user.setAge((int)(Math.random() * (22 - 20 + 1) + 20));
        user.setGender(GENDER_LIST.get((int) (Math.random() * (GENDER_LIST.size()))));
        return user;
    }

    private void setUsernameOfUser(User user, List<String> characterOfUsername) {
        Collections.shuffle(characterOfUsername);
        String username = characterOfUsername.get(0) + characterOfUsername.get(1) + characterOfUsername.get(2);
        user.setUsername(username);
    }

    public Set<String> collectSetOfUsername(List<User> userList) {
        Set<String> usernameCollect = userList.stream()
                .map(user -> user.getUsername())
                .collect(Collectors.toSet());
        return usernameCollect;
    }

    public Map<String, List<User>> collectUserByUsername(List<User> userList) {
        Map<String, List<User>> userListHasSameName =
                userList.stream().collect(
                        Collectors.groupingBy(User::getUsername, Collectors.toList())
                );
        return userListHasSameName;
    }

    public Map<UsernameAndAge, List<User>> collectUserByUsernameAndAge(List<User> userList) {
        Map<UsernameAndAge, List<User>> userListHasSameNameAndAge =
                userList.stream().collect(
                        Collectors.groupingBy(user -> new UsernameAndAge(user.getUsername(), user.getAge()))
                );
        return userListHasSameNameAndAge;
    }

    public void sortById(List<User> userList) {
        userList.stream().sorted(Comparator.comparing(User::getId))
                .forEach(user -> System.out.println(user));
    }

    public void sortByUsername(List<User> userList) {
        userList.stream().sorted(Comparator.comparing(User::getUsername))
                .forEach(user -> System.out.println(user));
    }

    // count female and male
    public void countFemaleAndMale(List<User> userList) {
        int count = (int) userList.parallelStream().filter(user -> user.getGender().equals("female")).count();
        System.out.println("Female: " + count);
        System.out.println("Male: " + (userList.size() - count));
    }

//    show function
    public void showUserHasSameNameAndAge(Map<UsernameAndAge, List<User>> userMap) {
        userMap.forEach((k,v) -> {
            v.stream().forEach(user -> System.out.println(user.toString()));
            System.out.println("-----------");
        });
    }

    public void showUserHasSameName(Map<String, List<User>> userMap) {
        userMap.forEach((k,v) -> {
            v.stream().forEach(user -> System.out.println(user.toString()));
            System.out.println("---------");
        });
    }

    public void showUserList(List<User> userList) {
        userList.forEach(user -> {
            System.out.println(user.toString());
        });
    }

    public void showUsernameSet(Set<String> userSet) {
        userSet.forEach(username -> {
            System.out.println(username);
        });
    }

//    write file
    public void writeToFile(String fileName, List<User> userList) throws IOException {
        try {
            // Step 1: Create an object of BufferedWriter
            BufferedWriter f_writer = new BufferedWriter(new FileWriter(fileName));
            // Step 2: Write text(content) to file
            userList.stream().forEach(user -> {
                try {
                    f_writer.write(user.toString() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            f_writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
