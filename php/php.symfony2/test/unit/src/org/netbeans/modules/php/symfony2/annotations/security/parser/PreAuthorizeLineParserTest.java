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
package org.netbeans.modules.php.symfony2.annotations.security.parser;

import java.util.Map;
import org.netbeans.junit.NbTestCase;
import org.netbeans.modules.csl.api.OffsetRange;
import org.netbeans.modules.php.spi.annotation.AnnotationLineParser;
import org.netbeans.modules.php.spi.annotation.AnnotationParsedLine;
import org.netbeans.modules.php.spi.annotation.AnnotationParsedLine.ParsedLine;

/**
 *
 * @author Ondrej Brejla <obrejla@netbeans.org>
 */
public class PreAuthorizeLineParserTest extends NbTestCase {
    private AnnotationLineParser parser;

    public PreAuthorizeLineParserTest(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.parser = SymfonySecurityAnnotationLineParser.getDefault();
    }

    public void testIsAnnotationParser() throws Exception {
        assertTrue(parser instanceof AnnotationLineParser);
    }

    public void testReturnValueIsPreAuthorizeParsedLine_01() throws Exception {
        assertTrue(parser.parse("PreAuthorize") instanceof ParsedLine);
    }

    public void testReturnValueIsPreAuthorizeParsedLine_02() throws Exception {
        assertTrue(parser.parse("Annotations\\PreAuthorize") instanceof ParsedLine);
    }

    public void testReturnValueIsPreAuthorizeParsedLine_03() throws Exception {
        assertTrue(parser.parse("\\Sensio\\Bundle\\FrameworkExtraBundle\\Configuration\\PreAuthorize") instanceof ParsedLine);
    }

    public void testReturnValueIsPreAuthorizeParsedLine_04() throws Exception {
        assertTrue(parser.parse("Annotations\\PreAuthorize(\"hasRole('A') or (hasRole('B') and hasRole('C'))\")") instanceof ParsedLine);
    }

    public void testReturnValueIsNull() throws Exception {
        assertNull(parser.parse("PreAuthorizes"));
    }

    public void testValidUseCase_01() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("PreAuthorize");
        assertEquals("PreAuthorize", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(12, offsetRange.getEnd());
            assertEquals("PreAuthorize", value);
        }
    }

    public void testValidUseCase_02() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("PreAuthorize   ");
        assertEquals("PreAuthorize", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(12, offsetRange.getEnd());
            assertEquals("PreAuthorize", value);
        }
    }

    public void testValidUseCase_03() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("PreAuthorize\t\t  ");
        assertEquals("PreAuthorize", parsedLine.getName());
        assertEquals("", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(12, offsetRange.getEnd());
            assertEquals("PreAuthorize", value);
        }
    }

    public void testValidUseCase_04() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("PreAuthorize(\"hasRole('A') or (hasRole('B') and hasRole('C'))\")");
        assertEquals("PreAuthorize", parsedLine.getName());
        assertEquals("(\"hasRole('A') or (hasRole('B') and hasRole('C'))\")", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(12, offsetRange.getEnd());
            assertEquals("PreAuthorize", value);
        }
    }

    public void testValidUseCase_05() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("Annotations\\PreAuthorize(\"hasRole('A') or (hasRole('B') and hasRole('C'))\")  \t");
        assertEquals("PreAuthorize", parsedLine.getName());
        assertEquals("(\"hasRole('A') or (hasRole('B') and hasRole('C'))\")", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(24, offsetRange.getEnd());
            assertEquals("Annotations\\PreAuthorize", value);
        }
    }

    public void testValidUseCase_06() throws Exception {
        AnnotationParsedLine parsedLine = parser.parse("\\Sensio\\Bundle\\FrameworkExtraBundle\\Configuration\\PreAuthorize(\"hasRole('A') or (hasRole('B') and hasRole('C'))\")  \t");
        assertEquals("PreAuthorize", parsedLine.getName());
        assertEquals("(\"hasRole('A') or (hasRole('B') and hasRole('C'))\")", parsedLine.getDescription());
        Map<OffsetRange, String> types = parsedLine.getTypes();
        assertNotNull(types);
        for (Map.Entry<OffsetRange, String> entry : types.entrySet()) {
            OffsetRange offsetRange = entry.getKey();
            String value = entry.getValue();
            assertEquals(0, offsetRange.getStart());
            assertEquals(62, offsetRange.getEnd());
            assertEquals("\\Sensio\\Bundle\\FrameworkExtraBundle\\Configuration\\PreAuthorize", value);
        }
    }

}
