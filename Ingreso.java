//Propiedades de la clase Ingreso
public class Ingreso extends Dinero {
	//metodos de la clase Ingeso
	public Ingreso(double ingreso, String description) {
        this.dinero=ingreso;
        this.description=description;
    }
 
    public String toString() {
        return "Realizaste un ingreso de: " + this.description + ". Ingreso: " + this.dinero ;
    } 

}
