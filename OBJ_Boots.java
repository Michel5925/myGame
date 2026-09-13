public class OBJ_Boots extends Entity{

    GamePanel gp;
    public static final String objName = "Boots";

    public OBJ_Boots(GamePanel gp) {
        super(gp);

        name = objName;
        down1 = setup("/objects/boot", gp.tileSize, gp.tileSize);
        price = 40;
    } 
}