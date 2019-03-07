package sistemFacturi;

import java.util.Iterator;

public class HyperMarket extends Magazin{
	
	String tip = "HyperMarket";
	
	public double calculScutiriTaxe(){
		double scutire = 0;
		double totalFacturaCuTaxe;
		double totalCuTaxe = getTotalCuTaxe();
		Iterator<Factura> facturi = vectorFacturi.iterator();
		while (facturi.hasNext()){
			Factura fact = facturi.next();
			totalFacturaCuTaxe = fact.getTotalCuTaxe();
			if(totalFacturaCuTaxe > totalCuTaxe/10) {
				scutire = 1;
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
