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
		System.out.println("1.  Crear transaccion");
        System.out.println("2.  Modificar transaccion");
        System.out.println("3.  Borrar Transaccion");
        System.out.println("4.  Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);		
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
        case 2: // Modificar
        if (update(oCtrl)) {
            System.out.println("El cliente ha sido modificado con exito.");
        } else {
            System.out.println("El cliente no se ha podido modificar.");
        }
        break;
        case 3: // Borrar
        if (remove(oCtrl)) {
            System.out.println("La Transaccion ha sido eliminado con exito.");
        } else {
            System.out.println("La Transaccion no se ha podido eliminar.");
        }
        break;
        }
    }



        private static boolean create(Controller oCtrl) {
            String sFecha;
            int iIdTransaccion;
    
            System.out.println("Introduce los datos de la transaccion: ");
            iIdTransaccion = (int) (Libreria.leer("Introduce la id Transaccion", 1, 250, -1, -1, (byte) 1));
            sFecha = String.valueOf(Libreria.leer("Introduce la fecha", 1, 250, -1, -1, (byte) 6));
            
            return oCtrl.getTransaccionCtrl().add(new Transaccion(iIdTransaccion, sFecha));
        }


        private static boolean update(Controller oCtrl) {

            String sFecha;
            int iIdTransaccion;
            boolean bExito = false;
            iIdTransaccion = (int) (Libreria.leer("Introduce la id Transaccion", 1, 250, -1, -1, (byte) 1));
            Transaccion oTransaccion = oCtrl.searchTransaccion(new Transaccion (iIdTransaccion));
            if (oTransaccion != null) {
                iIdTransaccion = (int)(Libreria.leer("Introduce un nombre (" + oTransaccion.getiIdTransaccion() + ")", 0, 250, -1, -1, (byte) 6));
    
                        oTransaccion.setiIdTransaccion(iIdTransaccion);
    
                sFecha = String.valueOf(Libreria.leer("Introduce unos apellidos (" + oTransaccion.getsFecha() + ")", 0,
                        250, -1, -1, (byte) 6));
                oTransaccion.setsFecha(sFecha);
    
                
    
                bExito = oCtrl.updateTransaccion(oTransaccion);
            }
            return bExito;
        }

        private static boolean remove(Controller oCtrl) {
            int sTipoTransaccion = (int) (Libreria.leer("Introduce la id Transaccion", 1, 250, -1, -1, (byte) 1));
            return oCtrl.removeTransaccion(new Transaccion(sTipoTransaccion));
        }
    }
