package dmTools.managers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class saveManager {
    private ArrayList<int[]> stats;
    private ArrayList<String[]> ClassRaces;

    public void saveFiles(String[] playerNames) {
        File csvOutputFile = new File("save.csv");
        stats = menuManager.returnStats();
        ClassRaces = menuManager.returnExtra();
        
        try {
            FileWriter csvWriter = new FileWriter(csvOutputFile);

            csvWriter.append("Name,STR,DEX,CON,INT,WIS,CHA,Class,Race");
            csvWriter.append("\n");

            for (int i = 0; i < playerNames.length; i++) {
                csvWriter.append(playerNames[i] + ",");
                for (int j = 0; j < stats.get(i).length; j++) {
                    csvWriter.append("" + stats.get(i)[j] + ",");
                }
                for (int j = 0; j < ClassRaces.get(i).length; j++) {
                    csvWriter.append(ClassRaces.get(i)[j] + ",");
                }
                csvWriter.append("\n");
            }

            csvWriter.close();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFiles() {
        
    }

    /*public static void saveFiles(String[] playerNames) {
        FileOutputStream saveFile;
        stats = menuManager.returnStats();
        ClassRaces = menuManager.returnExtra();
        try {
            saveFile = new FileOutputStream("saveFile.txt");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);

            save.writeObject(playerNames);
            save.writeObject(stats);
            save.writeObject(ClassRaces);

            save.close();
        } catch (Exception exc) {
            exc.printStackTrace(); // If there was an error, print the info.
        }
    }

    public static void loadFiles() {
        FileInputStream saveFile;

        try {
            saveFile = new FileInputStream("saveFile.txt");
            ObjectInputStream save = new ObjectInputStream(saveFile);

            playerNames = (String[]) save.readObject();
            stats = (ArrayList<int[]>) save.readObject();
            ClassRaces = (ArrayList<String[]>) save.readObject();

            save.close();

            dmTools.Loading(playerNames, stats, ClassRaces);
        } catch(Exception exc) {
            exc.printStackTrace();
        }
    }*/
}