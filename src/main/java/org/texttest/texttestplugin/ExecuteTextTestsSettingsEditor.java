package org.texttest.texttestplugin;

import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class ExecuteTextTestsSettingsEditor extends SettingsEditor<ExecuteTextTestsRunConfiguration> {

    private JPanel myPanel;

    @Override
    protected void resetEditorFrom(@NotNull ExecuteTextTestsRunConfiguration s) {

    }

    @Override
    protected void applyEditorTo(@NotNull ExecuteTextTestsRunConfiguration s) throws ConfigurationException {

    }

    @Override
    protected @NotNull JComponent createEditor() {
        return null;
    }
}
