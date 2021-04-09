import Models.Cliente;

public class App {
    public static void main(String[] args) throws Exception {
        Cliente oCliente = new Cliente("12345678b78678");
        System.out.println(oCliente.getsDni());
    }
}
