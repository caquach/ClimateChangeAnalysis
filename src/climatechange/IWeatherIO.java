package climatechange;
import java.io.IOException;
import java.util.ArrayList;

public interface IWeatherIO{
	
	
	/**
	 * Method which reads and parses all temperature from the given data file
	 * @param fileName a String parameter which specifies which file to read from
	 * @return ArrayList<ITemperatures> returns an ArrayList of ITemperatures containing all the data from the data file
	 * @throws IOException if the file specified cannot be found
	 */
	public ArrayList<ITemperature> readDataFromFile(String fileName) throws IOException;
	
	
	
	/**
	 * Method which writes the subject header before temperature data in the file
	 * @param filename a String parameter which specifies which file to write into
	 * @param subject A string parameter that is written into the file to clarify the subject of the data in each written file
	 * @throws IOException
	 */
	public void writeSubjectHeaderInFile(String filename, String subject) throws IOException;
	
	
	/**
	 * Method which parses and writes the data of the given ArrayList into the file under the subject header
	 * @param filename a String parameter which specifies which file to write into
	 * @param topic A string parameter that is written into the file to clarify the subject of the data in each written file
	 * @param theWeatherList an input ArrayList of the ITemperature objects to write into the specified file
	 * @throws IOException
	 */
	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) throws IOException;
}
