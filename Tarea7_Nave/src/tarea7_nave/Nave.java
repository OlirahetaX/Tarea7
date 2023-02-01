package tarea7_nave;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

public class Nave {

    private int serie;
    private String nombre;
    private Cabina cabina;
    private ArrayList<Ala> alas = new ArrayList();
    private ArrayList<Propulsor> propulsores = new ArrayList();
    private int numero;
    private Color color;
    private Date fechaCrea;

    public Nave() {
    }

    public Nave(int serie, String nombre, Cabina cabina, int numero, Color color, Date fechaCrea) {
        this.serie = serie;
        this.nombre = nombre;
        this.cabina = cabina;
        this.numero = numero;
        this.color = color;
        this.fechaCrea = fechaCrea;
    }

    public double choque() {
        double velo = 0;
        double pcabina = cabina.getPeso();
        double pala = 0;
        
        for (Ala ala : alas) {
            pala += ala.getPeso();
            pala += ala.getArmamento().getPeso();
        }
        
        double ppropulsor = 0;
        
        for (Propulsor p : propulsores) {
            ppropulsor += p.getPeso();
            velo += p.getVelocidad();
        }
        
        double peso = pcabina + pala + ppropulsor;
        
        double x=peso/velo;

    return x ;
}

public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cabina getCabina() {
        return cabina;
    }

    public void setCabina(Cabina cabina) {
        this.cabina = cabina;
    }

    public ArrayList<Ala> getAlas() {
        return alas;
    }

    public int setAlas(ArrayList<Ala> alas) {
        int x = 0;
        if (alas.size() < 4) {
            this.alas = alas;
            x = 1;
        }
        return x;
    }

    public ArrayList<Propulsor> getPropulsores() {
        return propulsores;
    }

    public int setPropulsores(ArrayList<Propulsor> propulsores) {
        int x = 0;
        if (this.propulsores.size() < 4) {
            this.propulsores = propulsores;
            x = 1;
        }
        return x;

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    @Override
public String toString() {
        return ">>> Nave X-Wing Fighter <<<" + "\n> # Serie = " + serie + "\n> Nombre = " + nombre + "\n> Cabina = " + cabina + "\n> Alas = " + alas + "\n> Propulsores = " + propulsores + "\n> Numero = " + numero + "\n> Color = " + color + "\n> Fecha de Creacion = " + fechaCrea ;
    }

}
