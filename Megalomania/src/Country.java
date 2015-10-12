
public class Country {
	public String name;
	public String region;
	public int area;
	public long pop;
	public long gdp;
	
	public Country(String n,String r,int a,long p,long gdp){
		this.name = n;
		this.region = r;
		this.area = a;
		this.pop = p;
		this.gdp = gdp;
	}
	
	public Country(String line){
		String f[] = line.split("\t");
		name = f[0];
		region = f[1];
		area = Integer.parseInt(f[2]);
		pop = Long.parseLong(f[3]);
		gdp = Long.parseLong(f[4]);
	}
	
	public String toString(){
		return "Country("+name+","+region+","+area+"sq km,"+pop+",$"+gdp+")";
	}
	
}
