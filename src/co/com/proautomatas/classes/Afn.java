package co.com.proautomatas.classes;

/**
 *
 * @author mazapatafr
 */
public class Afn {
    
    private String nextState;
    private String initialSate;
    
    /**
     * @return the nextState
     */
    public String getNextState() {
        return nextState;
    }
    
    /**
     * @param nextState the nextState to set
     */
    public void setNextState(String nextState) {
        this.nextState = nextState;
    }
    
    /**
     * @return the initialSate
     */
    public String getInitialSate() {
        return initialSate;
    }
    
    /**
     * @param initialSate the initialSate to set
     */
    public void setInitialSate(String initialSate) {
        this.initialSate = initialSate;
    }
    
    @Override
    public String toString() {
        return "Afn{" + "nextState=" + nextState + ", initialSate=" + initialSate + '}';
    }
}
