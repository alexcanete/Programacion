package Views;
import Controllers.Controller;
import Models.Transaccion;

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




    public static void Transaccion (Controller oCtrl) {
		switch (TransaccionView.subMenuConsultas()) {
		case 1: 
		if (create(oCtrl)) { //crear transaccion
            System.out.println("La transaccion ha sido creado con exito.");
        } else {
            System.out.println("La transaccion no se ha podido crear.");
        }
		break;
		
		}



        private static boolean create(Controller oCtrl) {
            String sFecha ,  iIdTransaccion;
    
            System.out.println("Introduce los datos de las monedas: ");
            iIdTransaccion = String.valueOf(Libreria.leer("Introduce la id Transaccion", 1, 250, -1, -1, (byte) 6));
            sFecha = String.valueOf(Libreria.leer("Introduce la fecha", 1, 250, -1, -1, (byte) 6));
            
            return oCtrl.getTransaccionCtrl().add(new Transaccion(iIdTransaccion, sFecha));
        }
    }
