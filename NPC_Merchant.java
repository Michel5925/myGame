public class NPC_Merchant extends Entity {
    
    public NPC_Merchant(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;

        getImage();
        setDialogue();
        setItems();
    }
    
    public void getImage() {

        up1 = setup("/npc/merchant_down_1", gp.tileSize, gp.tileSize);
        up2 = setup("/npc/merchant_down_2", gp.tileSize, gp.tileSize);
        down1 = setup("/npc/merchant_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("/npc/merchant_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("/npc/merchant_down_1", gp.tileSize, gp.tileSize);
        left2 = setup("/npc/merchant_down_2", gp.tileSize, gp.tileSize);
        right1 = setup("/npc/merchant_down_1", gp.tileSize, gp.tileSize);
        right2 = setup("/npc/merchant_down_2", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {

        dialogues[0][0] = "He he, you found me eh.\nI have some good stuff on me mate.\nYou want a peak?";
        dialogues[1][0] = "Come back soon, mate!";
        dialogues[2][0] = "You'll need a little bit more than that.";
        dialogues[3][0] = "You cannot carry any more!";
        dialogues[4][0] = "You cannot sell equipped item!";
    }

    public void setItems() {

        inventory.add(new OBJ_Potion_Red(gp));
        inventory.add(new OBJ_Key(gp));
        inventory.add(new OBJ_Sword_Normal(gp));
        inventory.add(new OBJ_Boots(gp));
        inventory.add(new OBJ_Shield_Wood(gp));
        inventory.add(new OBJ_Shield_Blue(gp));
    }

    public void speak() {
        
        facePlayer();
        gp.gameState = gp.tradeState;
        gp.ui.npc = this;
    }
}
