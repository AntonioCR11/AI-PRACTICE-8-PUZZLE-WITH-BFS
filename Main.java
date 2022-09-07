import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        
        ReadFile reader = new ReadFile();
        reader.loadInputs("input");
        int[][] goalState = new int[3][3];

        goalState = reader.getGoalState();

        // CONTOH QUEUE
        Queue<Integer> q = new LinkedList<>();
  
        for (int i = 0; i < 5; i++)
            q.add(i);
  
        // Display contents of the queue.
        System.out.println("Elements of queue "+ q);
  
        // To remove the head of queue.
        int removedele = q.remove();
        System.out.println("removed element-"+ removedele);
  
        System.out.println(q);
  
        // To view the head of queue
        int head = q.peek();
        System.out.println("head of queue-"+ head);
  
        // Rest all methods of collection
        // interface like size and contains
        // can be used with this
        // implementation.
        int size = q.size();
        System.out.println("Size of queue-"+ size);
    }
}