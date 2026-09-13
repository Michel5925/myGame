import java.awt.Graphics2D;

public class InteractiveTile extends  Entity {

    GamePanel gp;
    public boolean destructible = false;

    public InteractiveTile(GamePanel gp, int col, int row) {
        super(gp);
        this.gp = gp;
    }
    
    public boolean isCorrectItem(Entity entity) {
        boolean isCorrectItem = false;
        return isCorrectItem;
    }

    public void playSE() {}

    public InteractiveTile getDestroyedForm() {
        InteractiveTile tile = null;
        return tile;
    }

    public void update() {

        if(invincible == true)
        {
            invincibleCounter++;
            if(invincibleCounter > 20)
            {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {

        int screenX = worldX - gp.player.worldX + gp.player.screenX; 
        int screenY = worldY - gp.player.worldY + gp.player.screenY; 

        // ONLY DRAWS IF IN THE BOUNDARY (For performance)
        if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
           worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
           worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
           worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
        {
            g2.drawImage(down1, screenX, screenY, null);
        }
    }
}
