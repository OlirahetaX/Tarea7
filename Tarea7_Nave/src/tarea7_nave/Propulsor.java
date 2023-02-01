package tarea7_nave;

public final class Propulsor {

    private double peso, velocidad;
    private String material;

    public Propulsor() {
    }

    public Propulsor(double peso, double velocidad, String material) {
        setPeso(peso);
        setVelocidad(velocidad);
        this.material = material;
    }

    public double getPeso() {
        return peso;
    }

    public boolean setPeso(double peso) {
        boolean x = true;
        if (peso > 0) {
            this.peso = peso;
            x = false;
        }
        return x;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public boolean setVelocidad(double velocidad) {
        boolean x = true;
        if (velocidad > 0) {
            this.velocidad = velocidad;
            x = false;
        }
        return x;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return " Peso = " + peso + " -> Velocidad = " + velocidad + " -> Material = " + material ;
    }

}
