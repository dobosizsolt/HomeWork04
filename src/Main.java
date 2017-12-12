public class Main {

    public static void main(String[] args) {
       //UserRegistry userRegistry = new UserRegistry();
       //userRegistry.printMenu();
       //userRegistry.run();
       //System.out.println(userRegistry.countUser());
       ArrayTest arrayTest = new ArrayTest();
       arrayTest.initArray();
       System.out.println("A második legnagyobb szám: " + arrayTest.getSecondHighest());
    }
}
