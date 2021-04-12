package Views;

import Controllers.Controller;
import Models.Cliente;
import Models.Usuario;

public class App {
    public static void main(String[] args) throws Exception {
        byte bOpcion;
		Controller oCtrl = new Controller();

		if (oCtrl.init()) {
			do {
				bOpcion = menu();

				switch (bOpcion) {
				case 1: // Gestion de clientes
				
					break;
				default:
					System.out.println("Hasta luego.");
				}

			} while (bOpcion != 2);
			oCtrl.closeDb();
		} else {
			System.out.println("Error al conectar con la base de datos.");
		}
	}

	public static byte menu() {
		System.out.println("   a88888b.                     dP                                       ");
		System.out.println("  d8'   `88                     88                                       ");
		System.out.println("  88        .d8888b. 88d888b. d8888P .d8888b. 88d888b. dP    dP dP.  .dP ");
		System.out.println("  88        88'  `88 88'  `88   88   88ooood8 88'  `88 88    88  `8bd8'  ");
		System.out.println("  Y8.   .88 88.  .88 88         88   88.  ... 88       88.  .88  .d88b.  ");
        System.out.println("  Y8.   .88 88.  .88 88         88   88.  ... 88       88.  .88  .d88b.  ");
        System.out.println("   Y88888P' `88888P8 dP         dP   `88888P' dP       `88888P' dP'  `dP ");
        System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		return (byte) Libreria.leer("Introduce una opcion", 1, 2, -1, -1, (byte) 1);
    }

	
    
}
