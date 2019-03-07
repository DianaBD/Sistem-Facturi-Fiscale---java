package sistemFacturi;

import java.util.Iterator;

public class MiniMarket extends Magazin {

	String tip = "MiniMarket";
	
	public double calculScutiriTaxe(){
		double scutire = 0;
		double totalTaraCuTaxe;
		double totalCuTaxe = getTotalCuTaxe();
		Iterator<String> tari = tariFurnizoare.iterator();
		while (tari.hasNext()){
			String tara = tari.next();
			totalTaraCuTaxe=getTotalTaraCuTaxe(tara);
			if(totalTaraCuTaxe > totalCuTaxe/2) {
				scutire = 10;
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
