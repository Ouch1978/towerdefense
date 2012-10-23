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

package com.mechanitis.towerdefense2;

import com.lmax.disruptor.EventHandler;

public class Turret implements EventHandler<Enemy> {
    @Override
    public void onEvent(Enemy enemy, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(sequence + " An enemy on the horizon! " + enemy);
        enemy.shootAt();
    }
}
