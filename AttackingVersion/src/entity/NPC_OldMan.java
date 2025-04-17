package entity;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.UtilityTool;

public class NPC_OldMan extends Entity {

    public NPC_OldMan(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
        setDialogue();
    }

        public void getImage() {


            up1 = setup("/npc/oldman_up_1.png");
            up2 = setup("/npc/oldman_up_2.png");
            down1 = setup("/npc/oldman_down_1.png");
            down2 = setup("/npc/oldman_down_2.png");
            left1 = setup("/npc/oldman_left_1.png");
            left2 = setup("/npc/oldman_left_2.png");
            right1 = setup("/npc/oldman_right_1.png");
            right2 = setup("/npc/oldman_right_2.png");

    }

    public void setDialogue() {
        dialogues[0] = "Hello, lad.";
        dialogues[1] = "So you've come to this island to find \nthe treasure";
        dialogues[2] = "I used to be a great wizard but now ... \nI'm a bit too old for taking an adventure";
        dialogues[3] = "Well, good luck on you";
        // dialogues[0] = "Hello, lad.";

    }

    public void setAction() {
        actionLockCounter++;
        
        if (actionLockCounter > 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "up";
            }

            if (i > 25 && i <= 50) {
                direction = "down";
            }

            if (i > 50 && i <= 75) {
                direction = "left";
            }

            if (i > 75) {
                direction = "right";
            }
        
            actionLockCounter = 0;
        }
    }

    public void speak() {
        super.speak();
    }

    
        

}
