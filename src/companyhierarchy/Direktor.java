package companyhierarchy;

public class Direktor implements Calisan{
    private int index; //direktörün altındaCalisanlar dizisinde o anda kaç kişi bulunduğunu gösteren dizi indeksi.
    private String ad;
    private String soyad;
    private int maas;
    private String parent; // direktörün, altında çalıştığı direktörün adı.
    private Calisan altindaCalisanlar[];

    public Direktor(String adSoyad, String maas, String parent) {
        String[] adVeSoyad = adSoyad.split(" ");
        this.ad = adVeSoyad[0];
        this.soyad = adVeSoyad[1];
        this.maas = Integer.parseInt(maas);
        this.parent = parent;
        altindaCalisanlar = new Calisan[arraySize];
        index = 0;
    }

    public Direktor(String adSoyad, int maas, String parent) {
        String[] adVeSoyad = adSoyad.split(" ");
        this.ad = adVeSoyad[0];
        this.soyad = adVeSoyad[1];
        this.maas = maas;
        this.parent = parent;
        this.altindaCalisanlar = new Calisan[arraySize];
        index = 0;
    }
    
    public Direktor() {
    }
    
    /* Before implementing iterator pattern.
    @Override
    public void altindaCalisanlar(){
        System.out.println(this.toString());
        for (int i = 0; i < index; i++) {
            this.altindaCalisanlar[i].altindaCalisanlar();
        }
    }
    
    @Override
    public int maliyetHesapla(){
        int toplamMaas = this.maas;
        for (int i = 0; i < index; i++){
            toplamMaas += this.altindaCalisanlar[i].maliyetHesapla();
        }
        
        return toplamMaas;
    }*/
    
    // After iterator pattern implemented.
    @Override
    public void altindaCalisanlar(){
        System.out.println(this.toString());
         CalisanIterator iter = this.getCalisanIterator();
         while(iter.hasNext()){
             Calisan calisan = (Calisan) iter.next();
             if(calisan != null)
                 calisan.altindaCalisanlar();
         }
        
    }   
    
    @Override
    public int maliyetHesapla(){
        int toplamMaas = this.maas;
        CalisanIterator iter = this.getCalisanIterator();
        while(iter.hasNext()){
            Calisan calisan = (Calisan) iter.next();
            if(calisan != null)
                toplamMaas += calisan.maliyetHesapla();
        }
        
        return toplamMaas;
    }
    
    
    
    @Override
    public void maliyetYazdir(){
        System.out.println(this.toString() + " adlı çalışanın maliyeti: " + this.maliyetHesapla() + " TL");
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

    @Override
    public String getParent() {
        return parent;
    }
    

    public CalisanIterator getCalisanIterator() { //iterator patternına ait iterator nesnesini almak için gerekli metot.
        return new CalisanIterator(this.altindaCalisanlar);
    }

    public int getIndex() {
        return index;
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
     

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return (this.ad + " " + this.soyad);
    }
    
    
    @Override
    public void calisanEkle(Calisan calisan){
        this.altindaCalisanlar[getIndex()] = calisan;
        setIndex(getIndex() + 1);
    }
    
    
   
}
