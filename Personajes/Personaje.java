package Personajes;

import java.util.Random;
import videojuego.Estados;

public abstract class Personaje {

    public String Elemento;
    public int vida;
    public int defensa;
    public Estados estado;
    public int poder;
    public String nombre;
    private boolean yaMostroEstado = false;
    private int turnosCongelado = 0;
    private int turnosQuemado = 0;

    public Personaje(int vida, int defensa, Estados estado, int poder, String nombre, String Elemento) {
        this.vida = vida;
        this.defensa = defensa;
        this.estado = estado;
        this.poder = poder;
        this.nombre = nombre;
        this.Elemento = Elemento;
    }

    public int getVida() {
        return vida;
    }

    public int getDefensa() {
        return defensa;
    }

    public Estados getEstado() {
        return estado;
    }

    public int getPoder() {
        return poder;
    }

    public String getNombre() {
        return nombre;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // LOGICA DEL PERSONAJE
    public abstract void habilidadEspecial(Personaje enemigo);

    public boolean yaMostroEstado() {
        return yaMostroEstado;
    }

    public void setYaMostroEstado(boolean yaMostroEstado) {
        this.yaMostroEstado = yaMostroEstado;
    }

    public void curar() {
        if (turnosCongelado > 0) {
            System.out.println("No te puedes curar ya que estas congelado");
            return;
        }
        
        //Logica de curacion
        Random random = new Random();
        int probabilidad = random.nextInt(100);
        if (probabilidad < 50) {
            int cantidadCurada = 10;
            vida += cantidadCurada;
            System.out.println(nombre + " 🍀 se ha curado " + cantidadCurada + " puntos de vida.");
        } else {
            System.out.println(nombre + " intentó curarse, pero falló. 😢");
        }
    }

    public void reducirVida(int cantidad) {
        this.vida -= cantidad;
        if (this.vida < 0) {
            this.vida = 0;
        }
        System.out.println(nombre + " pierde " + cantidad + " de vida. Vida restante: " + vida);
    }

    public void atacar(Personaje enemigo) {
        if (turnosCongelado > 0) {
            System.out.println("❄️ " + nombre + " está CONGELADO y no puede atacar este turno. ❄️");
            turnosCongelado--; // Reduce el contador de turnos congelado
            return;
        }

        int daño = this.poder - enemigo.defensa;
        enemigo.reducirVida(daño);
        System.out.println("⚔️ " + this.nombre + " ataca y causa " + daño + " de daño a " + enemigo.nombre + "!");
    }

    public void aplicarEfectoQuemado() {
        if (estado == Estados.QUEMADO) {
            System.out.println(nombre + " 🔥 está QUEMADO y perderá 1 de vida por turno durante 5 turnos.");
            for (int i = 1; i <= 5; i++) {
                reducirVida(1);
                System.out.println("Turno " + i + ": " + nombre + " pierde 1 de vida. Vida restante: " + vida);
            }
        }
    }

    public void aplicarEfectoCongelado() {
        if (estado == Estados.CONGELADO) {
            System.out.println(nombre + " ❄ está CONGELADO y pierde un turno.");
            if (Math.random() < 0.2) { // 20% de probabilidad de descongelarse
                System.out.println(nombre + " se ha descongelado.");
                estado = Estados.NORMAL;
            } else {
                System.out.println(nombre + " sigue congelado.");
            }
        }
    }

    public void aplicarEfectoEnvenenado() {
        if (estado == Estados.ENVENENADO) {
            System.out.println(nombre + " ☠ está ENVENENADO y pierde 2 de vida por turno durante 3 turnos.");
            for (int i = 1; i <= 3; i++) {
                reducirVida(2);
                System.out.println("Turno " + i + ": " + nombre + " pierde 2 de vida. Vida restante: " + vida);
            }
        }
    }

    public void aplicarEfectoParalizado() {
        if (estado == Estados.PARALIZADO) {
            System.out.println(nombre + " ⚡ está PARALIZADO y tiene 25% de probabilidad de perder su turno.");
            if (Math.random() < 0.25) {
                System.out.println(nombre + " no puede moverse por la parálisis.");
            } else {
                System.out.println(nombre + " resiste la parálisis y puede atacar.");
            }
        }
    }

    public void aplicarEfectoSangrado() {
        if (estado == Estados.SANGRADO) {
            System.out.println(nombre + " 🩸 está SANGRANDO y perderá vida progresivamente.");
            for (int i = 1; i <= 3; i++) {
                reducirVida(i);
                System.out.println("Turno " + i + ": " + nombre + " pierde " + i + " de vida. Vida restante: " + vida);
            }
        }
    }
  

}
