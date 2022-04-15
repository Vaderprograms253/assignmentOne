package informal_tests;

import structures.ReversibleStackLL;

/**
 *
 * @author Xavier Denson
 * @version 17
 */
public class MyTests {
    private ReversibleStackLL<Object> list = new ReversibleStackLL<>();


    /**
     * This method creates a test and calls the printTests method to start the program
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args) {

        MyTests test = new MyTests();
        test.printTests();

    }


    /**
     * This method displays the tests for the ReversibleStack
     */
    public void printTests(){
        System.out.println("Tests\n-----\nList: " + testAdd());
        System.out.println("Size: " + testSize());
        //test reverse
        System.out.println("Reversed List: " + testReverse() +"\n");
        System.out.println("Test Removed\n------------\nRemoved: " +list.remove() + "\n"+list);
        System.out.println("Removed: " +list.remove() + "\n"+list);
        System.out.println("Removed: " +list.remove() + "\n"+list);
        //test contains
        System.out.println("\nTest contains\n-------------\ncontains Red?: ");
        System.out.println(list.contains("Red") + " Expected: true");
        System.out.println("contains Violet?: " + list.contains("Violet") + " Expected: false");
        System.out.println("contains 5?: " + list.contains(5) + " Expected: true");
        System.out.println("contains true?: " + list.contains(true) + " Expected: true");
        System.out.println("contains Yellow?: " + list.contains("Yellow") + " Expected: true");
        System.out.println("\nTest is empty and clear\n-----------------------\n");
        System.out.println("is list empty?: "+list.isEmpty() +"\n" + list);
        list.clear();
        System.out.println("is list empty?: "+list.isEmpty() +"\n" + list);
        System.out.println("Test Reverse\n----------------");
        testReverse1000();
        testExceptions();

    }

    /**
     * this method tests the add method in the ReversibleStack
     * @return String version of list
     */
    public String testAdd(){
        //add strings
        list.add("Red");
        list.add("Blue");
        list.add("Green");
        list.add("Yellow");
        list.add("Purple");
        //add ints
        list.add(4);
        list.add(5);
        list.add(6);
        //add boolean
        list.add(true);
        list.add(false);
        list.add(true);
        list.add(false);

        return list.toString();
    }

    /**
     * This method tests the Reverse method when 1000 elements are added
     */
    public void testReverse1000(){
        for (int i = 0; i <= 1000; i++) {
            list.add("Number: " + i);
        }
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }

    /**
     * @return size of list
     */
    public int testSize(){
        return list.size();
    }

    /**
     * @return returns a ReversibleStack reversed
     */
    public ReversibleStackLL<Object> testReverse(){
        list.reverse();
        return list;
    }

    /**
     * This method tests if NoSuchElementException is called
     */
    public void testExceptions(){
        testAdd();
        list.clear();
        list.remove();
    }


    @Override
    public String toString() {
        return "MyTests{" +
                "list=" + list +
                '}';
    }
}
