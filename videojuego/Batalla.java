package videojuego;
import Personajes.*;
import java.util.Random;
import java.util.Scanner;
public class Batalla {
 
    public void Batalla(Personaje p1, Personaje cpu){
        IAbot IA = new IAbot();
        Scanner scan = new Scanner(System.in);
        int Turno = (int) (Math.random() * 2) + 1;
        System.out.println("Comienza la batalla entre " + p1.getNombre() + " y " + cpu.getNombre() + "! ");
        
        
        while (p1 .getVida()>0 && cpu.getVida()>0 ){
        
        
            if(Turno == 1 ){
                System.out.println("Tu turno jugador");
                System.out.println("1 Para atacar ");
                System.out.println("2 Para usar la habilidad especia;l (30% De probabilidad de fallar)");
                System.out.println("3 Para curarte (50% de probabilidad de curarte)");
                System.out.println("");
                int opcion = Integer.parseInt(scan.nextLine());
                
                switch (opcion) {
                
                    case 1:
                        p1.atacar(cpu);
                        break;
                    case 2:
                        p1.habilidadEspecial(cpu);
                    break;
                    case 3:
                        p1.curar();
                }
            }else {
            IA.decidirAccion(p1, cpu);
            
            }
           
        
        } 
    
    }
             
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
