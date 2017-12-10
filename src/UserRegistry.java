
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
				break;
			case 4:
				break;
			case 5:
				System.out.println("Kilépés...");
				break;
			default:
				printMenu();

			}
		}

	}

	private void printMenu() {
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
			users[i].setPassword("secretkey" + Math.random() * 100);
			users[i].setAge((int) (Math.random() * 100));
		}
	}

	private void printAllUser() {

		for (int i = 0; i < users.length; ++i) {
			if(users[i] != null){
				System.out.print("id: " + users[i].getId());
				System.out.print(" \t,firstname: " + users[i].getFirstName());
				System.out.print(" \t,lastname: " + users[i].getLastName());
				System.out.print(" \t,password: " + users[i].getPassword());
				System.out.println(" \t,age: " + users[i].getAge());
			}

		}
	}

	private void addNewUser(){
		boolean hasPlace = false;

		for(int i = 0; i < users.length; ++i){
			if(users[i] == null){
				User user = new User();
				Scanner scanner = new Scanner(System.in);

				int id = 0;

				for(int j = 0; j < users.length; ++j){
					if(users[j] != null && users[j].getId() >= id){
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

		if(!hasPlace){
			System.out.println("Nincs több hely");
		}


	}

	private void modifyUser(){
		//TODO
	}

	private void deleteUser(){
		//TODO
	}
}
