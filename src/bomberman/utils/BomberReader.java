/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.utils;

import bomberman.Board;
import bomberman.elements.Bomber;
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
public class BomberReader {

    public static ArrayList<Bomber> readFile(Board board, String filename) {
        ArrayList<Bomber> bombers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            while (line != null) {
                String[] split = line.split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                int radius = Integer.parseInt(split[2]);
                int healthPoints = Integer.parseInt(split[3]);
                Geometry aBody = new Geometry(x, y, radius);
                Bomber aBomber = new Bomber(board, aBody, healthPoints);
                bombers.add(aBomber);
                line = br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BomberReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BomberReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bombers;
    }
    
    public static ArrayList<Bomber> defaultFile(Board board, int numberOfPlayers){
        ArrayList<Bomber> bombers = new ArrayList<>();
        if (numberOfPlayers > 0) {
            bombers.add(new Bomber(board, new Geometry(48, 48, 10), 3));
        }
        if (numberOfPlayers > 1) {
            bombers.add(new Bomber(board, new Geometry(434, 434, 10), 3));
        }
        if (numberOfPlayers > 2) {
            bombers.add(new Bomber(board, new Geometry(434, 48, 10), 3));
        }
        if (numberOfPlayers > 3) {
            bombers.add(new Bomber(board, new Geometry(48, 434, 10), 3));
        }
        return bombers;
    }
}
