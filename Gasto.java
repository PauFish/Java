
//Declaramos la clase Gasto
public class Gasto extends Dinero{
	
	//Metodos de la clase gasto
	public Gasto(double gasto, String description) {
        this.dinero=gasto;
        this.description=description;
    }
	
	public String toString() {
        return "Realizaste un gasto de: " + this.description + ". Gasto: " + this.dinero ;
    }  
}
