import java.time.LocalDate;

public class Tree extends Plant{
    public Tree(String genusSpecies, String commonName, LocalDate introDate, PlantGroup plantGroup){
        super(genusSpecies, commonName, introDate, plantGroup);
    }
    public static enum growSpeed{
        fast,
        slow;
    }
    //TODO: FILL OUT CLASS
}