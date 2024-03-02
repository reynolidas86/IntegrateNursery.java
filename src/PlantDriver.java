import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.time.LocalDate;
//building of a nursery does not need input
public class PlantDriver {
    public static ArrayList<Plant> plants = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How should we evaluate? [Enter 'least' or 'most']");
        String evaluatorType = sc.nextLine();
        Predicate<Plant> evaluation = Plant.evaluator.get(evaluatorType);
        readInput(sc);
        createNormalPlant();
        createTree();
        createFloweringPlant();

        sc.close();
    }

    private static void readInput(Scanner sc){

        System.out.println("What zone are you currently in?");
        int zone = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the common name of the plant");
        String commonName = sc.nextLine();
        System.out.println("Enter the scientific name of the plant (make one up!)");
        String scientificName = sc.nextLine();
        System.out.println("Enter when the plant was first introduced to the nursery [YYYY-MM-DD]");
        String date = sc.nextLine();
        LocalDate assignedDate = LocalDate.parse(date);
        Plant plantName = new Plant(scientificName, commonName, assignedDate, PlantGroup.ANGIOSPERM);
        plantName.addZone(3);
        plants.add(plantName);
        Plant plantName3 = new Plant("Valitinidus Forna", "Valiti Forin", LocalDate.parse("2016-02-29"), PlantGroup.PTERIDOPHYTE);
        plantName.addZone(10);
        plants.add(plantName3);
        
        plants.add(plantName4);
        
        plants.add(plantName5);
}


    // Talked with assistant, will discuss later with partner.
    //Plant plantName2 = new Tree("Esperanicus", "Spiranco", LocalDate.parse("2020-08-18"), PlantGroup.BRYOPHYTE);
    private static void createNormalPlant(){
        Plant plantName6 = new Plant("Valitinidus Forna", "Valiti Forin", LocalDate.parse("2016-02-29"), PlantGroup.PTERIDOPHYTE);
        plantName6.addZone(10);
        plants.add(plantName6);
    }
    private static void createTree(){
        Plant plantName2 = new Tree("Esperanicus", "Spiranco", LocalDate.parse("2020-08-2018"), PlantGroup.BRYOPHYTE);
        plantName2.addZone(8);
        plants.add(plantName2);
        Plant plantName4 = new Tree("Puserpina Delianos", "Puserp Delen",LocalDate.parse("2014-05-19"), PlantGroup.ANGIOSPERM);
        plantName4.addZone(6);
        plants.add(plantName4);
    }
    private static void createFloweringPlant(){
        Plant plantName3 = new FloweringPlant("Valitinidus Forna", "Valiti Forin", LocalDate.parse("2016-02-29"), PlantGroup.PTERIDOPHYTE);
        plantName3.addZone(10);
        plants.add(plantName3);
        Plant plantName5 = new FloweringPlant("Polaris Septunia", "Polar Septin", LocalDate.parse("2018-12-16"), PlantGroup.GYMNOSPERM);
        plantName5.addZone(1);
        plants.add(plantName5);
    }
}