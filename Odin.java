import javafx.scene.media.MediaPlayer;

import javax.print.attribute.standard.Media;
import javax.swing.JFrame;
import java.awt.*;

public class Odin {
    public static void main(String[] args) {
        Okno wnd = new Okno();
        wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wnd.setBackground(Color.WHITE);
        wnd.setSize(300, 400);
        wnd.setVisible(true);
    }
}
