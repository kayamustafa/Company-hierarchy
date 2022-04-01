package companyhierarchy;

import java.util.Iterator;

public class CalisanIterator implements Iterator{
    
    private final Calisan[] calisanlar;
    private int index;

    public CalisanIterator(Calisan[] calisanlar) {
        this.calisanlar = calisanlar;
    }
    
    @Override
    public boolean hasNext() {
        if(index < calisanlar.length)
            return true;
        else
            return false;
    }

    @Override
    public Object next() {
        Calisan calisan = calisanlar[index];
        index++;
        
        return  calisan;
    }
    
    
    
}
