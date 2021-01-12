package pPartida;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MPartida modelo = new MPartida();
        IVista vista = new VistaConsola();
        Presentador p = new Presentador(vista);
        vista.setPresentador(p);
        vista.inicio();
    }
    
}
