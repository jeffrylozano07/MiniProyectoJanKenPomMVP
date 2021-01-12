package pPartida;

import java.util.Random;
import java.util.Scanner;

public class VistaConsola implements IVista{
    int entrada1;
    int entrada2;
    Presentador presenter;
    Scanner read=new Scanner(System.in);
    @Override
    public void setPresentador(Presentador p) {
        presenter=p;
    }

    @Override
    public void contraJugador() {
        for (int i = 1; i <= 5; i++) {
          presenter.calcularNumRondas(i);
          System.out.println("");
          System.out.println("EMPEZÓ EL JUEGO ");
          System.out.println("----------------------------------");
          System.out.println("RONDA 0"+presenter.mostrarNumRonda());
          System.out.println("----------------------------------");
          System.out.println("El ganador de la ronda "+i+" es: "+this.MsjGanadorRonda(this.elementoJ1(), this.elementoJ2()));
          System.out.println("El jugador1 eligió el elemento: "+presenter.verificarElemento(entrada1));
          System.out.println("El jugador2 eligió el elemento: "+presenter.verificarElemento(entrada2));
          System.out.println("----------------------------------");
          System.out.println("");
          presenter.contVict(i);
          presenter.guardar();
        }
        presenter.calcularGanPartJug();
        this.MostrarResultadosRonda();
        this.MsjGanadorPartida();
    }

    @Override
    public void contraMaquina() {
        System.out.println("");
        System.out.println("----------------------------------");
        System.out.println("EMPEZÓ EL JUEGO ");
        for (int i = 1; i <= 5; i++) {
          presenter.calcularNumRondas(i);
          System.out.println("----------------------------------");
          System.out.println("RONDA 0"+presenter.mostrarNumRonda());
          System.out.println("----------------------------------");
          System.out.println("El ganador de la ronda "+i+" es: "+this.MsjGanadorRonda(this.elementoJ1(), this.elementoMaquina()));
          System.out.println("El jugador1 eligió el elemento: "+presenter.verificarElemento(entrada1));
          System.out.println("La Maquina eligió el elemento: "+presenter.verificarElemento(this.elementoMaquina()));
          System.out.println("");
          presenter.contVict(i);
          presenter.guardar();
        }
        presenter.calcularGanPartMaq();
        this.MostrarResultadosRonda();
        this.MsjGanadorPartida();
        
    }

    @Override
    public int elementoJ1() {
        System.out.println("ELEMENTOS DEL JUGADOR 1");
        System.out.println("----------------------------------");
        System.out.println("1. Piedra");
        System.out.println("2. Papel");
        System.out.println("3. Tijera");
        System.out.println("Ingrese el número de su elemento: ");
        System.out.println("----------------------------------");
        entrada1=this.validarint();
        return entrada1;
    }

    @Override
    public int elementoJ2() {
        System.out.println("ELEMENTOS DEL JUGADOR 2");
        System.out.println("----------------------------------");
        System.out.println("1. Piedra");
        System.out.println("2. Papel");
        System.out.println("3. Tijera");
        System.out.println("Ingrese el número de su elemento: ");
        System.out.println("----------------------------------");
        entrada2=this.validarint();
        return entrada2;
    }

    @Override
    public int elementoMaquina() {
        Random rnd=new Random();
        int b=(int)(rnd.nextDouble()*3+1);
        return b;
    }

    @Override
    public void iniciarJuego() {
        this.elegirRival();
    }

    @Override
    public void MsjGanadorPartida() {
        System.out.println("******************************************************");
        System.out.println("EL GANADOR DE LA PARTIDA ES: "+presenter.mostrarGanPart());
        System.out.println("******************************************************");
    }

    @Override
    public String MsjGanadorRonda(int elementoJugador, int elementoRival) {
        String mensaje = presenter.calcularGan(elementoJugador, elementoRival);
        return mensaje;
    }

    @Override
    public void MostrarResultadosRonda() {
        System.out.println("******************************************************");
        System.out.println("RESULTADOS DE LA PARTIDA");
        System.out.println("-------------------------------------------------------");
        System.out.println("El ganador de  la ronda 1 es: "+presenter.mostrarGanadorR1());
        System.out.println("El ganador de  la ronda 2 es: "+presenter.mostrarGanadorR2());
        System.out.println("El ganador de  la ronda 3 es: "+presenter.mostrarGanadorR3());
        System.out.println("El ganador de  la ronda 4 es: "+presenter.mostrarGanadorR4());
        System.out.println("El ganador de  la ronda 5 es: "+presenter.mostrarGanadorR5());
        System.out.println("******************************************************");
    }

    @Override
    public void recuperarJuego() {
        System.out.println("juego recuperado");
    }

    @Override
    public void inicio() {
        System.out.println("");
        System.out.println("BIENVENIDO AL JUEGO ¡¡JAKENPOP!!");
        System.out.println("----------------------------------");
        System.out.println("1. Iniciar Juego");
        System.out.println("2. Recuperar Juego");
        System.out.print("Seleeciona una acción: ");
        presenter.redirecionarInicio();
    }
    
    @Override
    public int validarint(){
        return read.nextInt();
    }

    @Override
    public void elegirRival() {
        System.out.println("");
        System.out.println("¡¡A PUNTO DE EMPEZAR EL JUEGO!!");
        System.out.println("----------------------------------");
        System.out.println("RIVALES");
        System.out.println("----------------------------------");
        presenter.rivales();
        System.out.println("----------------------------------");
        System.out.print("Ingrese el número de su rival: ");
        presenter.redireccionarRival();
    }
    
}
