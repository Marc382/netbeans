/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.lib.profiler.server;

import org.netbeans.lib.profiler.global.CommonConstants;
import org.netbeans.lib.profiler.server.system.GC;


/**
 * Performs special handling of Take Snapshot profiling points on server side.
 *
 * @author Tomas Hurka
 * @author Maros Sandor
 */
public class TakeSnapshotProfilingPointHandler extends ProfilingPointServerHandler {
    //~ Static fields/initializers -----------------------------------------------------------------------------------------------

    private static ProfilingPointServerHandler instance;

    //~ Methods ------------------------------------------------------------------------------------------------------------------

    public static synchronized ProfilingPointServerHandler getInstance(String clientInfo) {
        if (instance == null) {
            instance = new TakeSnapshotProfilingPointHandler();
        }

        return instance;
    }

    public void profilingPointHit(int id) {
        int instrType = ProfilerInterface.getCurrentInstrType();
        boolean cpuProfiling = (instrType == CommonConstants.INSTR_RECURSIVE_FULL)
                               || (instrType == CommonConstants.INSTR_RECURSIVE_SAMPLED);

        if (cpuProfiling) { // CPU profiling
            ProfilerRuntimeCPU.suspendCurrentThreadTimer();
        } else {
            GC.runGC();

            // TODO: REVISIT: to wait for ProfilerRuntimeObjLiveness.ReferenceManagerThread, should be removed once we utilize object tags 
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
            }
        }

        super.profilingPointHit(id);
        ProfilerRuntime.dumpEventBuffer();

        if (cpuProfiling) {
            ProfilerRuntimeCPU.resumeCurrentThreadTimer();
        }
    }
}
