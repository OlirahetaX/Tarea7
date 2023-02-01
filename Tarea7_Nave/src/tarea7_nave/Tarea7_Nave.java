package tarea7_nave;

import java.awt.Color;
import java.util.Date;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

public class Tarea7_Nave {
    
    public static Cabina c = new Cabina();
    public static Nave nave = new Nave();
    public static Ala ala = new Ala();
    public static Armamento arma = new Armamento();
    public static Propulsor propu = new Propulsor();
    
    public static void main(String[] args) {
        nave.setSerie(Integer.parseInt(JOptionPane.showInputDialog("""
                                            == Bienvenido a la nave nave espacial X-Wing Fighter == 
                                            
                                                                   Ingrese numero de Serie""")));
        nave.setNombre(JOptionPane.showInputDialog("""
                                                        NAVE
                                                   
                                                   Nombre"""));
        nave.setColor(JColorChooser.showDialog(null, "Color DE NAVE", Color.black));
        nave.setNumero(Integer.parseInt(JOptionPane.showInputDialog("""
                                                                            Nave
                                                                    
                                                                    Numero""")));
        nave.setFechaCrea(setFecha());
        settCabina(0);
        nave.setCabina(c);
        
        agregarAla(0, 0);
        
        int x= 0;
        while(x!=11){
            System.out.println(nave+"\n");
            x = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                    Nave mods
                                                             
                                                             1- Serie
                                                             2- Nombre
                                                             3- Color
                                                             4- Numero almacenado
                                                             5- Fecha de creacion
                                                             6- Cabina
                                                             7- Alas
                                                             8- Propulsores
                                                             9- CHOQUE
                                                             10- Agregar Propulsor
                                                             11- Salir"""));
                    menu(x);
        }
                
    }
    static void menu(int x){
        switch(x){
            case 1-> nave.setSerie(Integer.parseInt(JOptionPane.showInputDialog("Nuevo # serie")));
            case 2-> nave.setNombre(JOptionPane.showInputDialog("Nuevo nombre"));
            case 3-> nave.setColor(JColorChooser.showDialog(null, "Nuevo Color DE NAVE", Color.black));
            case 4-> nave.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Nuevo numero")));
            case 5-> nave.setFechaCrea(setFecha());
            case 6-> settCabina(Integer.parseInt(JOptionPane.showInputDialog("""
                                                                                    CABINA MODS
                                                                             1-> Peso
                                                                             2-> # Tripulantes"""))); 
            case 7-> {
                int a=nave.getAlas().size()+1;
                int z = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                                Alas Mods
                                                                           0- Agregar ala
                                                                           1- Longitud
                                                                           2- Peso
                                                                           3- Armamento"""));
                if (z>0) {
                    a = Integer.parseInt(JOptionPane.showInputDialog("Numero de Ala"));
                }
                if (z!=3) {
                    agregarAla(z, a);
                }else{
                    armamento(Integer.parseInt(JOptionPane.showInputDialog(a+ 1 + ")" + """
                                                                    ALA ARMAMENTO Mods
                                                             1- Nombre
                                                             2- Peso 
                                                             3- Poder de destruccion""")), a);
                }
            }
            case 8-> {
                if (nave.getPropulsores().size()>0 ){
                    
                    agregarPropu(Integer.parseInt(JOptionPane.showInputDialog("""
                                                                                Propulsores Mods
                                                                           1- Peso
                                                                           2- Material
                                                                           3- Velocidad""")), Integer.parseInt(JOptionPane.showInputDialog("# Propulsor")));
                }else{
                    JOptionPane.showMessageDialog(null,"NO hay propulsores");
                }                                                            
            }
            case 9-> JOptionPane.showMessageDialog(null, "  Indice de Destruccion ="+nave.choque());
            case 10-> agregarPropu(0, nave.getPropulsores().size());
        }
    }
    
    static void agregarPropu(int x, int a) {
        if (x == 0 || x == 1) {
            if (propu.setPeso(Double.parseDouble(JOptionPane.showInputDialog(a + 1 + ")" + """
                                                                                    PROPULSOR
                                                                               
                                                                               Peso""")))) {
                agregarPropu(1, a);
            }
        }
        if (x == 0 || x == 2) {
            propu.setMaterial(JOptionPane.showInputDialog(a + 1 + ")" + """ 
                                                                        PROPULSOR
                                                                               
                                                                      Material"""));
        }
        if (x == 0 || x == 3) {
            if (propu.setVelocidad(Double.parseDouble(JOptionPane.showInputDialog((a + 1 + ")" + """
                                                                                    PROPULSOR
                                                                                                 
                                                                                Velocidad"""))))){ 
                agregarPropu(3, a);
            }
        }
        if (x == 0) {
            nave.getPropulsores().add(propu);
        }
    }
    
    static void agregarAla(int x, int a) {
        int num = a;
        if (x == 0 || x == 1) {
            if(ala.setLongitud(Double.parseDouble(JOptionPane.showInputDialog(a+ 1 + ")" + """                                                                                
                                                                           ALA
                                                                       
                                                                       Longitud""")))){
                agregarAla(1, a);
            }
        }
        
        if (x == 0 || x == 2) {
            if (ala.setPeso(Double.parseDouble(JOptionPane.showInputDialog(a+ 1 + ")" + """
                                                                            ALA
                                                                       
                                                                       Peso""")))) {
                JOptionPane.showMessageDialog(null, "Peso no valido");
                agregarAla(2, a);
            }            
        }
        if (x == 0) {
            nave.getAlas().add(ala);
            armamento(0, a);
            ala.setArmamento(arma);
            
            
        }
        
    }
    
    static void armamento(int x, int a) {
        if (x == 0 || x == 1) {
            arma.setNombre(JOptionPane.showInputDialog(a + ")" + """
                                                                    ALA ARMAMENTO
                                                             
                                                             Nombre"""));
        }
        if (x == 0 || x == 2) {
            if (arma.setPeso(Double.parseDouble(JOptionPane.showInputDialog(a + ")" + """
                                                                    ALA ARMAMENTO
                                                             
                                                             Peso""")), nave.getAlas().get(a).getPeso())) {
                JOptionPane.showMessageDialog(null, "Peso no valido");
                armamento(2, a);
            }
        }
        System.out.println("[[[[[[[[[[[[[[[[[[[[[");
        if (x == 0 || x == 3) {
            if (arma.setPoder(Integer.parseInt(JOptionPane.showInputDialog(a+ ")" + """
                                                                    ALA ARMAMENTO
                                                             
                                                             Poder de destruccion""")))) {
                JOptionPane.showMessageDialog(null, "Poder de destruccion no valido");
                armamento(3, a);
            }
        }
        
    }
    
    public static Date setFecha() {
        boolean x = true;
        Date fecha = new Date();
        while (x) {
            int anio = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                            FECHA DE CREACION
                                                                    
                                                                    Anio"""));
            int mes = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                            FECHA DE CREACION
                                                                   
                                                                    Mes"""));
            int dia = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                            FECHA DE CREACION
                                                                    Dia"""));
            
            if (validarFecha(anio, mes, dia) == true) {
                fecha.setDate(dia);
                fecha.setMonth(mes);
                fecha.setYear(anio - 1900);
                x = false;
            } else {
                JOptionPane.showMessageDialog(null, "Fecha no valida");
            }
        }
        
        return fecha;
    }
    
    static boolean validarFecha(int anio, int mes, int dia) {
        boolean z = false;
        if (anio > 0 && mes > 0 && mes < 13 && dia > 0 && dia < 32) {
            z = true;
        }
        return z;
    }
    
    static void settCabina(int x) {
        int y = 0;
        
        if (x == 0 || x == 1) {
            while (y == 0) {
                y = c.setPeso(Double.valueOf(JOptionPane.showInputDialog("""
                                                                        CABINA
                                                                 
                                                                 Peso""")));
            }
            y = 0;
        }
        if (x == 0 || x == 2) {
            while (y == 0) {
                y = c.setTripulantes(Integer.parseInt(JOptionPane.showInputDialog("""
                                                                                        CABINA
                                                                                  
                                                                                  # Tripulantes""")));
            }
        }
        
    }
}
