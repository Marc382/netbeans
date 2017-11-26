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
package org.netbeans.modules.java.j2seproject.ui.wizards;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.netbeans.modules.java.api.common.classpath.ClassPathSupport;
import org.netbeans.modules.java.api.common.project.ui.customizer.ClassPathListCellRenderer;
import org.netbeans.modules.java.j2seproject.J2SEProject;
import org.openide.util.NbBundle;

/**
 *
 * @author Dusan Balek
 */
public class MoveToModulePathPanelGUI extends javax.swing.JPanel {

    private final List<ChangeListener> listeners = new ArrayList<>();

    /**
     * Creates new form MoveToModulePathPanelGUI
     */
    public MoveToModulePathPanelGUI(J2SEProject project) {

        initComponents();

        table.getDefaultEditor(Boolean.class).addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                fireChange();
            }
            @Override
            public void editingCanceled(ChangeEvent e) {
            }
        });
        table.setDefaultRenderer(Object.class, ClassPathListCellRenderer.createClassPathTableRenderer(project.evaluator(), project.getProjectDirectory()));        
        table.setRowHeight(table.getRowHeight() + 3);
        setName(NbBundle.getBundle(MoveToModulePathPanelGUI.class).getString("LBL_MoveToModulePathPanelGUI_Name")); //NOI18N
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Classpath entries", "Move to modulepath"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(MoveToModulePathPanelGUI.class, "MoveToModulePathPanelGUI.table.columnModel.title0")); // NOI18N
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(MoveToModulePathPanelGUI.class, "MoveToModulePathPanelGUI.table.columnModel.title1")); // NOI18N
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void addChangeListener(ChangeListener l) {
        listeners.add(l);
    }

    public void removeChangeListener(ChangeListener l) {
        listeners.remove(l);
    }

    private void fireChange() {
        ChangeEvent e = new ChangeEvent(this);
        for (ChangeListener l : listeners) {
            l.stateChanged(e);
        }
    }

    void setCPItems(Iterable<ClassPathSupport.Item> cpItems) {
        for (int i = table.getRowCount() -1; i >= 0 ; i--) {
            ((DefaultTableModel) table.getModel()).removeRow(i);            
        }
        for (ClassPathSupport.Item cpItem : cpItems) {
            ((DefaultTableModel) table.getModel()).addRow(new Object[]{cpItem, true});
        }
    }

    public Iterable<ClassPathSupport.Item> getCPItemsToMove() {
        List<ClassPathSupport.Item> itemsToMove = new ArrayList<>();
        for (int i = 0; i < table.getModel().getRowCount(); i++) {
            if ((boolean) table.getModel().getValueAt(i, 1)) {
                itemsToMove.add((ClassPathSupport.Item) table.getModel().getValueAt(i, 0));
            }
        }
        return itemsToMove;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
