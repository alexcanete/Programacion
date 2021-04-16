package Views;



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

    public static void Consultas () {
		switch (ClienteView.subMenuClientes()) {
		case 1: // Alta de cliente
			if (create(oCtrl)) {
				System.out.println("El cliente ha sido creado con exito.");
			} else {
				System.out.println("El cliente no se ha podido crear.");
			}
			break;
}
