import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Plant {
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
    
    private static long nextId = 4902;
    
    private static Plant oldest = null;
    private static Plant youngest = null;
    public static final HashMap<String, Predicate<Plant>> evaluator;
    static{
        evaluator = new HashMap<String, Predicate<Plant>>();
        // Indicating whether the given plant has the most experience comparing to other plants.
        evaluator.put("most", (p) -> oldest.equals(p));

        //Indicating whether the given plant has the least experience comparing to other plants.
        evaluator.put("least", (p) -> youngest.equals(p));
    }

    private long id;
    private String genusSpecies;
    private String commonName;
    private PlantGroup plantGroup;
    private LocalDate dateIntroduced;
    private HashSet<Zone> zones = new HashSet<Zone>();

    public Plant(String genusSpecies, String commonName, LocalDate dateIntroduced, PlantGroup group){
        id = nextId++;
        this.genusSpecies = genusSpecies;
        this.commonName = commonName;
        this.dateIntroduced = dateIntroduced;
        plantGroup = group;

        validateGenusSpecies(genusSpecies);
        validateCommonName(commonName);

        
        if (oldest == null && youngest == null){
            //This is the first plant we have created so far and should be stored as the baseline for
            //  all future plants.
            oldest = this;
            youngest = this;
            return;
            //Early return because we don't need to evaluate the rest as it is only used for updating 
            //  the stored values when new plants are created. But since this is the first plant we create
            //  we would only end up comparing it against itself.
        }
    
        oldest = this.dateIntroduced.isBefore(oldest.getDateIntroduced()) ? this : oldest;
        youngest = this.dateIntroduced.isAfter(youngest.getDateIntroduced()) ? this : youngest;
    }
    
    /*
     * Returns the value, id, as data type long.
     * 
     * @return              The id of the plant
     */
    public long getId(){
        return id;
    }

    /*
     * Returns the genial-name of the plant species as a string.
     * 
     * @return              The string of the species genial-name.
     */
    public String getGenusAndSpecies(){
        return genusSpecies;
    }

    /*
     * Returns the common-name of the plant species as a string.
     * 
     * @return              The string of the species common-name.
     */
    public String getCommonName(){
        return commonName;
    }

    /*
     * Returns the plant group from the Plant Group selection.
     * 
     * @return              One of the types/enumerations signifying the plant's group.
     */
    public PlantGroup getPlantGroup(){
        return plantGroup;
    }

    /*
     * Returns the introduced date for which the information of the plant species is vital.
     * 
     * @return              The date, month, and year for which is used for information of the designated plant.
     */
    public LocalDate getDateIntroduced(){
        return dateIntroduced;
    }



    /*
     * Returns whether the designated plant is able to grow in this particular zone.
     * 
     * @param      zoneNumber      The zone to which is (initially) assigned for the plant.
     * @return                     A boolean to which whether the zone will work or not.
     */
    public boolean growsInZone(int zoneNumber){
        //TODO: Double check this is the intended behaviour been checked for progress
        return this.zones.contains(Zone.zones.get(zoneNumber));
    }

    /*
     * Adds a zone from a previous set of zones into the list.
     * 
     * @param                   The zone number to which will be added into the zone if conditions apply.
     */
    public void addZone(int... index){
        for (int i : index){
            if(i >= 1 && i <= 11) {
                zones.add(Zone.zones.get(i));
            }
            else{
                System.err.println("Attempted to add an invalid zone, " + i + ", to plant " + this.commonName);
                System.err.println("All zones must be between 1 and 11");
            }
        }
    }

    @Override
    public String toString(){
        return commonName + " (" + genusSpecies + ")";
    }

    @Override
    public boolean equals(Object e){
        if (!(e instanceof Plant))
            return false;
        
        return ((Plant)e).id == this.id;
    }
}