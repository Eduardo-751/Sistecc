package Main;

import javax.swing.JInternalFrame;

import View.MenuFrame;


public class MainApplication {

	private static MenuFrame mainFrame = new MenuFrame();
	
	public static void main(String[] args) {
        mainFrame.setVisible(true);
	}

    public static void AddControlFrame(JInternalFrame frame) {
    	mainFrame.add(frame).setVisible(true);
    }
    public static void RemoveControlFrame(JInternalFrame frame) {
    	mainFrame.remove(frame);
    }
}
