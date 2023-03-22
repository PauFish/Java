import java.util.*;
//Declaramos la clase Cuenta
public class Cuenta {
	
	//Declaro sus propiedades
	private double saldo; 
    private Usuario usuario; 
    private List<Gasto> gastos; 
    private List<Ingreso>ingresos; 
 
    //Declaro sus métodos
    public Cuenta(Usuario usuario) {
        this.usuario=usuario;
        this.saldo=0;
        this.gastos=new ArrayList<Gasto>();
        this.ingresos=new ArrayList<Ingreso>();
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public double addIngresos(String description, double cantidad){
    	
        //El ingreso se añade al saldo
        Ingreso nuevoIngreso = new Ingreso(cantidad,description);
        this.ingresos.add(nuevoIngreso);
        this.saldo=this.saldo+cantidad;
        return saldo;
    }
    
    public double addGastos(String description, double cantidad){
        //El gasto se resta del saldo, si el saldo no es inferior a cero
        try{ 
            this.saldo = this.saldo-cantidad;
            if(this.getSaldo()<0){ 
            	//Si no hay saldo salta la excepcion
                throw new GastoException("No se pudo cobrar, quedaria la cuenta en numeros rojos, haz un ingreso antes de pasar de nuevo este gasto");
            }
        }catch(GastoException e){
            return -1;
        }
       
        Gasto nuevoGasto=new Gasto(cantidad,description);
        gastos.add(nuevoGasto);
        return saldo;
    }
    
    public List<Ingreso> getIngresos() {
        return ingresos;
    }
    
    public List<Gasto> getGastos() {
        return gastos;
    }
    
    public String toString(){
        return   this.usuario.getNombre() + ", Tienes: " + this.saldo;
    }
}
