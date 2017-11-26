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

package org.netbeans.core.netigso;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import org.netbeans.MockEvents;
import org.netbeans.MockModuleInstaller;
import org.netbeans.Module;
import org.netbeans.ModuleManager;

/**
 *
 * @author Jaroslav Tulach <jtulach@netbeans.org>
 */
public class NetigsoOSGiCanRequestNoMajorTest extends NetigsoHid {
    public NetigsoOSGiCanRequestNoMajorTest(String name) {
        super(name);
    }

    public void testOSGiCanRequireBundleOnNetBeans() throws Exception {
        MockModuleInstaller installer = new MockModuleInstaller();
        MockEvents ev = new MockEvents();
        ModuleManager mgr = new ModuleManager(installer, ev);
        mgr.mutexPrivileged().enterWriteAccess();
        HashSet<Module> both = null;
        try {
            String mfModule = "Manifest-Version: 1.0\n" +
                    "OpenIDE-Module: org.foo\n" +
                    "OpenIDE-Module-Name: Foo test module\n" +
                    "OpenIDE-Module-Specification-Version: 1.2\n\n\n";

            String mfBar = "Bundle-SymbolicName: org.bar\n" +
                "Bundle-Version: 1.1.0\n" +
                "Bundle-ManifestVersion: 2\n" +
                "Export-Package: org.bar\n" +
                "Require-Bundle: org.foo;bundle-version=\"[1.0,2.0)\"\n" +
                "\n\n";

            File j1 = changeManifest(new File(jars, "simple-module.jar"), mfModule);
            File j2 = changeManifest(new File(jars, "depends-on-simple-module.jar"), mfBar);
            Module m1 = mgr.create(j1, null, false, false, false);
            Module m2 = mgr.create(j2, null, false, false, false);
            HashSet<Module> b = new HashSet<Module>(Arrays.asList(m1, m2));
            mgr.enable(b);
            both = b;

            Class<?> sprclass = m1.getClassLoader().loadClass("org.foo.Something");
            Class<?> clazz = m2.getClassLoader().loadClass("org.bar.SomethingElse");

            assertEquals("Correct parent is used", sprclass, clazz.getSuperclass());
        } finally {
            if (both != null) {
                mgr.disable(both);
            }
            mgr.mutexPrivileged().exitWriteAccess();
        }
    }

}
