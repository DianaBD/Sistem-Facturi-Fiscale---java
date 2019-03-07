package sistemFacturi;

public class MagazinFactory {

	public Magazin getInstanceMagazin(String magazinType){
	      if(magazinType == null){
	         return null;
	      }		
	      if(magazinType.equalsIgnoreCase("MiniMarket")){
	         return new MiniMarket();
	         
	      } else if(magazinType.equalsIgnoreCase("MediumMarket")){
	         return new MediumMarket();
	         
	      } else if(magazinType.equalsIgnoreCase("HyperMarket")){
	         return new HyperMarket();
	      }
	      
	      return null;
	   }

}
