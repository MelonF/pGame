package main;

import entity.men;
import entity.nPC_Rat;
import item.*;

public class AssetSetter {
    GamePanel gp;


    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }

    public void setItem()
    {
        gp.iT[0] = new itmTray();
        gp.iT[0].worldX = 23 * gp.tileSize;
        gp.iT[0].worldY = 21 * gp.tileSize;

        gp.iT[11] = new itmSpoon();
        gp.iT[11].worldX = 24 * gp.tileSize;
        gp.iT[11].worldY = 21 * gp.tileSize;





        //23
        //23

//        gp.iT[1] = new itmKey();
//        gp.iT[1].worldX = 11 * gp.tileSize;
//        gp.iT[1].worldY = 22 * gp.tileSize;

        gp.iT[2] = new itmCabnet();
        gp.iT[2].worldX = 21 * gp.tileSize;
        gp.iT[2].worldY = 5 * gp.tileSize;

        gp.iT[3] = new itmBed();
        gp.iT[3].worldX = 24 * gp.tileSize;
        gp.iT[3].worldY = 17 * gp.tileSize;

        gp.iT[4] = new itmNail();
        gp.iT[4].worldX = 30 * gp.tileSize;
        gp.iT[4].worldY = 21 * gp.tileSize;
//
        gp.iT[5] = new itmBars();
        gp.iT[5].worldX = 21 * gp.tileSize;
        gp.iT[5].worldY = 19 * gp.tileSize;
//
        gp.iT[6] = new itmKey();

        gp.iT[6].worldX = 15 * gp.tileSize;
        gp.iT[6].worldY = 7 * gp.tileSize;

        gp.iT[7] = new itmCodeDoor();
        gp.iT[7].worldX = 38 * gp.tileSize;
        gp.iT[7].worldY = 6 * gp.tileSize;



        gp.iT[8] = new paper();
        gp.iT[8].worldX = 2 * gp.tileSize;
        gp.iT[8].worldY = 6 * gp.tileSize;

//x 11
        //y 32

//        gp.iT[9] = new scorchedLib();
//        gp.iT[9].worldX = 38 * gp.tileSize;
//        gp.iT[9].worldY = 7 * gp.tileSize;
//
//
//
//        gp.iT[10] = new itmLibrary();
//        gp.iT[10].worldX = 10 * gp.tileSize;
//        gp.iT[10].worldY = 7 * gp.tileSize;





    }


    public void setNPC()
    {
        gp.rat[0] = new nPC_Rat(gp);
        gp.rat[0].worldx = gp.tileSize * 30;
        gp.rat[0].worldy =  gp.tileSize * 17;



    }

    public void setMen()
    {
        gp.m[0] = new men(gp);
        gp.m[0].worldx = gp.tileSize * 40;
        gp.m[0].worldy = gp.tileSize * 31;



        gp.m[1] = new men(gp);
        gp.m[1].worldx = 40 * gp.tileSize;
        gp.m[1].worldy = 31 * gp.tileSize;


        gp.m[3] = new men(gp);
        gp.m[3].worldx = 11 * gp.tileSize;
        gp.m[3].worldy = 30 * gp.tileSize;


        gp.m[4] = new men(gp);
        gp.m[4].worldx = 13 * gp.tileSize;
        gp.m[4].worldy = 7 * gp.tileSize;

        gp.m[5] = new men(gp);
        gp.m[5].worldx = 32 * gp.tileSize;
        gp.m[5].worldy = 7 * gp.tileSize;

        gp.m[6] = new men(gp);
        gp.m[6].worldx = 32 * gp.tileSize;
        gp.m[6].worldy = 7 * gp.tileSize;


        gp.m[7] = new men(gp);
        gp.m[7].worldx = 32 * gp.tileSize;
        gp.m[7].worldy = 7 * gp.tileSize;

        gp.m[8] = new men(gp);
        gp.m[8].worldx = 2 * gp.tileSize;
        gp.m[8].worldy = 7 * gp.tileSize;


        gp.m[9] = new men(gp);
        gp.m[9].worldx = 2 * gp.tileSize;
        gp.m[9].worldy = 7 * gp.tileSize;

        gp.m[10] = new men(gp);
        gp.m[10].worldx = 2 * gp.tileSize;
        gp.m[10].worldy = 39 * gp.tileSize;

        gp.m[11] = new men(gp);
        gp.m[11].worldx = 2 * gp.tileSize;
        gp.m[11].worldy = 39 * gp.tileSize;


        gp.m[11] = new men(gp);
        gp.m[11].worldx = 49 * gp.tileSize;
        gp.m[11].worldy = 36 * gp.tileSize;








    }
}
