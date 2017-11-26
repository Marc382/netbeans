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

package org.netbeans.modules.hibernate.loaders.cfg.multiview;

import javax.swing.table.AbstractTableModel;
import org.netbeans.modules.hibernate.cfg.model.SessionFactory;
import org.openide.util.NbBundle;

/**
 * Table model for the class cache table
 * 
 * @author Dongmei Cao
 */
public class ClassCachesTableModel extends AbstractTableModel {

    private static final String[] columnNames = {
        NbBundle.getMessage(SecurityTableModel.class, "LBL_Class"),
        NbBundle.getMessage(SecurityTableModel.class, "LBL_Region"),
        NbBundle.getMessage(SecurityTableModel.class, "LBL_Usage"),
        NbBundle.getMessage(SecurityTableModel.class, "LBL_Include")
    };
    // Matches the attribute name used in org.netbeans.modules.hibernate.cfg.model.SessionFactory
    private static final String attrNames[] = new String[]{"Class", "Region", "Usage", "Include"};
    private SessionFactory sessionFactory;

    public ClassCachesTableModel(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
    // TODO
    }

    public Object getValueAt(int row, int column) {

        if (sessionFactory == null) {
            return null;
        } else {
            String attrValue = sessionFactory.getAttributeValue(SessionFactory.CLASS_CACHE, row, attrNames[column]);
            return attrValue;
        }
    }

    public int getRowCount() {
        if (sessionFactory == null) {
            return 0;
        } else {
            return sessionFactory.sizeClassCache();
        }
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return (false);
    }
    
    /**
     * Add a new class cache element
     * 
     * @param values Contains the attribute vaues for the class cache element. 
     *               The values must be in the order of class, region, usage, include
     */
    public void addRow(String[] values) {
        
        int index = sessionFactory.addClassCache(true);
        for (int i = 0; i < values.length; i++) {
            if( values[i] != null && values[i].length() > 0)
                sessionFactory.setAttributeValue(SessionFactory.CLASS_CACHE, index, attrNames[i], values[i]);
        }

        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    /**
     *  Modify an existing class cache element
     * 
     * @param row The row to be modified
     * @param values Contains the attribute vaues for the class cache element. 
     *               The values must be in the order of class, region, usage, include
     */
    public void editRow(int row, String[] values) {
        for (int i = 0; i < values.length; i++) {
            sessionFactory.setAttributeValue(SessionFactory.CLASS_CACHE, row, attrNames[i], values[i]);
        }
        
        fireTableRowsUpdated(row, row);
    }

    public void removeRow(int row) {
        sessionFactory.removeClassCache(row);
        
        fireTableRowsDeleted(row, row);
    }
}
