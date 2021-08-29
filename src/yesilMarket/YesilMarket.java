package yesilMarket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class YesilMarket {
	
	public static List <String> urunler = new ArrayList<>();  // Global
	public static List <Double> fiyatlar = new ArrayList<>();
	
	public static List <String> sepeteEklenenler = new ArrayList<>();
	public static List <Double> sepetKg = new ArrayList<>();
	public static List <Double> sepetFiyatlar = new ArrayList<>();
	
		
	public static void main(String[] args) {
		
		/* Yesil Market al��-veri� program�
		 * 
		 * 1. Ad�m: �r�nler ve fiyatlar� i�eren listeleri olu�turunuz.
		 * 			No 	   �r�n 		  Fiyat
				   ====	 =======	 	=========
					00	 Domates   	 	 2.10 TL 
					01	 Patates   	 	 3.20 TL
					02	 Biber     	 	 1.50 TL
					03	 Soğan      	 2.30 TL
					04	 Havuç     	 3.10 TL
					05	 Elma      	   	 1.20 TL
					06	 Muz     	 	 1.90 TL
					07	 Çilek 	     6.10 TL
					08	 Kavun      	 4.30 TL
					09	 �z�m     	 	 2.70 TL
					10	 Limon     	 	 0.50 TL
					
		 * 2. Adim: Kullan�c�dan �r�n nosuna g�re listeden �r�n se�mesini isteyiniz.
		 * 3. Adim: Ka� kg sat�n almak istedi�ini sorunuz.
		 * 4. Adim: Al�nacak bu �r�nleri sepete ekleyiniz ve Sepeti yazd�r�n�z.
		 * 5. Ba�ka bir �r�n al�p almak istemedi�ini sorunuz.
		 * 6. Eger devam etmek istiyorsa yeniden �r�n se�me k�sm�na y�nlendiriniz.
		 * 7. Eger bitirmek istiyorsa �deme k�sm�na geliniz ve �deme sonras�nda program� bitirinzi.
		 */
		Scanner scan = new Scanner(System.in);
		
		urunler.addAll(Arrays.asList("Domates","Patates","Biber","Sogan","Havuc",
				                     "Elma","Muz","Cilek","Kavun","Uzum","Limon"));
		
				
		fiyatlar.addAll(Arrays.asList(2.1, 3.2, 1.5, 2.3, 3.1, 1.2, 1.9, 6.1, 4.3, 2.7, 0.5));	
		String devam ;
		double toplamFiyat = 0.0;
		
		do {
			UrunListele();
			System.out.println("�r�n� numaraya gore seciniz:");
			int UrunNo = scan.nextInt();
			System.out.println("Agirlik giriniz:");
			double kg = scan.nextDouble();
			sepeteEkle(UrunNo, kg);
			toplamFiyat = Math.round(sepeteYazdir());
			System.out.println("Alis veris devam etmek istermisiniz:");
			devam = scan.next();
		}while(devam.equalsIgnoreCase("e"));
		
		Odeme(toplamFiyat);
		
	
	}
	
	public static void UrunListele() {
		System.out.println("No\t �r�nler \tFiyatlar");
		System.out.println("===\t ======== \t========");
		
		for (int i = 0; i<urunler.size(); i++) {
			System.out.println(" "+ i + "\t" + urunler.get(i) + "\t \t   " + fiyatlar.get(i));
		}
	}
	
	public static void sepeteEkle(int UrunNo, double kg) {
		sepeteEklenenler.add(urunler.get(UrunNo));
		sepetKg.add(kg);
		sepetFiyatlar.add(fiyatlar.get(UrunNo) * kg);
	}
	
	public static double sepeteYazdir() {
		
		double fiyatToplami = 0.0;
		double kgToplami = 0.0;
		
		System.out.println("Urun adi \tKG \tFiyati");
		System.out.println("=================================");
		for(int i=0 ; i < sepeteEklenenler.size() ; i++ ) {
			System.out.println(sepeteEklenenler.get(i) + "\t \t" + sepetKg.get(i) + "\t" + sepetFiyatlar.get(i));
			fiyatToplami +=  sepetFiyatlar.get(i);
			kgToplami += sepetKg.get(i);
		}
		
		System.out.println("=================================");
		System.out.println("\t TOPLAM:" + kgToplami + "\t" + fiyatToplami);
		
		return fiyatToplami;
	}
	
	public static void Odeme(double toplamFiyat){
		Scanner scan  = new Scanner(System.in);
		
		System.out.println("***********************************");
		System.out.println("************* ODEME ***************");
		System.out.println("ODENECEK TOPLAM FIYAT:" + toplamFiyat);
//		System.out.printf("ODENECEK TOPLAM FIYAT: %.2f", toplamFiyat);
		double nakit = 0.0;
		do {
			System.out.print("Lutfen Nakit Giriniz:");
			nakit += scan.nextDouble();
			if(nakit < toplamFiyat) {
				System.out.println("Girilen Rakam yetersiz.");
				System.out.println((toplamFiyat - nakit) + " TL daha yatirmaniz gerekmektedir.");
			}
		}while(nakit < toplamFiyat);
		
		double paraUstu = nakit - toplamFiyat;
		if (paraUstu > 0) {
			System.out.println("PARA USTU :" + paraUstu);
		}
		
		System.out.println("YINE BEKLERIZ");
		
	
	}
	
	
	
	
	
	

}
