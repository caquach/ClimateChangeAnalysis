package climatechange;
import java.io.*;

public class WeatherWriter {

	private PrintWriter printWrite;
	
	/**
	 * Constructor that instantiates a thePrinterWriter instance variable
	 * @param pw argument of type PrinterWriter that instantiates thePrinterWriter.
	 */
	public WeatherWriter(PrintWriter pw)
	{
		printWrite = pw;
	}
	
	/**
	 * Method which writes the subject line before the data
	 * @param subject a string object which is to be written into the file
	 */
	public void writeSubject(String subject)
	{
		printWrite.println(subject);
		printWrite.println("Temperature(C), Year, Month, Country, Country_Code");
	}
	
	/**
	 * Method which writes the data from an ITemperature object
	 * Note: Temperatures values are rounded to two decimal places
	 * @param te an ITemperature object to be parsed and written into a line of the file
	 */
	public void writeData(ITemperature te)
	{
		double cRounded = Math.round(te.getTemperature(false)*100)/100.00;
		double fRounded = Math.round(te.getTemperature(true)*100)/100.00;
		
		
		printWrite.println(""+ cRounded + "(C) " + fRounded + "(F)" + ", " 
								+ te.getYear() 
								+ ", " + te.getMonth() 
								+ ", " + te.getCountry() 
								+ ", " + te.getCountry3LetterCode());
	}
	
	/**
	 * Method which "writes" an empty line in the file
	 */
	public void spaceLine()
	{
		printWrite.println("");
	}
}
