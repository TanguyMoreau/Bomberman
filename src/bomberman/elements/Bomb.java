/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Geometry;
import bomberman.elements.lite.BombLite;

/**
 *
 * @author grochette
 */
public class Bomb extends Indestructible{

        private int countdown;
        private double blastRadius;
        private Bomber owner;

        public Bomb(Board board, Bomber owner){
                super(board, owner.getBody());
                this.blastRadius = owner.getBlastRadius();
                this.owner = owner;
                this.countdown = 5;
        }

        public int getCountdown(){
                return countdown;
        }

        public void setCountdown(int countdown){
                this.countdown = countdown;
        }

        public double getBlastRadius(){
                return blastRadius;
        }

        public void setBlastRadius(double blastRadius){
                this.blastRadius = blastRadius;
        }

        public Bomber getOwner(){
                return owner;
        }

        public void setOwner(Bomber owner){
                this.owner = owner;
        }

        private void explode(){
                Explosion anExplosion = new Explosion(this.getBoard(), new Geometry(this.getBody().getPosition(), blastRadius));
                this.getBoard().getBombs().remove(this);
                this.getBoard().getExplosions().add(anExplosion);
        }

        public void tick(){
                this.countdown--;
                if(countdown == 0){
                        explode();
                }
        }

        public BombLite getBombLite(){
                return new BombLite(this.getBody().getGeometryLite());
        }
}
