import java.text.SimpleDateFormat;
import java.util.Date;

//JodaTimeLibrary

public class timestamp {
	
	public void generateDate(){
		
		SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.S" );
		try{
			Date start = df.parse("2011-05-15 12:55:24.4");
			
			Date end = df.parse("2011-05-15 15:55:24.4");
			
			Date rest = new Date("yyyy-MM-dd HH:mm:ss.S");
		
			System.out.println(""+rest.getTime());
		
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}

}
