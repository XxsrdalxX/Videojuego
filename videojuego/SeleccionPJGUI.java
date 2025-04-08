package videojuego;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Personajes.*;

public class SeleccionPJGUI extends JFrame {
    private Personaje personajeSeleccionado;
    
    public SeleccionPJGUI() {
        setTitle("Selección de Personaje");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        JLabel titulo = new JLabel("Elige tu personaje", SwingConstants.CENTER);
        add(titulo);

        // Botones para seleccionar personajes
        agregarBoton("Sub-Zero", new SubZero(38, 12, Estados.NORMAL, 18, "Sub-Zero", "Hielo"));
        agregarBoton("Scorpion", new Scorpion(40, 10, Estados.NORMAL, 20, "Scorpion", "Fuego"));
        agregarBoton("Liu Kang", new LiuKang(36, 11, Estados.NORMAL, 19, "Liu Kang", "Fuego"));
        agregarBoton("Raiden", new Raiden(37, 11, Estados.NORMAL, 18, "Raiden", "Electricidad"));
        agregarBoton("Kitana", new Kitana(38, 11, Estados.NORMAL, 18, "Kitana", "Viento"));
    }

    private void agregarBoton(String nombre, Personaje personaje) {
        JButton boton = new JButton(nombre);
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personajeSeleccionado = personaje;
                JOptionPane.showMessageDialog(null, "Has elegido a " + personaje.getNombre());
                dispose(); // Cierra la ventana después de seleccionar
            }
        });
        add(boton);
    }
}
