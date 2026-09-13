import java.awt.Rectangle;
import java.util.ArrayList;

public class NPC_BigRock extends Entity {
    
    public static final String npcName = "Big Rock";
    public NPC_BigRock(GamePanel gp) {
        super(gp);

        name = npcName;
        direction = "down";
        speed = 4;

        // OLD MAN HIT BOX
        solidArea = new Rectangle();
        solidArea.x = 2;
        solidArea.y = 6;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 44;
        solidArea.height = 40;

        dialogueSet = -1;

        getImage();
        setDialogue();
    }
    
    public void getImage() {

        up1 = setup("/npc/bigrock", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/bigrock", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/bigrock", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/bigrock", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/bigrock", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/bigrock", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/bigrock", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/bigrock", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {

        dialogues[0][0] = "It's a giant rock.";
    }

    public void setAction() {}
    public void update() {}

    public void speak() {

        // Do this character specific stuff
        facePlayer();
        startDialogue(this, dialogueSet);

        dialogueSet++;

        if(dialogues[dialogueSet][0] == null)
        {
            dialogueSet--;
        }
    }

    public void move(String d) {

        this.direction = d;

        checkCollision();

        if(collisionOn == false)
        {
            switch (direction) {
                case "up": worldY -= speed; break;
                case "down": worldY += speed; break;
                case "left": worldX -= speed; break;
                case "right": worldX += speed; break;
            }
        }

        detectPlate();
    }

    public void detectPlate() {

        ArrayList<InteractiveTile> plateList = new ArrayList<>();
        ArrayList<Entity> rockList = new ArrayList<>();

        // Create a plate list
        for(int i = 0; i < gp.iTile[i].length; i++) {

            if(gp.iTile[gp.currentMap][i] != null &&
               gp.iTile[gp.currentMap][i].name.equals(IT_MetalPlate.itName)) {
                plateList.add(gp.iTile[gp.currentMap][i]);
            }
        }

        // Create a rock list
        for(int i = 0; i < gp.npc[i].length; i++) {

            if(gp.npc[gp.currentMap][i] != null &&
               gp.npc[gp.currentMap][i].name.equals(NPC_BigRock.npcName)) {
                rockList.add(gp.npc[gp.currentMap][i]);
            }
        }
    }
}