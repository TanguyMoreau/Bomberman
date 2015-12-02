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

        private double blastRadius;

        public double getBlastRadius(){
                return blastRadius;
        }

        public void setBlastRadius(double blastRadius){
                this.blastRadius = blastRadius;
        }

        public Explosion(Board board, Geometry body, double blastRadius){
                super(board, body);
                this.blastRadius = blastRadius;
        }

}
