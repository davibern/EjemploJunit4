package calculadora;

/**
 *
 * @author davibern
 * @version 1.0
 */
public class Calculadora {
    
    private int ans;
    
    public Calculadora() {
        this.ans = 0;
    }
    
    public int ans() {
        return this.ans;
    }
    
    public void clear() {
        this.ans = 0;
    }
    
    public int add(int a, int b) {
        ans = a + b;
        return ans;
    }
    
    public int add(int v) {
        ans += v;
        return ans;
    }
    
    public int sub(int a, int b) {
        ans = a - b;
        return ans;
    }
    
    public int sub(int v) {
        ans -= v;
        return ans;
    }
    
    public int plus(int a, int b) {
        ans = a * b;
        return ans;
    }
    
    public int plus(int v) {
        ans = ans * v;
        return ans;
    }
    
    public int div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No es posible dividir por cero.");
        }
        ans = a / b;
        return ans;
    }
    
    public void addSleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
    }
    
}
