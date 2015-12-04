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
public class Explosion extends Indestructible{
        
        public Explosion(Board board, Geometry body){
                super(board, body);
        }

        public void destroy(){
                for(Bomber aBomber : this.getBoard().getBombers()){
                        if(this.getBody().isInBall(aBomber.getBody())){
                                aBomber.loseHealth();
                        }
                }
                for(Brick aBrick : this.getBoard().getBricks()){
                        if(this.getBody().isInBall(aBrick.getBody())){
                                aBrick.loseHealth();
                        }
                }
                this.getBoard().getExplosions().remove(this);
        }

}
