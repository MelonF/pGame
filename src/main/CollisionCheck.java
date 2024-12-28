package main;

import entity.player;
import entity.entity;
import entity.nPC_Rat;
import entity.men;


import javax.swing.text.html.parser.Entity;

public class CollisionCheck {

    GamePanel gp;

    public CollisionCheck(GamePanel gp) {
        this.gp = gp;
    }


    public void checkCollision(entity p) {


        int pLeftWorldX = p.worldx + p.solidArea.x;
        int pRightWorldX = p.worldx + p.solidArea.x + p.solidArea.width;
        int pTopWorldY = p.worldy + p.solidArea.y;
        int pBottomWorldY = p.worldy + p.solidArea.y + p.solidArea.height;

        // Tile positions
        int pLeftCol = pLeftWorldX / gp.tileSize;
        int pRightCol = pRightWorldX / gp.tileSize;
        int pTopRow = pTopWorldY / gp.tileSize;
        int pBottomRow = pBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;
        p.on = false; // Reset collision flag before checking

        // Ensure tile indices are within bounds
        if (pLeftCol < 0 || pRightCol >= gp.tM.mapTileNum.length ||
                pTopRow < 0 || pBottomRow >= gp.tM.mapTileNum[0].length) {
            return; // Prevent accessing out-of-bounds indices
        }

        switch (p.direction) {
            case "up":
                int newTopWorldY = pTopWorldY - p.speed;
                int newTopRow = newTopWorldY / gp.tileSize;
                if (newTopRow >= 0) { // Validate newTopRow is within bounds
                    tileNum1 = gp.tM.mapTileNum[pLeftCol][newTopRow];
                    tileNum2 = gp.tM.mapTileNum[pRightCol][newTopRow];
                    if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
                        p.on = true;
                    }
                }
                break;
            case "down":
                int newBottomWorldY = pBottomWorldY + p.speed;
                int newBottomRow = newBottomWorldY / gp.tileSize;
                if (newBottomRow < gp.tM.mapTileNum[0].length) { // Validate newBottomRow is within bounds
                    tileNum1 = gp.tM.mapTileNum[pLeftCol][newBottomRow];
                    tileNum2 = gp.tM.mapTileNum[pRightCol][newBottomRow];
                    if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
                        p.on = true;
                    }
                }
                break;
            case "left":
                int newLeftWorldX = pLeftWorldX - p.speed;
                int newLeftCol = newLeftWorldX / gp.tileSize;
                if (newLeftCol >= 0) { // Validate newLeftCol is within bounds
                    tileNum1 = gp.tM.mapTileNum[newLeftCol][pTopRow];
                    tileNum2 = gp.tM.mapTileNum[newLeftCol][pBottomRow];
                    if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
                        p.on = true;
                    }
                }
                break;
            case "right":
                int newRightWorldX = pRightWorldX + p.speed;
                int newRightCol = newRightWorldX / gp.tileSize;
                if (newRightCol < gp.tM.mapTileNum.length) { // Validate newRightCol is within bounds
                    tileNum1 = gp.tM.mapTileNum[newRightCol][pTopRow];
                    tileNum2 = gp.tM.mapTileNum[newRightCol][pBottomRow];
                    if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
                        p.on = true;
                    }
                }
                break;
        }


        // Player bounding box in world coordinates
//        int pLeftWorldX = p.worldx + p.solidArea.x;
//        int pRightWorldX = p.worldx + p.solidArea.x + p.solidArea.width;
//        int pTopWorldY = p.worldy + p.solidArea.y;
//        int pBottomWorldY = p.worldy + p.solidArea.y + p.solidArea.height;
//
//        // Tile positions
//        int pLeftCol = pLeftWorldX / gp.tileSize;
//        int pRightCol = pRightWorldX / gp.tileSize;
//        int pTopRow = pTopWorldY / gp.tileSize;
//        int pBottomRow = pBottomWorldY / gp.tileSize;
//
//        int tileNum1, tileNum2;
//        p.on = false; // Reset collision flag before checking
//
//        switch (p.direction) {
//            case "up":
//                int newTopWorldY = pTopWorldY - p.speed;
//                int newTopRow = newTopWorldY / gp.tileSize;
//                tileNum1 = gp.tM.mapTileNum[pLeftCol][newTopRow];
//                tileNum2 = gp.tM.mapTileNum[pRightCol][newTopRow];
//                if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
//                    p.on = true;
//                }
//                break;
//            case "down":
//                int newBottomWorldY = pBottomWorldY + p.speed;
//                int newBottomRow = newBottomWorldY / gp.tileSize;
//                tileNum1 = gp.tM.mapTileNum[pLeftCol][newBottomRow];
//                tileNum2 = gp.tM.mapTileNum[pRightCol][newBottomRow];
//                if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
//                    p.on = true;
//                }
//                break;
//            case "left":
//                int newLeftWorldX = pLeftWorldX - p.speed;
//                int newLeftCol = newLeftWorldX / gp.tileSize;
//                tileNum1 = gp.tM.mapTileNum[newLeftCol][pTopRow];
//                tileNum2 = gp.tM.mapTileNum[newLeftCol][pBottomRow];
//                if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
//                    p.on = true;
//                }
//                break;
//            case "right":
//                int newRightWorldX = pRightWorldX + p.speed;
//                int newRightCol = newRightWorldX / gp.tileSize;
//                tileNum1 = gp.tM.mapTileNum[newRightCol][pTopRow];
//                tileNum2 = gp.tM.mapTileNum[newRightCol][pBottomRow];
//                if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
//                    p.on = true;
//                }
//                break;
//        }


    }

    public int checkItem(entity e, boolean player) {
        int index = 999;


        for (int i = 0; i < gp.iT.length; i++) {

            if (gp.iT[i] != null) {
                //get entitiy solid area postion

                e.solidArea.x = e.worldx + e.solidArea.x;
                e.solidArea.y = e.worldy + e.solidArea.y;


                //get objects solid area postion

                gp.iT[i].solidArea.x = gp.iT[i].worldX + gp.iT[i].solidArea.x;
                gp.iT[i].solidArea.y = gp.iT[i].worldY + gp.iT[i].solidArea.y;

                switch (e.direction) {
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (e.solidArea.intersects(gp.iT[i].solidArea)) {
                            if (gp.iT[i].collision) {
                                e.on = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (e.solidArea.intersects(gp.iT[i].solidArea)) {
                            if (gp.iT[i].collision) {
                                e.on = true;
                            }
                            if (player == true) {
                                index = i;
                            }

                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (e.solidArea.intersects(gp.iT[i].solidArea)) {
                            if (gp.iT[i].collision) {
                                e.on = true;
                            }
                            if (player == true) {
                                index = i;
                            }

                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (e.solidArea.intersects(gp.iT[i].solidArea)) {
                            if (gp.iT[i].collision) {
                                e.on = true;
                            }
                            if (player == true) {
                                index = i;
                            }

                        }

                        break;

                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                gp.iT[i].solidArea.x = gp.iT[i].solidAreaDefaultX;
                gp.iT[i].solidArea.y = gp.iT[i].solidAreaDefaultY;


            }

        }

        return index;


    }

    //NPC or Monster Collision
    public int checkEntity(player e, nPC_Rat[] target) {


        int index = 999;


        for (int i = 0; i < target.length; i++) {

            if (target[i] != null) {
                //get entitiy solid area postion

                e.solidArea.x = e.worldx + e.solidAreaDefaultX;
                e.solidArea.y = e.worldy + e.solidAreaDefaultY;


                //get objects solid area postion

                target[i].solidArea.x = target[i].worldx + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldy + target[i].solidArea.y;

                switch (e.direction) {
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (e.solidArea.intersects(target[i].solidArea)) {
                            e.on = true;
                            index = i;

                        }
                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (e.solidArea.intersects(target[i].solidArea)) {

                            e.on = true;
                            index = i;

                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (e.solidArea.intersects(target[i].solidArea)) {

                            e.on = true;

                            index = i;

                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (e.solidArea.intersects(target[i].solidArea)) {

                            e.on = true;


                            index = i;

                        }

                        break;

                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;


            }

        }

        return index;


    }


    public int checkEntity(player e, men[] target) {


        int index = 999;


        for (int i = 0; i < target.length; i++) {

            if (target[i] != null) {
                //get entitiy solid area postion

                e.solidArea.x = e.worldx + e.solidAreaDefaultX;
                e.solidArea.y = e.worldy + e.solidAreaDefaultY;


                //get objects solid area postion

                target[i].solidArea.x = target[i].worldx + target[i].solidArea.x;
                target[i].solidArea.y = target[i].worldy + target[i].solidArea.y;

                switch (e.direction) {
                    case "up":
                        e.solidArea.y -= e.speed;
                        if (e.solidArea.intersects(target[i].solidArea)) {
                            e.on = true;
                            index = i;

                        }
                        break;
                    case "down":
                        e.solidArea.y += e.speed;
                        if (e.solidArea.intersects(target[i].solidArea)) {

                            e.on = true;
                            index = i;

                        }
                        break;
                    case "left":
                        e.solidArea.x -= e.speed;
                        if (e.solidArea.intersects(target[i].solidArea)) {

                            e.on = true;

                            index = i;

                        }
                        break;
                    case "right":
                        e.solidArea.x += e.speed;
                        if (e.solidArea.intersects(target[i].solidArea)) {

                            e.on = true;


                            index = i;

                        }

                        break;

                }
                e.solidArea.x = e.solidAreaDefaultX;
                e.solidArea.y = e.solidAreaDefaultY;
                target[i].solidArea.x = target[i].solidAreaDefaultX;
                target[i].solidArea.y = target[i].solidAreaDefaultY;


            }

        }

        return index;


    }


    public void checkCollision(men p) {


        int pLeftWorldX = p.worldx + p.solidArea.x;
        int pRightWorldX = p.worldx + p.solidArea.x + p.solidArea.width;
        int pTopWorldY = p.worldy + p.solidArea.y;
        int pBottomWorldY = p.worldy + p.solidArea.y + p.solidArea.height;

        // Tile positions
        int pLeftCol = pLeftWorldX / gp.tileSize;
        int pRightCol = pRightWorldX / gp.tileSize;
        int pTopRow = pTopWorldY / gp.tileSize;
        int pBottomRow = pBottomWorldY / gp.tileSize;

        int tileNum1, tileNum2;
        p.on = false; // Reset collision flag before checking

        // Ensure tile indices are within bounds
        if (pLeftCol < 0 || pRightCol >= gp.tM.mapTileNum.length ||
                pTopRow < 0 || pBottomRow >= gp.tM.mapTileNum[0].length) {
            return; // Prevent accessing out-of-bounds indices
        }

        switch (p.direction) {
            case "up":
                int newTopWorldY = pTopWorldY - p.speed;
                int newTopRow = newTopWorldY / gp.tileSize;
                if (newTopRow >= 0) { // Validate newTopRow is within bounds
                    tileNum1 = gp.tM.mapTileNum[pLeftCol][newTopRow];
                    tileNum2 = gp.tM.mapTileNum[pRightCol][newTopRow];
                    if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
                        p.on = true;
                    }
                }
                break;
            case "down":
                int newBottomWorldY = pBottomWorldY + p.speed;
                int newBottomRow = newBottomWorldY / gp.tileSize;
                if (newBottomRow < gp.tM.mapTileNum[0].length) { // Validate newBottomRow is within bounds
                    tileNum1 = gp.tM.mapTileNum[pLeftCol][newBottomRow];
                    tileNum2 = gp.tM.mapTileNum[pRightCol][newBottomRow];
                    if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
                        p.on = true;
                    }
                }
                break;
            case "left":
                int newLeftWorldX = pLeftWorldX - p.speed;
                int newLeftCol = newLeftWorldX / gp.tileSize;
                if (newLeftCol >= 0) { // Validate newLeftCol is within bounds
                    tileNum1 = gp.tM.mapTileNum[newLeftCol][pTopRow];
                    tileNum2 = gp.tM.mapTileNum[newLeftCol][pBottomRow];
                    if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
                        p.on = true;
                    }
                }
                break;
            case "right":
                int newRightWorldX = pRightWorldX + p.speed;
                int newRightCol = newRightWorldX / gp.tileSize;
                if (newRightCol < gp.tM.mapTileNum.length) { // Validate newRightCol is within bounds
                    tileNum1 = gp.tM.mapTileNum[newRightCol][pTopRow];
                    tileNum2 = gp.tM.mapTileNum[newRightCol][pBottomRow];
                    if (gp.tM.tile[tileNum1].collision || gp.tM.tile[tileNum2].collision) {
                        p.on = true;
                    }
                }
                break;
        }
    }
}






























































//    {
//        int pLeftWorldX = p.worldx + p.solidArea.x;
//        int pRightWorldX = p.worldx + p.solidArea.x + p.solidArea.width;
//        int pTopWorldY = p.worldy + p.solidArea.y;
//        int pBottomWorldY = p.worldy + p.solidArea.y + p.solidArea.height;
//
//        int pLeftCol = pLeftWorldX/gp.tileSize;
//        int pRightCol = pRightWorldX/gp.tileSize;
//        int pToprow = pTopWorldY/gp.tileSize;
//        int pBottomrow = pBottomWorldY/gp.tileSize;
//
//
//        int tileNum1, tileNum2;
//
//
//        switch (p.direction) {
//            case "up":
//                pToprow = (pToprow - p.speed)/gp.tileSize;
//                tileNum1 = gp.tM.mapTileNum[pLeftCol][pToprow];
//                tileNum2 = gp.tM.mapTileNum[pRightCol][pToprow];
//                if (gp.tM.tile[tileNum1].collision == true || gp.tM.tile[tileNum2].collision == true)
//                {
//                    p.on = true;
//                }
//                break;
//                case "down":
//                    pBottomrow = (pBottomrow + p.speed)/gp.tileSize;
//                    tileNum1 = gp.tM.mapTileNum[pLeftCol][pBottomrow];
//                    tileNum2 = gp.tM.mapTileNum[pRightCol][pBottomrow];
//                    if (gp.tM.tile[tileNum1].collision == true || gp.tM.tile[tileNum2].collision == true)
//                    {
//                        p.on = true;
//                    }
//                    break;
//                    case "left":
//                        pLeftCol = (pLeftWorldX - p.speed)/gp.tileSize;
//                        tileNum1 = gp.tM.mapTileNum[pLeftCol][pToprow];
//                        tileNum2 = gp.tM.mapTileNum[pLeftCol][pBottomrow];
//                        if (gp.tM.tile[tileNum1].collision == true || gp.tM.tile[tileNum2].collision == true)
//                        {
//                            p.on = true;
//                        }
//                        break;
//                        case "right":
//                            pRightCol= (pRightWorldX + p.speed)/gp.tileSize;
//                            tileNum1 = gp.tM.mapTileNum[pRightCol][pToprow];
//                            tileNum2 = gp.tM.mapTileNum[pRightCol][pBottomrow];
//                            if (gp.tM.tile[tileNum1].collision == true || gp.tM.tile[tileNum2].collision == true)
//                            {
//                                p.on = true;
//                            }
//                            break;






