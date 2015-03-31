package com.thoughtworks.securityinourdna;

import java.util.Scanner;

public class Main {

    private static final UserRepo userRepo = initializeUserRepo();

    public static void main(final String[] args) throws Exception {
        System.out.print("Please Login.\n");

        System.out.print("Username: ");
        final String username = new Scanner(System.in).nextLine();
        System.out.print("Password: ");
        final String password = new Scanner(System.in).nextLine();

        if (userRepo.login(username, password)) {
            System.out.println("Welcome " + username + " " + userRepo.findLastName(username) + "!");
        } else {
            System.out.println("Sorry, please check your username and password combination.");
        }
    }

    private static UserRepo initializeUserRepo() {
        try {
            final ConnectionFactory connectionFactory = new ConnectionFactory();
            final UserRepo userRepo = new UserRepo(connectionFactory.createInMemoryDatabase());

            userRepo.addName("Alice", "Brown", "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8");
            userRepo.addName("Bob", "Smith", "ae4a41f7d414c4daef82a048b4240c56228b738649e032fe3ac6a482d4fb97bc");
            userRepo.addName("Eve", "Johnson", "89b4c9f491523c0dd9bc9f924ea0e781e68eaa54f66ecc6fc155d97dc5a45399");
            userRepo.addName("Mallory", "Jones", "2ce89dc2ab42ea761853f2908d17a722f0a4dbe93ec493469e86ea681960e6a7");
            userRepo.addName("Dan", "Williams", "982a36019792f43b7dae5d0935b8a24b1049e047639cf432a26aa1dbd28cf23e");
            userRepo.addName("admin", "Almighty", "19ea60d7f67e88549d3182b885705b1c0240ad7e5182f6fe279af857d6cd7e13");

            return userRepo;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
