import java.util.ArrayList;
import java.util.Random;

//Ejercicio 1
//Haz un programa que pida al usuario cuántos hilos (numHilos) quiere lanzar.
//Los hilos realizarán una carrera. Cada hilo espera un tiempo aleatorio entre 10 y 25 milisegundos
//y a continuación van a poner su nombre en la lista de llegada a la meta.
//Al final, el hilo principal muestra dicha lista.
public class coche extends Thread{
    private String nombre;
    private ArrayList<String >orden;

    public coche(String nombre, ArrayList<String> orden) {
        this.nombre = nombre;
        this.orden = orden;
    }
    public synchronized void run(){
        Random r= new Random();
        int tiempvuelta = r.nextInt(12 ,25);

        try {
            Thread.sleep(tiempvuelta);
            orden.add(this.nombre);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}