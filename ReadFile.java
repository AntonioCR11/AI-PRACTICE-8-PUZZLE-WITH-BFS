import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadFile {
    // RETURN GOAL STATE KE MAIN
    protected int[][] goalState = new int[3][3];

    // LOAD INPUT DATA
    public void loadInputs(String filename) throws FileNotFoundException{
        String path = "./"+filename+".txt";
        File file = new File(path);
        Scanner sc = new Scanner(file);

        ArrayList<String> inputs = new ArrayList<>();

        while (sc.hasNextLine()){
            inputs.add(sc.nextLine());
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                goalState[i][j] = Integer.parseInt(inputs.get(i).substring(j, j+1));
            }
        }
    }

    // GETTER SETTER
    public int[][] getGoalState() {
        return this.goalState;
    }

    public void setGoalState(int[][] goalState) {
        this.goalState = goalState;
    }

}
