package Views;
import Controllers.Controller;
import Models.Cliente;
import Models.Usuario;

public class TransaccionView {
    public static byte subMenuConsultas(){
        System.out.println("");
        System.out.println("-----------------------");
		System.out.println("Transaccion");
		System.out.println("-----------------------");
        System.out.println("");
		System.out.println("1. Si");
        System.out.println("2. No, Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 2, -1, -1, (byte) 1);		
    }




    /*public static void Transaccion (Controller oCtrl) {
		switch (TransaccionView.subMenuConsultas()) {
		case 1: 
		;
		
		break;
		
		}*/
    }
