package dmTools;

import java.util.Scanner;

public class Player {
    Scanner keyboard = new Scanner(System.in);
    String player;
    String race = null;
    String profession = null;
    static int[] stats = new int[6];

    public Player(String playername) {
        player = playername;

        makeStats();
    }

    public Player(String playername, int[] lStats) {
        stats = lStats;
        player = playername;
    }

    public Player(String playername, int[] lStats, String[] crs) {
        stats = lStats;
        player = playername;
        race = crs[0];
        profession = crs[1];
    }

    public void setRace(String raceSel) {
        race = raceSel;
    }

    public void setClass(String classSel) {
        profession = classSel;
    }

    private void makeStats() {
        System.out.print("What is " + player + "\'s Strength Stat: ");
        stats[0] = keyboard.nextInt();
        System.out.print("What is " + player + "\'s Dexterity Stat: ");
        stats[1] = keyboard.nextInt();
        System.out.print("What is " + player + "\'s Constitution Stat: ");
        stats[2] = keyboard.nextInt();
        System.out.print("What is " + player + "\'s Intelligence Stat: ");
        stats[3] = keyboard.nextInt();
        System.out.print("What is " + player + "\'s Wisdom Stat: ");
        stats[4] = keyboard.nextInt();
        System.out.print("What is " + player + "\'s Charisma Stat: ");
        stats[5] = keyboard.nextInt();
    }

    public void setStat() {
        System.out.print("Which stat would you like to change (Use the all caps abbreviation eg: STR, DEX, etc.):");
        String statOption = keyboard.nextLine();

        switch(statOption) {
            case "STR":
                System.out.print("What is the new STR stat of " + player + ".");
                stats[0] = keyboard.nextInt();
                break;
            case "DEX":
                System.out.print("What is the new STR stat of " + player + ".");
                stats[0] = keyboard.nextInt();
                break;
            case "CON":
                System.out.print("What is the new STR stat of " + player + ".");
                stats[0] = keyboard.nextInt();
                break;
            case "INT":
                System.out.print("What is the new STR stat of " + player + ".");
                stats[0] = keyboard.nextInt();
                break;
            case "WIS":
                System.out.print("What is the new STR stat of " + player + ".");
                stats[0] = keyboard.nextInt();
                break;
            case "CHA":
                System.out.print("What is the new STR stat of " + player + ".");
                stats[0] = keyboard.nextInt();
                break;
            default:
                System.out.println("Stat not found or abbreviation typed incorectlly.");
                break;
        }
    }

    public String[] returnClassRace() {
        String[] cr = new String[2];

        cr[0] = race;
        cr[1] = profession;

        return cr;
    }

    public int[] getStats() {
        int[] statReturn = stats;

        return statReturn;
    }

    public void stats() {
        System.out.println("Player: " + player);
        System.out.println("Race: " + race);
        System.out.println("Class: " + profession);
        System.out.println("STR \t DEX \t CON");
        System.out.println(" " + stats[0] + "  \t  " + stats[1] + "  \t  " + stats[2]);
        System.out.println("INT \t WIS \t CHA");
        System.out.println(" " + stats[3] + "  \t  " + stats[4] + "  \t  " + stats[5]);
    }
}