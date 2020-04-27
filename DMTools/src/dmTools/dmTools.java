package dmTools;

import java.util.ArrayList;
import java.util.Scanner;

import dmTools.managers.menuManager;
import dmTools.managers.saveManager;

public class dmTools {
    static String[] playerList;
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        String welcome = "Welcome to the Dungeons and Dragons DMs Tool! \n This tool was made for managing characters, fights, and the rolls that each character makes. \n you will be asked a series of questions in order for the tool to work effectively.  All of the information can be found on your character sheet.";
        System.out.print("Create\nLoad\nExit\n");
        System.out.print("What do you choose:");
        String startMenu = keyboard.nextLine();
        switch(startMenu) {
            case "Create":
                //Player Count
                System.out.println(welcome);
                System.out.print("How many characters are in the campaign: ");
                String playernum = keyboard.nextLine();

                int numOfPlayers = Integer.parseInt(playernum);

                playerList = new String[numOfPlayers];

                //Player Names
                for (int i = 0; i < numOfPlayers; i++) {
                    System.out.print("What is player " + (i+1) + "\'s name: ");
                    String playerName = keyboard.nextLine();

                    playerList[i] = playerName;
                }

                ArrayList<Player> players = new ArrayList<Player>();

                for (int i = 0; i < playerList.length; i++) {
                    players.add(new Player(playerList[i]));
                }

                menuManager mm = new menuManager(players, playerList);
                mm.menu();
            case "Load":
                saveManager sm = new saveManager();
                sm.loadFiles();
            case "Exit":
                return;
        }
    }

    public static void Loading(String[] playerNames, ArrayList<int[]> statsList, ArrayList<String[]> crs) {
        ArrayList<Player> players = new ArrayList<Player>();

        for (int i = 0; i < playerNames.length; i++) {
            int[] stats = statsList.get(i);
            String[] ClassRace = crs.get(i);
            players.add(new Player(playerNames[i], stats, ClassRace));
        }
        menuManager mm = new menuManager(players, playerNames);
        mm.menu();
    }
}