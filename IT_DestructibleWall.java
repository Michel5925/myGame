import java.awt.Color;
//import java.util.Random;

public class IT_DestructibleWall extends InteractiveTile{

    GamePanel gp;

    public IT_DestructibleWall(GamePanel gp, int col, int row) {
        super(gp, col, row);
        this.gp = gp;

        this.worldX = gp.tileSize * col;
        this.worldY = gp.tileSize * row;

        down1 = setup("/interactiveTiles/destructibleWall", gp.tileSize, gp.tileSize);
        destructible = true;
        life = 3;
    }
    
    public boolean isCorrectItem(Entity entity) {
        boolean isCorrectItem = false;

        if(entity.currentWeapon.type == type_pickaxe)
        {
            isCorrectItem = true;
        }
        return isCorrectItem;
    }

    public void playSE() {
        gp.playSE(9);
    }

    public InteractiveTile getDestroyedForm() {
        InteractiveTile tile = null;
        return tile;
    }

    public Color getParticleColour() {
        Color colour = new Color(65, 65, 65);
        return colour;
    }

    public int getParticleSize() {
        int size = 6; // 6 pixels
        return size;
    }

    public int getParticleSpeed() {
        int speed = 1;
        return speed;
    }

    public int getParticleMaxLife() {
        int maxLife = 20;
        return maxLife;
    }

    // public void checkDrop() {

    //     // CAST A DIE
    //     int i = new Random().nextInt(100)+1;

    //     // SET THE MONSTER DROP
    //     if(i < 50) { dropItem(new OBJ_Coin_Bronze(gp)); }
    //     if(i >= 50 && i < 75) { dropItem(new OBJ_Heart(gp)); }
    //     if(i >= 75 && i < 100) { dropItem(new OBJ_ManaCrystal(gp)); }
    // }
}
