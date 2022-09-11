
public class State {
    // State Components
    protected int idState; // id of this state
    protected int parent; // parent's id of this state
    protected String state = ""; // shape of this state

    // CONSTRUCTOR
    public State(int idState, int parent, String state) {
        this.idState = idState;
        this.parent = parent;
        this.state = state;
    }
    
    // GETTER SETTER

    public int getParent() {
        return this.parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }


    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIdState() {
        return this.idState;
    }

    public void setIdState(int idState) {
        this.idState = idState;
    }
}


