package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item added successfully.");
        System.out.println();
    }

    public static void findAllItems(Tracker tracker) {
        Item[] res = tracker.findAll();
        System.out.println("All Items:");
        for(int i = 0; i < res.length; i++) {
            Item item = res[i];
            System.out.println(item);
        }
        System.out.println();
    }

    public static void replaceItem(Input input, Tracker tracker){
        String id = input.askStr("Enter ID of the Item:");
        if (tracker.findById(id) != null) {
            String name = input.askStr("Enter new name of the Item:");
            Item item = new Item(name);
            if (tracker.replace(id, item)) {
                System.out.println("Item edited successfully.");
            }
            else {
                System.out.println("Error");
            }
        }
        else {
            System.out.println("Item with id " + id + " not found.");
        }
        System.out.println();
    }

    public static void deleteItem(Input input, Tracker tracker) {
        String id = input.askStr("Enter ID of the Item:");
        if (tracker.delete(id)) {
            System.out.println("Item deleted successfully.");
        }
        else {
            System.out.println("Error");
        }
        System.out.println();
    }

    public static void findItemById(Input input, Tracker tracker){
        String id = input.askStr("Enter ID of the Item:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("Item's found:");
            System.out.println(item);
        }
        else {
            System.out.println("Item with id " + id + " not found.");
        }
        System.out.println();
    }

    public static void findItemsByName(Input input, Tracker tracker){
        String name = input.askStr("Enter name: ");
        Item[] res = tracker.findByName(name);
        if (res.length > 0) {
            System.out.println("All Items with name " + name + ":");
            for(int i = 0; i < res.length; i++) {
                Item item = res[i];
                System.out.println(item);
            }
        }
        else {
            System.out.println("There's no any Items with name " + name);
        }
        System.out.println();
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = (input.askInt("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItems(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemsByName(input, tracker);
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
