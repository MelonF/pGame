package res.sprites.items;

import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NoteBook {
    public GamePanel gp;

    public boolean isOpen;
    public List<String> entries;


    public NoteBook(GamePanel gp) {

        this.isOpen = false;
        this.entries = new ArrayList<String>();
    }

    public void addEntries(String entry) {

        if (!entries.contains(entry))
        {
            entries.add(entry);
        }
    }


    public void openBook()
    {
        this.isOpen = true;
    }

    public void closeNotebook()
    {
        this.isOpen = false;
    }

    public void printEntries()
    {
        for(int i = 0; i < entries.size(); i++)
        {
            System.out.println(entries.get(i));
        }
    }




    public void renderNotebook (Graphics g)
    {




        g.setColor(new Color(139, 69, 19));
        g.fillRect(179, 88, 400, 400);

        g.setColor(Color.BLACK);
        g.drawRect(229, 138, 300, 300);


        g.setColor(new Color(245, 222, 179));
        g.fillRect(230, 139, 298, 298);

        g.setFont(new Font("Times New Roman", Font.BOLD, 16));
        int yPosition = 178;

        g.setColor(Color.BLACK); // REMEMBER set color back to black so it;s visable!!!
        for (String entry : entries) {
            g.drawString(entry, 249, yPosition);
            yPosition += 25;
        }

// Draw the instruction at the bottom of the notebook
        g.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        g.drawString("..............", 249, 418);










            }
    }





