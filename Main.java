import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        ReadFile reader = new ReadFile();
        reader.loadInputs("start","goal");

        /*
            BFS Algorithm with open and closed list/queue
            1.	Begin
            2.	Open = [start];
            3.	Closed =[];
            4.	While open != [] do
            5.	Begin
            6.	Remove leftmost state from open call it x;
            7.	If x is a goal then return success
            8.	Else
            9.	Begin
            10.	Generate children of x;
            11.	Put x on closed;
            12.	Put children on right end of open;
            13.	End
            14.	End
            15.	Return(failure)
            16.	End
        */

        // Initialize Component
        Queue<State> openList = new LinkedList<State>();
        Queue<State> closedList = new LinkedList<State>();
        
        int depth=1,idState=1;
        int[][] currentState = new int[3][3];
        int[][] goalState = reader.getGoalState();

        // Insert start state to Open
        openList.add(new State(depth, idState ,0, reader.getStartState()));

        // Main program
        while(!openList.isEmpty()){
            currentState = openList.peek().getState();
            int currentId = openList.peek().getIdState();
            int parentId = openList.peek().getParent();

            // Remove leftmost state from open call it x
            State xState = openList.remove();

            System.out.println("CURRENT STATE : "+currentId+" CHILD OF : "+parentId);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(currentState[i][j]+" ");
                }
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(goalState[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("---------------------");

            if(Arrays.deepEquals(currentState, goalState)){
                // Check if current state is the solution
                System.out.println("Solution Found!");
                break;
            }
            else{
                // Expand to search the child of current state (blank move up,down,left,right)
                depth++;

                // Get blank postion 
                int yPos=0,xPos=0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if(currentState[i][j] == 0){
                            yPos = i;
                            xPos = j;
                            break;
                        }
                    }
                }
                
                // Move left
                if(xPos!=0){
                    int[][] newState = new int[3][3];
                    boolean recurring = false;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            newState[i][j] = currentState[i][j];
                        }
                    }
                    idState++;

                    int temp = newState[yPos][xPos-1];
                    newState[yPos][xPos-1] = newState[yPos][xPos];
                    newState[yPos][xPos] = temp;
                    
                    // Put x on closed
                    if(!closedList.contains(xState)){
                        closedList.add(xState);
                    }
                    // check if recurring
                    for(State closedState : closedList) {
                        if(Arrays.deepEquals(newState, closedState.state)){
                            recurring = true;
                            break;
                        }
                    }
                    // Put children on right end of open
                    if(!recurring){
                        openList.add(new State(depth, idState ,xState.getIdState(), newState));
                    }
                }

                // Move right
                if(xPos!=2){
                    int[][] newState = new int[3][3];
                    boolean recurring = false;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            newState[i][j] = currentState[i][j];
                        }
                    }
                    idState++;

                    int temp = newState[yPos][xPos+1];
                    newState[yPos][xPos+1] = newState[yPos][xPos];
                    newState[yPos][xPos] = temp;
                    
                    // Put x on closed
                    if(!closedList.contains(xState)){
                        closedList.add(xState);
                    }

                    // check if recurring
                    for(State closedState : closedList) {
                        if(Arrays.deepEquals(newState, closedState.state)){
                            recurring = true;
                            break;
                        }
                    }
                    // Put children on right end of open
                    if(!recurring){
                        openList.add(new State(depth, idState ,xState.getIdState(), newState));
                    }
                }
                               
                // Move up
                if(yPos!=0){
                    int[][] newState = new int[3][3];
                    boolean recurring = false;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            newState[i][j] = currentState[i][j];
                        }
                    }
                    idState++;

                    int temp = newState[yPos-1][xPos];
                    newState[yPos-1][xPos] = newState[yPos][xPos];
                    newState[yPos][xPos] = temp;
                    
                    // Put x on closed
                    if(!closedList.contains(xState)){
                        closedList.add(xState);
                    }
                    // check if recurring
                    for(State closedState : closedList) {
                        if(Arrays.deepEquals(newState, closedState.state)){
                            recurring = true;
                            break;
                        }
                    }
                    // Put children on right end of open
                    if(!recurring){
                        openList.add(new State(depth, idState ,xState.getIdState(), newState));
                    }
                }
                
                // Move down
                if(yPos!=2){
                    int[][] newState = new int[3][3];
                    boolean recurring = false;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            newState[i][j] = currentState[i][j];
                        }
                    }
                    idState++;

                    int temp = newState[yPos+1][xPos];
                    newState[yPos+1][xPos] = newState[yPos][xPos];
                    newState[yPos][xPos] = temp;
                    
                    // Put x on closed
                    if(!closedList.contains(xState)){
                        closedList.add(xState);
                    }

                    // check if recurring
                    for(State closedState : closedList) {
                        if(Arrays.deepEquals(newState, closedState.state)){
                            recurring = true;
                            break;
                        }
                    }
                    // Put children on right end of open
                    if(!recurring){
                        openList.add(new State(depth, idState ,xState.getIdState(), newState));
                    }
                }
            
            }

        }
    }
}