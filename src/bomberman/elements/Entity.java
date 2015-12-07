/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements;

import bomberman.Board;
import bomberman.elements.geometry.Geometry;
import java.util.Objects;

/**
 * @author grochette
 */
public abstract class Entity{

        private Board board;
        private Geometry body;

        public Entity(Board board, Geometry body){
                this.board = board;
                this.body = body;
        }

        public Board getBoard(){
                return board;
        }

        public void setBoard(Board board){
                this.board = board;
        }

        public Geometry getBody(){
                return body;
        }

        public void setBody(Geometry body){
                this.body = body;
        }

        @Override
        public String toString(){
                return "body=" + body;
        }
}
