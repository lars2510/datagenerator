import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class xmlreader{
	
	SAXParserFactory factory = SAXParserFactory.newInstance();
	
	//SAXParser saxParser = factory.newSAXParser();
	
	
		DefaultHandler handler = new DefaultHandler() {
	 
			boolean broute = false;
			int irouts = 0;
			boolean btotalcosts = false;
			boolean btotaldistance = false;
			boolean btotalemissions = false;
			boolean btotaltraveltime = false;
			String[][] arouts = new String[4][5];
			boolean bsubroute = false;
			int subroutscounter = 0;
			int isubrouts = 0;
			boolean bsubcosts = false;
			boolean bsubdistance = false;
			boolean bsubemissions = false;
			boolean bsubtraveltime = false;
			boolean bsubtransport = false;
			boolean subname = false;
			boolean bstart= false;
			boolean bend = false;
			boolean substarttime = false;
			boolean subendtime = false;
			String[][] asubrouts = new String[50][9];

	 
			public void startElement(String uri, String localName,String qName, Attributes attributes) throws SAXException {
		 
				//System.out.println("Start Element :" + qName);
		 
				if (qName.equalsIgnoreCase("ROUTE")) {
					broute = true;
					irouts++;
					subroutscounter = 0;
				}
				
				if (qName.equalsIgnoreCase("TOTALCOSTS")) {
					btotalcosts = true;
				}
		 
				if (qName.equalsIgnoreCase("TOTALDISTANCE")) {
					btotaldistance = true;
				}
		 
				if (qName.equalsIgnoreCase("TOTALEMISSION")) {
					btotalemissions = true;
				}
		 
				if (qName.equalsIgnoreCase("TOTALTRAVELTIME")) {
					btotaltraveltime = true;
				}
				
				if(qName.equalsIgnoreCase("SUBROUTE")){
					bsubroute = true;
					isubrouts++;
					subroutscounter++;
				}
				if (qName.equalsIgnoreCase("COSTS")) {
					bsubcosts = true;
				}
		 
				if (qName.equalsIgnoreCase("DISTANCE")) {
					bsubdistance = true;
				}
		 
				if (qName.equalsIgnoreCase("EMISSION")) {
					bsubemissions = true;
				}
		 
				if (qName.equalsIgnoreCase("TRAVELTIME")) {
					bsubtraveltime = true;
				}
				
				if (qName.equalsIgnoreCase("TRANSPORTATION")){
					bsubtransport = true;
				}
				if (qName.equalsIgnoreCase("NAME")){
					subname = true;
				}
				if (qName.equalsIgnoreCase("STARTSITUATION")){
					bstart = true;
				}
				if (qName.equalsIgnoreCase("ENDSITUATION")){
					bend = true;
				}
				if (qName.equalsIgnoreCase("STARTTIME")){
					substarttime = true;
				}
				if (qName.equalsIgnoreCase("DUETIME")){
					subendtime = true;
				}
		 
			}
	 
			public void endElement(String uri, String localName, String qName) throws SAXException {
		 
				//System.out.println("End Element :" + qName);
				if(qName.equalsIgnoreCase("SUBROUTES")){
//					System.out.print(asubrouts);
					int y = irouts;
					y--;
					arouts[y][4] = ""+subroutscounter;
				}
				
				if(qName.equalsIgnoreCase("RESPONSE")){
//					System.out.print(arouts);
					dataanalyzer prepare = new dataanalyzer();
					//derzeit noch ueberpruefungsfunktion
					prepare.showdata(arouts, asubrouts);
				}
		 
			}
	 
			public void characters(char ch[], int start, int length) throws SAXException {
				
				if (broute) {
//					System.out.println("--- Routenalternative "+irouts+" ---");
					broute = false;
				}
					
				if (btotalcosts) {
//					System.out.println("Costs: " + new String(ch, start, length));
					int y = irouts;
					y--;
					arouts[y][0] = new String(ch, start, length);
					btotalcosts = false;
				}
		 
				if (btotaldistance) {
//					System.out.println("Distance: " + new String(ch, start, length));
					int y = irouts;
					y--;
					arouts[y][1] = new String(ch, start, length);
					btotaldistance = false;
				}
		 
				if (btotalemissions) {
//					System.out.println("Emissions: " + new String(ch, start, length));
					int y = irouts;
					y--;
					arouts[y][2] = new String(ch, start, length);
					btotalemissions = false;
				}
		 
				if (btotaltraveltime) {
//					System.out.println("Traveltime: " + new String(ch, start, length));
					int y = irouts;
					y--;
					arouts[y][3] = new String(ch, start, length);
					btotaltraveltime = false;
				}
				
				if (bsubroute) {
//					System.out.println("--- Subrouten "+isubrouts+" ---");
					bsubroute = false;
				}
					
				if (bsubcosts) {
//					System.out.println("Costs: " + new String(ch, start, length));
					int y = isubrouts;
					y--;
					asubrouts[y][0] = new String(ch, start, length);
					bsubcosts = false;
				}
		 
				if (bsubdistance) {
//					System.out.println("Distance: " + new String(ch, start, length));
					int y = isubrouts;
					y--;
					asubrouts[y][1] = new String(ch, start, length);
					bsubdistance = false;
				}
		 
				if (bsubemissions) {
//					System.out.println("Emissions: " + new String(ch, start, length));
					int y = isubrouts;
					y--;
					asubrouts[y][2] = new String(ch, start, length);
					bsubemissions = false;
				}
		 
				if (bsubtraveltime) {
//					System.out.println("Traveltime: " + new String(ch, start, length));
					int y = isubrouts;
					y--;
					asubrouts[y][3] = new String(ch, start, length);
					bsubtraveltime = false;
				}
				
				if (bsubtransport) {
//					System.out.println("Transport : " + new String(ch, start, length));
					int y = isubrouts;
					y--;
					asubrouts[y][4] = new String(ch, start, length);
					bsubtransport = false;
				}
				
				if (subname && bstart) {
//					System.out.println("Startort : " + new String(ch, start, length));
					int y = isubrouts;
					y--;
					asubrouts[y][5] = new String(ch, start, length);
					subname = false;
					bstart =false;
				}
				
				if (substarttime) {
//					System.out.println("Starttime : " + new String(ch, start, length));
					int y = isubrouts;
					y--;
					asubrouts[y][6] = new String(ch, start, length);
					substarttime = false;
				}
				
				if (subname && bend) {
//					System.out.println("Endort : " + new String(ch, start, length));
					int y = isubrouts;
					y--;
					asubrouts[y][7] = new String(ch, start, length);
					subname = false;
					bend=false;
				}
				
				if (subendtime) {
//					System.out.println("Endtime : " + new String(ch, start, length));
					int y = isubrouts;
					y--;
					asubrouts[y][8] = new String(ch, start, length);
					subendtime = false;
				}

			}
		};
}
