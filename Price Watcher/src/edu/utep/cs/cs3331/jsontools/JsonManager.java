package edu.utep.cs.cs3331.jsontools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import org.json.simple.JSONObject;


import edu.utep.cs.cs3331.Item;

public class JsonManager {
	FileWriter file;
	FileWriter tempWriter;
	BufferedReader bufferedReader;
	String line = null;
	Boolean fileExist = false;
	
	int amountOfItems = 0;
	
	public JsonManager() throws IOException {
		/** Create new JSON file when JsonManager instance is created */
		//file = new FileWriter("myJson.json");
		//file = new FileWriter("tempFile.json");
		
	}
	/** This method will turn an item into a json instance */
	@SuppressWarnings("unchecked")
	public JSONObject toJson(Item item) {
		JSONObject jsonDetails = new JSONObject();
		jsonDetails.put("name", item.getItemName());
		jsonDetails.put("url", item.getUrl());
		jsonDetails.put("currentPrice", item.getCurrentPrice());
		jsonDetails.put("originalPrice", item.getOriginalPrice());
		jsonDetails.put("dateAdded", item.getDateAdded());
		
		return jsonDetails;
	}
	
	/** This method will read from a JSON object */
	public Item fromJson(JSONObject object) {
		String readItemName = (String) object.get("name");
		String readUrl = (String) object.get("url");
		Double readCurrentPrice = (Double) object.get("currentPrice");
		Double readOriginalPrice = (Double) object.get("originalPrice");
		String readDateAdded = (String) object.get("dateAdded");
		
		Item readItem = new Item(readItemName, readUrl, readCurrentPrice, readOriginalPrice, readDateAdded);
		
		return readItem;
	}
	
	public void writeIntoFile(Item item){
		
		// Check if file exist and write into temporary file
		try {
			FileReader fileReader = new FileReader("File.json");
			bufferedReader = new BufferedReader(fileReader);
			
			tempWriter = new FileWriter("tempfile.json");
			
			// Write everything into temporary file
			while((line = bufferedReader.readLine()) != null) {
				tempWriter.write(line);
			}
			tempWriter.flush();
		}
		
		
		// If not then create one and write item into then return
		catch(FileNotFoundException exception) {
			try {
				JSONObject jsonItem = toJson(item);
				
				FileWriter writer = new FileWriter("File.json");
				BufferedWriter filewriter1 = new BufferedWriter(writer);
				filewriter1.write(jsonItem.toString());

				filewriter1.newLine();
				
				filewriter1.flush();
				filewriter1.close();
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Unable to create new file");
				System.out.println("Ending method call");
				return;
			} catch (NullPointerException exception1) {
				System.out.println("NulPointerException Returned");
			}
			
		}
		
		catch(IOException exception) {
			System.out.println("Error reading file");
			return;
		}
		
		// Rewrite everything into the original file
		
		try {
			FileReader fileReader = new FileReader("tempFile.json");
			bufferedReader = new BufferedReader(fileReader);
			
			FileWriter writer = new FileWriter("File.json");
			BufferedWriter tempWriter = new BufferedWriter(writer);
		
			while((line = bufferedReader.readLine()) != null) {
				tempWriter.write(line);
			}
			
			// Write item to add
			JSONObject jsonItem = toJson(item);
			tempWriter.write(jsonItem.toString());
			tempWriter.newLine();
			tempWriter.flush();
			tempWriter.close();
		}
		catch(Exception exception) {
			System.out.println("Exception caught on second try statement...");
		}
	}
	
	public Item[] readItemsFromFile(){
		
		// max of 100 items
		Item[] itemArray = new Item[100];
		
		//JSONParser jsonParser = new JSONParser();
		
		try {
			FileReader fileReader = new FileReader("File.json");
			bufferedReader = new BufferedReader(fileReader);
			
			String scanString = "";
			
			while((line = bufferedReader.readLine()) != null) {
				int i=0;
				while(i < line.length()) {
					if(line.charAt(i) == '{') {
						//System.out.println("Found opening bracket");
					}
					while(line.charAt(i) != '}') {
						scanString += line.charAt(i);
						i++;
					}
					
					Item itemToAdd = getDetailsFromString(scanString);
					if(amountOfItems>=100) {
						System.out.println("Reached maximum amount of items");
						return null;
					}
					itemArray[amountOfItems] = itemToAdd;
					amountOfItems++;
					//System.out.println("Amount of items is at " + amountOfItems);
					
					
					//System.out.println("Found closing bracket");
					scanString = "";
					i++;
				}
			}
			
			//System.out.println("Found " + amountOfItems + " item(s) in file");
			
		}
		catch(FileNotFoundException exception) {
			System.out.println("No file found to load items");
			return null;
		}
		catch(IOException exception) {
			exception.printStackTrace();
			System.out.println("IOException");
			return null;
		}
		return itemArray;
	}
	
	public Item getDetailsFromString(String string) {
		String originalPrice = "";
		//System.out.println("Original Price: " + originalPrice);
		int i = 17;
		while(string.charAt(i) != ',')
		{
			originalPrice += string.charAt(i);
			i++;
		}
		
		String name = "";
		while(string.charAt(i) != ':') 
		{
			i++;
		}
		
		i++;
		i++;
		
		while(string.charAt(i) != '"')
		{
			name += string.charAt(i);
			i++;
		}
		
		while(string.charAt(i) != ':') 
		{
			i++;
		}
		i++;
		
		String currentPrice = "";
		while(string.charAt(i) != ',')
		{
			currentPrice +=string.charAt(i);
			i++;
		}
		
		while(string.charAt(i) != ':') 
		{
			i++;
		}
		i++;
		i++;
		
		String url = "";
		while(string.charAt(i) != '"')
		{
			url += string.charAt(i);
			i++;
		}
		
		
		while(string.charAt(i) != ':') 
		{
			i++;
		}
		
		i++;
		i++;
		
		String dateAdded = "";
		while(string.charAt(i) != '"')
		{
			dateAdded += string.charAt(i);
			i++;
		}
		
		url = removeSlashes(url);
		dateAdded = removeSlashes(dateAdded);
		
		return new Item(name, url, Double.parseDouble(currentPrice), Double.parseDouble(originalPrice), dateAdded);
	}
	
	String removeSlashes(String date) {
		String temp = "";
		for(int i=0; i<date.length(); i++) {
			if(date.charAt(i) == '\\') {
				continue;
			}
			temp+=date.charAt(i);
		}
		return temp;
	}
	public void removeItemFromFile(String url) {
		//TODO: Remove from file.
		
		int openBracketPosition = 0;
		
		//System.out.println("ENTERING METHOD TO TEST");
		FileReader filereader = null;
		try {
			/** Start reading the file */
			//System.out.println("CREATING FILEREADER");
			filereader = new FileReader("File.json");
			BufferedReader bufferedReader = new BufferedReader(filereader);
			
			int i = 0;
			/* Read the line */
			//System.out.println("ENTERING WHILE LOOP");
			line = bufferedReader.readLine();
			while(true) {
				
				String itemLine = "";
				
				while(i < line.length() && line.charAt(i) != '}') {
					itemLine+=line.charAt(i);
					i++;
				}
				if(i>=line.length()) {
					return;
				}
				
				//System.out.println("line is set to " + line);
				//System.out.println("itemLine is set to " + itemLine);
				//System.out.println("ENTERING findOpenBracketPosition(String)");
				openBracketPosition = findOpenBracketPosition(line, url);
				
				if(openBracketPosition == -1) {
					System.out.println("Item not found in line...");
					itemLine = "";
					i++;
				}
				else {
					//System.out.println("Opening bracket of item is " + openBracketPosition);
					break;
				}
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("File not found!");
		}
		
		String stringToWrite = "";
		
		try {
			
			boolean itemToAvoid = false;
			// Write into the temp file, but dont write the item that was deleted
			FileWriter tempWriter = new FileWriter("tempFile.json");
			
			FileReader fileReader = new FileReader("File.json");
			bufferedReader = new BufferedReader(fileReader);
			
			line = bufferedReader.readLine();
			//System.out.println("LINE IS SET TO :" + line);
			for(int i=0; i<line.length(); i++){
				//System.out.println("I IS AT : " + i);
				if(i==openBracketPosition) {
					//System.out.println("Item to avoid is set to true" );
					itemToAvoid = true;
				}
				if(itemToAvoid) {
					if(line.charAt(i) == '}') {
						//System.out.println("Item to avoid is set to false");
						itemToAvoid = false;
						i++;
					}
				}
				
				if(!itemToAvoid && i < line.length()) {
					//System.out.println("Currently Writing " + line.charAt(i));
					//System.out.println("Line length is " + line.length());
					tempWriter.write(line.charAt(i));
				}
			}
			
			tempWriter.close();
			
			FileWriter fileWriter = new FileWriter("File.json");
			
			fileReader = new FileReader("tempFile.json");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			
			
			line = bufferedReader.readLine();
			//System.out.println("LINE IS SET TO " + line);
			if(line == null) {
				System.out.println("Items file is empty");
				return;
			}
			//System.out.println("LENGTH OF LINE IS " + line.length());
			for(int i=0; i<line.length(); i++) {
				fileWriter.write(line.charAt(i));
			}
			
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Deleted item from file!");
		return;
	}
	public int findOpenBracketPosition(String jsonString, String url) {
		int urlStartIndex = 0;
		String currentUrl = "";
		
		/** Iterate through the string */
		for(int i=0; i<jsonString.length(); i++) {
			/** look for the "url": part */
			if(jsonString.substring(i, i+6).equals("\"url\":")) {
				//System.out.println("FOUND MATCH");
				/** Set the position of i so that it starts to read the url*/
				i+=7;
				/** Add to the currentUrl string */
				while(jsonString.charAt(i) != '"') {
					currentUrl+=jsonString.charAt(i);
					i++;
				}
				
				currentUrl = removeSlashes(currentUrl);
				/* If the url matches, traverse backwards until an open bracket is found */
				if(currentUrl.equals(url)) {
					//System.out.println("URL MATCHES");
					//TODO CONTINUE WORK HERE!!
					while(jsonString.charAt(i) != '{') {
						i--;
					}
					//System.out.println("Position of open bracket is " + i);
					return i;
					
				}
				else {
					//System.out.println("URL DOES NOT MATCH");
					//System.out.println("Given: " + url);
					//System.out.println("Looking for: " + currentUrl);
					currentUrl = "";
				}
			}
			//System.out.println("substring = " + jsonString.substring(i, i+6));
			
		}
		return -1;
	}
	public int getAmountOfItems() {
		return amountOfItems;
	}
	

}
