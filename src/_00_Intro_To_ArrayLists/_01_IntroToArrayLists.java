package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
    public static void main(String[] args) {
        // 1. Create an array list of Strings
        //    Don't forget to import the ArrayList class
    	ArrayList <String> list = new ArrayList<String> () ;
        // 2. Add five Strings to your list
    	list.add("ball");
    	list.add("cube");
    	list.add("prism");
    	list.add("pyramid");
    	list.add("cylinder");
        // 3. Print all the Strings using a standard for-loop
    	for (int x =0; x < list.size(); x++) {
    		System.out.print(list.get(x)  + " ");
    	}
        // 4. Print all the Strings using a for-each loop
System.out.println();

    	for (String s: list) {
    		System.out.print(s + " ");
    	}
    	
System.out.println();
    	
        // 5. Print only the even numbered elements in the list.
    	for (int x =0; x < list.size(); x++) {
    		if (x % 2 ==0) 
    		System.out.print(list.get(x) + " ");
    	}

System.out.println();

        // 6. Print all the Strings in reverse order.
    	for (int x = list.size() - 1; x >= 0 ; x--) {
    		System.out.print(list.get(x) + " ");
    	}
    	
System.out.println();

        // 7. Print only the Strings that have the letter 'e' in them.
    	for (int x =0; x < list.size(); x++) {
    		if (list.get(x).indexOf("e") != -1) {
    			System.out.print(list.get(x) + " ");
    		}
    	}
    }
}
