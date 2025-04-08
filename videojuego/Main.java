package videojuego;

public class Main {
    public static void main(String[] args) {
         Batalla b = new Batalla();
         javax.swing.SwingUtilities.invokeLater(() -> {
            new SeleccionPJGUI().setVisible(true);
        });
         
         
    }
}
