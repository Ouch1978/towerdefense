/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mechanitis.towerdefense4.eventhandler.turret;

import com.lmax.disruptor.EventHandler;
import com.mechanitis.towerdefense4.Enemy;

//hit rate of about 70
//Time Taken: 1341 millis
//Number of hits: 77 (out of 2048)
public class NaivePauseTurret implements EventHandler<Enemy> {
    private int locationCurrentlyBeingTargeted = -1;

    @Override
    public void onEvent(final Enemy enemy, final long sequenceNumber, final boolean endOfBatch) throws Exception {
        final int locationToFireAt = enemy.getCurrentLocation();

        //let's add a delay to the shooting.  The Turret needs to retarget, for example.
        final int distanceBetweenTurretLastTargetAndNewTargetLocation = Math.abs(locationToFireAt - locationCurrentlyBeingTargeted);
//        System.out.printf("NaivePauseTurret re-targeting, moving %d metres%n", distanceBetweenTurretLastTargetAndNewTargetLocation);
        Thread.sleep(0, distanceBetweenTurretLastTargetAndNewTargetLocation);
        locationCurrentlyBeingTargeted = locationToFireAt;

        enemy.shootAt(locationCurrentlyBeingTargeted);
    }
}
