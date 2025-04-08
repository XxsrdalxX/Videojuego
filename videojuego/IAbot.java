
package videojuego;

import Personajes.Personaje;


public class IAbot {

    public void decidirAccion(Personaje enemigo, Personaje jugador) {
        // Si el jugador está congelado, la IA no usa su habilidad
        if (jugador.estado == Estados.CONGELADO) {
            System.out.println("🤖 La IA ve que " + jugador.nombre + " está congelado. Ataca normalmente.");
            enemigo.atacar(jugador);
            return;
        }

        // Si la IA está en peligro, puede intentar curarse
        if (enemigo.vida <= 20) {
            System.out.println("🤖 " + enemigo.nombre + " está en peligro. Intenta curarse.");
            enemigo.curar();  
            return;
        }

        // Probabilidad de usar habilidad especial (60% de las veces)
        if (Math.random() < 0.6) {
            System.out.println("🤖 " + enemigo.nombre + " decide usar su habilidad especial.");
            enemigo.habilidadEspecial(jugador);
        } else {
            System.out.println("🤖 " + enemigo.nombre + " ataca normalmente.");
            enemigo.atacar(jugador);
        }
    }


}
