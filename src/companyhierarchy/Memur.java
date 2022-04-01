package companyhierarchy;
/*
Gerekli metot açıklamaları calisan interfaceinin içerisinde yapıldı.
*/
public class Memur implements Calisan{
    private String ad;
    private String soyad;
    private int maas;
    private String parent; //memurun, altında çalıştığı direktörünün adı.
    
    public Memur(String adSoyad, String maas, String parent) {
        String[] adVeSoyad = adSoyad.split(" ");
        this.ad = adVeSoyad[0];
        this.soyad = adVeSoyad[1];
        this.maas = Integer.parseInt(maas);
        this. parent = parent;   
    }
    

    public Memur(String adSoyad, int maas, String parent) {
        String[] adVeSoyad = adSoyad.split(" ");
        this.ad = adVeSoyad[0];
        this.soyad = adVeSoyad[1];
        this.maas = maas;
        this.parent = parent;
    }

    public Memur() {
    }
    
    @Override
    public void altindaCalisanlar() {
        System.out.println(this.toString());
    }

    @Override
    public void maliyetYazdir() {
        System.out.println(this.toString() + " adlı çalışanın maliyeti: " + this.maliyetHesapla() + " TL");
    }
    
    @Override
    public int maliyetHesapla(){
        return this.maas;
    }

    @Override
    public String getAd() {
        return ad;
    }

    @Override
    public String getSoyad() {
        return soyad;
    }
    

    @Override
    public int getMaas() {
        return maas;
    }

    public String getParent() {
        return parent;
    }
    

    public void setAdSoyad(String adSoyad) {
        String[] adVeSoyad = adSoyad.split(" ");
        this.ad = adVeSoyad[0];
        this.soyad = adVeSoyad[1];
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
    
    @Override
    public String toString() {
        return (this.ad + " " + this.soyad);
    }
    
    
    @Override
    public void calisanEkle(Calisan calisan){
        System.out.println("Memurların altına çalışan eklenemez!");
    }
}
