
public class State {
    // State Components
    protected int depth; // depth level of this state
    protected int idState; // id of this state
    protected int parent; // parent's id of this state
    protected int[][] state = new int[3][3]; // shape of this state

    // CONSTRUCTOR
    public State(int depth, int idState, int parent, int[][] state) {
        this.depth = depth;
        this.idState = idState;
        this.parent = parent;
        this.state = state;
    }
    
    // GETTER SETTER
    public int getDepth() {
        return this.depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getParent() {
        return this.parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int[][] getState() {
        return this.state;
    }

    public void setState(int[][] state) {
        this.state = state;
    }
    public int getIdState() {
        return this.idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }
}


