import java.io.*;
public class P1 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("cia.txt"));
		Country[] world = new Country[194];
		// What's the population of the world?
		// What's the population of Europe?
		// Which country has the highest population density?
		// Which region is the largest by pop/area?
		for (int i=0;i<194;i++) world[i] = new Country(br.readLine());
		br.close();
		long pop = 0;
		for (Country country : world){
			pop += country.region.equals("Europe")?country.pop:0;
		}
		System.out.println("The population of Europe is: "+pop);

	}

}
