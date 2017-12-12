
import java.util.*;

public class UserRegistry {

    private User[] users;

    public UserRegistry() {
        users = new User[10];
        init();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int operation = -1;

        while (operation != 5) {
            System.out.print("Válasszon egy menüpontot: ");
            operation = scanner.nextInt();
            switch (operation) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    printAllUser();
                    break;
                case 2:
                    addNewUser();
                    break;
                case 3:
                    modifyUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    System.out.println("Kilépés...");
                    break;
                default:
                    printMenu();

            }
        }

    }

    public void printMenu() {
        System.out.println("*********Menu*********");
        System.out.println("****Print menu (0)****");
        System.out.println("**Print all User (1)**");
        System.out.println("***Add new User (2)***");
        System.out.println("****Modify User (3)***");
        System.out.println("****Delete User (4)***");
        System.out.println("*******Exit (5)*******");
    }

    private void init() {
        for (int i = 0; i < users.length - 1; ++i) {
            users[i] = new User();
            users[i].setId(i);
            users[i].setFirstName("alma" + Math.random() * 100);
            users[i].setLastName("béla" + Math.random() * 100);
            users[i].setPassword(PasswordGenerator.generatePassword(7));
            users[i].setAge((int) (Math.random() * 100));
        }
    }

    private void printAllUser() {

        for (int i = 0; i < users.length; ++i) {
            if (users[i] != null) {
                System.out.print("id: " + users[i].getId());
                System.out.print(" \t,firstname: " + users[i].getFirstName());
                System.out.print(" \t,lastname: " + users[i].getLastName());
                System.out.print(" \t,password: " + users[i].getPassword());
                System.out.println(" \t,age: " + users[i].getAge());
            }

        }
    }

    private void addNewUser() {
        boolean hasPlace = false;

        for (int i = 0; i < users.length; ++i) {
            if (users[i] == null) {
                User user = new User();
                Scanner scanner = new Scanner(System.in);

                int id = 0;

                for (int j = 0; j < users.length; ++j) {
                    if (users[j] != null && users[j].getId() >= id) {
                        id = users[j].getId() + 1;
                    }
                }

                String firstname;
                String lastname;
                String password;
                int age;

                System.out.println("firstname: ");
                firstname = scanner.next();
                System.out.println("lastname: ");
                lastname = scanner.next();
                System.out.println("password: ");
                password = scanner.next();
                System.out.println("age: ");
                age = scanner.nextInt();

                user.setId(id);
                user.setFirstName(firstname);
                user.setLastName(lastname);
                user.setPassword(password);
                user.setAge(age);

                users[i] = user;
                hasPlace = true;

                break;
            }
        }

        if (!hasPlace) {
            System.out.println("Nincs több hely");
        }


    }

    private void modifyUser() {

        String modifFirstname;
        String modifLastname;

        Scanner scanner = new Scanner(System.in);

        /**Konzolról bekértem a módosítandó felhasználó azonosítóját,
         * inicializáltam egy boolean típusú segéd változót,
         * majd for ciklussal megvizsgáltam, hogy a tömbben létezik-e
         * ilyen azonosító és a benne szereplő azonosítók egyike
         * egyezik-e az inputId értékével, ha igen, akkor
         * bekéri a módosítandó adatokat és a tömb kiválasztott
         * elemének értékéül adja azokat,
         * ha nincs ilyen azonosító, akkor kiírja konzolra.*/

        System.out.println("A módosítandó felhasználó azonosítója: ");

        int inputId = scanner.nextInt();
        boolean match = false;

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == inputId) {
                Scanner scannerModif = new Scanner(System.in);

                System.out.println("firstname: ");
                modifFirstname = scannerModif.next();

                System.out.println("lastname: ");
                modifLastname = scannerModif.next();

                users[i].setFirstName(modifFirstname);
                users[i].setLastName(modifLastname);
                users[i].setPassword(PasswordGenerator.generatePassword(7));

                match = true;
                System.out.println("Felhasználó módosítva.");
                break;
            }
        }

        if (!match) {
            System.out.println("Azonosító nem létezik!");
        }
    }

    private void deleteUser() {
        Scanner scanner = new Scanner(System.in);

        /**Konzolról bekértem a törlendő felhasználó azonosítóját,
         * inicializáltam egy boolean típusú segéd változót,
         * majd for ciklussal megvizsgáltam, hogy a tömbben létezik-e
         * ilyen azonosító és a benne szereplő azonosítók egyike
         * egyezik-e az inputId értékével, ha igen, akkor
         * törli az elemet a tömbből, ha nincs ilyen azonosító,
         * akkor kiírja konzolra.*/

        System.out.println("A törlendő felhasználó azonosítója: ");

        int inputId = scanner.nextInt();
        boolean match = false;

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == inputId) {
                match = true;
                users[i] = null;
                System.out.println("Felhasználó törölve.");
                break;
            }
        }

        if (!match) {
            System.out.println("Azonosító nem létezik!");
        }

    }
}
