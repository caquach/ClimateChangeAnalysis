package climatechange;

import java.io.IOException;

public class ClimateAnalyzerRunner {

	public static void main(String[] args)
	{
		ClimateAnalyzer weatherFrom2000to2016 = new ClimateAnalyzer();
		
		try
		{
			weatherFrom2000to2016.runClimateAnalyzer();
		}
		catch(IOException x)
		{
			System.out.println(x.getMessage());
		}
		
	}
}
