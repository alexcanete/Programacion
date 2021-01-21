package b8p2;

public class b8p2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Punto punto = new Punto ();
		System.out.println(punto);
		punto =new Punto ((double)6, (double) 7);
		System.out.println(punto);
		punto.borrar();
		System.out.println(punto);
		punto =new Punto ((double)5, (double) 10);
		punto.mover(punto);
		System.out.println(punto);
	}

}
