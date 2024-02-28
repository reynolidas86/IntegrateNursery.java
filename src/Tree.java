public class Tree extends Plant{
    //TODO: Verify this should be a 'String' and not an 'enum'
    private final String speed;

    public Tree(long id, String genusSpecies, String commonName, PlantGroup plantGroup, String speed){
        super(id, genusSpecies, commonName, plantGroup);
        this.speed = speed;
    }

    public String getGrowthSpeed(){
        return speed;
    }
}
