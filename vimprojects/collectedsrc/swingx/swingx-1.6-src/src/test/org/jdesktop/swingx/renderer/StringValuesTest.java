/*
 * $Id: StringValuesTest.java 3297 2009-03-11 13:45:10Z kleopatra $
 *
 * Copyright 2008 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 */
package org.jdesktop.swingx.renderer;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author Karl George Schaefer
 */
@RunWith(JUnit4.class)
public class StringValuesTest extends TestCase {
    @Test
    public void testFileNameWithNonFile() {
        Object o = new Object();
        
        assertEquals(StringValues.TO_STRING.getString(o),
                StringValues.FILE_NAME.getString(o));
    }
    
    //not asserting the output of file name just that it isn't empty
    // PENDING JW: don't quite understand what we are testing here - need to update to 
    // TO_STRING as of fixing #972?
    @Test
    public void testFileNameWithFile() throws Exception {
        File f = File.createTempFile("svt", "tmp");
        f.deleteOnExit();
        
        assertNotSame(StringValues.EMPTY.getString(f),
                StringValues.FILE_NAME.getString(f));
    }
    
    @Test
    public void testFileTypeWithNonFile() {
        Object o = new Object();
        
        assertEquals(StringValues.TO_STRING.getString(o),
                StringValues.FILE_TYPE.getString(o));
    }
    
    //not asserting the output of file type just that it isn't empty
    @Test
    public void testFileTypeWithFile() throws Exception {
        File f = File.createTempFile("svt", "tmp");
        f.deleteOnExit();
        
        assertNotSame(StringValues.EMPTY.getString(f),
                StringValues.FILE_TYPE.getString(f));
    }
}