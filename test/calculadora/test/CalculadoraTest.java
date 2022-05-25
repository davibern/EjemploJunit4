package calculadora.test;

import calculadora.Calculadora;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.After;
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
public class CalculadoraTest {
    
    private Calculadora calculadora;
    private static StringBuilder sb;
    private static File file;
    private static FileWriter fileWriter;
    private static final String line = "---------------------------------------------------------------------------";
    
    /**
     * Método que se lanza antes de la ejecución de la clase
     * 
     * Se instancia el fichero de texto y se crea, y se empieza a añadir el texto de salida de las pruebas
     * 
     * @throws IOException Excepción de ficheros
     */
    @BeforeClass
    public static void beforeClass() throws IOException {
        String text = "=============================\nInicio de las pruebas Junit 4\n=============================\n";
        System.out.println("text");
        sb = new StringBuilder();
        file = new File("LogCalculadora.txt");
        file.createNewFile();
        fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.flush();
    }
    
    /**
     * Método qeu se lanza después de la ejecución de la clase
     * 
     * Se añade el texto final y se cierra el fichero
     * 
     * @throws IOException 
     */
    @AfterClass
    public static void afterClass() throws IOException {
        String text = "=============================\nFinal de las pruebas Junit 4\n=============================\n";
        System.out.println(text);
        sb.append("\n").append(text).append("\n");
        fileWriter.write(sb.toString());
        fileWriter.flush();
        fileWriter.close();
    }
    
    /**
     * Se ejecutará antes de cualquier otro método
     */
    @Before
    public void before() {
        System.out.println("before()");
        this.calculadora = new Calculadora();
    }
    
    /**
     * Se ejecutará después de una ejecución
     * 
     * En este caso limpio la calculadora (los cálculos que tenga)
     */
    @After
    public void after() {
        System.out.println("after()");
        calculadora.clear();
    }
    
    @Test
    public void testAdd() {
        System.out.println("add()");
        String text = "\n" + line + "\nAdd: 3 + 3 >>> 6\n" + line;
        sb.append(text).append("\n");
        int result = this.calculadora.add(3, 3);
        int expected = 6;
        Assert.assertEquals("Test add() correctamente", expected, result);
    }
    
    @Test
    public void testAnsAdd() {
        System.out.println("ansAdd()");
        String text = "\n" + line + "\nansAdd: 10 + 10 >>> 20\n" + line;
        sb.append(text).append("\n");
        this.calculadora.add(10, 10);
        int result = this.calculadora.ans();
        int expected = 20;
        Assert.assertEquals("Test ansAdd() correctamente", expected, result);
    }
    
    @Test
    public void testSub() {
        System.out.println("sub()");
        String text = "\n" + line + "\nSub: 20 - 5 >>> 15\n" + line;
        sb.append(text).append("\n");
        int result = this.calculadora.sub(20, 5);
        int expected = 15;
        Assert.assertEquals("Test sub() correctamente", expected, result);
    }
    
    @Test
    public void testAnsSub() {
        System.out.println("ansSub()");
        String text = "\n" + line + "\nansSub: 10 - 10 >>> 0\n" + line;
        sb.append(text).append("\n");
        this.calculadora.sub(10, 10);
        int result = this.calculadora.ans();
        int expected = 0;
        Assert.assertEquals("Test ansSub() correctamente", expected, result);
    }
    
    @Test
    public void testPlus() {
        System.out.println("plus()");
        String text = "\n" + line + "\nPlus: 2 * 2 >>> 4\n" + line;
        sb.append(text).append("\n");
        int result = this.calculadora.plus(2, 2);
        int expected = 4;
        Assert.assertEquals("Test plus() correctamente", expected, result);
    }
    
    @Test
    public void testAnsPlus() {
        System.out.println("ansPlus()");
        String text = "\n" + line + "\nansPlus: 2 * 2 >>> 4\n" + line;
        sb.append(text).append("\n");
        this.calculadora.plus(2, 2);
        int result = this.calculadora.ans();
        int expected = 4;
        Assert.assertEquals("Test ansPlus() correctamente", expected, result);
    }
    
    @Test
    public void testDiv() {
        System.out.println("testDiv");
        String text = "\n" + line + "\nDiv: 15 / 3 >>> 5\n" + line;
        sb.append(text).append("\n");
        int result = this.calculadora.div(15, 3);
        int expected = 5;
        Assert.assertEquals("Test div() correctamente", expected, result);
    }
    
    @Test(expected = ArithmeticException.class) 
    public void testDivZero() {
        String text = "\n" + line + "\ndivZero: 5 / 0 >>> err\n" + line;
        sb.append(text).append("\n");
        System.out.println("testDivZero");
        this.calculadora.div(5, 0);
    }
    
    @Test(timeout = 3000)
    public void testOperacion() {
        System.out.println("testOperacion");
        String text = "\n" + line + "\nOperacion: 3000 > 2000 >>> timeout\n" + line;
        sb.append(text).append("\n");
        this.calculadora.addSleep();
    }
}
