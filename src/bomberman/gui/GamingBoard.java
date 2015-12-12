package bomberman.gui;

import bomberman.elements.lite.*;
import bomberman.gui.elements.*;
import bomberman.gui.elements.geometry.GeometryX;
import java.awt.*;

import javax.swing.*;

import java.util.ArrayList;

public class GamingBoard extends JPanel {

    private ArrayList<EntityX> entitiesX;

    public GamingBoard() {
        super(null, true);
        this.setBackground(Color.DARK_GRAY);
        entitiesX = new ArrayList<>();
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
        WallX w = new WallX(null);
        for (EntityX temp : entitiesX) {
            temp.paint(g2);

        }
        //g2.finalize();
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
