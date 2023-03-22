import java.util.Scanner;

public class Main {
	//Declaramos todas las propiedades a utilizar
    //Leer datos por teclado
    private static final Scanner lee = new Scanner(System.in);
    
  //Almacena usuario.
    private static Usuario nuevoUsuario = new Usuario();
    
    //Almacena el nombre del usuario
    private static String nombreUsuario="";
    
    //Almacena la edad del usuario
    private static String anyosUsuario="";
    
    //Almacena la edad del usuario en numerico
    private static byte edadUsuario=-1;
    
    //Almacena el dni del usuario
    private static String dniUsuario="";
    
    //Valida que el usuario creado es correcto
    //Falso hasta que se cree el usuario
    private static boolean cuentaCreada=false;
    
    //Almacena Cuenta en nuevaCuenta
    //Null hasta que se introduzca
    private static Cuenta nuevaCuenta = null;
    
    //Almacena lo que selecciona el usuario 
    //Con un valor vacio para empezar
    private static String seleccion = "";
    
    //Byte para pasar el texto que se introduce por teclado a numerico
    private static byte numeroSeleccion= -1;
    
    //Almacena el concepto de la transaccion
    private static String concepto="";
    
    //Almacena importe de gasto o ingreso
    private static String importe="";
    
    //Almacena importe total de gasto o ingreso
    private static double importeTotal=0;
    
    //A continuacion los metodos
    //Muestra las 6 opciones en consola y pedimos que se introduzca una
    private static void Menu(){
        
        do{
        System.out.println("Realiza una nueva accion");	
        System.out.println("1 Introduce un nuevo gasto");
        System.out.println("2 Introduce un nuevo ingreso");
        System.out.println("3 Mostrar gastos");
        System.out.println("4 Mostrar ingresos");
        System.out.println("5 Mostrar saldo");
        System.out.println("0 Salir");

         try{
            seleccion = lee.nextLine();
            numeroSeleccion = Byte.parseByte(seleccion);
        }
        //No acepatara numeros no validos, letras o simbolos
        catch(NumberFormatException e){
            System.out.println(e.getMessage());
            System.out.println("ERROR. Tiene que ser un número "
                    + "entre 0 y 5");
        }
        }while(numeroSeleccion<0 && numeroSeleccion>5); 
    }
    
    private static void pedirDatosUsuario(){
    	cuentaCreada=false;
        do{
            System.out.println("Nombre del usuario");
            nombreUsuario=lee.nextLine().toUpperCase();
        }while(nombreUsuario.isEmpty());
        nuevoUsuario.setNombre(nombreUsuario);     
        	do{
            System.out.println("Tu edad");
            anyosUsuario=lee.nextLine();
            //Pasa la edad a numérico si se puede
        try{
                edadUsuario = Byte.parseByte(anyosUsuario);
                nuevoUsuario.setEdad(edadUsuario);
            }catch(NumberFormatException e){
                System.out.println("La edad tiene que ser un numero mayor que cero");
            }
        }while(anyosUsuario.isEmpty() || edadUsuario<=0);
        
        do{
            System.out.println("Tu DNI");
            dniUsuario=lee.nextLine().toUpperCase();
            
            //si el dni intruducido es correcto se guarda
            if(nuevoUsuario.setDNI(dniUsuario)){
                nuevoUsuario.setDNI(dniUsuario);
            }
            else{
                System.out.println("El DNI no es correcto. Vuelva a introducir el DNI");
            }
        }while(dniUsuario.isEmpty() || nuevoUsuario.setDNI(dniUsuario)==false);
        
        	//Se valida el usuario si todo es correcto
        cuentaCreada=true;
    }
    
    private static void introducirGastos(){
    	//Igual que en el caso de ingresos    
    	//Resetear las variables para que queden listas
        importe="";
        concepto="";
        importeTotal=0;
        
        do{
            System.out.print("Concepto del gasto: ");
            concepto = lee.nextLine();
            
        }while(concepto.isEmpty());
        
        do{
            System.out.print("Importe del gasto: ");
            importe = lee.nextLine();
            
            try{ 
                importeTotal=Double.parseDouble(importe);
            }catch(NumberFormatException e){
                System.out.println("El importe tiene que ser un numero" + e.getMessage());
            } 
        }while(importe.isEmpty());
            
        //Saldo de la cuenta es <= o 
        if(nuevaCuenta.getSaldo()<importeTotal || nuevaCuenta.getSaldo()==0){
           
            System.out.println("No se pudo cobrar, quedaria la cuenta en numeros rojos, haz un ingreso antes de pasar de nuevo este gasto");
        }
        else{ 
        	
            nuevaCuenta.addGastos(concepto, importeTotal);

            System.out.println("Su gasto fue registrado");  
        }
    }
    
    private static void mostrarGastos(){
        
        //Si gastos no esta vacio
       if(!nuevaCuenta.getGastos().isEmpty()){
            //Recorre Gastos
           for(int x=0;x<nuevaCuenta.getGastos().size();x++){
        	   //Y los muestra
               System.out.println(nuevaCuenta.getGastos().get(x).toString());
           }
       }
       else{ 
           System.out.println("No tiene gastos");
       }
    }
    
    private static void introducirIngresos(){
        
        //Resetear las variables para que queden listas
        importe="";
        concepto="";
        importeTotal=0;
        
        do{
            System.out.print("Concepto del ingreso: ");
            concepto = lee.nextLine();
            
        }while(concepto.isEmpty());
        
        do{
            System.out.print("Importe del ingreso: ");
            importe = lee.nextLine();
            //intenta pasar a numerico
            try{ 
                importeTotal=Double.parseDouble(importe);
            }catch(NumberFormatException e){
                System.out.println("El importe tiene que ser un numero" + e.getMessage());
            }
        }while(importe.isEmpty());
        
        nuevaCuenta.addIngresos(concepto, importeTotal);
        
        System.out.println("Su ingreso fue registrado");
    }
    private static void mostrarIngresos(){
        
       //Si ingresos no esta vacio
       if(!nuevaCuenta.getIngresos().isEmpty()){
    	   //Recorre ingresos
           for(int x=0;x<nuevaCuenta.getIngresos().size();x++){
        	   //Y los muestra
               System.out.println(nuevaCuenta.getIngresos().get(x).toString());
           }
       }
       else{ 
           System.out.println("No tiene ingresos");
       }
    }
    
    public static void main(String[] args) {
        
       //Crea un usuario
        do{
           pedirDatosUsuario();
       }while(cuentaCreada=false);
        
        //Si true imprime
        System.out.println("Nuevo usuario creado:");
        System.out.println(nuevoUsuario.toString());
        
        //Creamos nueva cuenta
        nuevaCuenta=new Cuenta(nuevoUsuario);
        
        do{Menu();

            if(numeroSeleccion ==1 ){
            	introducirGastos();
            }else if(numeroSeleccion ==2){
            	introducirIngresos();
            }else if(numeroSeleccion ==3){
            	mostrarGastos();
            }else if(numeroSeleccion ==4){
            	mostrarIngresos();	
            }else if(numeroSeleccion ==5){
            	System.out.println(nuevaCuenta.toString());	
            }else if(numeroSeleccion ==0) {
            	System.out.println("Fin del programa.\n Gracias por utilizar la aplicacion.");
            	
            }else {
            	 System.out.println("Introduce un valor correcto");
                 break;}
            	
            	

        }while(numeroSeleccion !=0);
        
        //Si se cierra el programa termino
        lee.close();
    }
    
}



