package sistemFacturi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;

public class MakeOut {

	public static void main(String[] args){
		Gestiune gestiune = Gestiune.getInstanceGestiune();
		
		try{
			MakeOut make = new MakeOut();
			make.write(gestiune);
		}
		catch(IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public void write(Gestiune gestiune)throws IOException{	
		File f = new File("out.txt");
		if (!f.exists())
			f.createNewFile();
		FileWriter fw = new FileWriter(f.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        DecimalFormat df = new DecimalFormat("#.####");
        df.format(0.912385);
        
        java.util.Collections.sort(gestiune.vectorTari);
        //java.util.Collections.sort(gestiune.magazine);
        //Collections.reverseOrder(gestiune.magazine);
        
        //-------- scriere MiniMarket ---------
        	
        Iterator<String> tari;
        Iterator<Magazin> magazine = gestiune.magazine.iterator();
        Magazin magazin = null;
        			
        bw.write("MiniMarket");
       	while(magazine.hasNext()){
       		magazin = magazine.next();
          	if(magazin instanceof MiniMarket){
           		bw.write("\n"+magazin.nume+"\n\nTotal"+" "+df.format(magazin.getTotalFaraTaxe()) +" "+ df.format(magazin.getTotalCuTaxe())+" "+df.format(((MiniMarket) magazin).getTotalCuTaxeScutite())+"\n\nTara\n");
           		tari = gestiune.vectorTari.iterator();
           		while(tari.hasNext()){            				
           			String tara = tari.next();
               		if(magazin.getTotalTaraFaraTaxe(tara)!=(double)0)
               			bw.write(tara+" "+df.format(magazin.getTotalTaraFaraTaxe(tara))+" "+ df.format(magazin.getTotalTaraCuTaxe(tara))+" "+df.format(((MiniMarket) magazin).getTotalTaraCuTaxeScutite(tara))+"\n");
               		else bw.write(tara+" 0\n");
               	}
           		Iterator<Factura> facturi = magazin.vectorFacturi.iterator();
                while(facturi.hasNext()){
                	Factura factura = facturi.next();
                	bw.write("\n"+factura.denumire+"\n\nTotal"+" "+df.format(factura.getTotalFaraTaxe())+" "+df.format(factura.getTotalCuTaxe())+"\n\nTara\n");
             
                	tari = gestiune.vectorTari.iterator();
                	while(tari.hasNext()){
                		String tara = tari.next();
                		if(factura.getTotalTaraFaraTaxe(tara)!=(double)0)
                			bw.write(tara+" "+df.format(factura.getTotalTaraFaraTaxe(tara))+" "+df.format(factura.getTotalTaraCuTaxe(tara))+"\n");
                		else
                			bw.write(tara+" 0\n");
                	}
                }
            }	
       	}
       		
       	//-------- scriere MediumMarket ---------
       	
        bw.write("\nMediumMarket");
        magazine = gestiune.magazine.iterator();
        magazin = null;
        while(magazine.hasNext()){
        magazin = magazine.next();
        	if(magazin instanceof MediumMarket){
                bw.write("\n"+magazin.nume+"\n\nTotal"+" "+df.format(magazin.getTotalFaraTaxe()) +" "+ df.format(magazin.getTotalCuTaxe())+" "+df.format(((MediumMarket) magazin).getTotalCuTaxeScutite())+"\n\nTara\n");
                
                tari = gestiune.vectorTari.iterator();
                while(tari.hasNext()){
                	String tara = tari.next();
                	if(magazin.getTotalTaraFaraTaxe(tara)!=(double)0)
                		bw.write(tara+" "+df.format(magazin.getTotalTaraFaraTaxe(tara))+" "+ df.format(magazin.getTotalTaraCuTaxe(tara))+" "+df.format(((MediumMarket) magazin).getTotalTaraCuTaxeScutite(tara))+"\n");
                	else bw.write(tara+" 0\n");
                }
                Iterator<Factura> facturi = magazin.vectorFacturi.iterator();
            	while(facturi.hasNext()){
            		Factura factura = facturi.next();
            		bw.write("\n"+factura.denumire+"\n\nTotal"+" "+df.format(factura.getTotalFaraTaxe())+" "+df.format(factura.getTotalCuTaxe())+"\n\nTara\n");
         
            		tari = gestiune.vectorTari.iterator();
            		while(tari.hasNext()){
            			String tara = tari.next();
            			if(factura.getTotalTaraFaraTaxe(tara)!=(double)0)
            				bw.write(tara+" "+df.format(factura.getTotalTaraFaraTaxe(tara))+" "+df.format(factura.getTotalTaraCuTaxe(tara))+"\n");
            			else
            				bw.write(tara+" 0\n");
            		}
            	}
            }
        }
        
        //-------- scriere HyperMarket ---------
        bw.write("\nHyperMarket");
        magazine = gestiune.magazine.iterator();
        magazin = null;
        while(magazine.hasNext()){
        	magazin = magazine.next();
        	if(magazin instanceof HyperMarket){
                bw.write("\n"+magazin.nume+"\n\nTotal"+" "+df.format(magazin.getTotalFaraTaxe()) +" "+ df.format(magazin.getTotalCuTaxe())+" "+df.format(((HyperMarket) magazin).getTotalCuTaxeScutite())+"\n\nTara\n");
                tari = gestiune.vectorTari.iterator();
                while(tari.hasNext()){
                	String tara = tari.next();
                	if(magazin.getTotalTaraFaraTaxe(tara)!=(double)0)
                		bw.write(tara+" "+df.format(magazin.getTotalTaraFaraTaxe(tara))+" "+ df.format(magazin.getTotalTaraCuTaxe(tara))+" "+df.format(((HyperMarket) magazin).getTotalTaraCuTaxeScutite(tara))+"\n");
                	else bw.write(tara+" 0\n");
                }
            	Iterator<Factura> facturi = magazin.vectorFacturi.iterator();
            	while(facturi.hasNext()){
            		Factura factura = facturi.next();
            		bw.write("\n"+factura.denumire+"\n\nTotal"+" "+df.format(factura.getTotalFaraTaxe())+" "+df.format(factura.getTotalCuTaxe())+"\n\nTara\n");
         
            		tari = gestiune.vectorTari.iterator();
            		while(tari.hasNext()){
            			String tara = tari.next();
            			if(factura.getTotalTaraFaraTaxe(tara)!=(double)0)
            				bw.write(tara+" "+df.format(factura.getTotalTaraFaraTaxe(tara))+" "+df.format(factura.getTotalTaraCuTaxe(tara))+"\n");
            			else
            				bw.write(tara+" 0\n");
            		}
            	}
            }
       }
       bw.close();
	}
	
}
