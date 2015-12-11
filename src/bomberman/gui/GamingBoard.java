package bomberman.gui;

import bomberman.elements.lite.*;
import bomberman.gui.elements.*;
import bomberman.gui.elements.geometry.GeometryX;
import java.awt.*;

import javax.swing.*;

import java.util.ArrayList;

public class GamingBoard extends Canvas {

    private Image wallImg;
    private Image brickImg;
    private Image bombImg;
    private Image bomberImg;

    private ArrayList<EntityX> entitiesX;

    public GamingBoard() {
        super();
        this.setBackground(Color.DARK_GRAY);
        wallImg = new ImageIcon("resources/WallImg.png").getImage();
        brickImg = new ImageIcon("resources/BrickImg.png").getImage();
        bombImg = new ImageIcon("resources/BombImg.png").getImage();
        bomberImg = new ImageIcon("resources/BomberImg.png").getImage();
        entitiesX = new ArrayList<>();
    }

    public GamingBoard(GraphicsConfiguration config) {
        super(config);
    }

    public ArrayList<EntityX> getEntities() {
        return entitiesX;
    }

    public void setEntities(ArrayList<EntityX> entitiesX) {
        this.entitiesX = entitiesX;
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        for (EntityX temp : entitiesX) {
            temp.paint(g2);
        }
        g2.finalize();
    }

    public void convertList(ArrayList<EntityLite> listLite) {
        this.entitiesX = new ArrayList<>();
        //System.out.println(listLite);
        for (EntityLite entityLite : listLite) {
            if (entityLite.getClass().equals(new BombLite(null).getClass())) {
                this.entitiesX.add(new BombX(new GeometryX(entityLite.getBody())));
            }
            if (entityLite.getClass().equals(new BomberLite(null, 0).getClass())) {
                this.entitiesX.add(new BomberX(new GeometryX(entityLite.getBody())));
            }
            if (entityLite.getClass().equals(new BrickLite(null, 0).getClass())) {
                this.entitiesX.add(new BrickX(new GeometryX(entityLite.getBody())));
            }
            if (entityLite.getClass().equals(new WallLite(null).getClass())) {
                this.entitiesX.add(new WallX(new GeometryX(entityLite.getBody())));
            }
        }
    }

}
