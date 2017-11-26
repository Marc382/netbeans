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

/*
 * JFXIconsPanel.java
 *
 * Created on 5.2.2013
 */
package org.netbeans.modules.javafx2.project.ui;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import org.netbeans.api.annotations.common.NonNull;
import org.netbeans.api.project.Project;
import org.netbeans.modules.javafx2.project.JFXProjectProperties;
import org.netbeans.modules.javafx2.project.JFXProjectUtils;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbBundle;

/**
 *
 * @author Petr Somol
 */
public class JFXIconsPanel extends javax.swing.JPanel {

    private final Project project;
    private final JFXProjectProperties jfxProps;
    private File lastImageFolder = null;
    
    private IconFieldListener wsIconListener = null;
    private IconFieldListener splashListener = null;
    private IconFieldListener nativeIconListener = null;
    
    /**
     * Creates new form JFXIconsPanel
     */
    public JFXIconsPanel(JFXProjectProperties props, File lastFolder) {
        this.jfxProps = props;
        this.project = jfxProps.getProject();
        this.lastImageFolder = lastFolder;
        initComponents();
        wsIconTextField.setText(jfxProps.getWSIconPath());
        splashTextField.setText(jfxProps.getSplashImagePath());
        nativeIconTextField.setText(jfxProps.getNativeIconPath());
    }

    void store() {
        jfxProps.setWSIconPath(wsIconTextField.getText().trim());
        jfxProps.setSplashImagePath(splashTextField.getText().trim());
        jfxProps.setNativeIconPath(nativeIconTextField.getText().trim());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        wsIconLabel = new javax.swing.JLabel();
        wsIconTextField = new javax.swing.JTextField();
        splashLabel = new javax.swing.JLabel();
        splashTextField = new javax.swing.JTextField();
        nativeIconLabel = new javax.swing.JLabel();
        nativeIconTextField = new javax.swing.JTextField();
        wsIconButton = new javax.swing.JButton();
        splashButton = new javax.swing.JButton();
        nativeIconButton = new javax.swing.JButton();
        remarkLabel = new javax.swing.JLabel();
        wsIconToggleButton = new javax.swing.JButton();
        nativeIconToggleButton = new javax.swing.JButton();
        splashToggleButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        wsIconLabel.setLabelFor(wsIconTextField);
        org.openide.awt.Mnemonics.setLocalizedText(wsIconLabel, org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.wsIconLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(14, 38, 0, 0);
        add(wsIconLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 450;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 0);
        add(wsIconTextField, gridBagConstraints);
        wsIconTextField.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AN_JFXIconsPanel.textFieldWSIcon.text")); // NOI18N
        wsIconTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AD_JFXIconsPanel.textFieldWSIcon.text")); // NOI18N

        splashLabel.setLabelFor(splashTextField);
        org.openide.awt.Mnemonics.setLocalizedText(splashLabel, org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.splashLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(14, 44, 0, 0);
        add(splashLabel, gridBagConstraints);

        splashTextField.setText(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.splashTextField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 450;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 0);
        add(splashTextField, gridBagConstraints);
        splashTextField.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AN_JFXIconsPanel.textFieldSplashImage.text")); // NOI18N
        splashTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AD_JFXIconsPanel.textFieldSplashImage.text")); // NOI18N

        nativeIconLabel.setLabelFor(nativeIconTextField);
        org.openide.awt.Mnemonics.setLocalizedText(nativeIconLabel, org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.nativeIconLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(14, 10, 0, 0);
        add(nativeIconLabel, gridBagConstraints);

        nativeIconTextField.setText(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.nativeIconTextField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 450;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 0);
        add(nativeIconTextField, gridBagConstraints);
        nativeIconTextField.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AN_JFXIconsPanel.textFieldNativeIcon.text")); // NOI18N
        nativeIconTextField.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AD_JFXIconsPanel.textFieldNativeIcon.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(wsIconButton, org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.wsIconButton.text")); // NOI18N
        wsIconButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wsIconButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 10);
        add(wsIconButton, gridBagConstraints);
        wsIconButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AN_JFXIconsPanel.buttonWSIcon.text")); // NOI18N
        wsIconButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AD_JFXIconsPanel.buttonWSIcon.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(splashButton, org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.splashButton.text")); // NOI18N
        splashButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splashButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 10);
        add(splashButton, gridBagConstraints);
        splashButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AN_JFXIconsPanel.buttonSplashImage.text")); // NOI18N
        splashButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AD_JFXIconsPanel.buttonSplashImage.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(nativeIconButton, org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.nativeIconButton.text")); // NOI18N
        nativeIconButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nativeIconButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 10);
        add(nativeIconButton, gridBagConstraints);
        nativeIconButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AN_JFXIconsPanel.buttonNativeIcon.text")); // NOI18N
        nativeIconButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AD_JFXIconsPanel.buttonNativeIcon.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(remarkLabel, org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.remarkLabel.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 4, 3, 0);
        add(remarkLabel, gridBagConstraints);

        wsIconToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/javafx2/project/ui/resources/toggle_absolute_relative.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(wsIconToggleButton, org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.wsIconToggleButton.text")); // NOI18N
        wsIconToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wsIconToggleButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -25;
        gridBagConstraints.ipady = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        add(wsIconToggleButton, gridBagConstraints);
        wsIconToggleButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AN_JFXIconsPanel.buttonToggleWSIcon.text")); // NOI18N
        wsIconToggleButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AD_JFXIconsPanel.buttonToggleWSIcon.text")); // NOI18N

        nativeIconToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/javafx2/project/ui/resources/toggle_absolute_relative.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(nativeIconToggleButton, org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.nativeIconToggleButton.text")); // NOI18N
        nativeIconToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nativeIconToggleButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = -25;
        gridBagConstraints.ipady = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        add(nativeIconToggleButton, gridBagConstraints);
        nativeIconToggleButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AN_JFXIconsPanel.buttonToggleNativeIcon.text")); // NOI18N
        nativeIconToggleButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AD_JFXIconsPanel.buttonToggleNativeIcon.text")); // NOI18N

        splashToggleButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/netbeans/modules/javafx2/project/ui/resources/toggle_absolute_relative.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(splashToggleButton, org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "JFXIconsPanel.splashToggleButton.text")); // NOI18N
        splashToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                splashToggleButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -25;
        gridBagConstraints.ipady = -1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.ABOVE_BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        add(splashToggleButton, gridBagConstraints);
        splashToggleButton.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AN_JFXIconsPanel.buttonToggleSplashScreen.text")); // NOI18N
        splashToggleButton.getAccessibleContext().setAccessibleDescription(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "AD_JFXIconsPanel.buttonToggleSplashScreen.text")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void wsIconButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wsIconButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(null);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileFilter(new IconFileFilter(true));
        String current = wsIconTextField.getText();
        File lastFolder = current!=null ? getFileFromPath(current) : null;
        if (lastFolder != null) {
            chooser.setSelectedFile(lastFolder);
        } else if (lastImageFolder != null) {
            chooser.setSelectedFile(lastImageFolder);
        } else { // ???
            // workDir = FileUtil.toFile(project.getProjectDirectory()).getAbsolutePath();
            // chooser.setSelectedFile(new File(workDir));
        }
        chooser.setDialogTitle(NbBundle.getMessage(JFXIconsPanel.class, "LBL_Select_Icon_Image")); // NOI18N
        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this)) {
            File file = FileUtil.normalizeFile(chooser.getSelectedFile());
            String relPath = JFXProjectUtils.getRelativePath(project.getProjectDirectory(), FileUtil.toFileObject(file));
            wsIconTextField.setText(relPath);
            lastImageFolder = file;
        }
    }//GEN-LAST:event_wsIconButtonActionPerformed

    private void splashButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splashButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(null);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileFilter(new IconFileFilter(false));
        String current = splashTextField.getText();
        File lastFolder = current!=null ? getFileFromPath(current) : null;
        if (lastFolder != null) {
            chooser.setSelectedFile(lastFolder);
        } else if (lastImageFolder != null) {
            chooser.setSelectedFile(lastImageFolder);
        } else { // ???
            // workDir = FileUtil.toFile(project.getProjectDirectory()).getAbsolutePath();
            // chooser.setSelectedFile(new File(workDir));
        }
        chooser.setDialogTitle(NbBundle.getMessage(JFXIconsPanel.class, "LBL_Select_Icon_Image")); // NOI18N
        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this)) {
            File file = FileUtil.normalizeFile(chooser.getSelectedFile());
            String relPath = JFXProjectUtils.getRelativePath(project.getProjectDirectory(), FileUtil.toFileObject(file));
            splashTextField.setText(relPath);
            lastImageFolder = file;
        }
    }//GEN-LAST:event_splashButtonActionPerformed

    private void nativeIconButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nativeIconButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(null);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        chooser.setFileFilter(new IconFileFilter(false));
        String current = nativeIconTextField.getText();
        File lastFolder = current!=null ? getFileFromPath(current) : null;
        if (lastFolder != null) {
            chooser.setSelectedFile(lastFolder);
        } else if (lastImageFolder != null) {
            chooser.setSelectedFile(lastImageFolder);
        } else { // ???
            // workDir = FileUtil.toFile(project.getProjectDirectory()).getAbsolutePath();
            // chooser.setSelectedFile(new File(workDir));
        }
        chooser.setDialogTitle(NbBundle.getMessage(JFXIconsPanel.class, "LBL_Select_Icon_Image")); // NOI18N
        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this)) {
            File file = FileUtil.normalizeFile(chooser.getSelectedFile());
            String relPath = JFXProjectUtils.getRelativePath(project.getProjectDirectory(), FileUtil.toFileObject(file));
            nativeIconTextField.setText(relPath);
            lastImageFolder = file;
        }
    }//GEN-LAST:event_nativeIconButtonActionPerformed

    private void togglePathType(@NonNull JTextField field) {
        String path = field.getText();
        if(isAbsolutePath(path)) {
            File file = getFileFromPath(path);
            String r = getRelativePath(file);
            if(r != null && !r.isEmpty()) {
                field.setText(r);
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        } else {
            if(isRelativePath(path)) {
                File file = getFileFromPath(path);
                String a = getAbsolutePath(file);
                if(a != null && !a.isEmpty()) {
                    field.setText(a);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
    }
    
    private void wsIconToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wsIconToggleButtonActionPerformed
        togglePathType(wsIconTextField);
    }//GEN-LAST:event_wsIconToggleButtonActionPerformed

    private void splashToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_splashToggleButtonActionPerformed
        togglePathType(splashTextField);
    }//GEN-LAST:event_splashToggleButtonActionPerformed

    private void nativeIconToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nativeIconToggleButtonActionPerformed
        togglePathType(nativeIconTextField);
    }//GEN-LAST:event_nativeIconToggleButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton nativeIconButton;
    private javax.swing.JLabel nativeIconLabel;
    private javax.swing.JTextField nativeIconTextField;
    private javax.swing.JButton nativeIconToggleButton;
    private javax.swing.JLabel remarkLabel;
    private javax.swing.JButton splashButton;
    private javax.swing.JLabel splashLabel;
    private javax.swing.JTextField splashTextField;
    private javax.swing.JButton splashToggleButton;
    private javax.swing.JButton wsIconButton;
    private javax.swing.JLabel wsIconLabel;
    private javax.swing.JTextField wsIconTextField;
    private javax.swing.JButton wsIconToggleButton;
    // End of variables declaration//GEN-END:variables

    /**
     * WebStart accepts GIF, JPG only
     * No restriction assumed for splash images
     * Native Package icons currently accept native icons only, but should
     * soon accept general bitmaps, thus imposing no limit here
     */
    private static class IconFileFilter extends FileFilter {

        private boolean wsOnly = false;
        
        public IconFileFilter(boolean forWebStart) {
            this.wsOnly = forWebStart;
        }
        
        // should check size of images?
        public boolean accept(File f) {
            if (f.isDirectory()) {
                return true;
            }
            String name = f.getName();
            int index = name.lastIndexOf('.');
            if (index > 0 && index < name.length() - 1) {
                String ext = name.substring(index+1).toLowerCase();
                if ("gif".equals(ext) || "jpg".equals(ext) || // NOI18N
                        (!wsOnly && ("png".equals(ext) || "ico".equals(ext) || "icns".equals(ext))) )  { // NOI18N
                    return true;
                }
            }
            return false;
        }

        public String getDescription() {
            return NbBundle.getMessage(JFXIconsPanel.class, "MSG_IconFileFilter_Description"); // NOI18N
        }

    }

    boolean isAbsolutePath(String file) {
        File f = new File(file);
        return f.exists();
    }

    boolean isRelativePath(String file) {
        File f = new File(project.getProjectDirectory().getPath() + File.separator + file);
        return f.exists();
    }

    /**
     * return File from String path, either absolute or project-relative
     * @param file String path representation
     * @return File or null if path invalid
     */
    File getFileFromPath(String file) {
        if(file == null || file.isEmpty()) {
            return null;
        }
        File f = new File(file);
        if(f.exists()) {
            return f.getAbsoluteFile();
        }
        f = new File(project.getProjectDirectory().getPath() + File.separator + file);
        if(f.exists()) {
            return f.getAbsoluteFile();
        }
        return null;
    }
    
    String getRelativePath(@NonNull File file) {
        return JFXProjectUtils.getRelativePath(project.getProjectDirectory(), FileUtil.toFileObject(file));
    }
    
    String getAbsolutePath(@NonNull File file) {
        try {
            return file.getCanonicalPath();
        } catch (IOException ex) {
            return file.getAbsolutePath();
        }
    }
    
    class IconFieldListener implements DocumentListener {      
        private ToggleButtonUpdater toggleUpdater;
        public IconFieldListener(ToggleButtonUpdater toggleUpdater) {
            this.toggleUpdater = toggleUpdater;
        }
        public void changedUpdate(DocumentEvent e) {
            updateComponent();
        }
        public void removeUpdate(DocumentEvent e) {
            updateComponent();
        }
        public void insertUpdate(DocumentEvent e) {
            updateComponent();
        }
        public void updateComponent() {
            if(toggleUpdater != null) {
                toggleUpdater.update();
            }
        }
    }
    
    /**
     * on IconTextField edit check if field contents represent existing local file,
     * and accordingly enable/disable the absolute- vs. project-relative path type conversion button
     */
    class ToggleButtonUpdater {
        private JComponent button;
        private JTextField field;
        ToggleButtonUpdater(@NonNull JComponent button, @NonNull JTextField field) {
            this.button = button;
            this.field = field;
        }
        void update() {
            String path = field.getText();
            if(getFileFromPath(path) != null) {
                button.setEnabled(true);
                button.setToolTipText(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "TOOLTIP_IconsPanel.togglepath.text")); // NOI18N
            } else {
                button.setEnabled(false);
                button.setToolTipText(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "TOOLTIP_IconsPanel.notafile.text")); // NOI18N
                if(path!= null && !path.isEmpty()) {
                    field.setToolTipText(org.openide.util.NbBundle.getMessage(JFXIconsPanel.class, "TOOLTIP_IconsPanel.notafile.text")); // NOI18N
                } else {
                    field.setToolTipText(null);
                }
            }
        }
    }
    
    public void registerDocumentListeners() {
        wsIconListener = new IconFieldListener(new ToggleButtonUpdater(wsIconToggleButton, wsIconTextField));
        wsIconTextField.getDocument().addDocumentListener(wsIconListener);
        splashListener = new IconFieldListener(new ToggleButtonUpdater(splashToggleButton, splashTextField));
        splashTextField.getDocument().addDocumentListener(splashListener);
        nativeIconListener = new IconFieldListener(new ToggleButtonUpdater(nativeIconToggleButton, nativeIconTextField));
        nativeIconTextField.getDocument().addDocumentListener(nativeIconListener);
        wsIconListener.updateComponent();
        splashListener.updateComponent();
        nativeIconListener.updateComponent();
    }

    public void unregisterDocumentListeners() {
        wsIconTextField.getDocument().removeDocumentListener(wsIconListener);
        splashTextField.getDocument().removeDocumentListener(splashListener);
        nativeIconTextField.getDocument().removeDocumentListener(nativeIconListener);
    }
}
