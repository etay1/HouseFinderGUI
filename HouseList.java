import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class HouseList {
    private ArrayList<House> houseList;

    //---------------------------------------------------------------------------
    public HouseList(String fileName) {
        this.houseList = new ArrayList<House>();

        //Initialize Scanner before try to utilize exception properly
        Scanner fileInput = null;

        try {
            fileInput = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File: " + fileName + " is not found" +
                    "\nMake sure .txt is included " +
                    "\nMake sure the textfile is in the directory");
            System.exit(0);
        }

        //Create an instance of House this will be filled with data in the while loop below it
        House house;
        String address;
        int price;
        int area;
        int numBedrooms;

        //For each line of the text rip out data using next
        while (fileInput.hasNext()) {
            address = fileInput.next();
            price = fileInput.nextInt();
            area = fileInput.nextInt();
            numBedrooms = fileInput.nextInt();

            house = new House(address, price, area, numBedrooms);
            this.houseList.add(house);
        }

    }

    //---------------------------------------------------------------------------
    //Simple iteration grab the current house
    //Calls getMatchingHouses
    public void printHouses(Criteria c) {
        Iterator<House> iterator = getMatchingHouses(c).iterator();
        House house;

        while (iterator.hasNext()) {
            house = iterator.next();
            System.out.println(house.toString());
        }

    }

    //---------------------------------------------------------------------------
    //Compares the house with criteria object
    //if they pass the satisfies function from House class add it to matchingHouses
    public ArrayList<House> getMatchingHouses(Criteria c) {

        ArrayList<House> matchingHouses = new ArrayList<House>();
        Iterator<House> iterator = houseList.iterator();
        House house;

        while(iterator.hasNext()) {
            house = iterator.next();
            if(house.satisfies(c))
                matchingHouses.add(house);
        }

        return matchingHouses;

    }

}