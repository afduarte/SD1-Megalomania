/**
 * Created by antero on 13/10/15.
 */
import java.io.*;
import java.util.*;

public class Megalomania {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("bbc.txt"));
        ArrayList<Country> worldArray = new ArrayList<Country>();
        TreeMap<String,Country> worldMap = new TreeMap<String,Country>();
        for(String s=br.readLine();s!=null;s=br.readLine()) {
            worldArray.add(new Country(s));
        }
        br.close();
        for (Country country : worldArray) worldMap.put(country.name,country);

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
        System.out.println("Iterating over countries:\n");
        long pop = 0;
        for (Country country : worldArray) pop += country.pop;
        System.out.printf("A1: The population of the World is: %,d\n", pop);
        pop = 0;

        for (Country country : worldArray) pop += country.region.equals("Europe") ? country.pop : 0;
        System.out.printf("A2: The population of Europe is: %,d\n", pop);


        Country mexico = worldMap.get("Mexico");
        System.out.printf("A3: The population of %s is: %,d\n", mexico.name, mexico.pop);



        Country mostPop = new Country("","",Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE);;
        for (Country country: worldArray)
            mostPop = country.pop>mostPop.pop?country:mostPop;
        System.out.printf("A4: The country with highest population of all the countries is %s with %,d people\n",mostPop.name,mostPop.pop);

        int nAmericaCount = 0;
        for(Country country : worldArray)
            if ("North America".equals(country.region))
                nAmericaCount++;
        System.out.printf("A5: The number of countries in North America is: %d\n",nAmericaCount);

        ArrayList<String> sAmerica = new ArrayList<String>();
        for(Country country : worldArray)
            if ("South America".equals(country.region))
                sAmerica.add(country.name);
        System.out.printf("A6: The countries in South America are: %s\n",sAmerica);

        Country china = worldMap.get("China");
        Country uk = worldMap.get("United Kingdom");
        System.out.printf("A7: The population of %s as a multiple of the population of the %s is: %d\n",china.name,uk.name,china.pop/uk.pop);

        Country thailand = worldMap.get("Thailand");
        Country taiwan = worldMap.get("Taiwan");
        Country biggerPop = thailand.pop>taiwan.pop?thailand:taiwan;
        Country smallerPop = thailand.pop<taiwan.pop?thailand:taiwan;
        System.out.printf("A8: %s is bigger than %s in population with %,d people\n",biggerPop.name,smallerPop.name,biggerPop.pop);

        int count = 0;
        for(Country country : worldArray)
            if("Asia".equals(country.region)||"Asia-Pacific".equals(country.region))
                count++;
        System.out.printf("A9: The number of countries in Asia and Asia-Pacific is: %d\n",count);

        ArrayList<String> containsLand = new ArrayList<String>();
        for(Country country : worldArray)
            if(country.name.contains("land") && !country.name.endsWith("Islands"))
                containsLand.add(country.name);
        System.out.printf("A10: The list of countries that contain land but don't end with Islands is: %s\n",containsLand);

        /*  Pair of countries with identical population over 13 Million.
         *
         *
        */
         */
        System.out.println("\nPairs of countries:\n");

        ArrayList<Country> popOver13M = new ArrayList<Country>();
        for(Country country : worldArray)
            if(country.pop>13000000)
                popOver13M.add(country);





    }
}
