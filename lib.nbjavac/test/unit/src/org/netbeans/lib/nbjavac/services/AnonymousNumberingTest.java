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

package org.netbeans.lib.nbjavac.services;

import com.sun.source.tree.CompilationUnitTree;
import com.sun.tools.javac.api.JavacTaskImpl;
import com.sun.tools.javac.code.Symbol;
import com.sun.tools.javac.code.Symtab;
import com.sun.tools.javac.comp.Modules;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Name;
import java.io.IOException;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import junit.framework.TestCase;

/**
 *
 * @author lahvac
 */
public class AnonymousNumberingTest extends TestCase {

    public AnonymousNumberingTest(String name) {
        super(name);
    }

    public void testCorrectAnonymousIndicesForMethodInvocations() throws Exception {
        String code = "package test;\n" +
                      "public class Test {\n" +
                      "    public Test main(Object o) {\n" +
                      "        return new Test().main(new Runnable() {\n" +
                      "            public void run() {\n" +
                      "                throw new UnsupportedOperationException();\n" +
                      "            }\n" +
                      "        }).main(new Iterable() {\n" +
                      "            public java.util.Iterator iterator() {\n" +
                      "                throw new UnsupportedOperationException();\n" +
                      "            }\n" +
                      "        });\n" +
                      "    }\n" +
                      "}";

        JavacTaskImpl ct = Utilities.createJavac(null, Utilities.fileObjectFor(code));
        
        Iterable<? extends CompilationUnitTree> cuts = ct.parse();
        Iterable<? extends Element> analyze = ct.analyze();
        
        System.err.println("repair: " + Class.forName("com.sun.tools.javac.comp.Repair"));
        Symtab symTab = Symtab.instance(ct.getContext());
        
        for (Symbol.ClassSymbol cs : symTab.getAllClasses()) {
            if (cs.flatname.toString().contains("test.Test")) {
                System.err.println("XXX");
            }
        }
        Modules modules = Modules.instance(ct.getContext());
        TypeElement first = symTab.getClass(modules.getDefaultModule(), (Name)ct.getElements().getName("test.Test$1"));
        TypeElement second = symTab.getClass(modules.getDefaultModule(), (Name)ct.getElements().getName("test.Test$2"));

        assertEquals("java.lang.Iterable", ((TypeElement) ((DeclaredType) first.getInterfaces().get(0)).asElement()).getQualifiedName().toString());
        assertEquals("java.lang.Runnable", ((TypeElement) ((DeclaredType) second.getInterfaces().get(0)).asElement()).getQualifiedName().toString());
    }

    public void testCorrectAnonymousIndicesForMultipleMethods() throws IOException {
        String code = "package test;\n" +
                      "public class Test {\n" +
                      "    public Test main1(Object o) {\n" +
                      "        new Runnable() {\n" +
                      "            public void run() {\n" +
                      "                throw new UnsupportedOperationException();\n" +
                      "            }\n" +
                      "        };" +
                      "    }" +
                      "    public Test main2(Object o) {\n" +
                      "        new Iterable() {\n" +
                      "            public java.util.Iterator iterator() {\n" +
                      "                throw new UnsupportedOperationException();\n" +
                      "            }\n" +
                      "        };\n" +
                      "    }\n" +
                      "    public Test main3(Object o) {\n" +
                      "        new java.util.ArrayList() {};\n" +
                      "    }\n" +
                      "}";

        JavacTaskImpl ct = Utilities.createJavac(null, Utilities.fileObjectFor(code));

        ct.analyze();

        Symtab symTab = Symtab.instance(ct.getContext());
        Modules modules = Modules.instance(ct.getContext());
        TypeElement first = symTab.getClass(modules.getDefaultModule(), (Name)ct.getElements().getName("test.Test$1"));
        TypeElement second = symTab.getClass(modules.getDefaultModule(), (Name)ct.getElements().getName("test.Test$2"));
        TypeElement third = symTab.getClass(modules.getDefaultModule(), (Name)ct.getElements().getName("test.Test$3"));

        assertEquals("java.lang.Runnable", ((TypeElement) ((DeclaredType) first.getInterfaces().get(0)).asElement()).getQualifiedName().toString());
        assertEquals("java.lang.Iterable", ((TypeElement) ((DeclaredType) second.getInterfaces().get(0)).asElement()).getQualifiedName().toString());
        assertEquals("java.util.ArrayList", ((TypeElement) ((DeclaredType) third.getSuperclass()).asElement()).getQualifiedName().toString());
    }

    public void testCorrectNameForAnonymous() throws IOException {
        String code = "package test;\n" +
                      "public class Test {\n" +
                      "    public Test main1(Object o) {\n" +
                      "        new Runnable() {\n" +
                      "            public void run() {\n" +
                      "                throw new UnsupportedOperationException();\n" +
                      "            }\n" +
                      "        };" +
                      "        new Iterable() {\n" +
                      "            public java.util.Iterator iterator() {\n" +
                      "                new java.util.ArrayList() {};\n" +
                      "            }\n" +
                      "        };\n" +
                      "    }\n" +
                      "}";

        JavacTaskImpl ct = Utilities.createJavac(null, Utilities.fileObjectFor(code));
        
        ct.analyze();

        Symtab symTab = Symtab.instance(ct.getContext());
        Modules modules = Modules.instance(ct.getContext());
        TypeElement first = symTab.getClass(modules.getDefaultModule(), (Name)ct.getElements().getName("test.Test$1"));
        TypeElement second = symTab.getClass(modules.getDefaultModule(), (Name)ct.getElements().getName("test.Test$2"));
        TypeElement third = symTab.getClass(modules.getDefaultModule(), (Name)ct.getElements().getName("test.Test$2$1"));

        assertEquals("java.lang.Runnable", ((TypeElement) ((DeclaredType) first.getInterfaces().get(0)).asElement()).getQualifiedName().toString());
        assertEquals("java.lang.Iterable", ((TypeElement) ((DeclaredType) second.getInterfaces().get(0)).asElement()).getQualifiedName().toString());
        assertEquals("java.util.ArrayList", ((TypeElement) ((DeclaredType) third.getSuperclass()).asElement()).getQualifiedName().toString());
    }

}
