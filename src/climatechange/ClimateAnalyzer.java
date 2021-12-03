package climatechange;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class ClimateAnalyzer extends WeatherIO implements IClimateAnalyzer{

	private HashMap<Integer,String> months;

	/**
	 * Method which instantiates a hashSet which is used to map numbers of the month over the respective acronym
	 */
	public ClimateAnalyzer()
	{
		months = new HashMap<>();

		months.put(1, "Jan");
		months.put(2, "Feb");
		months.put(3, "Mar");
		months.put(4, "Apr");
		months.put(5, "May");
		months.put(6, "Jun");
		months.put(7, "Jul");
		months.put(8, "Aug");
		months.put(9, "Sep");
		months.put(10, "Oct");
		months.put(11, "Nov");
		months.put(12, "Dec");	
	}

	/**
	 * Method which determines the validity of the input string
	 * The question that this method answer is as follows:
	 * Is the input string a country that is part of the weather data?
	 * @param input A string object which is used to compare to all the countries
	 * @return boolean
	 * returns true if the input is equal to at least one country
	 * returns false otherwise
	 */
	public boolean isValidCountry(String input)
	{
		TreeSet<ITemperature> countryData = new TreeSet<>(returnWeatherData());
		for(ITemperature te : countryData) //out of all objects, return true if input equals at least one country
		{
			if(input.equals(te.getCountry()))
			{
				return true;
			}
		}
		return false;
	}
	
	//Task A1
	public ITemperature getLowestTempByMonth(String country, int month)
	{
		ArrayList<ITemperature> tempData = new ArrayList<>(returnWeatherData());
		ITemperature minTemp = null;
		int i = 0;
		while(minTemp == null) //grabs first country with from tempData with conditions
		{
			if(tempData.get(i).getCountry().equals(country) 
					&& tempData.get(i).getMonth().equals(months.get(month)))
					{
						minTemp = tempData.get(i);
					}
			i++;
		}

		for(ITemperature te : tempData) //sets minTemp to temperature object with the least temperature
		{
			if(te.getCountry().equals(country) 
					&& te.getMonth().equals(months.get(month)) 
				&& te.getTemperature(false) < minTemp.getTemperature(false))
			{
				minTemp = te;
			}
		}
		return minTemp;
	}

	public ITemperature getHighestTempByMonth(String country, int month)
	{
		ArrayList<ITemperature> tempData = new ArrayList<>(returnWeatherData());
		ITemperature maxTemp = null;
		int i = 0;
		while(maxTemp == null) //grabs first country with from tempData with conditions
		{
			if(tempData.get(i).getCountry().equals(country) 
					&& tempData.get(i).getMonth().equals(months.get(month)))
					{
						maxTemp = tempData.get(i);
					}
			i++;
		}

		for(ITemperature te : tempData) //finds the max temperature out of the objects in tempData
		{
			if(te.getCountry().equals(country) 
					&& te.getMonth().equals(months.get(month))
				&& te.getTemperature(false) > maxTemp.getTemperature(false))
			{
				maxTemp = te;
			}
		}
		return maxTemp;
	}

	//TaskA2
	public ITemperature getLowestTempByYear(String country, int year)
	{
		ArrayList<ITemperature> tempData = new ArrayList<>(returnWeatherData());
		ITemperature minTemp = null;
		int i = 0;
		while(minTemp == null) //grabs first country with from tempData with conditions
		{
			if(tempData.get(i).getCountry().equals(country) 
					&& tempData.get(i).getYear() == year)
					{
						minTemp = tempData.get(i);
					}
			i++;
		}

		for(ITemperature te : tempData) //finds the min temperature out of the objects in tempData
		{
			if(te.getCountry().equals(country) 
					&& te.getYear() == year 
				&& te.getTemperature(false) < minTemp.getTemperature(false))
			{
				minTemp = te;
			}
		}
		return minTemp;
	}

	public ITemperature getHighestTempByYear(String country, int year)
	{
		ArrayList<ITemperature> tempData = new ArrayList<>(returnWeatherData());
		ITemperature maxTemp = null;
		int i = 0;
		while(maxTemp == null) //grabs first country with from tempData with conditions
		{
			if(tempData.get(i).getCountry().equals(country) 
					&& tempData.get(i).getYear() == year)
					{
						maxTemp = tempData.get(i);
					}
			i++;
		}

		for(ITemperature te : tempData) //finds the max temperature out of the objects in tempData
		{
			if(te.getCountry().equals(country) 
					&& te.getYear() == year 
				&& te.getTemperature(false) > maxTemp.getTemperature(false))
			{
				maxTemp = te;
			}
		}
		return maxTemp;
	}
	
	//TaskA3
	public TreeSet<ITemperature> getTempWithinRange(String country, double rangeLowTemp, double rangeHighTemp)
	{
		TreeSet<ITemperature> treeTempRanged = new TreeSet<>();
		ArrayList<ITemperature> ArrayTempRanged = new ArrayList<>(returnWeatherData());
		
		for(ITemperature te : ArrayTempRanged) //adds temperature objects to treeset from arraylist using the temperature bounds
		{
			if(te.getCountry().equals(country) 
				&& te.getTemperature(false) >= rangeLowTemp 
				&& te.getTemperature(false) <= rangeHighTemp)
			{
				treeTempRanged.add(te);
			}
		}
		return treeTempRanged;
	}
	
	//TaskB4
	public ITemperature getLowestTempYearByCountry(String country)
	{
		ArrayList<ITemperature> tempData = new ArrayList<>(returnWeatherData());
		ITemperature minTemp = null;
		int i = 0;
		while(minTemp == null) //grabs first country with from tempData with conditions
		{
			if(tempData.get(i).getCountry().equals(country))
					{
						minTemp = tempData.get(i);
					}
			i++;
		}

		for(ITemperature te : tempData) //finds the min temperature out of the objects in tempData
		{
			if(te.getCountry().equals(country) && te.getTemperature(false) < minTemp.getTemperature(false))
			{
				minTemp = te;
			}
		}
		return minTemp;
	}

	public ITemperature getHighestTempYearByCountry(String country)
	{
		ArrayList<ITemperature> tempData = new ArrayList<>(returnWeatherData());
		ITemperature maxTemp = null;
		int i = 0;
		while(maxTemp == null) //grabs first country with from tempData with conditions
		{
			if(tempData.get(i).getCountry().equals(country))
					{
						maxTemp = tempData.get(i);
					}
			i++;
		}

		for(ITemperature te : tempData) //finds the max temperature out of the objects in tempData
		{
			if(te.getCountry().equals(country) && te.getTemperature(false) > maxTemp.getTemperature(false))
			{
				maxTemp = te;
			}
		}
		return maxTemp;
	}
	
	//TaskB1
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp(int month)
	{
		ArrayList<ITemperature> tempData = new ArrayList<>();
		ArrayList<ITemperature> tempMonth = new ArrayList<>();
		TreeSet<ITemperature> treeTemp = new TreeSet<>(returnWeatherData());
		for(ITemperature temp : treeTemp) //adds all data from treeTemp with the same month and ordered
		{
			if(temp.getMonth().equals(months.get(month)))
			{
				tempMonth.add(temp);
			}
		}
		
		tempData.add(tempMonth.get(0));
		int i = 1;
		int diffCountry = 0;
		
		while(tempData.size() < 10) //adds the first ten objects from tempMonth from unique countries
		{
			for(int j = 0; j < tempData.size(); j++)
			{
				if(!tempMonth.get(i).getCountry().equals(tempData.get(j).getCountry())) //if country from tempData is different from country from tempMonth, add a point
				{
					diffCountry++;
				}

			}
			if(diffCountry == tempData.size()) //algorithm to check if every country is unique, if diffCountry counter is equal to the size of the array
			{ //meaning that the country is unique, add it to the arraylist
				tempData.add(tempMonth.get(i));
			}
			diffCountry = 0;
			i++;
		}		
		
		return tempData;
	}

	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp(int month)
	{
		ArrayList<ITemperature> tempData = new ArrayList<>();
		ArrayList<ITemperature> tempMonth = new ArrayList<>();
		TreeSet<ITemperature> treeTemp = new TreeSet<>(returnWeatherData());
		for(ITemperature temp : treeTemp) //adds all data from treeTemp with the same month and ordered
		{
			if(temp.getMonth().equals(months.get(month)))
			{
				tempMonth.add(temp);
			}
		}
		
		tempData.add(tempMonth.get(0));
		int i = tempMonth.size() - 1; //sets the index to the last spot for the highest temperature values
		int diffCountry = 0;
		
		while(tempData.size() < 10) //adds the first ten objects from tempMonth from unique countries
		{
			for(int j = 0; j < tempData.size(); j++)
			{
				if(!tempMonth.get(i).getCountry().equals(tempData.get(j).getCountry()))
				{
					diffCountry++;
				}

			}
			if(diffCountry == tempData.size())//algorithm to check if every country is unique, if diffCountry counter is equal to the size of the array
			{ //meaning that the country is unique, add it to the arraylist
				tempData.add(tempMonth.get(i));
			}
			diffCountry = 0;
			i--;
		}		
		
		TreeSet<ITemperature> treeSort = new TreeSet<>(tempData); //reverses the array to sort from lowest to highest
		ArrayList<ITemperature> tempDataTwo = new ArrayList<>(treeSort);
		return tempDataTwo;
	}
	
	//B2
	public ArrayList<ITemperature> allCountriesGetTop10LowestTemp()
	{
		ArrayList<ITemperature> tempData = new ArrayList<>();
		TreeSet<ITemperature> treeTemp = new TreeSet<>(returnWeatherData());
		ArrayList<ITemperature> tempOrdered = new ArrayList<>(treeTemp);
		
		tempData.add(tempOrdered.get(0));
		int i = 1;
		int diffCountry = 0;
		
		while(tempData.size() < 10) //adds the first ten objects from tempMonth from unique countries
		{
			for(int j = 0; j < tempData.size(); j++)
			{
				if(!tempOrdered.get(i).getCountry().equals(tempData.get(j).getCountry()))
				{
					diffCountry++;
				}

			}
			if(diffCountry == tempData.size()) //different country algorithm
			{
				tempData.add(tempOrdered.get(i));
			}
			diffCountry = 0;
			i++;
		}		
		
		return tempData;
	}

	public ArrayList<ITemperature> allCountriesGetTop10HighestTemp()
	{
		ArrayList<ITemperature> tempData = new ArrayList<>();
		TreeSet<ITemperature> treeTemp = new TreeSet<>(returnWeatherData());
		ArrayList<ITemperature> tempOrdered = new ArrayList<>(treeTemp);
		
		tempData.add(tempOrdered.get(0));
		int i = tempOrdered.size() - 1; //sets index to highest temperature object
		int diffCountry = 0;
		
		while(tempData.size() < 10) //adds first ten object
		{
			for(int j = 0; j < tempData.size(); j++)
			{
				if(!tempOrdered.get(i).getCountry().equals(tempData.get(j).getCountry()))
				{
					diffCountry++;
				}

			}
			if(diffCountry == tempData.size()) //diff country algorithm
			{
				tempData.add(tempOrdered.get(i));
			}
			diffCountry = 0;
			i--;
		}
		
		TreeSet<ITemperature> treeSort = new TreeSet<>(tempData);
		ArrayList<ITemperature> tempDataTwo = new ArrayList<>(treeSort);
		return tempDataTwo;
	}
	
	//B3	
	public ArrayList<ITemperature> allCountriesGetAllDataWithinTempRange(double lowRangeTemp, double highRangeTemp)
	{
		ArrayList<ITemperature> tempData = new ArrayList<>();
		TreeSet<ITemperature> treeTemp = new TreeSet<>(returnWeatherData());
		
		for(ITemperature temp : treeTemp) //adds temperature objects to arraylist using the set conditions
		{
			if(temp.getTemperature(false) >= lowRangeTemp && temp.getTemperature(false) <= highRangeTemp)
			{
				tempData.add(temp);
			}
		}
		
		return tempData;
	}
	
	//C1	
	public ArrayList<ITemperature> allCountriesTop10TempDelta(int month, int year1, int year2)
	{
		ArrayList<ITemperature> tempData = new ArrayList<>(returnWeatherData());
		ArrayList<ITemperature> filtered = new ArrayList<>();
		TreeSet<ITemperature> treeTemp = new TreeSet<>();
		for(ITemperature temp : tempData) //adds objects to arraylist using the set conditions
		{
			if(temp.getMonth().equals(months.get(month)) && (temp.getYear() == year1 || temp.getYear() == year2))
			{
				filtered.add(temp);
			}
		}
		
		
		for(int i = 0; i < filtered.size(); i+=2) //From every two indexes, find the difference and add it to treeTemp
		{
			double deltaTemperature = Math.abs(filtered.get(i+1).getTemperature(false) - filtered.get(i).getTemperature(false));
			int deltaYear = Math.abs(filtered.get(i+1).getYear()-filtered.get(i).getYear());
			ITemperature deltaTemp = new Temperature(deltaTemperature, deltaYear, filtered.get(i).getMonth(), filtered.get(i).getCountry(), filtered.get(i).getCountry3LetterCode());
			treeTemp.add(deltaTemp);
		}
		
		ArrayList<ITemperature> filteredDelta = new ArrayList<>(treeTemp);
		TreeSet<ITemperature> top10 = new TreeSet<>();
		
		
		for(int i = 0; i < 10; i++) //finds the top 10 out of the entire list
		{
			top10.add(filteredDelta.get((filteredDelta.size()- 1) - i));
		}
		
		ArrayList<ITemperature> top10LowToHigh = new ArrayList<>(top10);
		
		
		
		
		
		return top10LowToHigh;
	}


	public void runClimateAnalyzer() throws IOException
	{
		String fileName = "data/world_temp_2000-2016.csv"; //data file containing all temperature data
		ClimateAnalyzer weatherRunner = new ClimateAnalyzer(); //intializes ClimateAnalyzer to be able to read the data file.
		Scanner in = new Scanner(System.in); //allows for user input
		
		try //checks if file is valid. if it's not valid, the program will stop here.
		{
			weatherRunner.readDataFromFile(fileName);
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
		
		IOException invalidMonth = new IOException("Invalid input for month parameter."); //intializes types of user input errors
		IOException invalidYear = new IOException("Invalid input for year parameter.");
		IOException invalidTemperature = new IOException("Invalid input for temperature parameter.");
		IOException invalidCountry = new IOException("Invalid input for country parameter.");
		
		
		//TASK A1
		System.out.println("For task A1: Lowest Temperature and Highest Temperature, choose a month and country for each topic.");
		
		//Topic 1
		System.out.println("Topic 1: Low temperature");
		System.out.print("Choose a country: ");
		
		String country = in.nextLine();
		if(!weatherRunner.isValidCountry(country))
		{
			in.close();
			throw invalidCountry;
		}
		
		System.out.print("Choose a month (1-12): ");
		
		int month = 0;
		if(in.hasNextInt()) //checks for a valid month input
		{
			month = in.nextInt();
		}
		if(month < 1 || month > 12)
		{
			in.close();
			throw invalidMonth;
		}
		in.nextLine(); //"empties" scanner to allow input for next string
		
		
		//Topic 2
		System.out.println("Topic 2: High temperature");
		System.out.print("Choose a country: ");
		
		String country2 = in.nextLine();
		if(!weatherRunner.isValidCountry(country2))
		{
			in.close();
			throw invalidCountry;
		}
		System.out.print("Choose a month (1-12): ");
		
		int month2 = 0;
		if(in.hasNextInt()) //checks for a valid month input
		{
			month2 = in.nextInt();
		}
		if(month2 < 1 || month2 > 12)
		{
			in.close();
			throw invalidMonth;
		}
		in.nextLine();
		
		
		String taskA1File = "data/TaskA1_climate_info.csv"; //intializes file data using input given
		String taskA1Topic1 = "TaskA1: Lowest Temperature in "  + months.get(month) + " for " + country;
		String taskA1Topic2 = "TaskA1: Highest Temperature in "  + months.get(month2) + " for " + country2;
		ArrayList<ITemperature> A1Task1 = new ArrayList<>();
		ArrayList<ITemperature> A1Task2 = new ArrayList<>();
		
		A1Task1.add(weatherRunner.getLowestTempByMonth(country, month));
		A1Task2.add(weatherRunner.getHighestTempByMonth(country2, month2));
		
		
		weatherRunner.writeDataToFile(taskA1File, taskA1Topic1, A1Task1);
		weatherRunner.writeDataToFile(taskA1File, taskA1Topic2, A1Task2);
		System.out.println("Task Done!");
		
		
		System.out.println("");
		System.out.println(""); //skip 3 lines to make it easier to read
		System.out.println("");
		
		
		//TASK A2
		System.out.println("For task A2: Lowest Temperature and Highest Temperature, choose a year and country for each topic.");
		
		//Topic 1
		System.out.println("Topic 1: Low temperature");
		System.out.print("Choose a country: ");
		
		country = in.nextLine();
		if(!weatherRunner.isValidCountry(country))
		{
			in.close();
			throw invalidCountry;
		}
		
		System.out.print("Choose a year (2000-2016): ");
		
		int year = 0;
		if(in.hasNextInt()) //checks for a valid year input
		{
			year = in.nextInt();
		}
		if(year < 2000 || year > 2016)
		{
			in.close();
			throw invalidYear;
		}
		in.nextLine(); 
		
		
		//Topic 2
		System.out.println("Topic 2: High temperature");
		System.out.print("Choose a country: ");

		country2 = in.nextLine();
		if(!weatherRunner.isValidCountry(country2))
		{
			in.close();
			throw invalidCountry;
		}

		System.out.print("Choose a year (2000-2016): ");

		int year2 = 0;
		if(in.hasNextInt()) //checks for a valid year input
		{
			year2 = in.nextInt();
		}
		if(year2 < 2000 || year2 > 2016)
		{
			in.close();
			throw invalidYear;
		}
		in.nextLine(); 
		
		
		String taskA2File = "data/TaskA2_climate_info.csv";
		String taskA2Topic1 = "TaskA2: Lowest Temperature in "  + year + " for " + country;
		String taskA2Topic2 = "TaskA2: Highest Temperature in "  + year2 + " for " + country2;
		ArrayList<ITemperature> A2Task1 = new ArrayList<>();
		ArrayList<ITemperature> A2Task2 = new ArrayList<>();
		
		A2Task1.add(weatherRunner.getLowestTempByYear(country, year));
		A2Task2.add(weatherRunner.getHighestTempByYear(country2, year2));
		
		weatherRunner.writeDataToFile(taskA2File, taskA2Topic1, A2Task1);
		weatherRunner.writeDataToFile(taskA2File, taskA2Topic2, A2Task2);
		System.out.println("Task Done!");

		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		
		//Task A3
		System.out.println("For task A3: all temperature data between two bounds inclusive, choose temperature bounds(celcius) and country");
		
		//Topic 1
		System.out.print("Choose a country: ");
		
		country = in.nextLine();
		if(!weatherRunner.isValidCountry(country))
		{
			in.close();
			throw invalidCountry;
		}
		
		System.out.print("Choose lower bound for temperature: ");
		
		double lowTemp = -9999;
		if(in.hasNextDouble()) //checks for a valid month input
		{
			lowTemp = in.nextDouble();
		}
		if(lowTemp == -9999)
		{
			in.close();
			throw invalidTemperature;
		}
		
		System.out.print("Choose higher bound for temperature: ");
		
		double highTemp = -9999;
		if(in.hasNextDouble()) //checks for a valid month input
		{
			highTemp = in.nextDouble();
		}
		if(highTemp == -9999 || highTemp < lowTemp) //makes sure higher bound is greater than low bound
		{
			in.close();
			throw invalidTemperature;
		}
		in.nextLine();
		
		
		String taskA3File = "data/TaskA3_climate_info.csv";
		String taskA3Topic = "TaskA3: All Temperature Data that is between " + lowTemp + " and " + highTemp + " degrees Celcius in " + country;
		ArrayList<ITemperature> A3Task = new ArrayList<>(weatherRunner.getTempWithinRange(country, lowTemp, highTemp));
		
		weatherRunner.writeDataToFile(taskA3File, taskA3Topic, A3Task);
		System.out.println("Task Done!");

		
		System.out.println("");
		System.out.println(""); 
		System.out.println("");
		
		
		//Task A4
		System.out.println("For task A4: Lowest Temperature and Highest Temperature throughout 2000 - 2016, choose country for each topic.");
		
		//Topic 1
		System.out.println("Topic 1: Low temperature");
		System.out.print("Choose a country: ");
		
		country = in.nextLine();
		if(!weatherRunner.isValidCountry(country))
		{
			in.close();
			throw invalidCountry;
		}
		in.nextLine(); //press enter again to continue
		
		
		//Topic 2
		System.out.println("Topic 2: High temperature");
		System.out.print("Choose a country: ");
		
		country2 = in.nextLine();
		if(!weatherRunner.isValidCountry(country2))
		{
			in.close();
			throw invalidCountry;
		}
		in.nextLine();
		
		
		String taskA4File = "data/TaskA4_climate_info.csv";
		String taskA4Topic1 = "TaskA4: Lowest Temperature in " + country + " from 2000 - 2016";
		String taskA4Topic2 = "TaskA4: Highest Temperature in " + country2 + " from 2000 - 2016";
		ArrayList<ITemperature> A4Task1 = new ArrayList<>();
		ArrayList<ITemperature> A4Task2 = new ArrayList<>();
		
		A4Task1.add(weatherRunner.getLowestTempYearByCountry(country));
		A4Task2.add(weatherRunner.getHighestTempYearByCountry(country2));
		
		weatherRunner.writeDataToFile(taskA4File, taskA4Topic1, A4Task1);
		weatherRunner.writeDataToFile(taskA4File, taskA4Topic2, A4Task2);
		System.out.println("Task Done!");

		
		System.out.println("");
		System.out.println(""); 
		System.out.println("");
		
		//Task B1
		System.out.println("For task B1: Top 10 Lowest Temperature and Highest Temperature in Unique Countries, choose a month for each topic.");
		
		//Topic 1
		System.out.println("Topic 1: Low temperature");
		System.out.print("Choose a month: ");
		month = 0;
		if(in.hasNextInt()) //checks for a valid month input
		{
			month = in.nextInt();
		}
		if(month < 1 || month > 12)
		{
			in.close();
			throw invalidMonth;
		}
		in.nextLine();
		
		
		//Topic 2
		System.out.println("Topic 2: High temperature");
		System.out.print("Choose a month: ");
		month2 = 0;
		if(in.hasNextInt()) //checks for a valid month input
		{
			month2 = in.nextInt();
		}
		if(month2 < 1 || month2 > 12)
		{
			in.close();
			throw invalidMonth;
		}
		in.nextLine();
		
		
		String taskB1File = "data/TaskB1_climate_info.csv";
		String taskB1Topic1 = "TaskB1: Top 10 Lowest Temperatures in Unique Countries in " + months.get(month);
		String taskB1Topic2 = "TaskB1: Top 10 Highest Temperatures in Unique Countries in " + months.get(month);
		ArrayList<ITemperature> B1Task1 = new ArrayList<>(weatherRunner.allCountriesGetTop10LowestTemp(month));
		ArrayList<ITemperature> B1Task2 = new ArrayList<>(weatherRunner.allCountriesGetTop10HighestTemp(month));
		
		weatherRunner.writeDataToFile(taskB1File, taskB1Topic1, B1Task1);
		weatherRunner.writeDataToFile(taskB1File, taskB1Topic2, B1Task2);
		System.out.println("Task Done!");
		
		
		System.out.println("");
		System.out.println(""); 
		System.out.println("");
		
		
		//Task B2
		System.out.println("For task B2: Top 10 Lowest Temperature and Highest Temperature in Unique Countries, no input is needed");
		
		String taskB2File = "data/TaskB2_climate_info.csv";
		String taskB2Topic1 = "TaskB2: Top 10 Lowest Temperatures in Unique Countries";
		String taskB2Topic2 = "TaskB2: Top 10 Highest Temperatures in Unique Countries";
		ArrayList<ITemperature> B2Task1 = new ArrayList<>(weatherRunner.allCountriesGetTop10LowestTemp());
		ArrayList<ITemperature> B2Task2 = new ArrayList<>(weatherRunner.allCountriesGetTop10HighestTemp());
		
		weatherRunner.writeDataToFile(taskB2File, taskB2Topic1, B2Task1);
		weatherRunner.writeDataToFile(taskB2File, taskB2Topic2, B2Task2);
		System.out.println("Task Done!");
		
		
		System.out.println("");
		System.out.println(""); 
		System.out.println("");
		
		
		//Task B3
		System.out.println("For task B3: all temperature data between two bounds inclusive, choose temperature bounds(celcius)");
		
		System.out.print("Choose lower bound for temperature: ");
		
		lowTemp = -9999;
		if(in.hasNextDouble()) //checks for a valid month input
		{
			lowTemp = in.nextDouble();
		}
		if(lowTemp == -9999)
		{
			in.close();
			throw invalidTemperature;
		}
		
		System.out.print("Choose higher bound for temperature: ");
		
	    highTemp = -9999;
		if(in.hasNextDouble()) //checks for a valid month input
		{
			highTemp = in.nextDouble();
		}
		if(highTemp == -9999 || highTemp < lowTemp) //makes sure higher bound is greater than low bound
		{
			in.close();
			throw invalidTemperature;
		}
		in.nextLine();
		String taskB3File = "data/TaskB3_climate_info.csv";
		lowTemp = 10.0;
		highTemp = 40.0;
		String taskB3Topic = "TaskB3: All Temperature Data that is between " + lowTemp + " and " + highTemp + " degrees celcius";
		ArrayList<ITemperature> B3Task = new ArrayList<>(weatherRunner.allCountriesGetAllDataWithinTempRange(lowTemp, highTemp));
		
		weatherRunner.writeDataToFile(taskB3File, taskB3Topic, B3Task);
		System.out.println("Task Done!");

		
		System.out.println("");
		System.out.println(""); 
		System.out.println("");
		
		//TaskC1
		System.out.println("For task C1: Top 10 Temperature deltas, choose two years and a month");
		
		System.out.print("Choose a month(1-12): ");
		month = 0;
		if(in.hasNextInt()) 
		{
			month = in.nextInt();
		}
		if(month < 1 || month > 12)
		{
			in.close();
			throw invalidMonth;
		}
		
		System.out.print("Choose a year (2000-2016): ");
		
		year = 0;
		if(in.hasNextInt()) //checks for a valid year input
		{
			year = in.nextInt();
		}
		if(year < 2000 || year > 2016)
		{
			in.close();
			throw invalidYear;
		}
		
		System.out.print("Choose a year (2000-2016): ");
		
		year2 = 0;
		if(in.hasNextInt()) //checks for a valid year input
		{
			year2 = in.nextInt();
		}
		if((year2 < 2000 || year2 > 2016) || year2 == year) //checks for different year
		{
			in.close();
			throw invalidYear;
		}
		in.nextLine(); 
		
		
		
		String taskC1File = "data/TaskC1_climate_info.csv";
		String taskC1Topic = "TaskC1: Top 10 " + months.get(month) + " Temperature Deltas using " + year + " and " + year2 + " data";
		ArrayList<ITemperature> C1Task = new ArrayList<>(weatherRunner.allCountriesTop10TempDelta(month,year,year2));
		
		weatherRunner.writeDataToFile(taskC1File, taskC1Topic, C1Task);
		System.out.println("Task Done!");
		in.close();
	}


}
