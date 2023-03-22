
//Declaramos la clase Dinero
public abstract class Dinero {
	
	//propiedades de la clase dinero
	protected double dinero;
    protected String description;
 
    //Metodos de la clase dinero
    public double getDinero() {
        return dinero;
    }
    
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
