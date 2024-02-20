import java.time.LocalDate;
import java.util.HashMap;

public class Plant {

    private long id;
    private String genusSpecies;
    private String commonName;
    private PlantGroup plantGroup;
    private LocalDate dateIntroduced;
    private HashMap<Integer, Zone> zones = new HashMap<Integer, Zone>();

    // TEST
    public Plant(long id, String genusSpecies, String commonName, PlantGroup plantGroup){
        this.id = id;
        this.genusSpecies = genusSpecies;
        this.commonName = commonName;
        this.plantGroup = plantGroup;
    }
}
