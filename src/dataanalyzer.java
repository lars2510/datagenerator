
public class dataanalyzer {
	
	public void dataanalyzer(String[][] routs, String[][] subrouts){
		//PLATZHALTER
	}
	public void showdata(String[][] routs, String[][] subrouts){
		
		int teilstreckencounter = 0;
		
		for(int y=0; y<routs.length; y++){
			for(int x=0; x<routs[y].length; x++){
				
				if(routs[y][x].toString() != null){
					System.out.println(y+"-"+x+" = "+routs[y][x]);
				}
				
			}
			
			
			if(routs[y][4].toString() != null){
				
				int sroute = Integer.parseInt(routs[y][4].toString());
				int zahl = y;
				zahl++;
				System.out.println("Alternative "+zahl+" hat "+sroute+" Teilstrecken!");
				
				for(int ycounter =0; ycounter < sroute; ycounter++){
					for(int xcounter =0; xcounter < subrouts[teilstreckencounter].length; xcounter++ ){
						
						System.out.println("Teilstrecke "+teilstreckencounter+" "+subrouts[teilstreckencounter][xcounter]);
						
					}
					teilstreckencounter++;
				}
			}
			
		}
	}


}
