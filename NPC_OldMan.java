import java.awt.Rectangle;
import java.util.Random;

public class NPC_OldMan extends Entity{

    public NPC_OldMan(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        // OLD MAN HIT BOX
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 30;
        solidArea.height = 30;

        dialogueSet = -1;

        getImage();
        setDialogue();
    }
    
    public void getImage() {

        up1 = setup("/npc/oldman_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/oldman_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/oldman_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/oldman_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/oldman_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/oldman_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/oldman_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/oldman_right_2", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {

        dialogues[0][0] = "Hello, lad.";
        dialogues[0][1] = "So you've came to this island to \nfind the treasure?";
        dialogues[0][2] = "I used to be a great wizard but \nnow... I'm a bit too old for taking \non adventures.";
        dialogues[0][3] = "Well, good luck my boy.";
        
        dialogues[1][0] = "If you get tired, rest at the pool of \nwater.";
        dialogues[1][1] = "However, the monsters reappear if \nyou rest. I don't know why but that's \nhow it works.";
        dialogues[1][2] = "in any case, don't push yourself too \nhard.";

        dialogues[2][0] = "I wonder how to get to that chest.";
    }

    public void setAction() {

        if(onPath == true)
        {
            int goalCol = 23;
            int goalRow = 3;
            // int goalCol = (gp.player.worldX + gp.player.solidArea.x)/gp.tileSize;
            // int goalRow = (gp.player.worldY + gp.player.solidArea.y)/gp.tileSize;

            searchPath(goalCol, goalRow);
        }
        else
        {
            actionLookCounter++;

            if(actionLookCounter == 120)
            {
                Random random = new Random();
                int i = random.nextInt(100)+1; // Pick a number from 1 to 100

                if(i <= 25) {
                    direction = "up";
                }
                
                if(i > 25 && i <= 50)
                {
                    direction = "down";
                }

                if(i > 50 && i <= 75)
                {
                    direction = "left";
                }

                if(i > 75 && i <= 100)
                {
                    direction = "right";
                }

                actionLookCounter = 0;
            }
        } 
    }

    public void speak() {

        // Do this character specific stuff
        facePlayer();
        startDialogue(this, dialogueSet);

        dialogueSet++;

        if(dialogues[dialogueSet][0] == null)
        {
            //dialogueSet = 0; // Repeats from the beginning
            dialogueSet--; // Repeats last text
        }

        // onPath = true;
    }
}