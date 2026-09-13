public class OBJ_Axe extends Entity{

    public static final String objName = "Woodcutter's Axe";

    public OBJ_Axe(GamePanel gp) {
        super(gp);

        type = type_axe;
        name = objName;
        down1 = setup("/objects/axe", gp.tileSize, gp.tileSize);
        attackValue = 2;
        attackArea.width = 30;
        attackArea.height = 30;
        description = "[Woodcutter's Axe]\nTanjiro's old buddy, ol' pal.";
        price = 75;
        knockBackPower = 10;
        motion1Duration = 20;
        motion2Duration = 40;
    }
}