package com.niit.jdp;


import com.niit.jdp.service.DatabaseService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();

        DatabaseService databaseService = new DatabaseService();

    }
}