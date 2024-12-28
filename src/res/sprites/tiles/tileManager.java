package res.sprites.tiles;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class tileManager {
    GamePanel gp;
    public tile[] tile;
   public  int[] [] mapTileNum;


  public tileManager(GamePanel gp) {
      this.gp = gp;

     tile = new tile[15];
      mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

      getTileImage();

      loadMap("/res/sprites/maps/mapP.txt");
  }

  public void getTileImage() {
      try {

          tile[0] = new tile();
          tile[0].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/newfloor_tile.png")));
          tile[0].collision = false;

//         setUp(0,"grass_tile", false);


          tile[1] = new tile();
          tile[1].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/water_tile.png")));
          tile[1].collision = true;

          tile[2] = new tile();
          tile[2].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/brick_tile.png")));
          tile[2].collision = true;

          tile[3] = new tile();
          tile[3].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/grass_tile.png")));
          tile[3].collision = false;

          tile[4] = new tile();
          tile[4].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/brickflow_tile.png")));
          tile[4].collision = true;

//          tile[5] = new tile();
//          tile[5].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/nailFloor_tile.png")));


          tile[6] = new tile();
          tile[6].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/vent_tile.png")));
          tile[6].collision = true;

          tile[7] = new tile();
          tile[7].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/treeFixed_tile.png")));
          tile[7].collision = true;

          tile[8] = new tile();
          tile[8].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/chair_tile.png")));
          tile[8].collision = true;

          tile[9] = new tile();
          tile[9].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/desk_tile.png")));
          tile[9].collision = false;

//evil grass >:)
          tile[10] = new tile();
          tile[10].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/grass_tile.png")));


          tile[11] = new tile();
          tile[11].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/writing_tile.png")));
          tile[11].collision = false;







      } catch(IOException e) {

          e.printStackTrace();
      }



  }

  public void setUp(int index, String path, boolean collision)
    {


        UtilityTool uTool = new UtilityTool();



        try {

            tile[index] = new tile();
            tile[index].image = ImageIO.read((getClass().getResourceAsStream("/res/sprites/tiles/" + path + ".png")));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch(IOException e) {
            e.printStackTrace();
        }
    }




    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int row = 0;

            while (row < gp.maxWorldRow) {
                String line = br.readLine();
                String[] numbers = line.split(" ");
                for (int col = 0; col < gp.maxWorldCol; col++) {
                    mapTileNum[col][row] = Integer.parseInt(numbers[col]);
                }
                row++;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }









////  public void loadMap(String filePath) {
////      try {
////
////
////          InputStream is = getClass().getResourceAsStream(filePath);
////    BufferedReader br = new BufferedReader( new InputStreamReader(is));
////          int col = 0;
////          int row = 0;
////          while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
////              String line = br.readLine();
////              while (col < gp.maxWorldCol) {
////                  String numbers[] = line.split(" ");
////                  int num = Integer.parseInt(numbers[col]);
////                  mapTileNum[col][row] = num;
////                  col++;
////              }
////              if (col == gp.maxWorldCol) {
////                  col = 0;
////                  row++;
////              }
////          }
//          br.close();
//
//      } catch (IOException e) {
//          throw new RuntimeException(e);
//      }
//  }



  public void draw (Graphics2D g2) {



      int worldCol = 0;
      int worldRow = 0;

// Iterate through the entire map
      while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {


          int tileNum = mapTileNum[worldCol][worldRow];


          int worldX = worldCol * gp.tileSize;
          int worldY = worldRow * gp.tileSize;

          int screenX = worldX - gp.p.worldx + gp.p.screenX;
          int screenY = worldY - gp.p.worldy + gp.p.screenY;

          //stop moving the camera


//

          if (worldX + gp.tileSize > gp.p.worldx - gp.p.screenX
                  && worldX - gp.tileSize < gp.p.worldx + gp.p.screenX
                  && worldY + gp.tileSize > gp.p.worldy - gp.p.screenY
                  && worldY - gp.tileSize < gp.p.worldy + gp.p.screenY) {


              g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
          }


          worldCol++;


          if (worldCol == gp.maxWorldCol) {
              worldCol = 0;
              worldRow++;
          }
      }
  }


//
//      int worldCol = 0;
//      int worldRow = 0;
//
//
//
//
//
//     while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
//
//
//         int tileNum = mapTileNum[worldCol][worldRow ];
//         int worldX = worldCol * gp.tileSize;
//         int worldY = worldRow * gp.tileSize;
//         int screenX = worldX - gp.p.worldx + gp.p.screenX;
//         int screenY = worldY - gp.p.worldy + gp.p.screenY;
//
//         g2.drawImage(tile[tileNum].image,screenX,screenY ,gp.tileSize,gp.tileSize,null);
//         worldCol ++;
//
//
//         if (worldCol == gp.maxScreenCol) {
//             worldCol = 0;
//
//             worldRow ++;
//
//         }
//     }
//



//      g2.drawImage(tile[0].image, 0,0,gp.tileSize,gp.tileSize,null);
//      g2.drawImage(tile[1].image, 48,0,gp.tileSize,gp.tileSize,null);
//      g2.drawImage(tile[2].image, 96,0,gp.tileSize,gp.tileSize,null);
//      g2.drawImage(tile[3].image, 192,0,gp.tileSize,gp.tileSize,null);
//      g2.drawImage(tile[4].image, 384,0,gp.tileSize,gp.tileSize,null);
  }






