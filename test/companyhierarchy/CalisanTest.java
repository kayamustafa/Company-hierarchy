/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package companyhierarchy;

import companyhierarchy.ReadTextFileCalisan;
import companyhierarchy.Calisan;
import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ka_ya
 */
public class CalisanTest {
    
    static Calisan [] tumCalisanlar;
    
    @BeforeClass  //Herşeyden önce çalışanlar dizisine ve direktörlerin altında çalışanlar dizilerine atama yapılıyor sonra test edilecek.
    public static void setup() {
        File dosya = new File("dosya.txt"); // Dosya nesnesi yaratılıyor.
        ReadTextFileCalisan reader = new ReadTextFileCalisan(dosya); //state design patternına ait nesne yaratılıyor.
        int numberOfLines = reader.getLineNumberOfFile();     //text dosyasındaki satır sayısı çekilip
        tumCalisanlar = new  Calisan[numberOfLines]; //bu sayı dizi oluştururken kullanılıyor.
        reader.readAndGenerateObjects(tumCalisanlar);
        
        for (Calisan tumCalisanlar1 : tumCalisanlar) {                          //iç içe iki for döngüsü içerisinde her çalışanın root sahasındaki
            for (Calisan tumCalisanlar2 : tumCalisanlar) {                      // isme bakılarak her çalışan kendi amiri olan direktörün
                if (tumCalisanlar1.getParent().equals(tumCalisanlar2.getAd())) {//altindaCalisanlar dizisine atılıyor.
                    tumCalisanlar2.calisanEkle(tumCalisanlar1);
                }
            }
        }
    }
  

    /**
     * Test of maliyetHesapla method, of class Calisan.
     */
    @Test
    public void testMaliyetHesapla() {
        System.out.println("maliyetHesapla");
        Calisan instance = tumCalisanlar[0];
        int expResult = 24000;
        int result = instance.maliyetHesapla();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getAd method, of class Calisan.
     */
    @Test
    public void testGetAd() {
        System.out.println("getAd");
        Calisan instance = tumCalisanlar[0];
        String expResult = "Mustafa";
        String result = instance.getAd();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getSoyad method, of class Calisan.
     */
    @Test
    public void testGetSoyad() {
        System.out.println("getSoyad");
        Calisan instance = tumCalisanlar[0];
        String expResult = "Turksever";
        String result = instance.getSoyad();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMaas method, of class Calisan.
     */
    @Test
    public void testGetMaas() {
        
        System.out.println("getMaas");
        Calisan instance = tumCalisanlar[0];
        int expResult = 5000;
        int result = instance.getMaas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getParent method, of class Calisan.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        Calisan instance = tumCalisanlar[0];
        String expResult = "Root";
        String result = instance.getParent();
        assertEquals(expResult, result);
        
    }
    
}
