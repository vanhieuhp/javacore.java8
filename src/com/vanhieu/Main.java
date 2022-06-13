package com.vanhieu;

import com.vanhieu.javacorebasic.usermanagement.User;
import com.vanhieu.javacorebasic.usermanagement.UsernameAndAge;
import com.vanhieu.javacorebasic.usermanagement.UserManagement;

import java.io.IOException;
import java.util.*;

public class Main {
    private static Random generator = new Random();
    public static void main(String[] args) throws IOException {

        UserManagement userManagement = new UserManagement();
        List<User> userList = null;
        Scanner in = new Scanner(System.in);
        String point;
        String runningSystemPoint = "y";
        while(!runningSystemPoint.equals("n")) {
            System.out.println("Choose function: ");
            System.out.println("1. Create user list");
            System.out.println("2. Sort user list by user");
            System.out.println("3. Sort user list by ID");
            System.out.println("4. Show number of female and male");
            System.out.println("5. Show collection of username");
            System.out.println("6. Show collection of user filter by username");
            System.out.println("7. Show collection of user filter by username and age");
            System.out.println("8. Write list user in output file");
            System.out.println("9. exit");
            point = in.nextLine();
            if (userList == null && !point.equals("1")) {
                System.out.println("You need to create a user list");
                continue;
            }
            switch (point) {
                case "1": {
                    userList = userManagement.createListUser(300);
                    userManagement.showUserList(userList);
                    break;
                }
                case "2": {
                    userManagement.sortByUsername(userList);
                    break;
                }
                case "3": {
                    userManagement.sortById(userList);
                    System.out.println("Hello");
                    break;
                }
                case "4": {
                    userManagement.countFemaleAndMale(userList);
                    break;
                }
                case "5": {
                    Set<String> usernameCollect = userManagement.collectSetOfUsername(userList);
                    userManagement.showUsernameSet(usernameCollect);
                    break;
                }
                case "6": {
                    Map<String, List<User>> userSameNameCollection = userManagement.collectUserByUsername(userList);
                    userManagement.showUserHasSameName(userSameNameCollection);
                    break;
                }
                case "7": {
                    Map<UsernameAndAge, List<User>> userSameAndAndAgeCollection =
                            userManagement.collectUserByUsernameAndAge(userList);
                    userManagement.showUserHasSameNameAndAge(userSameAndAndAgeCollection);
                    break;
                }
                case "8": {
                    System.out.print("Enter your file name: ");
                    String fileName = in.nextLine();
                    fileName = fileName + ".text";
                    userManagement.writeToFile(fileName, userList);
                    System.out.println("Write file " + fileName + " Successfully!");
                    break;
                }
                case "9": {
                    runningSystemPoint = "n";
                    break;
                }
            }
        }
    }
}
