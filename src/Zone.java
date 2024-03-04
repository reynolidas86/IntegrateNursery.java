import java.util.HashMap;

/**
 * Represents a zone as defined by the 
 * <a href="https://arboretum.harvard.edu/stories/mapping-an-indeterminable-quantity/">Arnold Arboretum map</a>.
 * <p>New zones cannot be created and instead users should access the preconstructed zones contained in the static HashMap
 * {@code zones}.
 */
public class Zone {
    public static final HashMap<Integer, Zone> zones;
    static{
        zones = new HashMap<Integer, Zone>();
        zones.put(1, new Zone(Double.NEGATIVE_INFINITY, -50.0));
        zones.put(2, new Zone(-50.0, -40.0));
        zones.put(3, new Zone(-40.0, -30.0));
        zones.put(4, new Zone(-30.0, -20.0));
        zones.put(5, new Zone(-20.0, -10.0));
        zones.put(6, new Zone(-10.0, 0.0));
        zones.put(7, new Zone(0.0, 10.0));
        zones.put(8, new Zone(10.0, 20.0));
        zones.put(9, new Zone(20.0, 30.0));
        zones.put(10, new Zone(30.0, 40.0));
        zones.put(11, new Zone(40.0, 50.0));
    }

    private final double maxTemperature;
    private final double minTemperature;

    private Zone(double min, double max){
        maxTemperature = max;
        minTemperature = min;
    }
    /**
     * Returns the value of the maximum temperature for the zone.
     * 
     * @return              The maximum temperature from the designated zone.
     */
    public double getMaxTemperature(){
        return maxTemperature;
    }
    
    /**
     * Returns the value of the minimum temperature for the zone.
     * 
     * @return              The minimum temperature from the designated zone.
     */
    public double getMinTemperature(){
        return minTemperature;
    }

        /**
     * Returns the Set of Zones available for use of plants.
     * 
     * @return              The zones for the use of all plants.
     */
    public HashMap<Integer, Zone> getZones(){
        return zones;
    }
}