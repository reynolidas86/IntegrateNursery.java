import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Plant {
    //TODO: Add variables for comparison via predicates
    /*
     * private static LocalDate currentMostExperience;
     * private static LocalDate currentLeastExperience;
     */

    //This is the 'HashMap' to hold the filtering predicates
    public static final HashMap<String, Predicate<Plant>> filters;
    static{
        filters = new HashMap<>();
        //TODO: Most experience predicate
        filters.put("most_experienced", (p) -> {/* [CODE HERE] */ return false; });
        //TODO: Least experience predicate
        filters.put("least_experienced", (p) -> {/* [CODE HERE] */ return false; });
    }

    private static void validateGenusSpecies(String genusSpecies){
        if (genusSpecies.length() < 7 || genusSpecies.length() > 39){
            //Breaks character bounds defined in Canvas
            System.err.println("Invalid plant name: " + genusSpecies);
            System.err.println("Breaks bounds. Length: " + genusSpecies.length());
            
            //Because this 'if' statement only runs if the name
            //  is invalid, there is no point in checking the other
            //  conditions. So we can return here.
            return;
            //This 'early return' will be used in all subsequent checks
        }
        if (genusSpecies.split(" ").length == 1){
            //Is only one word
            System.err.println("Invalid plant name: " + genusSpecies);
            System.err.println("The name is only one word");

            return; //Early return
        }

        //Creates a 'Matcher' object which will match only the uppercase
        //  letters in the plant name.
        Matcher uppercaseMatcher = Pattern.compile("[A-Z]").matcher(genusSpecies);
        //Uses the static method 'Pattern.compile' to create
        //  the RegEx to use on the 'String'. The 'matcher' method
        //  creates the actual 'Matcher' object which will be used to
        //  determine how many and where the uppercase letters are. 


        if (uppercaseMatcher.find()){
            //Has at least one uppercase letter
            
            if (Character.isLowerCase(genusSpecies.charAt(0))){
                //First letter of genus is lowercase
                System.err.println("Invalid plant name: " + genusSpecies);
                System.err.println("The first letter of the genus should be the only uppercase letter");

                return; //Early return
            }
            

            //Because the 'find' method in the 'if' statement on line 44
            //  evaluated to 'true', if the method returns 'true' again
            //  we know that there must be more than one uppercase letter
            if (uppercaseMatcher.find()) {
                //More than one uppercase letter
                System.err.println("Invalid plant name: " + genusSpecies);
                System.err.println("Only 1 letter should be capitalized");

                return; //Early return
            }

        }
        else{
            //Does not contain any uppercase letters
            System.err.println("Invalid plant name: " + genusSpecies);
            System.err.println("No capital letters. The first letter of the genus should be uppercase");

            return; //Early return
        }
    }
    private static void validateCommonName(String commonName){
        if (Character.isLowerCase(commonName.charAt(0))){
            //First letter is lowercase
            System.err.println("Invalid common name for plant: " + commonName);
            System.err.println("First letter of common name must be capitalized.");
        }
    }

    private long id;
    private String genusSpecies;
    private String commonName;
    private PlantGroup plantGroup;
    private LocalDate dateIntroduced;
    private HashSet<Zone> zones = new HashSet<Zone>();

    // TEST
    public Plant(long id, String genusSpecies, String commonName, PlantGroup plantGroup){
        this.id = id;
        this.genusSpecies = genusSpecies;
        this.commonName = commonName;
        this.plantGroup = plantGroup;

        validateGenusSpecies(genusSpecies);
        validateCommonName(commonName);
    }

    public long getId(){
        return id;
    }
    public String getGenusAndSpecies(){
        return genusSpecies;
    }
    public String getCommonName(){
        return commonName;
    }
    public PlantGroup getPlantGroup(){
        return plantGroup;
    }
    public LocalDate getDateIntroduced(){
        return dateIntroduced;
    }
    public HashSet<Zone> getZones(){
        return zones;
    }

    public boolean growsInZone(int zoneNumber){
        //TODO: Double check this is the intended behaviour
        return this.zones.contains(Zone.zones.get(zoneNumber));
    }

    @Override
    public String toString(){
        return commonName + " (" + genusSpecies.split(" ")[0] + ")";
    }
}
