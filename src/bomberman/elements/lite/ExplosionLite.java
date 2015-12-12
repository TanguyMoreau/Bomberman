/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements.lite;

import bomberman.elements.lite.geometry.GeometryLite;
import java.io.Serializable;

/**
 *
 * @author grochette
 */
public class ExplosionLite extends IndestructibleLite implements Serializable {

    public ExplosionLite(GeometryLite body) {
        super(body);
    }

}
