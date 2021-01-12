package pPartida;
public interface IVista {
    
    public void setPresentador(Presentador p);
    public void contraJugador();
    public void contraMaquina();
    public int elementoJ1();
    public int elementoJ2();
    public int elementoMaquina();
    public void iniciarJuego();
    public void MsjGanadorPartida();
    public String MsjGanadorRonda(int elementoJugador, int elementoRival);
    public void MostrarResultadosRonda();
    public void recuperarJuego();
    public int validarint();
    public void inicio();
    public void elegirRival();
}
