package Views;
import Controllers.Controller;
import Models.Billete;

public class BilleteView {
    public static byte subMenuBillete(){
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Billete");
        System.out.println("-----------------------");
        System.out.println("");
        System.out.println("1. Añadir Billete");
        System.out.println("2. Cambiar Billete");
        System.out.println("3. Eliminar Billete");
        System.out.println("4. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);		
    }

    public static void Billete(Controller oCtrl) {
        switch (subMenuBillete()) {
        case 1: // Crear Billete
            if (create(oCtrl)) {
                System.out.println("La Billete se ha sido creado con exito.");
            } else {
                System.out.println("La Billete no se ha podido crear.");
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
            System.out.println("La Billete ha sido eliminado con exito.");
        } else {
            System.out.println("La Billete no se ha podido eliminar.");
        }
        break;
        }
    }
        



    private static boolean create(Controller oCtrl) {
        String sTipoBillete,  sValorBillete;

        System.out.println("Introduce los datos de las Billetes: ");
        sTipoBillete = String.valueOf(Libreria.leer("Introduce el tipo de Billete", 1, 250, -1, -1, (byte) 6));
        sValorBillete = String.valueOf(Libreria.leer("Introduce el valor de la Billete", 1, 250, -1, -1, (byte) 6));
        
        return oCtrl.getBilleteCtrl().add(new Billete(sTipoBillete, sValorBillete));
    }

    private static boolean update(Controller oCtrl) {

        String sTipoBillete, sValorBilleteEU;
        boolean bExito = false;
        sTipoBillete = String.valueOf(Libreria.leer("Introduce el tipo de Billete", 1, 250, -1, -1, (byte) 6));
        Billete oBillete = oCtrl.searchBillete(new Billete(sTipoBillete));
        if (oBillete != null) {
            sTipoBillete = String.valueOf(
                    Libreria.leer("Introduce un nombre (" + oBillete.getsTipoBillete() + ")", 0, 250, -1, -1, (byte) 6));

            oBillete.setsTipoBillete(sTipoBillete);

            sValorBilleteEU = String.valueOf(Libreria.leer("Introduce unos apellidos (" + oBillete.getsValorBilleteEU() + ")", 0,
                    250, -1, -1, (byte) 6));
            oBillete.setsValorBilleteEU(sValorBilleteEU);

            

            bExito = oCtrl.updateBillete(oBillete);
        }
        return bExito;
    }



    private static boolean remove(Controller oCtrl) {
        String sTipoBillete = String.valueOf(Libreria.leer("Introduce el tipo de Billete", 1, 250, -1, -1, (byte) 6));
        return oCtrl.removeBillete(new Billete(sTipoBillete));
    }
}
