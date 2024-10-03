package _02_LongChipCompetition;

import java.util.ArrayList;
import java.util.Random;

public class LongChipCompetition {
    /*
     * The Beatles are eating lunch and playing a game to see who has the
     * longest chip. (In England, french fries are called "chips".)
     * Find the Beatle with the longest chip. You may not edit the Chip or
     * Beatle classes. Make sure to initialize The Beatles before you start
     * your search.
     */
    private static ArrayList<Beatle> theBeatles = new ArrayList<Beatle>();

    public static void main(String[] args) {
        LongChipCompetition lcc = new LongChipCompetition();
        lcc.initializeBeatles();
        
        ArrayList <Integer> eachBeetlesLongTater = new ArrayList <Integer> ();
        
       System.out.println(findLongestBeatle(theBeatles).getName());
    }
    
    public static Beatle findLongestBeatle (ArrayList <Beatle> beatles) {
    	
    
    	double longestChip = 0;
    	int longestChipPosition = 0;
    	
    	 for (int x = 0; x < theBeatles.size(); x++) {
         	if (findLongestChip(theBeatles.get(x).getChips()) > longestChip) {
         		longestChip = findLongestChip(theBeatles.get(x).getChips());
         		longestChipPosition = x;
         	}
         	
         }
    	 System.out.println(longestChip);
    	 System.out.println(longestChipPosition);
    	 System.out.println(theBeatles.get(longestChipPosition).getName());
    	 
    	 return theBeatles.get(longestChipPosition);
    }
    public static double findLongestChip (ArrayList <Chip> chips) {
    	double largestChip = 0;
    	for (int x = 0; x<chips.size(); x++) {
    		if (chips.get(x).getLength()>largestChip) {
    			largestChip = chips.get(x).getLength();
    		}
    	}
    	return largestChip;
    }
    
    private void initializeBeatles() {
        Beatle george = new Beatle("George");
        Beatle john = new Beatle("John");
        Beatle paul = new Beatle("Paul");
        Beatle ringo = new Beatle("Ringo");
        theBeatles.add(george);
        theBeatles.add(john);
        theBeatles.add(paul);
        theBeatles.add(ringo);
    }

    public ArrayList<Beatle> getTheBand(){
        return theBeatles;
    }
}

class Beatle {
    private String name;
    private ArrayList<Chip> chips = new ArrayList<Chip>();

    public Beatle(String name) {
        this.name = name;
        initializePlateOfChips();
    }

    private void initializePlateOfChips() {
        int numberOfChips = new Random().nextInt(100);
        for (int i = 0; i < numberOfChips; i++) {
            chips.add(new Chip(new Random().nextDouble() * 10));
        }
    }

    public ArrayList<Chip> getChips() {
        return this.chips;
    }

    public String getName() {
        return this.name;
    }
}

class Chip {
    private double length;

    public double getLength() {
        return length;
    }

    Chip(double d) {
        this.length = d;
    }
}
