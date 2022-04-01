package companyhierarchy;

import java.io.File;

public class Deneme {

    public static void main(String[] args) {
        File dosya = new File("dosya.txt"); // Dosya nesnesi yaratılıyor.
        ReadTextFileCalisan reader = new ReadTextFileCalisan(dosya); //state design patternına ait nesne yaratılıyor.
        int numberOfLines = reader.getLineNumberOfFile();     //text dosyasındaki satır sayısı çekilip
        Calisan[] tumCalisanlar = new Calisan[numberOfLines]; //bu sayı dizi oluştururken kullanılıyor.
        reader.readAndGenerateObjects(tumCalisanlar); // text dosyasından okunan veriler kullanılarak çalışan nesneleri oluşturuluyor ve diziye atılıyor. 
        
        for (Calisan tumCalisanlar1 : tumCalisanlar) {                          //iç içe iki for döngüsü içerisinde her çalışanın root sahasındaki
            for (Calisan tumCalisanlar2 : tumCalisanlar) {                      // isme bakılarak her çalışan kendi amiri olan direktörün
                if (tumCalisanlar1.getParent().equals(tumCalisanlar2.getAd())) {//altindaCalisanlar dizisine atılıyor.
                    tumCalisanlar2.calisanEkle(tumCalisanlar1);
                }
            }
        }
        
        tumCalisanlar[0].maliyetYazdir();
        System.out.println("");
        System.out.println(tumCalisanlar[0].toString() + "adlı çalışanın emrinde çalışanlar listesi:");
        System.out.println("");
        tumCalisanlar[0].altindaCalisanlar();
        System.out.println("");
        tumCalisanlar[5].maliyetYazdir();
        
        System.out.println("");
        System.out.println(tumCalisanlar[5].toString() + " adlı çalışanın emrinde çalışanlar listesi:");
        System.out.println("");
        tumCalisanlar[5].altindaCalisanlar();   
        System.out.println("");
        
        tumCalisanlar[7].maliyetYazdir();
        
        
    }
}
