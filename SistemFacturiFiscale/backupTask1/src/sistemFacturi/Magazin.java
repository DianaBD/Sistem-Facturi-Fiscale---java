package sistemFacturi;
import java.util.Vector;
import java.util.Iterator;

public abstract class Magazin {
	String nume;
	Vector<Factura> vectorFacturi = new Vector<Factura>();
	Vector<String> tariFurnizoare = new Vector<String>();
	Vector<String> categoriiProduse = new Vector<String>();
	
	public double getTotalFaraTaxe(){
		double total=0;
		Iterator<Factura> facturi = vectorFacturi.iterator();
		while(facturi.hasNext()){
			Factura fct = facturi.next();
			total = total + fct.getTotalFaraTaxe();
		}
		return total;
	}
	
	public double getTotalCuTaxe(){
		double total=0;
		Iterator<Factura> facturi = vectorFacturi.iterator();
		while(facturi.hasNext()){
			Factura fct = facturi.next();
			total = total + fct.getTotalCuTaxe();
		}
		return total;
	}
	
	public double getTotalTaraFaraTaxe(String tara){
		double total=0;
		Iterator<Factura> facturi = vectorFacturi.iterator();
		while(facturi.hasNext()){
			Factura fct = facturi.next();
			total = total + fct.getTotalTaraFaraTaxe(tara);
		}
		return total;
	}
	
	public double getTotalTaraCuTaxe(String tara){
		double total=0;
		Iterator<Factura> facturi = vectorFacturi.iterator();
		while(facturi.hasNext()){
			Factura fct = facturi.next();
			total = total + fct.getTotalTaraCuTaxe(tara);
		}
		return total;
	}
	
	public double getTotalCategorieCuTaxe(String categorie){
		double total=0;
		Iterator<Factura> facturi = vectorFacturi.iterator();
		while(facturi.hasNext()){
			Factura fct = facturi.next();
			total = total + fct.getTotalCategorieCuTaxe(categorie);
		}
		return total;
	}
	
	@Override
	public String toString(){
		String s = "" + nume +"\n\n";
		Iterator<Factura> it = vectorFacturi.iterator();
		while(it.hasNext()){
			s = s + it.next() + "\n";
		}
			
		s = s + "\n";
		return s;
	}
}
