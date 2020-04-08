package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11. На столе 11 спичек.");
        System.out.println("За один ход можно брать от 1 до 3 спичек.");
        System.out.println("Играют два игрока.");
        int res = 11;
        int action = 1;
        while (res > 0) {
            if (action == 1) {
                System.out.println("Первый игрок берет спички. Сколько?");
                action = 2;
            } else {
                System.out.println("Второй игрок берет спички. Сколько?");
                action = 1;
            }
            boolean check = true;
            while (check) {
                int select = Integer.valueOf(input.nextLine());
                if (select < 1 || select > 3) {
                    System.out.println("Эй, за один ход можно брать от 1 до 3 спичек!");
                    System.out.println("Давай еще раз.");
                } else if (res - select < 0) {
                    System.out.println("Ты хочешь взять больше спичек, чем осталось!");
                    System.out.println("Давай еще раз.");
                } else {
                    res = (res - select);
                    System.out.println("Осталось " + res + " спичек");
                    System.out.println();
                    check = false;
                }
            }
        }
        if (action == 2) {
            System.out.println("Выиграл первый игрок! Поздравляем!");
        }
        else {
            System.out.println("Выиграл второй игрок! Ура!");
        }
    }
}
