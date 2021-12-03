package climatechange;

public class Temperature implements ITemperature, Comparable<Temperature>{

	private double temperature;
	private int year;
	private String month;
	private String country;
	private String country3LetterCode;
	
	/**
	 * Constructor which instantiates all the instance variables in a Temperature object
	 * @param tempa Temperature to be used as instance variable
	 * @param yr Year to be used as instance variable
	 * @param mth month to be used as instance variable
	 * @param cty Country to be used as instance variable
	 * @param cty3Code A country's 3 letter code to be used as instance variable
	 */
	public Temperature(double tempa, int yr, String mth, String cty, String cty3Code)
	{
		temperature = tempa;
		year = yr;
		month = mth;
		country = cty;
		country3LetterCode = cty3Code;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public String getCountry3LetterCode()
	{
		return country3LetterCode;
	}
	
	public String getMonth()
	{
		return month;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public double getTemperature(boolean getFahrenheit)
	{
		double temp = temperature;
		
		if(getFahrenheit)
		{
			temp = (9.0 * temp)/5.0 + 32.0;
		}
		return temp;
	}
	
	/**
	 * Method that returns the deep equality of 2 Temperature objects
	 * @param x an object to be casted to be as a Temperature object
	 * and to be compared with "this"
	 * @return boolean returns true if all the instance variable are equal
	 */
	public boolean equals(Object x)
	{
		Temperature that = (Temperature)x;
		if(this.getTemperature(false) == that.getTemperature(false) 
			&& this.getYear() == that.getYear() 
			&& this.getMonth().equals(that.getMonth())
			&& this.getCountry3LetterCode().equals(that.getCountry3LetterCode()))
		{
			return true;
		}
		return false;		
	}
	
	/**
	 * Method that compares two Temperature objects and determines their order
	 * Note: Ordered by temperature, then country, and then year
	 * @param "that" is a Temperature object to be compared to "this"
	 * @return int 
	 * returns 1 (positive number) if "this" comes lexicographically before "that"
	 * returns 0 if both are equal
	 * returns -1 (negative number) if if "this" comes lexicographically after "that"
	 */
	public int compareTo(Temperature that)
	{
		if(this.equals(that))
		{
			return 0;
		}
		
		if(this.getTemperature(false) > that.getTemperature(false))
			return 1;
		else if(this.getTemperature(false) < that.getTemperature(false))
			return -1;
		
		int compare = this.getCountry().compareTo(that.getCountry());
		if(compare != 0)
			return compare;
		
		if(this.getYear() > that.getYear())
			return 1;
		
		return -1;
	}
	
	/**
	 * Method that returns a hash code number based on the instance variables
	 * @return int Returns the sum of the hash codes of temperature, year,month, and country
	 */
	public int hashCode()
	{
		return (int)temperature + year + month.hashCode() + country.hashCode(); 
	}
	
	
}
