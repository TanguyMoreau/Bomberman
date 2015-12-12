package bomberman.gui;

import java.awt.*;
import javax.swing.*;

import javax.accessibility.AccessibleContext;

public class GameScreen extends JFrame {

    private JPanel main, mainNorth, mainEast;
    private GamingBoard mainCenter;
    private UpDownListener uDL;
    private LeftRightListener lRL;
    private SpaceListener sL;

    public GameScreen() {
        super("Bomberman - INSA edition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*Definition du Panel principal*/
        this.main = (JPanel) this.getContentPane();
        main.setLayout(new BorderLayout());

        /*Definition du sous-Panel NORTH*/
        this.mainNorth = new JPanel(new GridLayout(1, 3));
        main.add(mainNorth, BorderLayout.NORTH);
        mainNorth.setBackground(Color.WHITE);
        ImageIcon headerIcon = new ImageIcon("resources/insa_logo.jpeg");
        mainNorth.add(new JLabel(new ImageIcon(headerIcon.getImage().getScaledInstance(200, 50, java.awt.Image.SCALE_SMOOTH))));

        /*mainNorth.add(new JLabel(" DevTeam:  L.DEBRIL  --  T.MOREAU  --  G.ROCHETTE  "));
        mainNorth.add(new JLabel("Bomberman - INSA edition"));
        */
        /*Definition du sous-Panel CENTER*/
        this.mainCenter = new GamingBoard();
        main.add(mainCenter, BorderLayout.CENTER);
        mainCenter.setPreferredSize(new Dimension(510, 510));
        mainCenter.setMinimumSize(new Dimension(510, 510));
        mainCenter.setMaximumSize(new Dimension(510, 510));

        uDL = new UpDownListener();
        lRL = new LeftRightListener();
        sL = new SpaceListener();
        mainCenter.addKeyListener(uDL);
        mainCenter.addKeyListener(lRL);
        mainCenter.addKeyListener(sL);
        mainCenter.setFocusable(true);

        /*Definition du sous-Panel EAST*/
        this.mainEast = new JPanel(new GridLayout(4, 1));
        mainEast.add(new JButton("DevTeam:"));
        mainEast.add(new JButton("Laurent DEBRIL"));
        mainEast.add(new JButton("Tanguy MOREAU"));
        mainEast.add(new JButton("Guillaume ROCHETTE"));
        main.add(mainEast, BorderLayout.EAST);

    }

    public JPanel getMain() {
        return main;
    }

    public void setMain(JPanel main) {
        this.main = main;
    }

    public JPanel getMainNorth() {
        return mainNorth;
    }

    public void setMainNorth(JPanel mainNorth) {
        this.mainNorth = mainNorth;
    }

    public JPanel getMainEast() {
        return mainEast;
    }

    public void setMainEast(JPanel mainEast) {
        this.mainEast = mainEast;
    }

    public GamingBoard getMainCenter() {
        return mainCenter;
    }

    public void setMainCenter(GamingBoard mainCenter) {
        this.mainCenter = mainCenter;
    }

    public UpDownListener getuDL() {
        return uDL;
    }

    public void setuDL(UpDownListener uDL) {
        this.uDL = uDL;
    }

    public LeftRightListener getlRL() {
        return lRL;
    }

    public void setlRL(LeftRightListener lRL) {
        this.lRL = lRL;
    }

    public SpaceListener getsL() {
        return sL;
    }

    public void setsL(SpaceListener sL) {
        this.sL = sL;
    }
}
