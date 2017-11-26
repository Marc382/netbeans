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

package org.netbeans.api.debugger.test;

import org.netbeans.api.debugger.DebuggerInfo;
import org.netbeans.spi.debugger.SessionProvider;
import org.netbeans.spi.debugger.ContextProvider;

/**
 * Provider for Test debugger session.
 *
 * @author Maros Sandor
 */
public class TestSessionProvider extends SessionProvider {

    private DebuggerInfo info;
    private TestDICookie cookie;

    public TestSessionProvider (ContextProvider info) {
        this.info = info.lookupFirst(null, DebuggerInfo.class);
        cookie = info.lookupFirst(null, TestDICookie.class);
    };
    
    public String getSessionName () {
        return "Test session";
    }
    
    public String getLocationName () {
        return "localhost";
    }
    
    public String getTypeID () {
        return TestDebugger.SESSION_ID;
    }
    
    public Object[] getServices () {
        return new Object [0];
    }
}
