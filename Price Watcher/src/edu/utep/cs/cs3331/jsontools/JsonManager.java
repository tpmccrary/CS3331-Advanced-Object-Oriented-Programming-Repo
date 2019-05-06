package edu.utep.cs.cs3331.jsontools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import edu.utep.cs.cs3331.Item;

public class JsonManager {
	FileWriter file;
	FileWriter tempWriter;
	BufferedReader bufferedReader;
	String line = null;
	Boolean fileExist = false;
	
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
	
	public void readItemFromFile(String filename){
		return;
	}
	public void removeItemFromFile(Item item) {
		return;
	}
	

}
