package tarea7_nave;

public final class Ala {

    
    private double peso=0;
    private double longitud;
    private Armamento armamento=new Armamento();

    public Ala() {
    }

    public Ala(double peso, double longitud, Armamento armamento) {
        setPeso(peso);
        setLongitud(longitud);
        this.armamento = armamento;
    }

    public double getPeso() {
        return peso;
    }

    public boolean setPeso(double peso) {
        boolean x=true;
        if (peso+armamento.getPeso()<=200 && peso>0) {
           this.peso = peso; 
           x=false;
        }
        return x;
    }

    public double getLongitud() {
        return longitud;
    }

    public boolean setLongitud(double longitud) {
        boolean x = true;
        if (longitud>0) {
           this.longitud = longitud; 
           x=false;
        }
        return x;
    }

    public Armamento getArmamento() {
        return armamento;
    }

    public void setArmamento(Armamento armamento) {
        this.armamento = armamento;
    }

    @Override
    public String toString() {
        return "Peso = " + peso + " // Longitud = " + longitud + " // Armamento = " + armamento +"\n";
    }
    

}
