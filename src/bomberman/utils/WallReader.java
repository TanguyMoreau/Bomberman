/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.utils;

import bomberman.Board;
import bomberman.elements.Wall;
import bomberman.elements.geometry.Geometry;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grochette
 */
public class WallReader{

        public static ArrayList<Wall> readFile(Board board, String filename){
                ArrayList<Wall> walls = new ArrayList<>();
                try(BufferedReader br = new BufferedReader(new FileReader(filename))){
                        String line = br.readLine();
                        while(line != null){
                                String[] split = line.split(" ");
                                int x = Integer.parseInt(split[0]), y = Integer.parseInt(split[1]), radius = Integer.parseInt(split[2]);
                                Geometry aBody = new Geometry(x, y, radius);
                                Wall aWall = new Wall(board, aBody);
                                walls.add(aWall);
                                line = br.readLine();
                        }
                }
                catch(FileNotFoundException ex){
                        Logger.getLogger(WallReader.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch(IOException ex){
                        Logger.getLogger(WallReader.class.getName()).log(Level.SEVERE, null, ex);
                }
                return walls;
        }
}
