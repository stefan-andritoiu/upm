/**
 * Author: Serban Waltter <serban.waltter@rinftech.com>
 * 
 */

import java.util.ArrayList;

import upm_collision.Collision;
import upm_grovecollision.*;
import upm_new_interfaces.*;

/**
 * iCollision_Example
 */
public class iCollision_Example {
    public static void main(String[] args) {
        ArrayList<iCollision> sensors = new ArrayList<iCollision>();
        sensors.add(new GroveCollision(2));
        sensors.add(new Collision(2));

        boolean collisionState = false;

		// ! [Interesting]
		while(true){
            for (int i = 0; i < sensors.size(); i++) {
                if(sensors.get(i).isColliding() && !collisionState){
                    System.out.println("Collision on sensor " + i + "!!");
                    collisionState = true;
                }
                else if (collisionState){
                    System.out.println("No Collision on sensor " + i + "!!");
                    collisionState = false;
                }
            }
		}
    }
    
}