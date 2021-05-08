package Views;

import Controllers.Controller;
import Models.*;

public class BilleteraView {
    public static byte subMenuBilletera(){
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Billetera");
        System.out.println("-----------------------");
        System.out.println("");
        System.out.println("1. Añadir Billetera");
        System.out.println("2. Eliminar Billetera");
        System.out.println("3. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 3, -1, -1, (byte) 1);		
    }

    public static void Billetera(Controller oCtrl) {
        switch (subMenuBilletera()) {
        case 1: // Crear Billetera
            if (create(oCtrl)) {
                System.out.println("La Billetera se ha sido creado con exito.");
            } else {
                System.out.println("La Billetera no se ha podido crear.");
            }
            break;
        case 2: // Borrar
        if (remove(oCtrl)) {
            System.out.println("La Billetera ha sido eliminado con exito.");
        } else {
            System.out.println("La Billetera no se ha podido eliminar.");
        }
        break;
        }
    }
        



    private static boolean create(Controller oCtrl) {
        String sNombreBilletera;
        String sSaldoActual;

        System.out.println("Introduce los datos de las Billeteras: ");
        sNombreBilletera = String.valueOf(Libreria.leer("Introduce el nombre de la billetera", 1, 250, -1, -1, (byte) 6));
        sSaldoActual = String.valueOf(Libreria.leer("Introduce el saldo de la billetera", 1, 250, -1, -1, (byte) 1));
        
        return oCtrl.getoBilleteraCtrl().add(new Billetera(sNombreBilletera, sSaldoActual));
    }

    



    private static boolean remove(Controller oCtrl) {
        String sNombreBilletera = String.valueOf(Libreria.leer("Introduce el nombre de la Billetera", 1, 250, -1, -1, (byte) 6));
        return oCtrl.removeBilletera(new Billetera(sNombreBilletera));
    }
}
