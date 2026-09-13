//import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][][];
    //boolean drawPath = true;

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[50];
        mapTileNum = new int[gp.maxMap][gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/world02.txt", 0);
        loadMap("/maps/interior01.txt", 1);
        loadMap("/maps/dungeon01.txt", 2);
        loadMap("/maps/dungeon02.txt", 3);
    }

    public void getTileImage() {

        //PLACEHOLDER
        setup(0,"000", false);
        setup(1,"plainGrass", false);
        setup(2,"plainGrass", false);
        setup(3,"plainGrass", false);
        setup(4,"plainGrass", false);
        setup(5,"plainGrass", false);
        setup(6,"plainGrass", false);
        setup(7,"plainGrass", false);
        setup(8,"plainGrass", false);
        // PLACEHOLDER

        //Grass
        setup(10,"plainGrass", false); // Starting from here so the numbers don't disturb the world map text file set up
        setup(11,"grassAccents", false);
        // Path
        setup(12,"path", false);
        setup(13,"bottomLeftPath", false);
        setup(14,"bottomRightPath", false);
        setup(15,"topLeftPath", false);
        setup(16,"topRightPath", false);
        //setup(17,"bottomPath", false);
        setup(17,"dirt", false);
        setup(18,"topPath", false);
        setup(19,"leftPath", false);
        setup(20,"rightPath", false);
        setup(21,"topLeftPathCorner", false);
        setup(22,"topRightPathCorner", false);
        setup(23,"bottomLeftPathCorner", false);
        setup(24,"bottomRightPathCorner", false);
        // Water
        setup(25,"plainWater", true);
        setup(26,"waterFoam", true);
        setup(27,"bottomLeftRiverBank", true);
        setup(28,"bottomMiddleRiverBank", true);
        setup(29,"bottomRightRiverBank", true);
        setup(30,"middleLeftRiverBank", true);
        setup(31,"middleRightRiverBank", true);
        setup(9,"topLeftRiverBank", true);
        setup(32,"wall", true);
        setup(33,"topMiddleRiverBank", true);
        setup(34,"topRightRiverBank", true);
        setup(35,"topLeftRiverBankCorner", true);
        setup(36,"bottomLeftRiverBankCorner", true);
        setup(37,"topRightRiverBankCorner", true);
        setup(38,"bottomRightRiverBankCorner", true);
        // Landscape
        setup(39,"dirt", false);
        setup(40,"earth", false);
        setup(41,"tree", true);
        setup(42,"hut", false);
        setup(43,"floor01", false);
        setup(44,"table01", true);
        setup(45,"sand", false);
        setup(46,"coniferousTree", true);
        setup(47,"wall", true);
        setup(48,"036", false);
        setup(49,"037", false);
    }

    public void setup(int index, String imageName, boolean collision) {

        UtilityTool uTool = new UtilityTool();

        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imageName + ".png"));
            tile[index].image = uTool.scaledImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath, int map) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath); // Imports text file
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); // Reads text file

            int col = 0;
            int row = 0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine(); // Read a line of text

                while(col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[map][col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol)
                {
                    col = 0;
                    row++;

                }
            }
            br.close();
        } catch (Exception e) {
            
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];

            int worldX = worldCol * gp.tileSize; // 0 x 48
            int worldY = worldRow * gp.tileSize; // 0 x 48
            int screenX = worldX - gp.player.worldX + gp.player.screenX; 
            int screenY = worldY - gp.player.worldY + gp.player.screenY; 

            // ONLY DRAWS IF TILE IS IN THE BOUNDARY (For performance)
            if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
               worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
               worldY + gp.tileSize > gp.player.worldY - gp.player.screenY && 
               worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
                {
                    g2.drawImage(tile[tileNum].image, screenX, screenY, null);
                }
            worldCol++; 

            if(worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }

        // if(drawPath == true)
        // {
        //     g2.setColor(new Color(255, 0, 0, 70));

        //     for(int i = 0; i < gp.pFinder.pathList.size(); i++)
        //     {
        //         int worldX = gp.pFinder.pathList.get(i).col * gp.tileSize;
        //         int worldY = gp.pFinder.pathList.get(i).row * gp.tileSize;
        //         int screenX = worldX - gp.player.worldX + gp.player.screenX; 
        //         int screenY = worldY - gp.player.worldY + gp.player.screenY; 

        //         g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
        //     }
        // }
    }
}
