package sistemFacturi;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;
import java.io.*;

public class Gestiune {
	
	private static Gestiune instance = null;
	public Vector<String> vectorTari = new  Vector<String>();
	public Vector<Produs> produse = new Vector<Produs>();
	public Vector<Magazin> magazine = new Vector<Magazin>();
	public TreeMap<String,TreeMap<String,Double>> taxe = new TreeMap<String,TreeMap<String,Double>>();
	
	private Gestiune(String produsetxt,String taxetxt,String facturitxt) throws IOException{
		
		//--------citire fisier "produse.txt"---------
		
		RandomAccessFile f = new RandomAccessFile(produsetxt,"r");
		String line = f.readLine();
		StringTokenizer st = new StringTokenizer(line," ");
		// se sare peste primele doua cuvinte
		st.nextToken();
		st.nextToken();	
		// se memoreaza tarile in ordine in vectorTari
		while(st.hasMoreTokens()){
			vectorTari.add(st.nextToken());
		}
		
		//se retin produsele in vectorProduse 
		line = f.readLine();
		while( line!=null){
			st = new StringTokenizer(line," ");
			String denumireProdus = st.nextToken();
			String categorieProdus = st.nextToken();
			Iterator<String> tari = vectorTari.iterator();
			while(tari.hasNext()){
				produse.add(new Produs(denumireProdus,categorieProdus,tari.next(),Double.parseDouble(st.nextToken())));
			}
			line = f.readLine();
		}
		f.close();
		
		//adaug tarile din vectorTari in dictionarul taxe
		Iterator<String> tari = vectorTari.iterator();
		while(tari.hasNext()){
			taxe.put(tari.next(),new TreeMap<String,Double>());
		}
		
		//------- citire fisier "taxe.txt" -------
		
		f = new RandomAccessFile(taxetxt,"r");
		//se sare peste prima linie
		line = f.readLine();
		line = f.readLine();
		
		//adaugare perechi (categorie,taxa) la dictionarul taxe
		while( line!=null){
			st= new StringTokenizer(line," ");
			String categorie = st.nextToken();
			tari = vectorTari.iterator();
			while(tari.hasNext()){
				taxe.get(tari.next()).put(categorie,Double.parseDouble(st.nextToken()));
			}
			line = f.readLine();
		}
		f.close();
		
		//------- citire fisier "facturi.txt" -------
		
		f = new RandomAccessFile(facturitxt,"r");
		line = f.readLine();
		
		String cuvant;
		Factura factura = null;
		Magazin magazin = null;
		MagazinFactory factory = new MagazinFactory();
		
		while(true){
			st = new StringTokenizer(line," :");
			cuvant = st.nextToken();
			if(cuvant.equals("Magazin")){
				magazin = factory.getInstanceMagazin(st.nextToken());
				magazin.nume = st.nextToken() ;
			}
			else if(cuvant.startsWith("Factura")){
				factura = new Factura(cuvant);
				
			}
			else {
				String denumireProdus = cuvant;
				String tara = st.nextToken();
				Double cantitate = Double.parseDouble(st.nextToken());
				
				//caut produsul curent in vectorProduse
				Iterator<Produs> it = produse.iterator();
				Produs produs =null;
				while(it.hasNext()){
					produs = it.next();
					if(produs.getDenumire().equals(denumireProdus) && produs.getTaraOrigine().equals(tara))
						break;
				}
				
				//caut taxa care se aplica produsului curent in dictionarul taxe
				Double taxa = taxe.get(tara).get(produs.getCategorie());
				//creez un obiect de tip ProdusComandat pe care sa il adaug la factura
				factura.vectorProduseComandate.add(new ProdusComandat(produs,taxa,cantitate));
				//daca tara sau categoria produsului nu apar in magazin.categoriiProduse sau magazin.tariFurnizoare, le adaug
				if(!magazin.categoriiProduse.contains(produs.getCategorie()));
					magazin.categoriiProduse.add(produs.getCategorie());
				if(!magazin.tariFurnizoare.contains(produs.getTaraOrigine()));
					magazin.tariFurnizoare.add(produs.getTaraOrigine());
			}
			
			line = f.readLine();
			if(line==null) break;
			if(line.isEmpty()||line.startsWith("Denumire"))
				line = f.readLine();
			
			if(line.startsWith("Factura")&&factura!=null)
				magazin.vectorFacturi.add(factura);
			
			if(line.startsWith("Magazin")&&factura!=null){
				magazin.vectorFacturi.add(factura);
				factura = null;
				
				magazine.add(magazin);
			}
		}
				
		f.close();
		magazin.vectorFacturi.add(factura);
		magazine.add(magazin);
	}
	
	public static Gestiune getInstanceGestiune(String produsetxt,String taxetxt,String facturitxt){
		try{
		if(instance==null)
			instance = new Gestiune(produsetxt,taxetxt,facturitxt);
		}
		catch (IOException e){
			 e.printStackTrace();
		}	
		return instance;
	}
	
	@Override
	public String toString(){
		String s ="";
		Iterator<Magazin> it = magazine.iterator();
		while(it.hasNext()){
			s = s + it.next().toString()+"\n";
		}
		s = s + "\n";
		
		return s;
	}

	void printTaxe(){
		for(Map.Entry<String,TreeMap<String,Double>> entry : taxe.entrySet()) {
			  System.out.println(entry.getKey());
			  TreeMap<String,Double> categorie = (TreeMap<String,Double>)entry.getValue();
			  for(Map.Entry<String,Double> subentry : categorie.entrySet())
				  System.out.println("        " + subentry.getKey() + " => " + subentry.getValue());
		}
	}
}
