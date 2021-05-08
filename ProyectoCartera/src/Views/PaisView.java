package Views;
import Controllers.*;
import Models.*;

public class PaisView {
    public static byte subMenuPais(){
        System.out.println("");
        System.out.println("-----------------------");
        System.out.println("Pais");
        System.out.println("-----------------------");
        System.out.println("");
        System.out.println("1. Añadir Pais");
        System.out.println("2. Eliminar Pais");
        System.out.println("3. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 3, -1, -1, (byte) 1);		
    }

    public static void Pais(Controller oCtrl) {
        switch (subMenuPais()) {
        case 1: // Crear Pais
            if (create(oCtrl)) {
                System.out.println("El Pais se ha sido creado con exito.");
            } else {
                System.out.println("El Pais no se ha podido crear.");
            }
            break;
        case 2: // Borrar
        if (remove(oCtrl)) {
            System.out.println("El Pais ha sido eliminado con exito.");
        } else {
            System.out.println("El Pais no se ha podido eliminar.");
        }
        break;
        }
    }
        



    private static boolean create(Controller oCtrl) {
        String sNombrePais;

        System.out.println("Introduce los datos de las Paiss: ");
        sNombrePais = String.valueOf(Libreria.leer("Introduce el nombre de la Pais", 1, 250, -1, -1, (byte) 6));
        
        return oCtrl.getoPaisCtrl().add(new Pais(sNombrePais));
    }

    



    private static boolean remove(Controller oCtrl) {
        String sNombrePais = String.valueOf(Libreria.leer("Introduce el nombre de la Pais", 1, 250, -1, -1, (byte) 6));
        return oCtrl.removePais(new Pais(sNombrePais));
    }
    
}
