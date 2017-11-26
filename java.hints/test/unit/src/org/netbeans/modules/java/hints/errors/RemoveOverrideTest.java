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
package org.netbeans.modules.java.hints.errors;

import com.sun.source.util.TreePath;
import java.util.List;
import java.util.Set;
import org.netbeans.api.java.source.CompilationInfo;
import org.netbeans.modules.java.hints.infrastructure.ErrorHintsTestBase;
import org.netbeans.spi.editor.hints.Fix;

/**
 *
 * @author lahvac
 */
public class RemoveOverrideTest extends ErrorHintsTestBase {
    
    public RemoveOverrideTest(String name) {
        super(name);
    }
    
    public void testRemoveOverride() throws Exception {
        performFixTest("test/Test.java",
                       "package test;\n" +
                       "public class Test {\n" +
                       "    @Override public void test() {\n" +
                       "    }\n" +
                       "}\n",
                       -1,
                       Bundle.FIX_RemoveOverride(),
                       ("package test;\n" +
                       "public class Test {\n" +
                       "    public void test() {\n" +
                       "    }\n" +
                       "}\n").replaceAll("[ \t\n]+", " "));
    }

    @Override
    protected List<Fix> computeFixes(CompilationInfo info, int pos, TreePath path) throws Exception {
        return new RemoveOverride().run(info, null, pos, path, null);
    }

    @Override
    protected String toDebugString(CompilationInfo info, Fix f) {
        return f.getText();
    }

    @Override
    protected Set<String> getSupportedErrorKeys() {
        return new RemoveOverride().getCodes();
    }

}
