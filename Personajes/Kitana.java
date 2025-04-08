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
public class Kitana extends Personaje {

    public Kitana(int vida, int defensa, Estados estado, int poder, String nombre, String Elemento) {
          super(vida, defensa, estado, poder, nombre, Elemento);
    }

    @Override
    public void habilidadEspecial(Personaje enemigo) {
        System.out.println("Kitana usa TORNADO DE ABANICOS");
        enemigo.setEstado(Estados.CONGELADO);
    }
    
}
