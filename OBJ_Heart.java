public class OBJ_Heart extends Entity{

    GamePanel gp;
    public static final String objName = "Heart";

    public OBJ_Heart(GamePanel gp) {
        super(gp);
        this.gp = gp;

        type = type_pickUpOnly;
        name = objName;
        value = 2;
        down1 = setup("/objects/heartFull", gp.tileSize, gp.tileSize);
        image = setup("/objects/heartFull", gp.tileSize, gp.tileSize);
        image2 = setup("/objects/heartHalf", gp.tileSize, gp.tileSize);
        image3 = setup("/objects/heartEmpty", gp.tileSize, gp.tileSize);
    }

    public boolean use(Entity entity) {

        gp.playSE(2);
        gp.ui.addMessage("Health + " + value);
        entity.life += value;
        return true;
    }
}