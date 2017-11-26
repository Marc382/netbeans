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
package org.netbeans.modules.project.uiapi;

import java.awt.CardLayout;
import java.io.File;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.api.progress.ProgressHandle;
import org.netbeans.api.progress.ProgressHandleFactory;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.spi.project.support.ProjectOperations;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.ChangeSupport;
import org.openide.util.NbBundle;

/**
 * @author Jan Lahoda
 */
public class ProjectCopyPanel extends javax.swing.JPanel implements DocumentListener, DefaultProjectOperationsImplementation.InvalidablePanel {
    
    private Project project;
    private boolean isMove;
    private boolean invalid;
    
    private final ChangeSupport changeSupport = new ChangeSupport(this);
    private ProgressHandle handle;
    
    /**
     * Creates new form ProjectCopyPanel
     */
    public ProjectCopyPanel(ProgressHandle handle, Project project, boolean isMove) {
        this.project = project;
        this.isMove = isMove;
        this.handle = handle;
        
        
        initComponents();
        setProject();
        projectName.getDocument().addDocumentListener(this);
        projectLocation.getDocument().addDocumentListener(this);
        
        if (isMove) {
            nameLabel.setVisible(false);
            projectName.setVisible(false);
            warningTextArea.setVisible(false);
        }
        
        if (Boolean.getBoolean("org.netbeans.modules.project.uiapi.DefaultProjectOperations.showProgress")) {
            ((CardLayout) progress.getLayout()).show(progress, "progress");
        }
    }
    
    public void addChangeListener(ChangeListener l) {
        changeSupport.addChangeListener(l);
    }
    
    public void removeChangeListener(ChangeListener l) {
        changeSupport.removeChangeListener(l);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        projectLocation = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        projectName = new javax.swing.JTextField();
        browse = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        projectFolder = new javax.swing.JTextField();
        extSourcesWarning = new javax.swing.JLabel();
        errorMessage = new javax.swing.JLabel();
        progress = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        progressImpl = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        warningTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "LBL_Copy_Move_Dialog_Text", new Object[] {new Integer(isMove ? 1 : 0), ProjectUtils.getInformation(project).getDisplayName()})); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        add(jLabel1, gridBagConstraints);

        jLabel2.setLabelFor(projectLocation);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "LBL_Project_Location")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 12);
        add(jLabel2, gridBagConstraints);

        projectLocation.setColumns(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 5);
        add(projectLocation, gridBagConstraints);
        projectLocation.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "ACSN_Project_Location", new Object[] {})); // NOI18N
        projectLocation.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "ACSD_Project_Location", new Object[] {})); // NOI18N

        nameLabel.setLabelFor(projectName);
        org.openide.awt.Mnemonics.setLocalizedText(nameLabel, org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "LBL_Project_Name")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 12);
        add(nameLabel, gridBagConstraints);

        projectName.setColumns(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 5);
        add(projectName, gridBagConstraints);
        projectName.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "ACSN_Project_Name", new Object[] {})); // NOI18N
        projectName.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "ACSD_Project_Name", new Object[] {})); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(browse, org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "LBL_Browse", new Object[] {})); // NOI18N
        browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        add(browse, gridBagConstraints);
        browse.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "ACSD_Browse", new Object[] {})); // NOI18N

        jLabel4.setLabelFor(projectFolder);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "LBL_Project_Folder")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 12);
        add(jLabel4, gridBagConstraints);

        projectFolder.setColumns(30);
        projectFolder.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 5);
        add(projectFolder, gridBagConstraints);
        projectFolder.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "ACSN_Project_Folder", new Object[] {})); // NOI18N
        projectFolder.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "ACSD_Project_Folder", new Object[] {})); // NOI18N

        extSourcesWarning.setForeground(UIManager.getColor("nb.errorForeground"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        add(extSourcesWarning, gridBagConstraints);

        errorMessage.setForeground(UIManager.getColor("nb.errorForeground"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 0, 0, 0);
        add(errorMessage, gridBagConstraints);

        progress.setLayout(new java.awt.CardLayout());
        progress.add(jPanel4, "not-progress");

        progressImpl.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "LBL_Copying_Moving", new Object[] {isMove ? new Integer(1) : new Integer(0)})); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        progressImpl.add(jLabel5, gridBagConstraints);

        jPanel3.add(ProgressHandleFactory.createProgressComponent(handle));
        jPanel3.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        progressImpl.add(jPanel3, gridBagConstraints);

        progress.add(progressImpl, "progress");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(progress, gridBagConstraints);

        warningTextArea.setColumns(20);
        warningTextArea.setEditable(false);
        warningTextArea.setForeground(UIManager.getColor("nb.errorForeground"));
        warningTextArea.setLineWrap(true);
        warningTextArea.setRows(5);
        warningTextArea.setText(org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "VCSWarningMessage")); // NOI18N
        warningTextArea.setWrapStyleWord(true);
        warningTextArea.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        add(warningTextArea, gridBagConstraints);

        getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(ProjectCopyPanel.class, "ACSD_Copy_Move_Panel", new Object[] {new Integer(isMove ? 1 : 0)})); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseActionPerformed
// TODO add your handling code here:
        String dlgTitle = NbBundle.getMessage(ProjectCopyPanel.class, "TITLE_BrowseProjectLocation");
        String okText = NbBundle.getMessage(ProjectCopyPanel.class, "LBL_BrowseProjectLocation_OK_Button");
        File dir = new FileChooserBuilder(ProjectCopyPanel.class).setDefaultWorkingDirectory(
            new File(projectLocation.getText())).setDirectoriesOnly(
            true).setTitle(dlgTitle).setApproveText(okText).showOpenDialog();
        if (dir != null) {
            projectLocation.setText(dir.getAbsolutePath());
        }
    }//GEN-LAST:event_browseActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browse;
    private javax.swing.JLabel errorMessage;
    private javax.swing.JLabel extSourcesWarning;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel progress;
    private javax.swing.JPanel progressImpl;
    private javax.swing.JTextField projectFolder;
    private javax.swing.JTextField projectLocation;
    private javax.swing.JTextField projectName;
    private javax.swing.JTextArea warningTextArea;
    // End of variables declaration//GEN-END:variables
    
    private String lastComputedName;
    
    private String computeValidProjectName(String projectLocation, String projectNamePrefix) {
        File location = new File(projectLocation);
        
        if (!location.exists()) {
            lastComputedName = projectNamePrefix;
            return projectNamePrefix;
        }
        
        int num = 1;
        String projectName = projectNamePrefix;
        if (new File(location, projectName).exists()) {
            while (new File(location, projectName = projectNamePrefix + "_" + num).exists()) {
                num++;
            }
        }
        lastComputedName = projectName;
        return projectName;
    }
    
    private void setProject() {
        FileObject parent = project.getProjectDirectory().getParent();
        File parentFile = FileUtil.toFile(parent);
        String parentPath;
        if (parentFile != null) {
            parentPath = parentFile.getAbsolutePath();
        } else { // #199706
            parentPath = System.getProperty("java.io.tmpdir");
        }
        
        projectLocation.setText(parentPath);
        
        if (isMove) {
            projectName.setText(ProjectUtils.getInformation(project).getName());
        } else {
            projectName.setText(computeValidProjectName(parentPath, ProjectUtils.getInformation(project).getName()));
        }
        
        updateProjectFolder();
        validateDialog();
        
        if (hasExternalSources() && !isMove) {
            extSourcesWarning.setText(NbBundle.getMessage(ProjectCopyPanel.class, "WRN_External_Sources"));
            invalid = true;
        }
    }
    
    private boolean hasExternalSources() {
        FileObject projectDir = project.getProjectDirectory();
        for (FileObject file : ProjectOperations.getDataFiles(project)) {
            if (!FileUtil.isParentOf(projectDir, file) && !projectDir.equals(file)) {
                return true;
            }
        }
        return false;
    }
    
    public String getNewName() {
        return projectName.getText();
    }
    
    public String getProjectFolderName() {
        return project.getProjectDirectory().getNameExt();
    }
    
    public File getNewDirectory() {
        return new File(projectLocation.getText());
    }
    
    public void changedUpdate(DocumentEvent e) {
        //ignored
    }
    
    public void insertUpdate(DocumentEvent e) {
        if (e.getDocument().equals(projectLocation.getDocument())) {
            if (lastComputedName != null && lastComputedName.equals(projectName.getText())) {
                projectName.setText(computeValidProjectName(new File(projectLocation.getText()).getAbsolutePath(), 
                        ProjectUtils.getInformation(project).getName()));
            }            
        }
        updateProjectFolder();
        validateDialog();
    }
    
    public void removeUpdate(DocumentEvent e) {
        if (e.getDocument().equals(projectLocation.getDocument())) {
            if (lastComputedName != null && lastComputedName.equals(projectName.getText())) {
                projectName.setText(computeValidProjectName(new File(projectLocation.getText()).getAbsolutePath(), 
                        ProjectUtils.getInformation(project).getName()));
            }            
        }
        updateProjectFolder();
        validateDialog();
    }
    
    private void updateProjectFolder() {
        final File location = new File(projectLocation.getText());
        File projectFolderFile = location;
        if (isMove) {
            projectFolderFile = new File(location, project.getProjectDirectory().getNameExt());
        } else {
            projectFolderFile = new File(location, projectName.getText());
        }
        projectFolder.setText(projectFolderFile.getAbsolutePath());
    }
    
    public boolean isPanelValid() {
        return " ".equals(errorMessage.getText()) && !invalid;
    }

    private void validateDialog() {
        if (invalid) {
            //no reason to do anything:
            return ;
        }
        
        String newError = computeError();
        boolean changed = false;
        String currentError = errorMessage.getText();
        
        newError = newError != null ? newError : " ";
        changed = !currentError.equals(newError);
        
        errorMessage.setText(newError);
        
        if (changed) {
            changeSupport.fireChange();
        }
    }
    
    private String computeError() {
        File location = new File(projectLocation.getText());
        return DefaultProjectOperationsImplementation.computeError(location, projectName.getText(), projectFolder.getText(), false);
    }
    
    public void showProgress() {
        projectFolder.setEnabled(false);
        projectLocation.setEnabled(false);
        projectName.setEnabled(false);
        browse.setEnabled(false);
        
        ((CardLayout) progress.getLayout()).show(progress, "progress");
    }
}
