package sistemFacturi;

import java.util.Iterator;

public class MediumMarket extends Magazin {

	String tip = "MediumMarket";
	
	public double calculScutiriTaxe(){
		double scutire = 0;
		double totalCategorieCuTaxe;
		double totalCuTaxe = getTotalCuTaxe();
		Iterator<String> categorii = categoriiProduse.iterator();
		while (categorii.hasNext()){
			String categorie = categorii.next();
			totalCategorieCuTaxe=getTotalCategorieCuTaxe(categorie);
			if(totalCategorieCuTaxe > totalCuTaxe/2) {
				scutire = 5;
			}
		}
		return scutire;
	}
	
	public double getTotalCuTaxeScutite(){
		return getTotalCuTaxe() *(100-calculScutiriTaxe())/100;
	}
	
	public double getTotalTaraCuTaxeScutite(String tara){
		
		return getTotalTaraCuTaxe(tara) *(100-calculScutiriTaxe())/100;
	}

}
