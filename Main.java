import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main{

    public static void main(String[] args) throws FileNotFoundException {
        ReadFile reader = new ReadFile();

        String[] color = {"\u001b[31m","\u001b[32m","\u001b[34m","\u001b[35m"};
        String reset = "\u001b[0m";    

        reader.loadInputs("start","goal");
        reader.printStates();

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
        ArrayList<State> answer = new ArrayList<>();

        int idState=1;
        String currentState = "";
        String goalState = reader.getGoalState();
        
        // Insert start state to Open
        openList.add(new State(idState ,0, reader.getStartState()));

        // Main program
        while(!openList.isEmpty()){
            currentState = openList.peek().getState();

            // Remove leftmost state from open call it x
            State xState = openList.remove();

            // Check if current state is the solution
            if(currentState.equalsIgnoreCase(goalState)){
                // Search parent history
                int currentParent = xState.parent;
                answer.add(xState);
                while(currentParent != 0){
                    for(State closedState : closedList) {
                        if(closedState.idState == currentParent){
                            answer.add(closedState);
                            currentParent = closedState.parent;
                            break;
                        }
                    }
                }
                // Print Solution
                for (int i = answer.size()-1; i >= 0; i--) {
                    for (int j = 0; j < 3; j++) {
                        System.out.print("| ");
                        for (int k = 0; k < 3; k++) {
                            if(answer.get(i).getState().substring(3*j+k, (3*j+k)+1).equalsIgnoreCase("0")){
                                System.out.print(color[2]);
                                System.out.print(answer.get(i).getState().substring(3*j+k, (3*j+k)+1)+" ");
                                System.out.print(reset); 
                            }else{System.out.print(answer.get(i).getState().substring(3*j+k, (3*j+k)+1)+" ");}
                        }
                        System.out.print("| ");
                        for (int k = 0; k < 3; k++) {
                            System.out.print(goalState.substring(3*j+k, (3*j+k)+1)+" ");
                        }
                        System.out.println("|");
                    }
                    System.out.println("-----------------");
                }
                
                System.out.println("Solution Found!");
                break;
            }
            else{
                // If the solution not yet found
                // Expand to search the child of current state (blank move up,down,left,right)

                // Get blank postion 
                int blankPos = currentState.indexOf('0');
                
                // Move left
                if(blankPos != 0 && blankPos != 3 && blankPos != 6){
                    // if blank position is not on the leftmost column
                    String newState = currentState;
                    boolean recurring = false;
                    idState++;

                    // Swap blank
                    newState = currentState.substring(0,blankPos-1)+"0"+currentState.charAt(blankPos-1)+currentState.substring(blankPos+1);
                    
                    // Check recurring
                    for(State closedState : closedList) {
                        if(newState.equalsIgnoreCase(closedState.state)){
                            recurring = true;
                            break;
                        }
                    }
                    // Put x on closed                    
                    // Put children on right end of open
                    if(!recurring){
                        closedList.add(xState);
                        openList.add(new State(idState ,xState.getIdState(), newState));
                    }
                }

                // Move right
                if(blankPos != 2 && blankPos != 5 && blankPos != 8){
                    // if blank position is not on the leftmost column
                    String newState = currentState;
                    boolean recurring = false;
                    idState++;

                    // Swap blank
                    newState = currentState.substring(0,blankPos)+currentState.charAt(blankPos+1)+"0"+currentState.substring(blankPos+2);
                    
                    // Check recurring
                    for(State closedState : closedList) {
                        if(newState.equalsIgnoreCase(closedState.state)){
                            recurring = true;
                            break;
                        }
                    }
                    // Put x on closed                    
                    // Put children on right end of open
                    if(!recurring){
                        closedList.add(xState);
                        openList.add(new State(idState ,xState.getIdState(), newState));
                    }
                }
                               
                // Move up
                if(blankPos != 0 && blankPos != 1 && blankPos != 2){
                    // if blank position is not on the leftmost column
                    String newState = currentState;
                    boolean recurring = false;
                    idState++;

                    // Swap blank
                    newState = currentState.substring(0,blankPos-3)+"0"+currentState.substring(blankPos-2,blankPos)+currentState.charAt(blankPos-3)+currentState.substring(blankPos+1);
                    
                    // Check recurring                 
                    for(State closedState : closedList) {
                        if(newState.equalsIgnoreCase(closedState.state)){
                            recurring = true;
                            break;
                        }
                    }

                    // Put x on closed   
                    // Put children on right end of open
                    if(!recurring){
                        closedList.add(xState);
                        openList.add(new State(idState ,xState.getIdState(), newState));
                    }
                }
                
                // Move down
                if(blankPos != 6 && blankPos != 7 && blankPos != 8){
                    // if blank position is not on the leftmost column
                    String newState = currentState;
                    boolean recurring = false;
                    idState++;

                    // Swap blank
                    newState = currentState.substring(0,blankPos)+currentState.substring(blankPos+3,blankPos+4)+currentState.substring(blankPos+1,blankPos+3)+"0"+currentState.substring(blankPos+4);
                    
                    // Check recurring
                    for(State closedState : closedList) {
                        if(newState.equalsIgnoreCase(closedState.state)){
                            recurring = true;
                            break;
                        }
                    }
                    // Put x on closed                    
                    // Put children on right end of open
                    if(!recurring){
                        closedList.add(xState);
                        openList.add(new State(idState ,xState.getIdState(), newState));
                    }
                }
            
            }

        }
    }
}