import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadFile {
    // RETURN GOAL STATE KE MAIN
    protected int[][] startState = new int[3][3];
    protected int[][] goalState = new int[3][3];

    // LOAD INPUT DATA
    public void loadInputs(String start_filename,String goal_filename) throws FileNotFoundException{
        String start_path = "./"+start_filename+".txt";
        File start_file = new File(start_path);
        Scanner start_scanner = new Scanner(start_file);

        String goal_path = "./"+goal_filename+".txt";
        File goal_file = new File(goal_path);
        Scanner goal_scanner = new Scanner(goal_file);

        ArrayList<String> start_inputs = new ArrayList<>();
        ArrayList<String> goal_inputs = new ArrayList<>();

        while (start_scanner.hasNextLine()){
            start_inputs.add(start_scanner.nextLine());
        }
        while (goal_scanner.hasNextLine()){
            goal_inputs.add(goal_scanner.nextLine());
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                startState[i][j] = Integer.parseInt(start_inputs.get(i).substring(j, j+1));
                goalState[i][j] = Integer.parseInt(goal_inputs.get(i).substring(j, j+1));
            }
        }
    }

    public void printStates(){
        System.out.println("-----------------");
        System.out.println("| START |  GOAL |");
        System.out.println("-----------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(startState[i][j]+" ");
            }
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(goalState[i][j]+" ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------");
    }
    
    // GETTER SETTER
    public int[][] getStartState() {
        return this.startState;
    }

    public void setStartState(int[][] startState) {
        this.startState = startState;
    }

    public int[][] getGoalState() {
        return this.goalState;
    }

    public void setGoalState(int[][] goalState) {
        this.goalState = goalState;
    }

}
