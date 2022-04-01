package companyhierarchy;

public interface Calisan {
    static final int arraySize = 20; //direktör nesnelerinde bulunan altindaCalisanlar dizisini oluştururken verilecek default boyut için tanımlanan sabit.
    public void altindaCalisanlar(); //çalışan nesnesi için altında çalışan kişileri listeleyecek metot.
    public int maliyetHesapla(); //ilgili çalışanın ve varsa altında çalışanların toplam maliyetini hesaplayan metot.
    public void maliyetYazdir(); //üstteki metotla hesaplanan maliyeti yazdıran metot.
    public String getAd();
    public String getSoyad();
    public int getMaas();
    public String getParent();
    public void calisanEkle(Calisan calisan); //bir çalışanın (direktörün) altindaCalisanlar dizisine parametre olarak verilen çalışanı ekleyen metot.
    
}
