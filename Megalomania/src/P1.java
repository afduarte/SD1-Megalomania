import java.io.*;
import java.util.*;

public class P1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("cia.txt"));
        ArrayList<Country> world = new ArrayList<Country>();
        for(String s=br.readLine();s!=null;s=br.readLine()) {
            world.add(new Country(s));
        }
        br.close();
		//Country[] world = new Country[194];
        //for (int i=0;i<194;i++) world[i] = new Country(br.readLine());
		// What's the population of the world?
		// What's the population of Europe?
		// Which country has the highest population density?
		// Which region is the largest by pop/area?
		long pop = 0;
        Country largest = new Country("","",Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE);
        for (Country country : world) pop += country.pop;
        System.out.printf("A1: The population of the World is: %,d\n", pop);
        pop = 0;

		for (Country country : world) pop += country.region.equals("Europe") ? country.pop : 0;
		System.out.printf("A2: The population of Europe is: %,d\n", pop);

        for (Country country : world) if(country.area>0)
            largest = country.pop/country.area>largest.pop/largest.area ? country : largest;
        System.out.printf("A3: The country with highest population density is: %s\n", largest.name);

        //TreeMap<String,Country> worldMap = new TreeMap<String,Country>();

        /*for (Country country : world) {
            worldMap.put(country.region,country);
        }
        for (Country country : world) {

            if (country.region) {
                largest = country.pop / country.area > largest.pop / largest.area ? country : largest;
            }
        }
        System.out.printf("A3: The country with highest population density is: %s\n", largest.name);
        */
	}

}
