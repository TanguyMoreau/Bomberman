/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Geometry;

/**
 *
 * @author grochette
 */
public abstract class Destructible extends Entity{

        private int healthPoints;

        public Destructible(Board board, Geometry body, int healthPoints){
                super(board, body);
                this.healthPoints = healthPoints;
        }
        
        public void loseHealth(){
                this.healthPoints--;
                if(this.healthPoints==0){
                        this.die();
                }
        }
        
        public abstract void die();

        public int getHealthPoints(){
                return healthPoints;
        }

        public void setHealthPoints(int healthPoints){
                this.healthPoints = healthPoints;
        }

}
