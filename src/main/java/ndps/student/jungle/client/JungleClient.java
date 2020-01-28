package ndps.student.jungle.client;//FINI

import ndps.student.jungle.gui.JungleIG;

public class JungleClient  {

    public static void main(String []args) {


        javax.swing.SwingUtilities.invokeLater( new Runnable() {
            public void run() {

                JungleIG ig = new JungleIG();
            }
        });
    }
}
		
