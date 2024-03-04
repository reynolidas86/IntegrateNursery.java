import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.time.LocalDate;

public class PlantDriver {
    private static ArrayList<Plant> plants = new ArrayList<>();
    private static int zone;
    private static String evaluatorAnswer;
    private static Predicate<Plant> experienceEval;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        readInput(sc);

        createTrees();
        createFloweringPlants();
        createNormalPlant(sc);

        sc.close();

        displayPlants();
    }

    /**
     * Prompts user for input to assign values to {@code zone} and {@code experienceEval}.
     * <p>This method does not close the provided scanner.
     * @param sc The scanner to gather input from
     */
    private static void readInput(Scanner sc){
        System.out.print("How should we evaluate?\n\t");
        evaluatorAnswer = sc.nextLine();
        experienceEval = Plant.evaluator.get(evaluatorAnswer);
        System.out.print("What zone are you currently in?\n\t");
        zone = Integer.parseInt(sc.nextLine());
    }

    /**
     * Creates a {@link Plant} based off user input and adds it to the {@code plants} list. 
     * <p>This method does not close the provided scanner.
     * @param sc The scanner to gather input from
     */
    private static void createNormalPlant(Scanner sc){
        System.out.print("Enter the common name of the plant\n\t");
        String commonName = sc.nextLine();
        System.out.print("Enter the scientific name of the plant\n\t");
        String scientificName = sc.nextLine();
        System.out.println("Enter when the plant was first introduced to the nursery [YYYY-MM-DD]\n\t");
        LocalDate introDate = LocalDate.parse(sc.nextLine());
        System.out.println();

        Plant tempPlant = new Plant(scientificName, commonName, introDate, PlantGroup.ANGIOSPERM);
        tempPlant.addZone(zone);

        plants.add(tempPlant);
    }
    /**
     * Constructs hard coded {@link Tree} plants and adds them to the {@code plants} list.
     */
    private static void createTrees(){
        Plant tempPlant = new Tree("Acer palmatum", "Bloodgood Japanese Maple",
            LocalDate.of(2016, 1, 2), PlantGroup.GYMNOSPERM, GrowthSpeed.FAST);
        tempPlant.addZone(6, 7, 8);
        plants.add(tempPlant);

        tempPlant = new Tree("Tsuga canadensis", "Hemlock Tree",
            LocalDate.of(2003, 1, 23), PlantGroup.GYMNOSPERM, GrowthSpeed.SLOW);
        tempPlant.addZone(3, 4, 5, 6, 7);
        plants.add(tempPlant);
    }
    /**
     * Constructs hard coded {@link FloweringPlant} and adds them to the {@code plants} list.
     */
    private static void createFloweringPlants(){
        Plant tempPlant = new FloweringPlant("Murraya paniculata", "Orange Jasmine", 
            LocalDate.of(2007, 3, 2), PlantGroup.ANGIOSPERM, "white", "orange-scented");
        tempPlant.addZone(9);
        plants.add(tempPlant);

        tempPlant = new FloweringPlant("Convallaria majalis", "Lily-of-the-Valley",
            LocalDate.of(2011, 10, 5), PlantGroup.ANGIOSPERM, "white, pink or red", "delicate, fragrent");
        tempPlant.addZone(5, 6, 7, 8);
    }

    /**
     * Displays all plants in the {@code plants} list to the console.
     */
    private static void displayPlants(){
        Predicate<Plant> goodForZone = (p) -> p.growsInZone(zone);

        plants.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.toString());
            System.out.println(p.getClass().getSimpleName());
            if (p instanceof FloweringPlant){
                System.out.println(((FloweringPlant)p).getFeatures() + " plant with " + ((FloweringPlant)p).getColor() + " colors");
            }
            else if (p instanceof Tree){
                System.out.println("A " + ((Tree)p).getGrowthSpeed().toString() + " growing tree");
            }
            System.out.println(evaluatorAnswer + " experience: " + experienceEval.test(p));
            System.err.println("Good for your zone: " + goodForZone.test(p));
            System.out.println();
        });
    }
}