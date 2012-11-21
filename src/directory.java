import java.io.File;
import java.util.ArrayList;


public class directory {

	public File[] directoryfiles(String directory){
	
		File f = new File(directory);
		File[] fileArray = f.listFiles();
		
		return fileArray;
		
	}
	public ArrayList<File> searchFile(String directory, String find) {

		File f = new File(directory);
		
		File[] files = f.listFiles();
		ArrayList<File> matches = new ArrayList<File> ();
		if (files != null) {
			//System.out.println(find);
			for (int i = 0; i < files.length; i++) {
				//System.out.println("in der Schleife "+i);
				//System.out.println(files[i]);
				
				if (files[i].getName().contains(find)) { 
					matches.add(files[i]);
//					System.out.println("Eins gefunden: " + files[i]);
				}
//				if (files[i].isDirectory()) {
//					matches.addAll(searchFile(files[i], find)); 
//				}
			}
		}
		return matches;
	}

	
}
