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
package org.netbeans.modules.css.prep.ui.options;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.modules.css.prep.less.LessExecutable;
import org.netbeans.modules.css.prep.util.FileUtils;
import org.netbeans.modules.web.common.ui.api.CssPreprocessorsUI;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.awt.HtmlBrowser;
import org.openide.awt.Mnemonics;
import org.openide.awt.StatusDisplayer;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.util.ChangeSupport;
import org.openide.util.NbBundle;

@OptionsPanelController.Keywords(keywords={"css", "preprocessors", "less", "#CssPrepOptionsPanel.keywords.preprocessing"},
        location=CssPreprocessorsUI.OPTIONS_CATEGORY, tabTitle="#CssPrepOptionsPanel.name")
public final class LessOptionsPanel extends JPanel {

    private static final long serialVersionUID = 268356546654654L;

    private static final Logger LOGGER = Logger.getLogger(LessOptionsPanel.class.getName());

    private final ChangeSupport changeSupport = new ChangeSupport(this);


    public LessOptionsPanel() {
        initComponents();
        init();
    }

    @NbBundle.Messages({
        "# {0} - longscript name",
        "# {1} - short script name",
        "LessOptionsPanel.less.path.hint=Full path of LESS executable (typically {0} or {1}).",
    })
    private void init() {
        lessPathHintLabel.setText(Bundle.LessOptionsPanel_less_path_hint(LessExecutable.EXECUTABLE_LONG_NAME, LessExecutable.EXECUTABLE_NAME));

        // listeners
        lessPathTextField.getDocument().addDocumentListener(new DefaultDocumentListener());
        DefaultItemListener defaultItemListener = new DefaultItemListener();
        lessOutputOnErrorCheckBox.addItemListener(defaultItemListener);
        lessDebugCheckBox.addItemListener(defaultItemListener);
    }

    public String getLessPath() {
        return lessPathTextField.getText();
    }

    public void setLessPath(String path) {
        lessPathTextField.setText(path);
    }

    public boolean getLessOutputOnError() {
        return lessOutputOnErrorCheckBox.isSelected();
    }

    public void setLessOutputOnError(boolean outputOnError) {
        lessOutputOnErrorCheckBox.setSelected(outputOnError);
    }

    public boolean getLessDebug() {
        return lessDebugCheckBox.isSelected();
    }

    public void setLessDebug(boolean debug) {
        lessDebugCheckBox.setSelected(debug);
    }

    public void addChangeListener(ChangeListener listener) {
        changeSupport.addChangeListener(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        changeSupport.removeChangeListener(listener);
    }

    void fireChange() {
        changeSupport.fireChange();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lessPathLabel = new JLabel();
        lessPathTextField = new JTextField();
        lessPathBrowseButton = new JButton();
        lessPathSearchButton = new JButton();
        lessPathHintLabel = new JLabel();
        installLessLabel = new JLabel();
        lessOutputOnErrorCheckBox = new JCheckBox();
        lessDebugCheckBox = new JCheckBox();

        lessPathLabel.setLabelFor(lessPathTextField);
        Mnemonics.setLocalizedText(lessPathLabel, NbBundle.getMessage(LessOptionsPanel.class, "LessOptionsPanel.lessPathLabel.text")); // NOI18N

        Mnemonics.setLocalizedText(lessPathBrowseButton, NbBundle.getMessage(LessOptionsPanel.class, "LessOptionsPanel.lessPathBrowseButton.text")); // NOI18N
        lessPathBrowseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                lessPathBrowseButtonActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(lessPathSearchButton, NbBundle.getMessage(LessOptionsPanel.class, "LessOptionsPanel.lessPathSearchButton.text")); // NOI18N
        lessPathSearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                lessPathSearchButtonActionPerformed(evt);
            }
        });

        Mnemonics.setLocalizedText(lessPathHintLabel, "HINT"); // NOI18N

        Mnemonics.setLocalizedText(installLessLabel, NbBundle.getMessage(LessOptionsPanel.class, "LessOptionsPanel.installLessLabel.text")); // NOI18N
        installLessLabel.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                installLessLabelMouseEntered(evt);
            }
            public void mousePressed(MouseEvent evt) {
                installLessLabelMousePressed(evt);
            }
        });

        Mnemonics.setLocalizedText(lessOutputOnErrorCheckBox, NbBundle.getMessage(LessOptionsPanel.class, "LessOptionsPanel.lessOutputOnErrorCheckBox.text")); // NOI18N

        Mnemonics.setLocalizedText(lessDebugCheckBox, NbBundle.getMessage(LessOptionsPanel.class, "LessOptionsPanel.lessDebugCheckBox.text")); // NOI18N

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lessPathLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lessPathHintLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(installLessLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lessPathTextField)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lessPathBrowseButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lessPathSearchButton))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(lessOutputOnErrorCheckBox)
                    .addComponent(lessDebugCheckBox))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lessPathTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lessPathLabel))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lessPathSearchButton)
                        .addComponent(lessPathBrowseButton)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(installLessLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lessPathHintLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lessOutputOnErrorCheckBox)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lessDebugCheckBox)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @NbBundle.Messages("LessOptionsPanel.less.browse.title=Select LESS")
    private void lessPathBrowseButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_lessPathBrowseButtonActionPerformed
        File file = new FileChooserBuilder(LessOptionsPanel.class)
                .setFilesOnly(true)
                .setTitle(Bundle.LessOptionsPanel_less_browse_title())
                .showOpenDialog();
        if (file != null) {
            lessPathTextField.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_lessPathBrowseButtonActionPerformed

    @NbBundle.Messages("LessOptionsPanel.executable.notFound=No LESS executable found.")
    private void lessPathSearchButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_lessPathSearchButtonActionPerformed
        List<String> lessPaths = FileUtils.findFileOnUsersPath(LessExecutable.EXECUTABLE_LONG_NAME, LessExecutable.EXECUTABLE_NAME);
        if (lessPaths.isEmpty()) {
            StatusDisplayer.getDefault().setStatusText(Bundle.LessOptionsPanel_executable_notFound());
        } else {
            lessPathTextField.setText(lessPaths.get(0));
        }
    }//GEN-LAST:event_lessPathSearchButtonActionPerformed

    private void installLessLabelMouseEntered(MouseEvent evt) {//GEN-FIRST:event_installLessLabelMouseEntered
        evt.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_installLessLabelMouseEntered

    private void installLessLabelMousePressed(MouseEvent evt) {//GEN-FIRST:event_installLessLabelMousePressed
        try {
            URL url = new URL("http://lesscss.org/"); // NOI18N
            HtmlBrowser.URLDisplayer.getDefault().showURL(url);
        } catch (MalformedURLException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_installLessLabelMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel installLessLabel;
    private JCheckBox lessDebugCheckBox;
    private JCheckBox lessOutputOnErrorCheckBox;
    private JButton lessPathBrowseButton;
    private JLabel lessPathHintLabel;
    private JLabel lessPathLabel;
    private JButton lessPathSearchButton;
    private JTextField lessPathTextField;
    // End of variables declaration//GEN-END:variables

    //~ Inner classes

    private final class DefaultDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e) {
            processUpdate();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            processUpdate();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            processUpdate();
        }

        private void processUpdate() {
            fireChange();
        }

    }

    private final class DefaultItemListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            fireChange();
        }

    }

}
