package dmTools.managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import dmTools.Player;

public class menuManager {
    Scanner keyboard = new Scanner(System.in);
    saveManager saves = new saveManager();
    private static ArrayList<Player> players;
    private static String[] playerNames;

    public menuManager(ArrayList<Player> playerList, String[] playernames) {

        players = playerList;
        playerNames = playernames;
    }

    public static ArrayList<int[]> returnStats() {
        ArrayList<int[]> stats = new ArrayList<int[]>();

        for (int i = 0; i < playerNames.length; i++) {
            stats.add(i, players.get(i).getStats());
        }

        return stats;
    }

    public static ArrayList<String[]> returnExtra() {
        ArrayList<String[]> crs = new ArrayList<String[]>();

        for (int i = 0; i < playerNames.length; i++) {
            crs.add(i, players.get(i).returnClassRace());
        }

        return crs;
    }

    public static int findIndex(String arr[], String input) 
    { 
        // if array is Null 
        if (arr == null) { 
            return -1; 
        } 
  
        // find length of array 
        int len = arr.length; 
        int i = 0; 
  
        // traverse in the array 
        while (i < len) { 
  
            // if the i-th element is t 
            // then return the index 
            if (arr[i].equals(input)) { 
                return i; 
            } 
            else { 
                i = i + 1; 
            } 
        } 
        return -1; 
    }

    public void menu() {

        System.out.print("What would you like to do: ");
        String menuOptions = keyboard.nextLine();
        ArrayList<String> playerListEditor = new ArrayList<String>(Arrays.asList(playerNames));

        int index;
        String player;

        saveManager saver = new saveManager();

        switch(menuOptions) {
            case "end":
                System.out.print("Did you save the game (y/n): ");
                if (keyboard.nextLine().equals("y")) {
                    return;
                } else {
                    break;
                }
            case "getcharacterlist":
                System.out.println(Arrays.toString(playerNames));
                break;
            case "selectrace":
                System.out.print("Which character: ");
                player = keyboard.nextLine();

                index = findIndex(playerNames, player);

                if (index == -1) {
                    System.out.println("//NOT FOUND \\\\");
                    break;
                }

                System.out.print("Which race: ");
                players.get(index).setRace(keyboard.nextLine());
                break;
            case "selectclass":
                System.out.print("Which character: ");
                player = keyboard.nextLine();

                index = findIndex(playerNames, player);

                if (index == -1) {
                    System.out.println("//NOT FOUND \\\\");
                    break;
                }

                System.out.print("Which class: ");
                players.get(index).setClass(keyboard.nextLine());
                break;
            case "getcharacter":
                System.out.print("Which character: ");
                player = keyboard.nextLine();

                index = findIndex(playerNames, player);

                if (index == -1) {
                    System.out.println("//NOT FOUND \\\\");
                    break;
                }

                players.get(index).stats();
                break;
            case "makecharacter":
                System.out.print("What is player " + (playerNames.length+1) + "\'s name: ");
                player = keyboard.nextLine();

                players.add(new Player(player));

                playerListEditor.add(player);

                playerNames = playerListEditor.toArray(playerNames);
                break;
            case "kill":
                System.out.print("Which character: ");
                player = keyboard.nextLine();

                System.out.print("Are you sure you want to kill " + player + "? (y/n): ");
                if (keyboard.nextLine().equals("y")) {
                    index = findIndex(playerNames, player);
                    players.remove(index);
                    
                    playerListEditor.removeAll(Arrays.asList(player));
                    playerNames = playerListEditor.toArray(playerNames);
                    String[] tempArrayNames = new String[playerNames.length-1];
                    for (int i = 0; i < tempArrayNames.length; i++) {
                        tempArrayNames[i] = playerNames[i];
                    }
                    playerNames = tempArrayNames;
                }
                break;
            case "save":
                saver.saveFiles(playerNames);

                System.out.println("Saved!");
                break;
            case "setstat":
                System.out.print("Which character: ");
                player = keyboard.nextLine();

                index = findIndex(playerNames, player);

                if (index == -1) {
                    System.out.println("//NOT FOUND \\\\");
                    break;
                }

                players.get(index).setStat();
                break;
            default:
                System.out.println("Command List:");
                System.out.println("help - Generate this command list.");
                System.out.println("selectrace - Allows you to select the race of the chosen character.");
                System.out.println("selectclass - Allows you to select the class of the chosen character.");
                System.out.println("getcharacter - Get all the information on the character loaded into DMTools.");
                System.out.println("getcharacterlist - Lists the name of every character loaded into DMTools at the current moment.");
                System.out.println("makecharacter - This creates a new character that will become a part of the campaign.");
                System.out.println("kill - This command will remove all data of a chosen character from DMTools.  There will be a dialog to make sure you want to do this.");
                System.out.println("save - Export a .csv to save the data of this campaign.");
                System.out.println("end - Exit DMTools");
                System.out.println("If you want to load a new file, you'll have to exit Tools and Open them again.");
        }
        menu();
    }
}