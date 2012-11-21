import java.math.BigInteger;


class routselector {
	
	private float sustainable;
	private float comftable;
	private float cost;
	
	public void getUserPref(BigInteger userID){
		
		String query = "SELECT sustainabilityPreference, comfortPreference, costsPreference FROM [JinengoOperationalCRM_Copy].[dbo].[Preferences] WHERE userID ="+userID;
		
	}
	
	public void choose(BigInteger userID){
		
		
		
	}
	

}
