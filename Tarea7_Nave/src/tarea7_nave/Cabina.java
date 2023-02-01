package tarea7_nave;

public final class Cabina {

    private Double peso;
    private int tripulantes;

    public Cabina() {
    }

    public Cabina(Double peso, int tripulantes) {
        setPeso(peso);
        setTripulantes(tripulantes);
    }

    public Double getPeso() {
        return peso;
    }

    public int setPeso(Double peso) {
        int x = 0;
        if (peso> 0) {
            this.peso = peso;
            x = 1;
        }
        return x;
        
    }

    public int getTripulantes() {
        return tripulantes;
    }

    public int setTripulantes(int tripulantes) {
        int x = 0;
        if (tripulantes < 5 && tripulantes > 0) {
            this.tripulantes = tripulantes;
            x = 1;
        }
        return x;
    }

    @Override
    public String toString() {
        return " Peso = " + peso + " // tripulantes = " + tripulantes ;
    }

}
