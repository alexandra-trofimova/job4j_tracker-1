package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Item added successfully.");
                System.out.println();
            } else if (select == 1) {
                Item[] res = tracker.findAll();
                System.out.println("All Items:");
                for(int i = 0; i < res.length; i++) {
                    Item item = res[i];
                    String id = item.getId();
                    String name = item.getName();
                    System.out.println(id + " " + name);
                }
                System.out.println();
            } else if (select == 2) {
                System.out.println("Enter ID of the Item:");
                String id = scanner.nextLine();
                System.out.println("Enter new name of the Item:");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Item edited successfully.");
                }
                else {
                    System.out.println("Error");
                }
                System.out.println();
            } else if (select == 3) {
                System.out.println("Enter ID of the Item:");
                String id = scanner.nextLine();
                if (tracker.delete(id)) {
                    System.out.println("Item deleted successfully.");
                }
                else {
                    System.out.println("Error");
                }
                System.out.println();
            } else if (select == 4) {
                System.out.println("Enter ID of the Item:");
                String id = scanner.nextLine();
                Item item = tracker.findById(id);
                if (item != null) {
                    String name = item.getName();
                    System.out.println("Item's found:");
                    System.out.println(id + " " + name);
                }
                else {
                    System.out.println("Item with id " + id + " not found.");
                }
                System.out.println();
            } else if (select == 5) {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item[] res = tracker.findByName(name);
                if (res.length > 0) {
                    System.out.println("All Items with name " + name + ":");
                    for(int i = 0; i < res.length; i++) {
                        Item item = res[i];
                        String id = item.getId();
                        System.out.println(id + " " + name);
                    }
                }
                else {
                    System.out.println("There's no any Items with name " + name);
                }
                System.out.println();
            } else if (select == 6) {
                System.out.println("Program is closed.");
                run = false;
            }
            else {
                System.out.println("Invalid command.");
                System.out.println("Please write number from 0 to 6.");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
