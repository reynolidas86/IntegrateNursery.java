import java.time.LocalDate;

public class Tree extends Plant{
    private final GrowthSpeed speed;
    public Tree(String genusSpecies, String commonName, LocalDate introDate, PlantGroup plantGroup, GrowthSpeed speed){
        super(genusSpecies, commonName, introDate, plantGroup);
        this.speed = speed;
    }

    public GrowthSpeed getGrowthSpeed(){
        return speed;
    }
}