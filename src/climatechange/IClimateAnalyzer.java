package climatechange;
import java.util.*;
import java.io.*;

public interface IClimateAnalyzer {
	
	// TASK A-1
	/**
	 * Method that returns an ITemperature object that has the least temperature from the specified country and month 
	 * @param country A string parameter which limits the search to that country 
	 * @param month a integer parameter which limits the search to that month 
	 * @return ITemperature returns the an ITemperature object with least temperature in a given month and country
	 */
	public ITemperature getLowestTempByMonth(String country, int month);
	
	
	/**
	 * Method that returns an ITemperature object that has the most temperature from the specified country and month 
	 * @param country A string parameter which limits the search to that country 
	 * @param month a integer parameter which limits the search to that month 
	 * @return ITemperature returns the an ITemperature object with most temperature in a given month and country
	 */
	public ITemperature getHighestTempByMonth(String country, int month);
	
	
	// TASK A-2
	/**
	 * Method that returns an ITemperature object that has the least temperature from the specified country and year 
	 * @param country A string parameter which limits the search to that country 
	 * @param year a integer parameter which limits the search to that year
	 * @return ITemperature returns the an ITemperature object with least temperature in a given year and country
	 */
	public ITemperature getLowestTempByYear(String country, int year);
	
	
	/**
	 * Method that returns an ITemperature object that has the most temperature from the specified country and year 
	 * @param country A string parameter which limits the search to that country 
	 * @param year a integer parameter which limits the search to that year
	 * @return ITemperature returns the an ITemperature object with most temperature in a given year and country
	 */
	public ITemperature getHighestTempByYear(String country, int year);
	
	
	// TASK A-3
	/**
	 * Method that returns an TreeSet of ITemperature objects that is from the specified country and within the temperature bounds
	 * @param country A string parameter which limits the search to that country 
	 * @param rangeLowTemp A double parameter which sets the lower bound
	 * @param rangeHighTemp A double parameter which sets the higher bound
	 * @return TreeSet<ITemperature> returns a TreeSet of ITemperature objects within the bounds and country
	 */
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp);
	

	// TASK A-4
	/**
	 * Method that returns an ITemperature object that has the least temperature from the specified country
	 * @param country A string parameter which limits the search to that country 
	 * @return ITemperature returns the an ITemperature object with least temperature in the given country
	 */
	public ITemperature getLowestTempYearByCountry(String country);
	
	
	/**
	 * Method that returns an ITemperature object that has the most temperature from the specified country
	 * @param country A string parameter which limits the search to that country 
	 * @return ITemperature returns the an ITemperature object with most temperature in the given country
	 */
	public ITemperature getHighestTempYearByCountry(String country);
	
	
	// TASK B-1
	/**
	 * Method which returns the lowest 10 ITemperatures objects from the given month
	 * Note: Each spot in the 10 are from unique countries meaning no two countries show up twice
	 * @param month a integer parameter which limits the search to that month
	 * @return ArrayList<ITemperature> returns an ArrayList of ITemperatures 
	 * containing the lowest 10 temperature readings ordered from lowest to highest
	 */
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month);
	
	
	/**
	 * Method which returns the highest 10 ITemperatures objects from the given month
	 * Note: Each spot in the 10 are from unique countries meaning no two countries show up twice
	 * @param month a integer parameter which limits the search to that month
	 * @return ArrayList<ITemperature> returns an ArrayList of ITemperatures 
	 * containing the highest 10 temperature readings ordered from lowest to highest
	 */
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month);
	
	
	// TASK B-2
	/**
	 * Method which returns the lowest 10 ITemperatures objects
	 * Note: Each spot in the 10 are from unique countries meaning no two countries show up twice
	 * @return ArrayList<ITemperature> returns an ArrayList of ITemperatures 
	 * containing the lowest 10 temperature readings ordered from lowest to highest
	 */
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp();
	
	
	/**
	 * Method which returns the highest 10 ITemperatures objects
	 * Note: Each spot in the 10 are from unique countries meaning no two countries show up twice
	 * @return ArrayList<ITemperature> returns an ArrayList of ITemperatures 
	 * containing the highest 10 temperature readings ordered from lowest to highest
	 */
	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp();
	
	
	// TASK B-3
	/**
	 * Method that returns an ArrayList of ITemperature objects that is within the temperature bounds ordered from lowest to highest
	 * Note: Each spot in the 10 are from unique countries meaning no two countries show up twice
	 * @param lowRangeTemp A double parameter which sets the lower bound
	 * @param highRangeTemp A double parameter which sets the higher bound
	 * @return TreeSet<ITemperature> returns a ArrayList of ITemperature objects within the bounds
	 */
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(
			double lowRangeTemp,
			double highRangeTemp
			);
	
	
	// TASK C-1
	/**
	 * Method which returns an ArrayList of ITemperature objects with the highest temperature deltas based on the month and the two given years
	 * Note: Each spot in the 10 are from unique countries meaning no two countries show up twice
	 * @param month an integer parameter which limits the search to that month
	 * @param year1 an integer parameter which limits the search to that year
	 * @param year2 an integer parameter which limits the search to that year
	 * @return ArrayList<ITemperature> returns the 10 highest temperature deltas for that month using the two years specified
	 * Note: the temperature and year for each object is returned as their difference
	 */
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2);
	
	
	/**
	 * Method that runs all the ClimateAnalyzer methods in order from top to bottom
	 * Each method returns its respective data and is used to write data files for each task
	 * Note: Takes user input for methods that have parameters
	 * @throws IOException if the input file is invalid or if any of the user inputs are invalid.
	 */
	public void runClimateAnalyzer() throws IOException;
}
