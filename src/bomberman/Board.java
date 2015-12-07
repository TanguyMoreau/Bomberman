/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman;

import bomberman.elements.*;
import bomberman.elements.geometry.Coordinates;
import bomberman.utils.BomberReader;
import bomberman.utils.BrickReader;
import bomberman.utils.WallReader;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author grochette
 */
public class Board{

        private ArrayList<Bomber> bombers;
        private HashSet<Bomb> bombs;
        private ArrayList<Brick> bricks;
        private ArrayList<Wall> walls;
        private HashSet<Explosion> explosions;

        public Board(){
                this.bombers = new ArrayList<>();
                this.bricks = new ArrayList<>();
                this.walls = new ArrayList<>();
                this.bombs = new HashSet<>();
                this.explosions = new HashSet<>();
        }

        public void build(String bomberFile, String brickFile, String wallFile){
                this.bombers = BomberReader.readFile(this, bomberFile);
                this.bricks = BrickReader.readFile(this, brickFile);
                this.walls = WallReader.readFile(this, wallFile);
        }

        public void run(){
                while(bombers.size() > 1){
                        for(Bomber aBomber : bombers){
                                aBomber.move(new Coordinates(1, 1));
                        }
                        for(Bomb aBomb : bombs){
                                aBomb.tick();
                        }
                        for(Explosion anExplosion : explosions){
                                anExplosion.destroy();
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

        public ArrayList<Wall> getWalls(){
                return walls;
        }

        public void setWalls(ArrayList<Wall> walls){
                this.walls = walls;
        }

        public HashSet<Explosion> getExplosions(){
                return explosions;
        }

        public void setExplosions(HashSet<Explosion> explosions){
                this.explosions = explosions;
        }

        @Override
        public String toString(){
                return "Board{" + "bombers=" + bombers + ", bombs=" + bombs + ", bricks=" + bricks + ", walls=" + walls + '}';
        }

}
