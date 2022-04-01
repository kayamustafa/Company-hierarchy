/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package companyhierarchy;

import companyhierarchy.ReadTextFileCalisan;
import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ka_ya
 */
public class ReadTextFileCalisanTest {
    
    static ReadTextFileCalisan reader;
    
    @BeforeClass
    public static void setup(){
        File dosya = new File("dosya.txt"); // Dosya nesnesi yaratılıyor.
        reader = new ReadTextFileCalisan(dosya); //state design patternına ait nesne yaratılıyor.
    }

    /**
     * Test of getLineNumberOfFile method, of class ReadTextFileCalisan.
     */
    @Test
    public void testGetLineNumberOfFile() {
        System.out.println("getLineNumberOfFile");
        int expResult = 12;
        int numberOfLines = reader.getLineNumberOfFile();
        assertEquals(expResult, numberOfLines);
  
    }

    
    
}
