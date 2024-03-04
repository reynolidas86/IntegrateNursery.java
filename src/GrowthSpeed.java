/**
 * Represents the different speeds at which {@link Tree} plants can grow.
 */
public enum GrowthSpeed {
    FAST("fast"),
    SLOW("slow");

    private final String asString;
    private GrowthSpeed(String s){
        asString = s;
    }

    /**
     * @return A String representation of the GrowthSpeed
     */
    public String toString(){
        return asString;
    }
}
