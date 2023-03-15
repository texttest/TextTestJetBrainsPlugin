package org.texttest.texttestplugin;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExecuteTextTestsConfigurationFactory extends ConfigurationFactory {
    protected ExecuteTextTestsConfigurationFactory(@NotNull ConfigurationType type) {
        super(type);
    }

    @Override
    public @NotNull @NonNls String getId() {
        return ExecuteTextTestsRunConfigurationType.ID;
    }

    @Override
    public @NotNull RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new ExecuteTextTestsRunConfiguration(project, this, "ExecuteTextTests");
    }

    @Override
    public @Nullable Class<? extends BaseState> getOptionsClass() {
        return ExecuteTextTestsRunConfigurationOptions.class;
    }
}
