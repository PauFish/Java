//Declaramos la clase Usuario
public class Usuario {
//Propiedades
private String nombre;
private int edad;
private String DNI;
	//Metodos de la clase Usuario
    public Usuario() { 
        this.nombre="";
        this.edad=0;
        this.DNI="";
        
    }
    
    public String getNombre() { 
        return nombre;
    }
    
    public void setNombre(String nombre) { 
        this.nombre = nombre;
    }
    
    public int getEdad() { 
        return edad;
    }
    
    public void setEdad(int edad) { 
        this.edad = edad;
    }
    
    public String getDni() { 
        return DNI;
    }
    
    public boolean setDNI(String DNI){
        //comprobamos si el DNI introducido coincide con este patron
        if(DNI.matches("^[0-9]{8}[a-zA-Z]$")
                || DNI.matches("^[0-9]{8}[-][a-zA-Z]$")){
            this.DNI=DNI;
            return true;
        }
        else{
            return false;
        }      
    }
    
    public String toString() {
        return "Nombre: " + this.nombre + ".\n" +
                "Edad: " + this.edad + ".\n"+
        		"DNI: " + this.DNI + ".";
    }

}
