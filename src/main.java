import java.util.ArrayList;
import java.util.Scanner;

//Ejercicio 1
//Haz un programa que pida al usuario cuántos hilos (numHilos) quiere lanzar.
//Los hilos realizarán una carrera. Cada hilo espera un tiempo aleatorio entre 10 y 25 milisegundos
//y a continuación van a poner su nombre en la lista de llegada a la meta.
//Al final, el hilo principal muestra dicha lista.
public class main {
    public static void main(String[]args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("INdica los hilos que quieras lanzar");
        int Nhilos = sc.nextInt();

        ArrayList<String>posicion= new ArrayList<>();

        ArrayList<coche>coches = new ArrayList<>();

        for (int i =0; i<Nhilos;i++){
            coche coche = new coche( "coche" + (i +1), posicion);
            coches.add(coche);
        }
        for (coche hilo :coches){
            hilo.start();
        }
        for (coche hilo: coches){
            try {
                hilo.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(posicion.toString());

    }
}
