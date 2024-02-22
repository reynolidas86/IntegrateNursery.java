import java.time.LocalDate;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Plant {
    //TODO: Verify if this function should halt execution or simply alert
    //  If the intended behaviour is that the program will throw
    //  an error if given an invalid 'String' then 'throw' statements
    //  should be added. If it should only alert the user there is an
    //  error then 'System.err.println' should be used.
    ///////////////////////////////////////////////////
    //                      NOTE                     //
    // This implementation is only alerting the user //
    ///////////////////////////////////////////////////
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

    //TODO: Verify if this function should halt execution or simply alert
    //  If the intended behaviour is that the program will throw
    //  an error if given an invalid 'String' then 'throw' statements
    //  should be added. If it should only alert the user there is an
    //  error then 'System.err.println' should be used.
    ///////////////////////////////////////////////////
    //                      NOTE                     //
    // This implementation is only alerting the user //
    ///////////////////////////////////////////////////
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
    private HashMap<Integer, Zone> zones = new HashMap<Integer, Zone>();

    // TEST
    public Plant(long id, String genusSpecies, String commonName, PlantGroup plantGroup){
        this.id = id;
        this.genusSpecies = genusSpecies;
        this.commonName = commonName;
        this.plantGroup = plantGroup;
    }

    public boolean growsInZone(int zoneNumber){
        //TODO: Double check this is the intended behaviour
        //  Assumes that the zones 'HashMap' will only have the zones that
        //  the plant is able to grow in. 
        return zones.keySet().contains(zoneNumber);
    }

    @Override
    public String toString(){
        return commonName + " (" + genusSpecies.split(" ")[0] + ")";
    }
}
