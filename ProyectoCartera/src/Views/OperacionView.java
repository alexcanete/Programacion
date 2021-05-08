package Views;

import Controllers.*;
import Models.*;

public class OperacionView {
    public static byte subMenuOperacion(){
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Operacion");
        System.out.println("-----------------------");
        System.out.println("");
        System.out.println("1. Añadir Operacion");
        System.out.println("2. Cambiar Operacion");
        System.out.println("3. Eliminar Operacion");
        System.out.println("4. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);		
    }

    public static void Operacion(Controller oCtrl) {
        switch (subMenuOperacion()) {
        case 1: // Crear Operacion
            if (create(oCtrl)) {
                System.out.println("La Operacion se ha sido creado con exito.");
            } else {
                System.out.println("La Operacion no se ha podido crear.");
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
            System.out.println("La Operacion ha sido eliminado con exito.");
        } else {
            System.out.println("La Operacion no se ha podido eliminar.");
        }
        break;
        }
    }
        


    private static boolean create(Controller oCtrl) {
        String sTipoOperacion;
        int iIdOperacion;

        System.out.println("Introduce los datos de las Operacions: ");
        iIdOperacion = (int) (Libreria.leer("Introduce la id Transaccion", 1, 250, -1, -1, (byte) 1));
        sTipoOperacion = String.valueOf(Libreria.leer("Introduce el valor de la Operacion", 1, 250, -1, -1, (byte) 6));
        
        return oCtrl.getoOperacionCtrl().add(new Operacion(iIdOperacion, sTipoOperacion));
    }
    

    private static boolean update(Controller oCtrl) {

        int iIdOperacion;
        String sTipoOperacion;
        
        boolean bExito = false;
        iIdOperacion = (int) (Libreria.leer("Introduce la id Transaccion", 1, 250, -1, -1, (byte) 1));
        Operacion oOperacion = oCtrl.searchOperacion(new Operacion(iIdOperacion));
        if (oOperacion != null) {
            iIdOperacion = (int)(
                    Libreria.leer("Introduce un nombre (" + oOperacion.getsTipoOperacion() + ")", 0, 250, -1, -1, (byte) 6));

            oOperacion.setiIdOperacion(iIdOperacion);

            sTipoOperacion = String.valueOf(Libreria.leer("Introduce unos apellidos (" + oOperacion.getsTipoOperacion() + ")", 0,
                    250, -1, -1, (byte) 6));
            oOperacion.setsTipoOperacion(sTipoOperacion);

            

            bExito = oCtrl.updateOperacion(oOperacion);
        }
        return bExito;
    }



    private static boolean remove(Controller oCtrl) {
        int iIdOperacion = (int)(Libreria.leer("Introduce el tipo de Operacion", 1, 250, -1, -1, (byte) 1));
        return oCtrl.removeOperacion(new Operacion(iIdOperacion));
    }
}
