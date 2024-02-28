public class FloweringPlant extends Plant{
    //TODO: Verify this should be a 'String' and not a different type
    private final String color;
    //TODO: Verify this type
    private final String[] features;

    public FloweringPlant(long id, String genusSpecies, String commonName, PlantGroup plantGroup, String color, String[] features){
        super(id, genusSpecies, commonName, plantGroup);
        this.color = color;
        this.features = features;
    }

    public String[] getFeatures(){
        return features;
    }

    public String getColor(){
        return color;
    }
}