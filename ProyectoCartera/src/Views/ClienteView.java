package Views;



import Controllers.Controller;
import Models.Cliente;
import Models.Usuario;

public class ClienteView {
	public static byte subMenuClientes() {
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("Gestion de clientes");
		System.out.println("-----------------------");
		System.out.println("1. Alta");
		System.out.println("2. Modificar");
		System.out.println("3. Buscar usuario por dni");
		System.out.println("4. Borrar");
		System.out.println("5. Volver atras");
		return (byte) Libreria.leer("Introduce una opcion", 1, 5, -1, -1, (byte) 1);
	}

	public static void gestionClientes(Controller oCtrl) {
		switch (ClienteView.subMenuClientes()) {
		case 1: // Alta de cliente
			if (create(oCtrl)) {
				System.out.println("El cliente ha sido creado con exito.");
			} else {
				System.out.println("El cliente no se ha podido crear.");
			}
			break;
		case 2: // Modificar
			if (update(oCtrl)) {
				System.out.println("El cliente ha sido modificado con exito.");
			} else {
				System.out.println("El cliente no se ha podido modificar.");
			}
			break;
		case 3: // Buscar
			Cliente oCliente = searchByDni(oCtrl);
			if (oCliente != null) {
				System.out.println("El cliente buscado existe en la base de datos.");
				System.out.println(oCliente);
			} else {
				System.out.println("El cliente no existe en la base de datos.");
			}
			break;
		case 4: // Borrar
		if (remove(oCtrl)) {
			System.out.println("El cliente ha sido eliminado con exito.");
		} else {
			System.out.println("El cliente no se ha podido eliminar.");
		}
		break;
		}
	}

	private static boolean create(Controller oCtrl) {
		String sDni, sNombre, sApellidos, sFechaNacimiento, sNombreUsuario, sCorreo, sContrasenia;

		System.out.println("Introduce los datos basicos del cliente: ");
		sDni = String.valueOf(Libreria.leer("Introduce un dni", 9, 9, -1, -1, (byte) 6));
		sNombre = String.valueOf(Libreria.leer("Introduce un nombre", 1, 250, -1, -1, (byte) 6));
		sApellidos = String.valueOf(Libreria.leer("Introduce unos apellidos", 1, 250, -1, -1, (byte) 6));
		sFechaNacimiento = String.valueOf(Libreria.leer("Introduce su fecha de nacimiento", 0, 250, -1, -1, (byte) 6));
		sNombreUsuario = String.valueOf(Libreria.leer("Introduce un nombre de usuario", 1, 250, -1, -1, (byte) 6));
		sCorreo = String.valueOf(Libreria.leer("Introduce un email", 1, 250, -1, -1, (byte) 6));
		sContrasenia = String.valueOf(Libreria.leer("Introduce una contrasena", 5, 12, -1, -1, (byte) 6));

		return oCtrl.addCliente(new Cliente(sDni, sNombre, sApellidos, sFechaNacimiento,
				new Usuario(sNombreUsuario, sCorreo, sContrasenia)));
	}

	private static boolean update(Controller oCtrl) {

		String sDni, sNombre, sApellidos, sFechaNacimiento;
		boolean bExito = false;
		sDni = String.valueOf(Libreria.leer("Introduce un DNI", 9, 9, -1, -1, (byte) 6));
		Cliente oCliente = oCtrl.searchCliente(new Cliente(sDni));
		if (oCliente != null) {
			sNombre = String.valueOf(
					Libreria.leer("Introduce un nombre (" + oCliente.getsNombre() + ")", 0, 250, -1, -1, (byte) 6));

			oCliente.setsNombre(sNombre);

			sApellidos = String.valueOf(Libreria.leer("Introduce unos apellidos (" + oCliente.getsApellidos() + ")", 0,
					250, -1, -1, (byte) 6));
			oCliente.setsApellidos(sApellidos);

			sFechaNacimiento = String.valueOf(Libreria.leer("Introduce una direccion (" + oCliente.getsFechaNacimiento() + ")", 0,
					250, -1, -1, (byte) 6));
			oCliente.setsFechaNacimiento(sFechaNacimiento);

			bExito = oCtrl.updateCliente(oCliente);
		}
		return bExito;
	}

	private static Cliente searchByDni(Controller oCtrl) {
		String sFechaNacimiento = String.valueOf(Libreria.leer("Introduce un dni", 9, 9, -1, -1, (byte) 6));
		return oCtrl.searchCliente(new Cliente(sFechaNacimiento));
	}

	private static boolean remove(Controller oCtrl) {
		String sNombreUsuario = String.valueOf(Libreria.leer("Introduce nombre de usuario", 1, 250, -1, -1, (byte) 6));
		return oCtrl.removeUsuario(new Usuario(sNombreUsuario));
	}

	
}