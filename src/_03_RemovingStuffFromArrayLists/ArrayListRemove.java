package _03_RemovingStuffFromArrayLists;

import java.util.ArrayList;

public class ArrayListRemove {

	class Stuff {
		public String type;
	}

	class Worm extends Stuff {
		public Worm() {
			type = "worm";
		}
	}

	class Dirt extends Stuff {
		public Dirt() {
			type = "dirt";
		}
	}

	// 1. Write a method that removes the dirt in the yard and returns the
	// ArrayList
	public static ArrayList<Stuff> cleanOutTheYard( ArrayList<Stuff> yard ) {
        
    	for (int x = 0; x < yard.size(); x++ ) {
    		if (yard.get(x).type.equals("dirt")) {
    			yard.remove(x);
    			x--;
    		}
    	}
    	
    	for (Stuff s: yard) {
    	System.out.println(s.type);
    	}
    	
    	System.out.println(yard.size());
        return yard;
    }

	// 2. Write a method that removes the hash tag ('#') characters from the
	// ArrayList and returns it
	public static ArrayList<Character> removeHashTags(ArrayList<Character> list) {

		for (int x = 0; x < list.size(); x++) {
			if (list.get(x) == '#') {
				list.remove(x);
				x--;
			}
		}
		
		for (Character s: list) {
	    	System.out.println(s);
	    	}
	    	
	    	System.out.println(list.size());

		return list;
	}
}
