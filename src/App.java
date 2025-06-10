import javax.swing.*;
import screens.Cadastro;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        SwingUtilities.invokeLater(() -> new Cadastro());
    }
}