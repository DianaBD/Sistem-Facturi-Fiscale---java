package sistemFacturi;
import java.util.*;


public class Factura {

	public String denumire;
	public Vector<ProdusComandat> vectorProduseComandate = new Vector<ProdusComandat>() ;
	
	public Factura(String den){
		denumire = den;
	}
	
	public double getTotalFaraTaxe(){
		double total=0;
		Iterator<ProdusComandat> produseComandate = vectorProduseComandate.iterator();
		while(produseComandate.hasNext()){
			ProdusComandat prcm = produseComandate.next();
			total = total + prcm.getCantitate() * prcm.getProdus().getPret();
		}
		return total;
	}
	
	public double getTotalCuTaxe(){
		double total=0;
		Iterator<ProdusComandat> produseComandate = vectorProduseComandate.iterator();
		while(produseComandate.hasNext()){
			ProdusComandat prcm = produseComandate.next();
			total = total + prcm.getCantitate() * prcm.getProdus().getPret() * (prcm.getTaxa()+100)/100;
		}
		return total;
	}
	
	public double getTaxe(){
		return getTotalCuTaxe()-getTotalFaraTaxe();
	}
	
	public double getTotalTaraFaraTaxe(String tara){
		double total=0;
		Iterator<ProdusComandat> produseComandate = vectorProduseComandate.iterator();
		while(produseComandate.hasNext()){
			ProdusComandat prcm = produseComandate.next();
			if(prcm.getProdus().getTaraOrigine().equals(tara)){
				total = total + prcm.getCantitate() * prcm.getProdus().getPret();
			}
		}
		return total;
	}
	
	public double getTotalTaraCuTaxe(String tara){
		double total=0;
		Iterator<ProdusComandat> produseComandate = vectorProduseComandate.iterator();
		while(produseComandate.hasNext()){
			ProdusComandat prcm = produseComandate.next();
			if(prcm.getProdus().getTaraOrigine().equals(tara)){
				total = total + prcm.getCantitate() * prcm.getProdus().getPret() * ( prcm.getTaxa()+100)/100;
			}
		}
		return total;
	}
	
	public double getTaxeTara(String tara){
		return getTotalTaraCuTaxe(tara)-getTotalTaraFaraTaxe(tara);
	}
	
	public double getTotalCategorieCuTaxe(String categorie){
		double total=0;
		Iterator<ProdusComandat> produseComandate = vectorProduseComandate.iterator();
		while(produseComandate.hasNext()){
			ProdusComandat prcm = produseComandate.next();
			if(prcm.getProdus().getCategorie().equals(categorie)){
				total = total + prcm.getCantitate() * prcm.getProdus().getPret() * ( prcm.getTaxa()+100)/100;
			}
		}
		return total;
	}
	
	@Override
	public String toString(){
		String s = denumire+"\n";
		Iterator<ProdusComandat> it = vectorProduseComandate.iterator();
		while(it.hasNext())
			s = s + it.next() + "\n";
		return s;
	}
}
