package org.texttest.texttestplugin;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ExecuteTextTestsRunConfigurationType implements ConfigurationType {

    static final String ID = "ExecuteTextTestsRunConfiguration";

    @Override
    public @NotNull @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName() {
        return "Execute TextTests";
    }

    @Override
    public @Nls(capitalization = Nls.Capitalization.Sentence) String getConfigurationTypeDescription() {
        return "Launch a test run using TextTest";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.General.Information;
    }

    @Override
    public @NotNull @NonNls String getId() {
        return ID;
    }

    @Override
    public @NotNull @NonNls String getTag() {
        return ConfigurationType.super.getTag();
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{
                new ExecuteTextTestsConfigurationFactory(this)
        };
    }

    @Override
    public @NonNls @Nullable String getHelpTopic() {
        return ConfigurationType.super.getHelpTopic();
    }

    @Override
    public boolean isManaged() {
        return ConfigurationType.super.isManaged();
    }
}
