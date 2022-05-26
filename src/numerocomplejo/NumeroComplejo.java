package numerocomplejo;

/**
 *
 * @author davibern
 * @version 1.0
 */
public class NumeroComplejo {
    
    private double real;
    private double imaginaria;
    
    public NumeroComplejo() {}
    
    public NumeroComplejo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginaria() {
        return imaginaria;
    }

    public void setImaginaria(double imaginaria) {
        this.imaginaria = imaginaria;
    }
    
    public NumeroComplejo sumarNumeroComplejo(NumeroComplejo n1, NumeroComplejo n2) {
        NumeroComplejo numeroComplejo = new NumeroComplejo();
        
        numeroComplejo.setReal(n1.getReal() + n2.getReal());
        numeroComplejo.setImaginaria(n1.getImaginaria() + n2.getImaginaria());
        
        return numeroComplejo;
    }
    
    public NumeroComplejo restarNumeroComplejo(NumeroComplejo n1, NumeroComplejo n2) {
        NumeroComplejo numeroComplejo = new NumeroComplejo();
        
        numeroComplejo.setReal(n1.getReal() - n2.getReal());
        numeroComplejo.setImaginaria(n1.getImaginaria() - n2.getImaginaria());
        
        return numeroComplejo;
    }
    
    public NumeroComplejo multiplicarNumeroComplejo(NumeroComplejo n1, NumeroComplejo n2) {
        NumeroComplejo numeroComplejo = new NumeroComplejo();
        
        double a = n1.getReal();
        double b = n1.getImaginaria();
        double c = n2.getReal();
        double d = n2.getImaginaria();
        
        numeroComplejo.setReal((a * c) - (b * d));
        numeroComplejo.setImaginaria((a * d) + (b * c));
        
        return numeroComplejo;
    }
    
    public NumeroComplejo dividirNumeroComplejo(NumeroComplejo n1, NumeroComplejo n2) {
        NumeroComplejo numeroComplejo = new NumeroComplejo();
        
        double a = n1.getReal();
        double b = n1.getImaginaria();
        double c = n2.getReal();
        double d = n2.getImaginaria();
        
        double dividendoReal = (a * c) + (b * d);
        double dividendoImaginario = (b * c) - (a * d);
        double divisor = (Math.pow(c, 2) + Math.pow(d, 2));
        
        if (divisor == 0) {
            throw new ArithmeticException("No es posible dividor por cero.");
        }
        
        if ((dividendoReal == 0 || dividendoImaginario == 0) && divisor == 0) {
            throw new ArithmeticException("Excepción por número indeterminado. Real o imaginario == 0 y divisor == 0");
        }
        
        numeroComplejo.setReal(dividendoReal / divisor);
        numeroComplejo.setImaginaria(dividendoImaginario / divisor);
        
        return numeroComplejo;
    }
    
    @Override
    public String toString() {
        if (this.imaginaria >= 0) {
            return this.real + "+" + this.imaginaria + "i";
        } else {
            return this.real + "-" + this.imaginaria + "i";
        }
    }
}
