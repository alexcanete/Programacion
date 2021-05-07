package Views;
import Controllers.Controller;
import Models.Cliente;
import Models.Usuario;



public class ConsultaView {
    public static byte subMenuConsultas(){
        System.out.println("");
        System.out.println("-----------------------");
		System.out.println("Consultas");
		System.out.println("-----------------------");
		System.out.println("1. Consultar Saldo");
        System.out.println("2. Volver atras");
        return (byte) Libreria.leer("Introduce una opcion", 1, 2, -1, -1, (byte) 1);		
    }

    public static void Consultas (Controller oCtrl) {
		switch (ConsultaView.subMenuConsultas()) {
		case 1: // Consultar saldo
		Cliente oCliente = searchByDni(oCtrl);
		if (oCliente != null) {
			System.out.println("El cliente buscado existe en la base de datos.");
			System.out.println(oCliente);
		} else {
			System.out.println("El cliente no existe en la base de datos.");
		}
		break;
		
		}
		
	}
	private static Cliente searchByDni(Controller oCtrl) {
		String sDni = String.valueOf(Libreria.leer("Introduce un dni", 9, 9, -1, -1, (byte) 6));
		return oCtrl.getoPersonasCtrl().searchCliente(new Cliente(sDni));
	}
}		

