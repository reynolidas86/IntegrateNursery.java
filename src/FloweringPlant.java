import java.time.LocalDate;

public class FloweringPlant extends Plant{
    private String color;
    private String features;
    
    public FloweringPlant(String genusSpecies, String commonName, LocalDate introDate, PlantGroup plantGroup, String color, String features){
        super(genusSpecies, commonName, introDate, plantGroup);
        this.color = color;
        this.features = features;
    }

    public String getFeatures(){
        return features;
    }

    public String getColor(){
        return color;
    }
}