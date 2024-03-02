import java.time.LocalDate;

public class Tree extends Plant{
    // Discussing with partner soon.
    public Tree(String genusSpecies, String commonName, LocalDate introDate, PlantGroup group){
        super(genusSpecies, commonName, introDate, group);
    }
    public static enum growSpeed{
        fast,
        slow;
    }
    //TODO: FILL OUT CLASS
}