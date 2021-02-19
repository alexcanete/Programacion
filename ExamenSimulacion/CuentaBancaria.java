

public class CuentaBancaria extends Cliente {
    private String sNumeroCuentaBancaria;
    private String sNombreBanco;
    private double dSaldo;

    public CuentaBancaria(String sNumeroCuentaBancaria, String sNombreBanco, double dSaldo) {
        setsNumeroCuentaBancaria(sNumeroCuentaBancaria);
        setsNombreBanco(sNombreBanco);
        setdSaldo(dSaldo);
    }
    public String getsNumeroCuentaBancaria() {
        return sNumeroCuentaBancaria;
    }

    public void setsNumeroCuentaBancaria(String sNumeroCuentaBancaria) {
        if(sNumeroCuentaBancaria.length()==16){
            this.sNumeroCuentaBancaria = sNumeroCuentaBancaria;
        }
        
    }

    public String getsNombreBanco() {
        return sNombreBanco;
    }

    public void setsNombreBanco(String sNombreBanco) {
        if(sNombreBanco.length()>=0 & sNombreBanco.length()<=150){
            this.sNombreBanco = sNombreBanco;
        }
    }

    public double getidSaldo() {
        return dSaldo;
    }

    public void setdSaldo(double dSaldo) {
        if(dSaldo>=000000001.01 & dSaldo<=999999999.99){
            this.dSaldo = dSaldo;
        }
    }

    @Override
    public String toString() {
        return "CuentaBancaria [dSaldo=" + dSaldo + ", sNumeroCuentaBancaria=" + sNumeroCuentaBancaria
                + ", sNombreBanco=" + sNombreBanco + "]";
    }
    super(getsDni);
}
