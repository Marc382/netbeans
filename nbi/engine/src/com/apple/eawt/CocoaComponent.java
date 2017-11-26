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

/* this is stub code written based on Apple EAWT package javadoc published at
 * http://developer.apple.com.  It makes compiling code which uses Apple EAWT
 * on non-Mac platforms possible.  The compiled stub classes should never be
 * included in the final product.
 */

package com.apple.eawt;

import java.awt.Canvas;
import java.awt.Dimension;

public abstract class CocoaComponent extends Canvas {
    public abstract int createNSView();
    
    public long createNSViewLong() {
        return 0;
    }
    
    @Override
    public abstract Dimension getMaximumSize();
    
    @Override
    public abstract Dimension getMinimumSize();
    
    @Override
    public abstract Dimension getPreferredSize();
    
    public void sendMessage(final int messageID, final Object message) {
        // does nothing
    }
}
