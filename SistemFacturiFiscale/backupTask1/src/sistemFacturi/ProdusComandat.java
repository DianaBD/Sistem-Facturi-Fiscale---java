package sistemFacturi;

public class ProdusComandat {

	private Produs produs;
	private double taxa;
	private double cantitate;
	
	public ProdusComandat(Produs pr,double tax,double cnt){
		setProdus(pr);
		setTaxa(tax);
		setCantitate(cnt);
	}
	
	private void setProdus(Produs pr) {
		produs=pr;	
	}
	
	public Produs getProdus(){
		return produs;
	}
	
	private void setTaxa(double tax) {
		taxa=tax;
	}
	
	public double getTaxa(){
		return taxa;
	}
	
	private void setCantitate(double cnt) {
		cantitate=cnt;
	}

	public double getCantitate(){
		return cantitate;
	}
	
	@Override
	public String toString(){
		return ""+produs+" "+"taxa:"+taxa+" "+"cant:"+cantitate;
	}
}
