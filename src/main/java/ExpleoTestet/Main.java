package ExpleoTestet;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("For AnagramFinder press 1\n" +
                "For Linkfinder press 2\nFor calculator press 3\n");

        Scanner scan = new Scanner(System.in);
        int choice = Integer.parseInt(scan.next());
        if (choice==1 ){
            AnagramFinder af = new AnagramFinder();
            System.out.println("Welcome to AnagramFinder!");
            System.out.println("Please enter your first string");
            String compare1 = scan.next();
            System.out.println("Please enter your second string");
            String compare2 = scan.next();
            System.out.println("Are these strings anagrams of each other: "+af.findAnagram(compare1,compare2));
        }
        if (choice==2 ){
            LinkFinder lf = new LinkFinder();
            System.out.println("Welcome to LinkFinder");
            System.out.println("Please enter a URL for the webpage that you want ALL the links from:");
            lf.findLinks(scan.next());
        }
        if (choice==3 ){
            Calculator c1 = new Calculator();
            System.out.println("Welcome to calculator!\nPlease chose level (1-3)" );
            int calcChoice = Integer.parseInt(scan.next());
            if (calcChoice==1){
                System.out.println("Calculator Lvl1!");
                System.out.println("Please enter 'Mathematical'-string");
                System.out.println(c1.calculatorLvl1(scan.next()));
            }
            if (calcChoice==2){
                System.out.println("Calculator Lvl2!");
                System.out.println("Please enter 'Mathematical'-string");
                System.out.println(c1.calculatorLvl2(scan.next()));
            }
            if (calcChoice==3){
                System.out.println("Calculator Lvl3!");
                System.out.println("Please enter 'Mathematical'-string");
                System.out.println(c1.calculatorLvl3(scan.next()));
            }
        }

    }
}
