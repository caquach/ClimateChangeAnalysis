package climatechange;
import java.io.*;

public class WeatherReader {

	private BufferedReader buffRead;
	
	/**
	 * Constructor that instantiates a theBufferedReader instance variable
	 * @param br argument of type BufferedReader that
	 * instantiates theBufferedReader.
	 */
	public WeatherReader(BufferedReader br)
	{
		buffRead = br;
	}
	
	/**
	 * Method that reads each line from a file and parses the information into a new Temperature object
	 * Note: skips over a line of a file if the first character is a the letter T
	 * @return Temperature returns a Temperature object 
	 * @returns null if the next first line that is read is null
	 * @throws IOException 
	 */
	public Temperature readFile() throws IOException
	{
		String line = buffRead.readLine();
		if(line == null)
		{
			return null;
		}
		if(line.substring(0,1).equals("T"))
		{
			line = buffRead.readLine();
		}
		
		String[] weatherArray = line.split(", ");
		double temperature = Double.parseDouble(weatherArray[0]);
		int year = Integer.parseInt(weatherArray[1]);
		String month = weatherArray[2];
		String country = weatherArray[3];
		String country3Letter = weatherArray[4];
		Temperature wData = new Temperature(temperature,year,month,country,country3Letter);
		
		return wData;
	}
}
