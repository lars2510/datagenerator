import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.List;
import java.util.Random;



import javax.xml.parsers.SAXParser;

import mssql.MSSQLConnection;

import org.xml.sax.helpers.DefaultHandler;



public class main {

	public static void main(String[] args) {
		
		//Anzahl der zu generierenden Routen
		int routenzahl = 2;
		
		//Pfad der xml Datein
		String path="/Users/Christopher/Dropbox/JinengoRoutenGenerator/datagenerator";
		
		System.out.println("Starten sie eine Aktion mittels Zahl:");
		System.out.println(" ");
		System.out.println("1: CSV READER aufrufen");
		System.out.println("Daraufhin werden User & Destinations für XML Erstellung geladen. Und die Routendatenerstellung angeworfen");
		System.out.println(" ");
		System.out.println("2: DIRECTORY aufrufen");
		System.out.println("Daraufhin wird das Verzeichnis nach *.xml Datein durchsucht, die alle Nach und nach verarbeitet werden.");
		System.out.println("!!! Fuer den Schreibe Mechanismus existiert derzeit nur ein Dummy, Details: siehe Mail !!!");
		System.out.println(" ");
		System.out.println("Erwarte Eingabe");
		
		try{
			InputStreamReader input  = new InputStreamReader(System.in);
		    BufferedReader keyboardInput = new BufferedReader(input);
		    String eingabe;
		    eingabe = keyboardInput.readLine();
		    System.out.println("Sie haben "+Integer.parseInt(eingabe)+" gewaehlt!");
		    
		    if(Integer.parseInt(eingabe) == 1){
		    	
		    	csvreader user = new csvreader();
				csvreader destinations = new csvreader();
				
				java.util.Random random = new java.util.Random();
				
				
				List userresult = user.csvhandler("users.csv");
				List destinationresult = destinations.csvhandler("destinations.csv");
				
				
		    	for(int i = 0; i<userresult.size(); i++){
		    		
		    		for(int counter = 0; counter < routenzahl; counter++){
		    			String result = userresult.get(i).toString();
		    			
		    			String[] splitString = result.split(",");
			    		
			    		System.out.println("User: "+splitString[0]);
			    		System.out.println("Passwort: "+splitString[1]);
			    		
			    		int start = random.nextInt(23);
						int end = random.nextInt(23);
						
						while(start==end){
							end = random.nextInt(23);
				    	}
						
						System.out.println("Start: "+destinationresult.get(start).toString());
						System.out.println("Ziel: "+destinationresult.get(end).toString());
						
						String token;
						String content;
						
						System.out.println("---- Los gehts! ----");
						htmlreader readpage = new htmlreader();
						token = readpage.getToken(splitString[0], splitString[1]);
						
						int istart=0;
						int iend=0;
						
						if (token.contains("<return>")){
							istart = token.indexOf("<return>");
							iend= token.indexOf("</return>");
							
							System.out.println("start: "+istart+" ende: "+iend);
						}
						
						content = readpage.getRouteInfo(token.substring(istart+=8, iend),destinationresult.get(start).toString(),destinationresult.get(end).toString());
						
						xmlwriter writedatfile = new xmlwriter();
						String filename = writedatfile.schreiben(splitString[0], content);
								
						System.out.println("---- Fertig! ----");
		    		}	
		    	}		
		    }
		    else if(Integer.parseInt(eingabe) == 2){
		    	
		    	directory files = new directory();
				
				File[] datein = files.directoryfiles(path);
								
				List results = files.searchFile(path, ".xml");
				
				for(int i = 0; i<results.size(); i++){
		    		System.out.println("Eintrag "+i+": "+results.get(i));
		    		
		    		try{
		    			xmlreader readshit = new xmlreader();
		    			DefaultHandler handler = readshit.handler;
		    		
		    			SAXParser saxParser = readshit.factory.newSAXParser();
		    		
		    			saxParser.parse(results.get(i).toString(), handler);
		    		}
		    		catch(Exception e){
		    			e.printStackTrace();
		    		}
		    			
		    	}
				
				System.out.println("----- Ende -------");
		    	
		    }
		    else if(Integer.parseInt(eingabe) == 3){
		    	 
		    	try{
		    		String query = "SELECT ID FROM [JinengoOperationalCRM_Copy].[dbo].[JinengoUser]";
			    	 
			    	ResultSet res = MSSQLConnection.selectSomething(query);
			    	 
			    	while (res.next())
				        {
			    			String s = res.getString("ID");
			    		//	String n = res.getString("NACHNAME");
			    			System.out.println("User: " + s);
				        }
		    	}
		    	catch(Exception e){
		    		e.printStackTrace();
		    	}
		    	
		    }
		    else if(Integer.parseInt(eingabe) == 4){
		    	
		    	timestamp one = new timestamp();
		    	
		    	one.generateDate();
		    	
		    	
		    }
		    
		}
	    catch(IOException e){
	    	System.out.println(e);
	    }
		
		
	}

}
