package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static Scanner sc = new Scanner(System.in);
    static int cups = 9;
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int money = 550;


    public static void main(String[] args) {

        boolean flag = true;

        while (flag) {

            switch (mainMenu()) {
                case 1:
                    switch (buyMenu()) {
                        case "1":
                            if (isPossible(250, 1, 16)) {
                                makeEspresso();
                            }
                            break;
                        case "2":
                            if (isPossible(350, 75, 20)) {
                                makeLatte();
                            }
                            break;
                        case "3":
                            if (isPossible(200, 100, 12)) {
                                makeCappuccino();
                            }
                            break;
                        case "4":
                            break;
                    }
                    break;

                case 2:
                    getUserInput();
                    break;

                case 3:
                    System.out.printf("I gave you $%d\n", money);
                    money = 0;
                    break;
                case 4:
                    status();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }


    public static void status() {
        System.out.printf("The coffee machine has:\n" + "%d ml of water\n" + "%d ml of milk\n" + "%d g of coffee beans\n" + "%d disposable cups\n" + "$%d of money\n", water, milk, coffeeBeans, cups, money);
    }

    public static String buyMenu() {
        System.out.println("What do you want to buy? 1 - espresso," + " 2 - latte, 3 - cappuccino, back - to main menu: \n");
        String option = sc.nextLine();
        if (option.equals("back")) {
            return "4";
        } else {
            return option;
        }

    }

    public static int mainMenu() {
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        switch (sc.nextLine()) {
            case "buy":
                return 1;
            case "fill":
                return 2;
            case "take":
                return 3;
            case "remaining":
                return 4;
            default:
                return 5;
        }
    }


    public static void makeEspresso() {
        water -= 250;
        coffeeBeans -= 16;
        money += 4;
        cups -= 1;
    }

    public static void makeLatte() {
        water -= 350;
        milk -= 75;
        coffeeBeans -= 20;
        money += 7;
        cups -= 1;
    }

    public static void makeCappuccino() {
        water -= 200;
        milk -= 100;
        coffeeBeans -= 12;
        money += 6;
        cups -= 1;
    }


    public static void getUserInput() {
        System.out.println("Write how many ml of water you want to add: ");
        water += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many ml of milk you want to add:");
        milk += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += Integer.parseInt(sc.nextLine());
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += Integer.parseInt(sc.nextLine());
    }

    public static int findFactorIngredient(int wtr, int mlk, int bns) {

        if (water / wtr == 0) {
            return 1;
        } else if (milk / mlk == 0) {
            return 2;
        } else if (coffeeBeans / bns == 0) {
            return 3;
        } else {
            return 0;
        }
    }

    public static boolean isPossible(int wtr, int mlk, int bns) {

        switch (findFactorIngredient(wtr, mlk, bns)) {
            case 1:
                System.out.println("Sorry, not enough water!");
                return false;
            case 2:
                System.out.println("Sorry, not enough milk!");
                return false;
            case 3:
                System.out.println("Sorry, not enough coffee beans!");
                return false;
            default:
                System.out.println("I have enough resources, making you a coffee!");
                return true;
        }
    }

}
