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
package org.netbeans.modules.editor.bracesmatching;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.editor.SideBarFactory;
import org.netbeans.spi.editor.mimelookup.MimeLocation;

/**
 *
 * @author sdedic
 */
@MimeRegistration(position=1400, mimeType="", service=SideBarFactory.class)
@MimeLocation(subfolderName="SideBars")
public class BraceMatchingSidebarFactory implements SideBarFactory {

    @Override
    public JComponent createSideBar(JTextComponent target) {
        return new BraceMatchingSidebarComponent(target);
    }
}
