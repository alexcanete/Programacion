public class b11ej1{
    public static void main(String[] args){
        //String sMarca, String sModelo, String sTipoDeAlmacenamiento
    ReproductorPortatil oReproductorPortatil = new ReproductorPortatil("acer", "aj23", "CD");
    ReproductorVideo oReproductorVideo = new ReproductorVideo("acer", "aj23", 23.3);

    System.out.println(oReproductorPortatil.getsMarca());
    
    System.out.println(oReproductorPortatil.toString());
    System.out.println(oReproductorVideo,toString());

    }   
}