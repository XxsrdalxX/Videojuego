/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personajes;

import videojuego.Estados;

/**
 *
 * @author Dylan
 */
public class Raiden extends Personaje {
    
public Raiden(int vida, int defensa, Estados estado, int poder, String nombre, String Elemento) {
    super(vida, defensa, estado, poder, nombre, Elemento);
}


    public String getElemento() {
        return Elemento;
    }

    public void setElemento(String Elemento) {
        this.Elemento = Elemento;
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

    @Override
    public void habilidadEspecial(Personaje enemigo) {
        System.out.println("Raiden a usado TRUENO DIVINO");
        enemigo.reducirVida(8);
    }

   
    
}
