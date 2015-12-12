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
public class EntityLite implements Serializable {

    private GeometryLite body;

    public EntityLite(GeometryLite body) {
        this.body = body;
    }

    public GeometryLite getBody() {
        return body;
    }

    public void setBody(GeometryLite body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Entity{" + "body=" + body + '}';
    }
}
