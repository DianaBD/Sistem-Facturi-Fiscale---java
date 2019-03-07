package sistemFacturi;

public class Produs {

	private String denumire;
	private String categorie;
	private String taraOrigine;
	private double pret;
	
	public Produs(String den,String cat,String ta, double pr){
		setDenumire(den);
		setCategorie(cat);
		setTaraOrigine(ta);
		setPret(pr);
		
	}
	
	public void setDenumire(String den){
		denumire=den;
	}
	
	public String getDenumire(){
		return ""+denumire;
	}
	
	public void setCategorie(String cat){
		categorie=cat;
	}
	
	public String getCategorie(){
		return ""+categorie;
	}
	
	public void setTaraOrigine(String ta){
		taraOrigine=ta;
	}
	
	public String getTaraOrigine(){
		return ""+taraOrigine;
	}
	
	public void setPret(double pr){
		pret=pr;
	}
	
	public double getPret(){
		return pret;
	}
	
	@Override
	public String toString(){
		return denumire+"-"+categorie+"-"+taraOrigine+"-"+pret;
	}
	
}
