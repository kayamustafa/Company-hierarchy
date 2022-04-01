package companyhierarchy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFileCalisan implements CalisanDataInterface{
    
    File file; //içinden verilerin çekileceği dosya.

    public ReadTextFileCalisan(File file) {
        this.file = file;
    }

    public ReadTextFileCalisan() {
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }
    
    
    @Override
    /*
    Bu metot, dosyadan okudğu her satırı virgüllerden bölerek bir diziye alır.
    Daha sonra diziye aldığı verileri kullanarak oluşturduğu Calisan nesnelerini 
    parametre olarak aldığı calisanArray dizisine atar.
    */
    public void readAndGenerateObjects(Calisan[] calisanArray){
        try{
            FileReader fileReader = new FileReader(this.file);
            String line;
            int lineNum = 0;
            
            BufferedReader br = new BufferedReader(fileReader);
            
            while ((line = br.readLine()) != null){
                String[] words = line.split(",");
                if(words[0].equals("D")){
                    calisanArray[lineNum] = new Direktor(words[1], words[2], words[3]);
                    lineNum++;
                }
                
                else if(words[0].equals("M")) { 
                    calisanArray[lineNum] = new Memur(words[1], words[2], words[3]);
                    lineNum++;
                }
                else
                    System.out.println("Calisan tipi 'M' veya 'D' olmalıdır! ");
            }
            
            br.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı!");
        }
        catch (IOException ex) {
            System.out.println("Dosyadan veri okunamadı!");
        }
    }
    
    public int getLineNumberOfFile(){ //dosyada kaç satırlık veri olduğunu döndüren metot.
        try{
            FileReader fileReader = new FileReader(this.file);
            int lineNum = 0;
            
            BufferedReader br = new BufferedReader(fileReader);
            
            while ((br.readLine()) != null){
                lineNum++;
            }
            br.close();
            return lineNum;
        }
        catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı!");
            return -1;
        }
        catch (IOException ex) {
            System.out.println("Dosyadan veri okunamadı!");
            return -1;
        }
    }
    
    public static int getLineNumberOfFile(File file){ // üstteki metodun statik versiyonu.
        try{
            FileReader fileReader = new FileReader(file);

            int lineNum = 0;
            
            BufferedReader br = new BufferedReader(fileReader);
            
            while ((br.readLine()) != null){
                lineNum++;
            }
            br.close();
            return lineNum;
        }
        catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadı!");
            return -1;
        }
        catch (IOException ex) {
            System.out.println("Dosyadan veri okunamadı!");
            return -1;
        }
    }
}
