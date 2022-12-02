package Main;

import javax.swing.JFrame;

import Controller.*;
import View.Login;


public class MainApplication {
	
	public static ControllerVenda vendasController;
	public static ControllerUsuario operador;
	public static JFrame frame;
    /**
     * @param args the command line arguments
     * @throws InterruptedException 
     */
	public static void main(String[] args) {
    	JFrame loginScreen = new Login();
        frame = loginScreen;
    	frame.setLocationRelativeTo(null);
    	frame.setVisible(true);
	}

}

