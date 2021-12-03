package climatechange;

import java.util.ArrayList;



import java.io.*;

public class WeatherIO implements IWeatherIO{

	private ArrayList<ITemperature> weatherList;

	/**
	 * A constructor which instantiates the weatherList instance variable
	 */
	public WeatherIO()
	{
		weatherList = new ArrayList<>();
	}

	public ArrayList<ITemperature> returnWeatherData()
	{
		return weatherList;
	}

	public ArrayList<ITemperature> readDataFromFile(String fileName) throws IOException
	{
		File weather = new File(fileName); 
		if (!weather.exists()) //checks to see if file exists
		{
			//System.out.println("Can't find input file " + weather.getAbsolutePath());
			throw new IOException("Can't find input file: " + fileName);
		}
		FileReader fr = new FileReader(weather); //open all readers using input file 
		BufferedReader br = new BufferedReader(fr);
		WeatherReader wr = new WeatherReader(br);

		while(true) //reads the file until the very end
		{
			Temperature temp = wr.readFile();
			if(temp == null)
			{
				break;
			}
			weatherList.add(temp); //adds the parsed data into the ArrayList instance variables
		}

		br.close(); //close all readers
		fr.close();

		return weatherList;
	}


	public void writeSubjectHeaderInFile(String filename, String subject) throws IOException
	{
		//Ex formatting:
		//TaskXX: Lowest Temperature in "month"
		//Temperature, Year, Month, Country, Country_Code
		File subjectFile = new File(filename);
		
		FileWriter fw = new FileWriter(subjectFile,true); //opens all writers
		PrintWriter pw = new PrintWriter(fw);
		WeatherWriter ww = new WeatherWriter(pw);
		
		ww.writeSubject(subject); //writes subject line into file
		
		pw.close(); //closes all writers
		fw.close();
		
	}

	public void writeDataToFile(String filename, String topic, ArrayList<ITemperature> theWeatherList) throws IOException
	{
		//Ex formatting
		//10.0, 2016, Jan, United States, USA
		writeSubjectHeaderInFile(filename, topic); //write subject header into the defined file chosen
		
		File data = new File(filename);
		
		FileWriter fw = new FileWriter(data,true); //append data to the existing file which has the subject line.
		PrintWriter pw = new PrintWriter(fw); //open all writers
		WeatherWriter ww = new WeatherWriter(pw);
		
		
		for(ITemperature temp : theWeatherList) //writes data from the given list into the file
		{
			ww.writeData(temp);
		}
		
		ww.spaceLine(); //skips a line at the end of the file to make it neater if another part of a task is to be inserted into the same file
		
		pw.close(); //close all writers
		fw.close();
	}
}
