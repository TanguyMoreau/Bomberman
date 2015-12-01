/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberman.elements.properties;

import java.util.Objects;

/**
 *
 * @author grochette
 */
public class Properties{
        private String name;
        private String color;

        public String getName(){
                return name;
        }

        public void setName(String name){
                this.name = name;
        }

        public String getColor(){
                return color;
        }

        public void setColor(String color){
                this.color = color;
        }

        public Properties(String name, String color){
                this.name = name;
                this.color = color;
        }

        @Override
        public int hashCode(){
                int hash = 5;
                hash = 31 * hash + Objects.hashCode(this.name);
                hash = 31 * hash + Objects.hashCode(this.color);
                return hash;
        }

        @Override
        public boolean equals(Object obj){
                if(obj == null){
                        return false;
                }
                if(getClass() != obj.getClass()){
                        return false;
                }
                final Properties other = (Properties) obj;
                if(!Objects.equals(this.name, other.name)){
                        return false;
                }
                if(!Objects.equals(this.color, other.color)){
                        return false;
                }
                return true;
        }

        @Override
        public String toString(){
                return "Properties{" + "name=" + name + ", color=" + color + '}';
        }
}
