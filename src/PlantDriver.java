import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
//building of a nursery does not need input
public class PlantDriver {
    public static ArrayList<Plant> plants = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("How should we evaluate?");
        String evaluatorType = sc.nextLine();
        System.out.println("What zone are you currently in?");
        int zone = Integer.parseInt(sc.nextLine());

        readInput(sc);

        sc.close();
    }

    private static void readInput(Scanner sc){

            System.out.println("Enter the common name of the plant");
            String commonName = sc.nextLine();
            System.out.println("Enter the scientific name of the plant");
            String scientificName = sc.nextLine();
            System.out.println("Enter when the plant was first introduced to the nursery [YYYY-MM-DD]");
            String date = sc.nextLine();
            LocalDate assignedDate = LocalDate.parse(date);
            // Hardcode on a few more plants down below; make sure to add some trees and flowers as well.
            Plant plantName = new Plant(scientificName, commonName, assignedDate, PlantGroup.ANGIOSPERM);
            plantName.addZone(3);
            plants.add(plantName);
            // Here involves hardcoding for the plants we will be comparing.
            Plant plantName2 = new Plant("Esperanicus", "Spiranco", LocalDate.parse("2020-08-18"), PlantGroup.BRYOPHYTE);
            plantName.addZone(8);
            plants.add(plantName2);
    }


    // Talked with assistant, will discuss later with partner.
    private static void createNormalPlant(){
        //TODO: Fill out method
        plants.add(null /* <-- Replace with call to constructor */);
    }
    private static void createTree(){
        //TODO: Fill out method
        plants.add(null /* <-- Replace with call to constructor */);
    }
    private static void createFloweringPlant(){
        //TODO: Fill out method
        plants.add(null /* <-- Replace with call to constructor */);
    }
}