package pPartida;

public class Presentador {
    private IVista ivista;
    private MPartida modelo;
    
    public Presentador(IVista iv) {
        ivista = iv;
        modelo = new MPartida();
    }
    
    public String calcularGan(int elementoJ1, int elementoRival){
        String ganador=modelo.calcularGanador(elementoJ1, elementoRival);
        return ganador;
    }
    
    public void calcularGanPartJug(){
        int J1=modelo.getGanJ1();
        int J2=modelo.getGanJ2();
        modelo.GanadorPartidaJugador2(J1, J2);
    }
    
    public void calcularGanPartMaq(){
        int J1=modelo.getGanJ1();
        int Maq=modelo.getGanMaq();
        modelo.GanadorPartidaMaq(J1, Maq);
    }
    
    public String mostrarGanPart(){
        return modelo.getGanadorPartida();
    }
    
    public String mostrarGanadorR1(){
        return modelo.getGanadorR1();
    }
    
    public String mostrarGanadorR2(){
        return modelo.getGanadorR2();
    }
    
    public String mostrarGanadorR3(){
        return modelo.getGanadorR3();
    }
    
    public String mostrarGanadorR4(){
        return modelo.getGanadorR4();
    }
    
    public String mostrarGanadorR5(){
        return modelo.getGanadorR5();
    }
    
    
    public void redirecionarInicio(){
        int eleg=ivista.validarint();
        if (eleg==1) {
            ivista.iniciarJuego();
        } else if (eleg==2) {
            ivista.recuperarJuego();
        }
    }
    
    public void rivales(){
        modelo.mostrarRival();
        
    }
    
    public void redireccionarRival(){
        int elg=ivista.validarint();
        if (elg==1) {
            modelo.rivalAsignado(elg);
            ivista.contraJugador();
        } else if (elg==2) {
            modelo.rivalAsignado(elg);
            ivista.contraMaquina();
        }
    }
    
    public void calcularNumRondas(int i){
        modelo.setNumRonda(i);
    }
    
    public int mostrarNumRonda(){
        int dato = modelo.getNumRonda();
        return dato;
    }
    
    public void contVict(int i){
        modelo.contVictorias(i);
    }
    
    public void guardar(){
        modelo.guardarPartida(modelo);
    }
    
    public String verificarElemento(int e){
        String elemento ="";
        if (e==1) {
            elemento="piedra";
        }else if (e==2) {
            elemento="papel";
        }else if (e==3) {
            elemento="tijera";
        }
        return elemento;
    }
    
    
}
