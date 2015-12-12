/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import bomberman.elements.*;
import bomberman.elements.geometry.Geometry;
import bomberman.elements.lite.EntityLite;
import bomberman.elements.motion.Action;
import bomberman.reseau.InterfaceReseauImpl;
import bomberman.utils.BomberReader;
import bomberman.utils.BrickReader;
import bomberman.utils.WallReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grochette
 */
public class Board {

    private ArrayList<Bomber> bombers;
    private HashSet<Bomb> bombs;
    private ArrayList<Brick> bricks;
    private HashSet<Wall> walls;
    private HashSet<Explosion> explosions;
    private InterfaceReseauImpl myInterfaceImpl;
    private final int numberOfPlayers;
    private int timeStep;
    private int fPS;
    private int aSecond;

    public Board(int numberOfPlayers) throws RemoteException {
        this.bombers = new ArrayList<>();
        this.bricks = new ArrayList<>();
        this.walls = new HashSet<>();
        this.bombs = new HashSet<>();
        this.explosions = new HashSet<>();
        this.myInterfaceImpl = new InterfaceReseauImpl();
        this.numberOfPlayers = numberOfPlayers;
        this.aSecond = 1000;
        this.fPS = 60;
        this.timeStep = aSecond / fPS;
    }

    public void build(String bomberFile, String brickFile, String wallFile) {
        this.bombers = BomberReader.readFile(this, bomberFile);
        this.bricks = BrickReader.readFile(this, brickFile);
        this.walls = WallReader.readFile(this, wallFile);
    }

    public void buildDefault() {
        walls = WallReader.defaultFile(this);
        bombers = BomberReader.defaultFile(this, numberOfPlayers);
        bricks = BrickReader.defaultFile(this);
    }

    public void run() throws RemoteException {
        while (/*!bombers.isEmpty()*/true) {
            ExchangeDataWithClient();
            ArrayList<Action> listOfActions = myInterfaceImpl.getListOfActions();
            int j = 0;
            for (Bomber aBomber : bombers) {
                aBomber.act(listOfActions.get(j));
                j++;
            }
            for (Iterator<Bomb> i = bombs.iterator(); i.hasNext();) {
                Bomb aBomb = i.next();
                aBomb.tick();
                if (aBomb.getCountdown() == 0) {
                    i.remove();
                }
            }
            for (Iterator<Explosion> i = explosions.iterator(); i.hasNext();) {
                Explosion anExplosion = i.next();
                if(!anExplosion.isBurst()){
                    anExplosion.destroy();
                }
                anExplosion.tick();
                if (anExplosion.getCountdown() == 0) {
                    i.remove();
                }
            }
            for (Iterator<Bomber> i = bombers.iterator(); i.hasNext();) {
                if (i.next().isDead()) {
                    i.remove();
                }
            }
            for (Iterator<Brick> i = bricks.iterator(); i.hasNext();) {
                if (i.next().isDead()) {
                    i.remove();
                }
            }
            try {
                Thread.sleep(timeStep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public int getaSecond() {
        return aSecond;
    }

    public void setaSecond(int aSecond) {
        this.aSecond = aSecond;
    }

    public int getfPS() {
        return fPS;
    }

    public void setfPS(int fPS) {
        this.fPS = fPS;
    }

    public int getTimeStep() {
        return timeStep;
    }

    public void setTimeStep(int timeStep) {
        this.timeStep = timeStep;
    }

    public InterfaceReseauImpl getMyInterfaceImpl() {
        return myInterfaceImpl;
    }

    public void setMyInterfaceImpl(InterfaceReseauImpl myInterfaceImpl) {
        this.myInterfaceImpl = myInterfaceImpl;
    }

    public ArrayList<Bomber> getBombers() {
        return bombers;
    }

    public void setBombers(ArrayList<Bomber> bombers) {
        this.bombers = bombers;
    }

    public HashSet<Bomb> getBombs() {
        return bombs;
    }

    public void setBombs(HashSet<Bomb> bombs) {
        this.bombs = bombs;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(ArrayList<Brick> bricks) {
        this.bricks = bricks;
    }

    public HashSet<Wall> getWalls() {
        return walls;
    }

    public void setWalls(HashSet<Wall> walls) {
        this.walls = walls;
    }

    public HashSet<Explosion> getExplosions() {
        return explosions;
    }

    public void setExplosions(HashSet<Explosion> explosions) {
        this.explosions = explosions;
    }

    public ArrayList<EntityLite> createListLite() {
        ArrayList<EntityLite> l = new ArrayList<>();
        for (Bomber b : this.bombers) {
            l.add(b.getBomberLite());
        }
        for (Bomb b : this.bombs) {
            l.add(b.getBombLite());
        }
        for (Brick b : this.bricks) {
            l.add(b.getBrickLite());
        }
        for (Explosion e : this.explosions) {
            l.add(e.getExplosionLite());
        }
        for (Wall w : this.walls) {
            l.add(w.getWallLite());
        }
        return l;
    }

    public InterfaceReseauImpl installingConnection(String[] args) throws RemoteException {
        if (args.length > 1) {
            Registry registry = LocateRegistry.getRegistry(args[1]);
            registry.rebind("distantServer_02", myInterfaceImpl);
        } else {
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("distantServer_02", myInterfaceImpl);
        }
        return myInterfaceImpl;
    }

    public void ExchangeDataWithClient() throws RemoteException {
        //System.out.println(this.myInterfaceImpl.getListOfActions());
        this.myInterfaceImpl.setDataBoard(createListLite());
        for (int i = 0; i < this.myInterfaceImpl.getInfoFromClients().size(); i++) {
            if (this.myInterfaceImpl.getInfoFromClientsPos(i).isDataSend() == true) {
                this.myInterfaceImpl.getListOfActions().set(i, this.myInterfaceImpl.getInfoFromClientsPos(i).getMyAction());
                this.myInterfaceImpl.getInfoFromClientsPos(i).setDataSend(false);
            }
        }
    }

    public void waitingForPlayers(int numberOfPlayers) throws RemoteException {
        while (this.myInterfaceImpl.getInfoFromClients().size() < numberOfPlayers) {
            if (this.myInterfaceImpl.getInfoFromClients().size() > 0) {
                if (this.myInterfaceImpl.getInfoFromClientsPos(this.myInterfaceImpl.getInfoFromClients().size() - 1).isCreateNew() == false) {
                    this.myInterfaceImpl.getInfoFromClientsPos(this.myInterfaceImpl.getInfoFromClients().size() - 1).setCreateNew(true);
                    //   this.myInterfaceImpl.setActualPosition(this.myInterfaceImpl.getActualPosition() + 1);
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return "bombers=" + bombers + "\nbombs=" + bombs + "\nbricks=" + bricks + "\nwalls=" + walls;
    }

}
