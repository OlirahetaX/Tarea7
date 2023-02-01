package tarea7_nave;

public final class Armamento{

    private String nombre;
    private double peso=0;
    private int poder;
    
            
    public Armamento(String nombre, double peso, int poder) {
        this.nombre = nombre;
        this.peso = peso;
        setPoder(poder);
    }

    public Armamento() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public boolean setPeso(double peso,double pesoala) {
        boolean x = true;
        if ((200-pesoala)>=peso) {
            this.peso = peso;
            x=false;
        }
        return x;
    }

    public int getPoder() {
        return poder;
    }

    public boolean setPoder(int poder) {
        boolean x = true;
        if (poder>0 && poder<11) {
           this.poder = poder; 
           x=false;
        }
        return x;
    }

    @Override
    public String toString() {
        return " Nombre = " + nombre + " -> Peso = " + peso + " -> poder = " + poder ;
    }
    
}
