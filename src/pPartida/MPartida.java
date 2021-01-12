package pPartida;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class MPartida {
    private String jugador="jugador1";
    private ArrayList<MRival> rivales = new ArrayList();
    private MRival rival1 = new MRival(1,"jugador2");
    private MRival rival2 = new MRival(2,"maquina");
    private String rivalAsignado;
    private int numRonda;
    private String ganador;
    private String ganadorR1;
    private String ganadorR2;
    private String ganadorR3;
    private String ganadorR4;
    private String ganadorR5;
    private String ganadorPartida;
    int ganJ1=0;
    int ganJ2=0;
    int ganMaq=0;

    public MPartida() {
        this.setRivales();
    }
    
    public String calcularGanador(int elemento1,int elemento2){
        if (elemento1 == elemento2) {
            ganador="empate";
        } else if (elemento1 == 1 && elemento2==2) {
            ganador=this.getRivalAsignado();
        } else if (elemento1 == 1 && elemento2==3) {
            ganador=jugador;
        } else if (elemento1 == 2 && elemento2==1) {
            ganador=jugador;
        } else if (elemento1 == 2 && elemento2==3) {
            ganador=this.getRivalAsignado();
        } else if (elemento1 == 3 && elemento2==1) {
            ganador=this.getRivalAsignado();
        } else if (elemento1 == 3 && elemento2==2) {
            ganador=jugador;
        } 
        return ganador;
    }
    
    public void contRondas(){
            if ("jugador1".equals(this.getGanador())) {
                ganJ1++;
            }else if ("jugador2".equals(this.getGanador())) {
                ganJ2++;
            }else if ("maquina".equals(this.getGanador())) {
                ganMaq++;
            }
    }
    
    public void GanadorPartidaJugador2(int J1, int J2){
        if (J1>J2) {
            this.setGanadorPartida("jugador1");
        }else if (J2>J1) {
            this.setGanadorPartida("jugador2");
        }else if (J1==J2) {
            this.setGanadorPartida("empate");
        }
    }
    
    public void GanadorPartidaMaq(int J1, int Maq ){
        if ( J1>Maq) {
            this.setGanadorPartida("jugador1");
        }else if (Maq>J1) {
            this.setGanadorPartida("maquina");
        }else if (J1==Maq) {
            this.setGanadorPartida("empate");
        }
    }
    
    public void contVictorias(int numRonda){
        switch (numRonda) {
            case 1:
                this.setGanadorR1(ganador);
                this.contRondas();
                break;
            case 2:
                this.setGanadorR2(ganador);
                this.contRondas();
                break;
            case 3:
                this.setGanadorR3(ganador);
                this.contRondas();
                break;
            case 4:
                this.setGanadorR4(ganador);
                this.contRondas();
                break;
            case 5:
                this.setGanadorR5(ganador);
                this.contRondas();
                break;
            default:
                break;
        }
    }
    
    public void guardarPartida(MPartida p){
        try {
            BufferedWriter bw = Files.newBufferedWriter(Paths.get("C:/files/partida.txt"), StandardOpenOption.APPEND);
            String jug = p.getJugador();
            String rival = p.getRivalAsignado();
            String ronda = String.valueOf(p.getNumRonda());
            String R1ganador = p.getGanadorR1();
            String R2ganador = p.getGanadorR2();
            String R3ganador = p.getGanadorR3();
            String R4ganador = p.getGanadorR4();
            String R5ganador = p.getGanadorR5();
            String line = jug + "," + rival + "," + ronda + "," + R1ganador + "," + R2ganador + "," + R3ganador + "," + R4ganador + "," + R5ganador ;
            bw.write(line);
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void recuperarPartida(){
        
    }
    
    
    public void mostrarRival(){
      for(MRival r: rivales){
          System.out.println(r.getId()+"."+r.getTipo());
      }  
    }
    
    public void rivalAsignado(int id){
        for(MRival r: rivales){
            if (id==r.getId()) {
                rivalAsignado=r.getTipo();;
            }
        }
    }
    
    public String mostrarElemento(int elemento){
        String elementoEscogido="";
        switch (elemento) {
            case 1:
                elementoEscogido="Piedra";
                break;
            case 2:
                elementoEscogido="Papel";
                
                break;
            case 3:
                elementoEscogido="Tijera";
                
                break;
            default:
                break;
        }
        return elementoEscogido;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public ArrayList<MRival> getRivales() {
        return rivales;
    }

    public void setRivales() {
        rivales.add(rival1);
        rivales.add(rival2);
    }

    public MRival getRival1() {
        return rival1;
    }

    public void setRival1(MRival rival1) {
        this.rival1 = rival1;
    }

    public MRival getRival2() {
        return rival2;
    }

    public void setRival2(MRival rival2) {
        this.rival2 = rival2;
    }

    public String getRivalAsignado() {
        return rivalAsignado;
    }

    public void setRivalAsignado(String rivalAsignado) {
        this.rivalAsignado = rivalAsignado;
    }

    public int getNumRonda() {
        return numRonda;
    }

    public void setNumRonda(int numRonda) {
        this.numRonda = numRonda;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getGanadorR1() {
        return ganadorR1;
    }

    public void setGanadorR1(String ganadorR1) {
        this.ganadorR1 = ganadorR1;
    }

    public String getGanadorR2() {
        return ganadorR2;
    }

    public void setGanadorR2(String ganadorR2) {
        this.ganadorR2 = ganadorR2;
    }

    public String getGanadorR3() {
        return ganadorR3;
    }

    public void setGanadorR3(String ganadorR3) {
        this.ganadorR3 = ganadorR3;
    }

    public String getGanadorR4() {
        return ganadorR4;
    }

    public void setGanadorR4(String ganadorR4) {
        this.ganadorR4 = ganadorR4;
    }

    public String getGanadorR5() {
        return ganadorR5;
    }

    public void setGanadorR5(String ganadorR5) {
        this.ganadorR5 = ganadorR5;
    }

    public String getGanadorPartida() {
        return ganadorPartida;
    }

    public void setGanadorPartida(String ganadorPartida) {
        this.ganadorPartida = ganadorPartida;
    }

    public int getGanJ1() {
        return ganJ1;
    }

    public void setGanJ1(int ganJ1) {
        this.ganJ1 = ganJ1;
    }

    public int getGanJ2() {
        return ganJ2;
    }

    public void setGanJ2(int ganJ2) {
        this.ganJ2 = ganJ2;
    }

    public int getGanMaq() {
        return ganMaq;
    }

    public void setGanMaq(int ganMaq) {
        this.ganMaq = ganMaq;
    }
    
    
}
