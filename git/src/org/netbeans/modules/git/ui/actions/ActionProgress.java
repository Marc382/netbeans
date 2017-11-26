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

package org.netbeans.modules.git.ui.actions;

import org.netbeans.modules.git.client.GitProgressSupport;
import org.openide.util.RequestProcessor.Task;

/**
 *
 * @author Ondrej Vrabec
 */
public interface ActionProgress {
    
    Task getActionTask ();
    
    boolean isCanceled ();
    
    boolean isError ();
    
    boolean isFinishedSuccess ();    
    
    public static final class DefaultActionProgress implements ActionProgress {
    
        private final GitProgressSupport supp;

        public DefaultActionProgress (GitProgressSupport supp) {
            this.supp = supp;
        }

        @Override
        public Task getActionTask () {
            return supp.getTask();
        }

        @Override
        public boolean isCanceled () {
            return supp.isCanceled();
        }

        @Override
        public boolean isError () {
            return supp.isError();
        }

        @Override
        public boolean isFinishedSuccess () {
            return supp.isFinishedSuccessfully();
        }
    }
    
    public static final class ActionResult implements ActionProgress {
        private final boolean canceled;
        private final boolean error;

        public ActionResult (boolean canceled, boolean error) {
            this.canceled = canceled;
            this.error = error;
        }
        
        @Override
        public Task getActionTask () {
            return null;
        }

        @Override
        public boolean isCanceled () {
            return canceled;
        }

        @Override
        public boolean isError () {
            return error;
        }

        @Override
        public boolean isFinishedSuccess () {
            return !(canceled || error);
        }
        
    }
    
}
