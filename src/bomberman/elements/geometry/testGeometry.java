/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements.geometry;

/**
 *
 * @author grochette
 */
public class testGeometry{

        public static void main(String[] args){
                Geometry a = new Geometry(5, 5, 1);
                Geometry b = new Geometry(5, 5, 1);

                System.out.println(a);
                System.out.println(b);
                System.out.println(Geometry.distanceInfinity(a.getPosition(), b.getPosition()));
                System.out.println(a.isInBall(b));
                System.out.println(a.equals(b));
        }
}
