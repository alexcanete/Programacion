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
        String sTipoBilletera,  sValorBilletera;

        System.out.println("Introduce los datos de las Billeteras: ");
        sTipoBilletera = String.valueOf(Libreria.leer("Introduce el tipo de Billetera", 1, 250, -1, -1, (byte) 6));
        sValorBilletera = String.valueOf(Libreria.leer("Introduce el valor de la Billetera", 1, 250, -1, -1, (byte) 6));
        
        return oCtrl.getBilleteraCtrl().add(new Billetera(sTipoBilletera, sValorBilletera));
    }

    private static boolean update(Controller oCtrl) {

        String sTipoBilletera, sValorBilleteraEU;
        boolean bExito = false;
        sTipoBilletera = String.valueOf(Libreria.leer("Introduce el tipo de Billetera", 1, 250, -1, -1, (byte) 6));
        Billetera oBilletera = oCtrl.searchBilletera(new Billetera(sTipoBilletera));
        if (oBilletera != null) {
            sTipoBilletera = String.valueOf(
                    Libreria.leer("Introduce un nombre (" + oBilletera.getsTipoBilletera() + ")", 0, 250, -1, -1, (byte) 6));

            oBilletera.setsTipoBilletera(sTipoBilletera);

            sValorBilleteraEU = String.valueOf(Libreria.leer("Introduce unos apellidos (" + oBilletera.getsValorBilleteraEU() + ")", 0,
                    250, -1, -1, (byte) 6));
            oBilletera.setsValorBilleteraEU(sValorBilleteraEU);

            

            bExito = oCtrl.updateBilletera(oBilletera);
        }
        return bExito;
    }



    private static boolean remove(Controller oCtrl) {
        String sTipoBilletera = String.valueOf(Libreria.leer("Introduce el tipo de Billetera", 1, 250, -1, -1, (byte) 6));
        return oCtrl.removeBilletera(new Billetera(sTipoBilletera));
    }
}
