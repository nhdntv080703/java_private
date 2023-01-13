package KiemTra.Bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class showMenu {
    static Scanner sc = new Scanner(System.in);
    List<Honey> honeyList = new ArrayList<>();
    public void Menu() {
        while (true) {
            System.out.println("1. Add Honey");
            System.out.println("2. Show all Honeys");
            System.out.println("3. Delete Honey by id");
            System.out.println("4. Edit Honey by id");
            System.out.println("5. Add Favoritepublic class Honey extends Person by honey id");
            System.out.println("6. Sort Honey by name");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addHoney();
                    break;
                case 2:
                    showAllHoneys();
                    break;
                case 3:
                    deleteHoneyById();
                    break;
                case 4:
                    editHoneyById();
                    break;
                case 5:
                    addFavoriteByHoneyId();
                    break;
                case 6:
                    sortHoneyByName();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    return;
            }
        }
    }

    private void addHoney() {
        System.out.println("Please enter the Honey's ten: ");
        String ten = sc.nextLine();
        sc.nextLine();

        System.out.println("Please enter the Honey's tuoi: ");
        int tuoi = sc.nextInt();
        sc.nextLine();

        System.out.println("Please enter the Honey's sdt: ");
        String sdt = sc.nextLine();
        sc.nextLine();

        Honey honey = new Honey(ten, tuoi, sdt, new ArrayList<>());
        honeyList.add(honey);
        System.out.println("Honey added successfully!");
    }

    private void showAllHoneys() {
        System.out.println("id\tstatus");
        System.out.println("--------------------");
        for (Honey honey : honeyList) {
            System.out.println(honey.getId() + "\t" + honey.getStatus());
        }
    }

    private void deleteHoneyById() {
        System.out.println("Please enter the Honey's id: ");
        String id = sc.nextLine();
        sc.nextLine();

        Honey targetHoney = null;
        for (Honey honey : honeyList) {
            if (honey.getId() == id) {
                targetHoney = honey;
                break;
            }
        }

        if (targetHoney != null) {
            honeyList.remove(targetHoney);
            System.out.println("Honey deleted successfully!");
        } else {
            System.out.println("Honey not found!");
        }
    }

    private void editHoneyById() {
        System.out.println("Please enter the Honey's id: ");
        String id = sc.nextLine();
        sc.nextLine();

        Honey targetHoney = null;
        for (Honey honey : honeyList) {
            if (honey.getId() == id) {
                targetHoney = honey;
                break;
            }
        }

        if (targetHoney != null) {
            System.out.println("Please enter the Honey's name: ");
            String name = sc.nextLine();
            targetHoney.setTen(name);

            System.out.println("Please enter the Honey's age: ");
            int age = sc.nextInt();
            sc.nextLine();
            targetHoney.setTuoi(age);

            System.out.println("Please enter the Honey's phone: ");
            String phone = sc.nextLine();
            targetHoney.setSdt(phone);

            System.out.println("Honey edited successfully!");
        } else {
            System.out.println("Honey not found!");
        }
    }

    private void addFavoriteByHoneyId() {
        System.out.println("Please enter the Honey's id: ");
        int id = sc.nextInt();
        sc.nextLine();

        Honey targetHoney = null;
        for (Honey honey : honeyList) {
            if (honey.getId() == honeyId) {
                targetHoney = honey;
                break;
            }
        }

        if (targetHoney != null) {
            System.out.println("Please enter the Favorite's id: ");
            int favoriteId = sc.nextInt();
            sc.nextLine();

            System.out.println("Please enter the Favorite's name: ");
            String name = sc.nextLine();

            Favorite favorite = new Favorite(favoriteId, name);
            targetHoney.getFavoriteList().add(favorite);

            System.out.println("Favorite added successfully!");
        } else {
            System.out.println("Honey not found!");
        }
    }

    private void sortHoneyByName() {
        honeyList.sort((h1, h2) -> h2.getTen().compareTo(h1.getTen()));
        System.out.println("Honeys sorted successfully!");
    }
}
}
