package sistemaferreteria;

import javax.swing.SwingUtilities;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.ModerateSkin;

import control.Control;

public class SistemaFerreteria {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SubstanceLookAndFeel.setSkin(new ModerateSkin());
                
                Control c = new Control();
                c.mostrarLogin();
            }
        });
    }
}