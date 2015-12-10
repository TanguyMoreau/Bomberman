/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements.lite;

import bomberman.elements.geometry.Geometry;
import bomberman.elements.lite.geometry.GeometryLite;
import java.io.Serializable;

/**
 *
 * @author grochette
 */
public class WallLite extends IndestructibleLite implements Serializable{

        public WallLite(GeometryLite body){
                super(body);
        }

}
