
package Personajes;

import videojuego.Estados;


public class Scorpion extends Personaje{
    
 

    public Scorpion( int vida, int defensa, Estados estado, int poder, String nombre, String Elemento) {
         super(vida, defensa, estado, poder, nombre, Elemento);
    
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    // HABILIDADES ESPECIALES 
    public void habilidadEspecial(Personaje enemigo){
        System.out.println("Scorpion usa LANZA INFERNAL");
        enemigo.setEstado(Estados.QUEMADO);
    }  
    }
    

