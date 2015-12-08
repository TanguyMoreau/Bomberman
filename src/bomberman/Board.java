/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import bomberman.elements.*;
import bomberman.elements.geometry.Coordinates;
import bomberman.elements.lite.EntityLite;
import bomberman.elements.motion.Action;
import bomberman.utils.BomberReader;
import bomberman.utils.BrickReader;
import bomberman.utils.WallReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grochette
 */
public class Board{

        private ArrayList<Bomber> bombers;
        private HashSet<Bomb> bombs;
        private ArrayList<Brick> bricks;
        private HashSet<Wall> walls;
        private HashSet<Explosion> explosions;
        private Random r = new Random();

        public Board(){
                this.bombers = new ArrayList<>();
                this.bricks = new ArrayList<>();
                this.walls = new HashSet<>();
                this.bombs = new HashSet<>();
                this.explosions = new HashSet<>();
        }

        public void build(String bomberFile, String brickFile, String wallFile){
                this.bombers = BomberReader.readFile(this, bomberFile);
                this.bricks = BrickReader.readFile(this, brickFile);
                this.walls = WallReader.readFile(this, wallFile);
        }

        public void buildDefault(){
                //
        }

        public void run(){
                while(bombers.size() >= 1){

                        System.out.println(this.bombers);

                        for(Bomber aBomber : bombers){
                                aBomber.act(new Action(new Coordinates(1 - 2 * r.nextDouble(), 1 - 2 * r.nextDouble()), false));
                        }
                        for(Bomb aBomb : bombs){
                                aBomb.tick();
                        }
                        for(Explosion anExplosion : explosions){
                                anExplosion.destroy();
                        }

                        try{
                                Thread.sleep(1000);
                        }
                        catch(InterruptedException ex){
                                Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
        }

        public ArrayList<Bomber> getBombers(){
                return bombers;
        }

        public void setBombers(ArrayList<Bomber> bombers){
                this.bombers = bombers;
        }

        public HashSet<Bomb> getBombs(){
                return bombs;
        }

        public void setBombs(HashSet<Bomb> bombs){
                this.bombs = bombs;
        }

        public ArrayList<Brick> getBricks(){
                return bricks;
        }

        public void setBricks(ArrayList<Brick> bricks){
                this.bricks = bricks;
        }

        public HashSet<Wall> getWalls(){
                return walls;
        }

        public void setWalls(HashSet<Wall> walls){
                this.walls = walls;
        }

        public HashSet<Explosion> getExplosions(){
                return explosions;
        }

        public void setExplosions(HashSet<Explosion> explosions){
                this.explosions = explosions;
        }

        public ArrayList<EntityLite> createListLite(){
                ArrayList<EntityLite> l = new ArrayList<>();
                for(Bomber b : this.bombers){
                        l.add(b.getBomberLite());
                }
                for(Bomb b : this.bombs){
                        l.add(b.getBombLite());
                }
                for(Brick b : this.bricks){
                        l.add(b.getBrickLite());
                }
                for(Explosion e : this.explosions){
                        l.add(e.getExplosionLite());
                }
                for(Wall w : this.walls){
                        l.add(w.getWallLite());
                }
                return l;
        }

        @Override
        public String toString(){
                return "bombers=" + bombers + "\nbombs=" + bombs + "\nbricks=" + bricks + "\nwalls=" + walls;
        }

}
