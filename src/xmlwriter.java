import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class xmlwriter {
	
	FileWriter writer;
	File file;
	
	public String schreiben(String user, String text){
		
		java.util.Date now = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("ddMMyyyy-HHmmss");
		String ausgabe = sdf.format(now);
		
		file = new File(user+ausgabe+".xml");
		String name = user+ausgabe+".xml";
		
		try{
			writer = new FileWriter(file, true);
			writer.write(text);
			writer.write(System.getProperty("line.separator"));
			writer.flush();
			writer.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return name;
		
		
	}

}
