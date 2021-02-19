public class ExamenSimulacion {

    public static void main(String[]args){
       
        Cliente oCliente = new Cliente("12345678A", "Pepe", "Cuela", 123456789, "Cliente basico");
     
        CuentaBancaria oCuentaBancaria = new CuentaBancaria("1234567891245678", "Bankia", 1234567.24);

        System.out.println(oCliente.toString());
        System.out.println(oCuentaBancaria.toString());
    }
}
    
    

