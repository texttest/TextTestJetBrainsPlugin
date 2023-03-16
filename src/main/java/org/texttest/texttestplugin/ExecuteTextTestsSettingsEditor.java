package org.texttest.texttestplugin;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ExecuteTextTestsSettingsEditor extends SettingsEditor<ExecuteTextTestsRunConfiguration> {

    private JPanel myPanel;
    private LabeledComponent<TextFieldWithBrowseButton> textTestHomeChooser;

    public ExecuteTextTestsSettingsEditor() {
        super();
        createEditor();
    }


    @Override
    protected void resetEditorFrom(@NotNull ExecuteTextTestsRunConfiguration ettrc) {
        textTestHomeChooser.getComponent().setText(ettrc.getTextTestHome());
    }

    @Override
    protected void applyEditorTo(@NotNull ExecuteTextTestsRunConfiguration ettrc) throws ConfigurationException {
        ettrc.setTextTestHome(textTestHomeChooser.getComponent().getText());
    }

    @Override
    protected @NotNull JComponent createEditor() {
        createUIComponents();
        myPanel = new JPanel();
        myPanel.add(textTestHomeChooser);
        return myPanel;
    }

    private void createUIComponents() {
        textTestHomeChooser = new LabeledComponent<>();
        textTestHomeChooser.setText("Path of TEXTTEST_HOME");

        textTestHomeChooser.setComponent(new TextFieldWithBrowseButton());
    }
}
