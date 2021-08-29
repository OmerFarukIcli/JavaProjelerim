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
		
		/* Yesil Market alýþ-veriþ programý
		 * 
		 * 1. Adým: Ürünler ve fiyatlarý içeren listeleri oluþturunuz.
		 * 			No 	   Ürün 		  Fiyat
				   ====	 =======	 	=========
					00	 Domates   	 	 2.10 TL 
					01	 Patates   	 	 3.20 TL
					02	 Biber     	 	 1.50 TL
					03	 SoÄŸan      	 2.30 TL
					04	 HavuÃ§     	 3.10 TL
					05	 Elma      	   	 1.20 TL
					06	 Muz     	 	 1.90 TL
					07	 Ã‡ilek 	     6.10 TL
					08	 Kavun      	 4.30 TL
					09	 Üzüm     	 	 2.70 TL
					10	 Limon     	 	 0.50 TL
					
		 * 2. Adim: Kullanýcýdan ürün nosuna göre listeden Ürün seçmesini isteyiniz.
		 * 3. Adim: Kaç kg satýn almak istediðini sorunuz.
		 * 4. Adim: Alýnacak bu ürünleri sepete ekleyiniz ve Sepeti yazdýrýnýz.
		 * 5. Baþka bir Ürün alýp almak istemediðini sorunuz.
		 * 6. Eger devam etmek istiyorsa yeniden Ürün seçme kýsmýna yönlendiriniz.
		 * 7. Eger bitirmek istiyorsa Ödeme kýsmýna geliniz ve Ödeme sonrasýnda programý bitirinzi.
		 */
		Scanner scan = new Scanner(System.in);
		
		urunler.addAll(Arrays.asList("Domates","Patates","Biber","Sogan","Havuc",
				                     "Elma","Muz","Cilek","Kavun","Uzum","Limon"));
		
				
		fiyatlar.addAll(Arrays.asList(2.1, 3.2, 1.5, 2.3, 3.1, 1.2, 1.9, 6.1, 4.3, 2.7, 0.5));	
		String devam ;
		double toplamFiyat = 0.0;
		
		do {
			UrunListele();
			System.out.println("Ürünü numaraya gore seciniz:");
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
		System.out.println("No\t Ürünler \tFiyatlar");
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
