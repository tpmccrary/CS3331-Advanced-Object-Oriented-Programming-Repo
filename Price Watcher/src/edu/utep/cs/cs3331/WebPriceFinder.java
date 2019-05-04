package edu.utep.cs.cs3331;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;


/**
* Class that updates price of items.
*
* @author Timothy P. McCrary
*/
public class WebPriceFinder extends PriceFinder
{
	/** Returns random price for an item.
	 * 
	 * @param givenUrl The URL where the price will be searched.
	 * @return Item price.
	 * */
	public static double findPrice(String givenUrl)
	{
		HttpURLConnection con = null;
		try 
		{
			URL url = new URL(givenUrl);
			con = (HttpURLConnection) url.openConnection();
			// con.setRequestProperty("User-Agent", "...");
			String encoding = con.getContentEncoding();
			if (encoding == null) 
			{ 
				encoding = "utf-8"; 
			}
			InputStreamReader reader = null;
			if ("gzip".equals(encoding)) 
			{ // gzipped document?
				reader = new InputStreamReader(new GZIPInputStream(con.getInputStream()));
			} 
			else 
			{
				reader = new InputStreamReader(con.getInputStream(), encoding);
			}
			BufferedReader in = new BufferedReader(reader);
			String line;
			
			//Pattern pattern = Pattern.compile("(?<!(?:\\d|\\.))\\d+\\.\\d{2}(?!\\.)");
			Pattern pattern = Pattern.compile("\\$(\\d+[[\\.,\\s]\\d+]*)");
			
			while ((line = in.readLine()) != null) 
			{
				//System.out.println(line);
				Matcher matcher = pattern.matcher(line);
				
				 if (matcher.find())
				    {
				        String match = matcher.group();

				        // proceed post treatments to convert the String to a Double
				        // delete space from price if any
				        if (match.contains(" "))
				            match = match.replace(" ", "");

				        if (match.contains(","))
				        {
				            // price contains one comma and one dot: price format is something like that : 1,000,000.00
				            // OR
				            // there is more than one comma in the price (price is something like that 1,000,000)
				            // so delete the , from price
				            if (match.contains(".") || match.length() - match.replace(",", "").length() > 1)
				                match = match.replace(",", "");
				            // price simply use a comma to mark the decimal part, replace it by a . for Double.parseDouble method.
				            else
				                match = match.replace(",", ".");
				        }
				        
				        if (match.contains("$"))
				        {
				        	match = match.replace("$", "");
				        }
				        //System.out.println(line);
				        
				        return Double.parseDouble(match);
				    }
				
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace(); 
		} 
		finally 
		{
			if (con != null) 
			{  
				con.disconnect(); 
			}
		}
		//System.out.println("got to last return");
		return -1.00;

	}
	
}
