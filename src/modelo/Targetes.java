
package modelo;

public class Targetes {
    
    private int Id;
    private String tipus;
    private String numero;
    private String titular;
    private int pin;

    public Targetes(int Id, String tipus, String numero, String titular, int pin) {
        this.Id = Id;
        this.tipus = tipus;
        this.numero = numero;
        this.titular = titular;
        this.pin = pin;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
    
    
    
}
