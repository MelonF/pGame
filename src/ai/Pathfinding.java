package ai;

import main.GamePanel;

import java.util.ArrayList;

public class Pathfinding {

    GamePanel gp;
    Node[][] node;
    ArrayList<Node> openList = new ArrayList<>();
    public ArrayList<Node> pathList = new ArrayList<>();

    Node startNode, goalNode, currentNode;
    boolean goalReached = false;
    int step = 0;

    public Pathfinding(GamePanel gp) {
        this.gp = gp;
        instantiateNodes();


    }

    public void instantiateNodes() {
        node = new Node[gp.maxWorldCol][gp.maxWorldRow];
        int col = 0;
        int row = 0;

        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
            node[col][row] = new Node(col, row);
            col++;
            if (col == gp.maxWorldCol) {
                col = 0;
                row++;
            }
        }
    }

    public void resetNodes() {
        int col = 0;
        int row = 0;
        while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
            node[col][row].open = false;
            node[col][row].checked = false;
            node[col][row].solid = false;

            col++;
            if (col == gp.maxWorldCol) {
                col = 0;
                row++;
            }
        }


        openList.clear();
        pathList.clear();
        goalReached = false;
        step = 0;
    }


    public void setNode(int startCol, int startRow, int goalCol, int goalRow) {
        resetNodes();

        // Initialize start and goal nodes
        startNode = node[startCol][startRow];
        currentNode = startNode;
        goalNode = node[goalCol][goalRow];
        openList.add(startNode);

        // Iterate over all nodes to set solid status
        for (int col = 0; col < gp.maxWorldCol; col++) {
            for (int row = 0; row < gp.maxWorldRow; row++) {
                int tileNum = gp.tM.mapTileNum[col][row];
                if (gp.tM.tile[tileNum].collision) {
                    node[col][row].solid = true;
                }
            }


        }
    }




    public void getCost(Node node) {
        // Calculate gCost (distance from start node to current node)
        node.gCost = Math.abs(node.col - startNode.col) + Math.abs(node.row - startNode.row);

        // Calculate hCost (estimated distance from current node to goal node - Manhattan Distance)
        node.hCost = Math.abs(node.col - goalNode.col) + Math.abs(node.row - goalNode.row);

        // Calculate fCost (total cost)
        node.fCost = node.gCost + node.hCost;
    }
}




