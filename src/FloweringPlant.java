import java.time.LocalDate;

public class FloweringPlant extends Plant{
    //TODO: Verify this should be a 'String' and not a different type
    private String color;
    //TODO: Verify this type
    private String[] features;

    public FloweringPlant(String genusSpecies, String commonName, LocalDate introDate, PlantGroup plantGroup){
        super(genusSpecies, commonName, introDate, plantGroup);
    }

    public String[] getFeatures(){
        return features;
    }

    public String getColor(){
        return color;
    }
}