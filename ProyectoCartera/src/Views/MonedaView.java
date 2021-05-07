package Views;

import Controllers.Controller;
import Models.Moneda;

public class MonedaView {
        public static byte subMenuMoneda(){
            System.out.println("");
            System.out.println("-----------------------");
            System.out.println("Moneda");
            System.out.println("-----------------------");
            System.out.println("");
            System.out.println("1. Añadir moneda");
            System.out.println("2. Cambiar moneda");
            System.out.println("3. Eliminar moneda");
            System.out.println("4. Volver atras");
            return (byte) Libreria.leer("Introduce una opcion", 1, 4, -1, -1, (byte) 1);		
        }

        public static void Moneda(Controller oCtrl) {
            switch (subMenuMoneda()) {
            case 1: // Crear moneda
                if (create(oCtrl)) {
                    System.out.println("La moneda se ha sido creado con exito.");
                } else {
                    System.out.println("La moneda no se ha podido crear.");
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
                System.out.println("La moneda ha sido eliminado con exito.");
            } else {
                System.out.println("La moneda no se ha podido eliminar.");
            }
            break;
		    }
        }
            
 


        private static boolean create(Controller oCtrl) {
            String sTipoMoneda,  sValorMoneda;
    
            System.out.println("Introduce los datos de las monedas: ");
            sTipoMoneda = String.valueOf(Libreria.leer("Introduce el tipo de moneda", 1, 250, -1, -1, (byte) 6));
            sValorMoneda = String.valueOf(Libreria.leer("Introduce el valor de la moneda", 1, 250, -1, -1, (byte) 6));
            
            return oCtrl.getMonedaCtrl().add(new Moneda(sTipoMoneda, sValorMoneda));
        }

        private static boolean update(Controller oCtrl) {

            String sTipoMoneda, sValorMonedaEU;
            boolean bExito = false;
            sTipoMoneda = String.valueOf(Libreria.leer("Introduce el tipo de moneda", 1, 250, -1, -1, (byte) 6));
            Moneda oMoneda = oCtrl.searchMoneda(new Moneda(sTipoMoneda));
            if (oMoneda != null) {
                sTipoMoneda = String.valueOf(
                        Libreria.leer("Introduce un nombre (" + oMoneda.getsTipoMoneda() + ")", 0, 250, -1, -1, (byte) 6));
    
                oMoneda.setsTipoMoneda(sTipoMoneda);
    
                sValorMonedaEU = String.valueOf(Libreria.leer("Introduce unos apellidos (" + oMoneda.getsValorMonedaEU() + ")", 0,
                        250, -1, -1, (byte) 6));
                oMoneda.setsValorMonedaEU(sValorMonedaEU);
    
                
    
                bExito = oCtrl.updateMoneda(oMoneda);
            }
            return bExito;
        }



        private static boolean remove(Controller oCtrl) {
            String sTipoMoneda = String.valueOf(Libreria.leer("Introduce el tipo de moneda", 1, 250, -1, -1, (byte) 6));
            return oCtrl.removeMoneda(new Moneda(sTipoMoneda));
        }
}
