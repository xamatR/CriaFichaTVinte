package br.ufjf.dcc196.matheus.criafichat20;
import java.util.Random;

public class Dado {
    Random dado;

    public Dado(){
        this.dado= new Random();
    }

    public int rodaDado(int faces){
        return dado.nextInt(faces)+1;
    }
}
