public class b10ej3M {
	public static void main(String []args){
		IAeronave an;//Instancia del objeto, con la clase de implementaci�n
		Airbus340 av = new Airbus340("XW432", 200);Globo gl = new Globo("CH221");// Funcionan como aeronavesan = av;
		// el avi�nan.despegar();
		an = gl;
		// el globoan.despegar();
		// Como avi�n tiene sus propias m�todos
		((IAvion) av).cerrarTrenDeAterrizaje();
		// el avi�n//S�lo como globo tiene sus m�todos
		gl.calentarAire(10);
		gl.expulsarAire(12);
		System.out.println("Actualemente el vuelo " + av.obtenerIdentificacion()+ " vuela a " + av.obtenerAlturaDeVuelo() + " pies de altura.");
		an = av; // el avi�nan.abrirTrenDeAterrizaje();
		}
	}

/*b)
	este es el problema
Exception in thread "main" java.lang.ClassCastException: class Globo cannot be cast to class IAvion (Globo and IAvion are in unnamed module of loader 'app')at b10ej3M.main(b10ej3M.java:14)
c)
no da problema
*/