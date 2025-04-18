package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;
import main.UtilityTool;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;
    // public int hasKey = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;

        direction = "down";
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;

        //PLAYER STATUS
        maxLife = 6;
        life = maxLife;

    }

    public void getPlayerImage() {


        up1 = setup("/player/boy_up_1.png");
        up2 = setup("/player/boy_up_2.png");
        down1 = setup("/player/boy_down_1.png");
        down2 = setup("/player/boy_down_2.png");
        left1 = setup("/player/boy_left_1.png");
        left2 = setup("/player/boy_left_2.png");
        right1 = setup("/player/boy_right_1.png");
        right2 = setup("/player/boy_right_2.png");

    }


    public void update() {

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed == true) {
                direction = "up";
                
            }
    
            if (keyH.downPressed == true) {
                direction = "down";
                
            }
    
            if (keyH.leftPressed == true) {
                direction = "left";
                
            }
    
            if (keyH.rightPressed == true) {
                direction = "right";
                
            }

            //CHECK TILE COLLISION
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // CHECK OBJECT COLLISION
            int objIndex = gp.cChecker.checkObject(this, true);
            pickUpObject(objIndex);

            // CHECK NPC COLLISION
            int npcIndex = gp.cChecker.checkEntity(this, gp.npc);
            interactNPC(npcIndex);

            // CHECK EVENT
            gp.eHandler.checkEvent();

            gp.keyH.enteredPressed = false;

            
            
            if (collisionOn == false) {
                switch(direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            spriteCounter++;
            if (spriteCounter > 10) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                }
    
                else if (spriteNum == 2) {
                    spriteNum = 1;
                }
    
                spriteCounter = 0;
            }
        }

        
    }

    public void pickUpObject(int i) {
        if (i != 999) {
          
        }
    }

    public void interactNPC(int i) {
        if (i != 999) {
            
            if (gp.keyH.enteredPressed == true) {
                gp.gameState = gp.dialogueState;
                System.out.println("Interact with NPC " );
                
                gp.npc[i].speak();
            }
            
            // gp.gameState = gp.dialogueState;
            // gp.npc[i].speak();
          
        }
    }


    public void draw(Graphics2D g2) {


        BufferedImage image = null;

        
        switch(direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
            default:
                break;
        }

        g2.drawImage(image, screenX, screenY, null);

    }
}
