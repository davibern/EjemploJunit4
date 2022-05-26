package numerocomplejo.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import numerocomplejo.NumeroComplejo;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author davibern
 * @version 1.0
 */
public class NumeroComplejoTest {
    
    private NumeroComplejo numeroComplejo;
    private static StringBuilder sb;
    private static File file;
    private static FileWriter fileWriter;
    
    @BeforeClass
    public static void beforeClass() throws IOException {
        String text = "=============================\nInicio de las pruebas Junit 4\n=============================\n";
        System.out.println(text);
        sb = new StringBuilder();
        file = new File("LogComplejo.txt");
        file.createNewFile();
        fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.flush(); 
    }
    
    @AfterClass
    public static void afterClass() throws IOException {
        String text = "=============================\nFinal de las pruebas Junit 4\n=============================\n";
        System.out.println(text);
        sb.append("\n").append(text).append("\n");
        fileWriter.write(sb.toString());
        fileWriter.flush();
        fileWriter.close();
    }
    
    @Before
    public void before() {
        System.out.println("*-*-*-*-\n Before\n*-*-*-*-");
        numeroComplejo = new NumeroComplejo();
    }
    
    @Test
    public void testSumar() {
        String expected = "2.0+4.0i";
        String line = "---------------------------------------------------------------------------";
        String text = "\n" + line + "\nSuma: numcomplejo.sumarComplejos(3.0+2.0i, -1.0+2.0i) >>> (3.0+2.0i)+(-1.0+2.0i)\n" + line;
        sb.append(text);
        sb.append("\n").append(expected).append("\n");
        NumeroComplejo actual = new NumeroComplejo();
        NumeroComplejo numCom2 = new NumeroComplejo(3.0, 2.0);
        NumeroComplejo numCom3 = new NumeroComplejo(-1.0, 2.0);
        System.out.println(sb);
        Assert.assertEquals("testSuma() -> fallido", expected, actual.sumarNumeroComplejo(numCom2, numCom3).toString());
    }
    
    @Test
    public void testRestar() {
        String expected = "4.0+0.0i";
        String line = "---------------------------------------------------------------------------";
        String text = "\n" + line + "\nResta: numcomplejo.restarComplejos(3.0+2.0i, -1.0+2.0i) >>> (3.0+2.0i)-(-1.0+2.0i)\n" + line;
        sb.append(text);
        sb.append("\n").append(expected).append("\n");
        NumeroComplejo actual = new NumeroComplejo();
        NumeroComplejo numCom2 = new NumeroComplejo(3.0, 2.0);
        NumeroComplejo numCom3 = new NumeroComplejo(-1.0, 2.0);
        System.out.println(sb);
        Assert.assertEquals("testRestar() -> fallido", expected, actual.restarNumeroComplejo(numCom2, numCom3).toString());
    }
    
    @Test
    public void testMultiplicar() {
        String expected = "-7.0+4.0i";
        String line = "---------------------------------------------------------------------------";
        String text = "\n" + line + "\nMultiplicación: numcomplejo.multiplicarComplejos(3.0+2.0i, -1.0+2.0i) >>> (3.0+2.0i)*(-1.0+2.0i)\n" + line;
        sb.append(text);
        sb.append("\n").append(expected).append("\n");
        NumeroComplejo actual = new NumeroComplejo();
        NumeroComplejo numCom2 = new NumeroComplejo(3.0, 2.0);
        NumeroComplejo numCom3 = new NumeroComplejo(-1.0, 2.0);
        System.out.println(sb);
        Assert.assertEquals("testMultiplicar() -> fallido", expected, actual.multiplicarNumeroComplejo(numCom2, numCom3).toString());
    }
    
    public void testDividir() {
        String expected = "0.2-1.6i";
        String line = "---------------------------------------------------------------------------";
        String text = "\n" + line + "\nDivisión: numcomplejo.dividirComplejos(3.0+2.0i, -1.0+2.0i) >>> (3.0+2.0i)/(-1.0+2.0i)\n" + line;
        sb.append(text);
        sb.append("\n").append(expected).append("\n");
        NumeroComplejo actual = new NumeroComplejo();
        NumeroComplejo numCom2 = new NumeroComplejo(3.0, 2.0);
        NumeroComplejo numCom3 = new NumeroComplejo(-1.0, 2.0);
        System.out.println(sb);
        Assert.assertEquals("testDividir() -> fallido", expected, actual.dividirNumeroComplejo(numCom2, numCom3).toString());
    }
    
    @Test(expected = ArithmeticException.class)
    public void testIndeterminado() {
        String expected = "Ha ocurrido una excepción aritmética: Indeterminado";
        String line = "---------------------------------------------------------------------------";
        String text = "\n" + line + "\n" + expected + "\n" + line;
        sb.append(text);
        NumeroComplejo actual = new NumeroComplejo();
        NumeroComplejo numCom2 = new NumeroComplejo(3.0, 2.0);
        NumeroComplejo numCom3 = new NumeroComplejo(0.0, 0.0);
        System.out.println(sb);
        actual.dividirNumeroComplejo(numCom2, numCom3).toString();
    }
    
}
