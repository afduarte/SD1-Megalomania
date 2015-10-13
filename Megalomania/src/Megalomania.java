/**
 * Created by antero on 13/10/15.
 */
import java.io.*;
import java.util.*;

public class Megalomania {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("bbc.txt"));
        ArrayList<Country> world = new ArrayList<Country>();
        for(String s=br.readLine();s!=null;s=br.readLine()) {
            world.add(new Country(s));
        }
        br.close();
        /* What's the population of the world?
        *  What's the population of Europe?
        *  What is the population of mexico?
        *  What is the highest population of all the countries?
        *  How many countries are there in North America?
        *  Print all the countries in South America.
        *  What is the population of China as a multiple of the population of the UK? (China pop divided by UK pop)
        *  Which is bigger in population, Thailand or Taiwan?
        *  How many countries are there in Asia and Asia-Pacific together?
        *  Print all the countries that contain "land" but do not print the ones that end in Islands
        */
        long pop = 0;
        Country largest = new Country("","",Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE);
        for (Country country : world) pop += country.pop;
        System.out.printf("A1: The population of the World is: %,d\n", pop);
        pop = 0;

        for (Country country : world) pop += country.region.equals("Europe") ? country.pop : 0;
        System.out.printf("A2: The population of Europe is: %,d\n", pop);

        for (Country country : world)
            if(country.name.equals("Mexico")){
                Country mexico = country;
                System.out.printf("A3: The population of %s is: %,d\n", mexico.name, mexico.pop);
            }

        //TreeMap<String,Country> worldMap = new TreeMap<String,Country>();

        /*for (Country country : world) {
            worldMap.put(country.region,country);
        }
        for (Country country : world) {x

            if (country.region) {
                largest = country.pop / country.area > largest.pop / largest.area ? country : largest;
            }
        }
        System.out.printf("A3: The country with highest population density is: %s\n", largest.name);
        */
    }
}
