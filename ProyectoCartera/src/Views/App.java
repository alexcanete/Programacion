package Views;

import Controllers.Controller;

public class App {
	public static void main(String[] args) throws Exception {
		byte bOpcion;
		Controller oCtrl = new Controller();

		if (oCtrl.init()) {
			do {

				bOpcion = menu();

				switch (bOpcion) {
					case 1: // Gestion de clientes
						ClienteView.gestionClientes(oCtrl);
						break;
					case 2:// Transaccion
						TransaccionView.Transaccion(oCtrl);
						break;
					case 3:// Moneda
						MonedaView.Moneda(oCtrl);
						break;
					case 4:// billete
						BilleteView.Billete(oCtrl);
						break;
					case 5:
						PaisView.Pais(oCtrl);
						break;
					case 6:
						TransaccionView.Transaccion(oCtrl);
						break;
					case 7:
						BilleteraView.Billetera(oCtrl);
						break;
					default:
						System.out.println("Hasta luego.");
						break;
				}

			} while (bOpcion != 8);
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
		System.out.println("");
		System.out.println("");
		System.out.println("-------------------------");
		System.out.println("1.	Gestión de clientes");
		System.out.println("2.	Transacción");
		System.out.println("3.	Moneda");
		System.out.println("4.	Billete");
		System.out.println("5.	Pais");
		System.out.println("6.	Transaccion");
		System.out.println("7.	Billetera");
		System.out.println("8.	Salir");
		System.out.println("-------------------------");
		return (byte) Libreria.leer("Introduce una opcion", 1, 8, -1, -1, (byte) 1);
	}

}
