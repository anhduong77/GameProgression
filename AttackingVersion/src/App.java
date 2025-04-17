import java.awt.image.BufferedImage;
import java.io.IOException; 

import javax.imageio.ImageIO;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        BufferedImage up1 = null, up2 = null, down1 = null, down2 = null, left1 = null, left2 = null, right1 = null, right2 = null;
        try {
                    up1 = ImageIO.read(App.class.getResourceAsStream("D:\\project game\\GAME\\res\\player\\boy_down_1.png"));
                    up2 = ImageIO.read(App.class.getResourceAsStream("/resources/player/boy_up_2.png"));
        
                    down1 = ImageIO.read(App.class.getResourceAsStream("/resources/player/boy_down_1.png"));
                    down2 = ImageIO.read(App.class.getResourceAsStream("/resources/player/boy_down_2.png"));
        
                    left1 = ImageIO.read(App.class.getResourceAsStream("/resources/player/boy_left_1.png"));
                    left2 = ImageIO.read(App.class.getResourceAsStream("/resources/player/boy_left_2.png"));
        
                    right1 = ImageIO.read(App.class.getResourceAsStream("/resources/player/boy_right_1.png"));
                    right2 = ImageIO.read(App.class.getResourceAsStream("/resources/player/boy_right_2.png"));
        
                }
        
                catch (IOException e) {
                    e.printStackTrace();
                }
        
    }
}
