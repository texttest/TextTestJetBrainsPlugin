package org.texttest.texttestplugin;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public class ExecuteTextTestsRunConfiguration extends RunConfigurationBase<ExecuteTextTestsRunConfigurationType> {
    protected ExecuteTextTestsRunConfiguration(@NotNull Project project, @Nullable ConfigurationFactory factory, @Nullable String name) {
        super(project, factory, name);
        if ("".equals(getTextTestHome())) {
            String basePath = project.getBasePath();
            setTextTestHome(basePath);
        }
    }

    @Override
    protected @NotNull ExecuteTextTestsRunConfigurationOptions getOptions() {
        return (ExecuteTextTestsRunConfigurationOptions) super.getOptions();
    }

    public String getTextTestHome() {
        return getOptions().getTextTestHome();
    }

    public boolean useTextTestHomeEnv() {
        return getOptions().getUse_TEXTTEST_HOME_env();
    }

    public void setTextTestHome(String texttestHome) {
        getOptions().setTextTestHome(texttestHome);
    }

    public void setUseTextTestHomeEnv(boolean selected) {
        getOptions().setUse_TEXTTEST_HOME_env(selected);
    }

    @Override
    public @NotNull SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new ExecuteTextTestsSettingsEditor();
    }

    @Override
    public @Nullable RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
        return new CommandLineState(environment) {
            @NotNull
            @Override
            protected ProcessHandler startProcess() throws ExecutionException {
                String textTestHome = getOptions().getTextTestHome();

                // try to save the situation if nothing is set properly
                if (!new File(textTestHome).exists()) {
                    if (System.getenv("TEXTTEST_HOME") != null) {
                        setUseTextTestHomeEnv(true);
                    } else {
                        Project project = environment.getProject();
                        textTestHome = project.getBasePath();
                    }
                }
                GeneralCommandLine commandLine;
                if (useTextTestHomeEnv()) {
                    commandLine = new GeneralCommandLine("texttest", "-con");
                } else {
                    commandLine = new GeneralCommandLine("texttest", "-con", "-d", textTestHome);
                }
                OSProcessHandler processHandler = ProcessHandlerFactory.getInstance().createColoredProcessHandler(commandLine);
                ProcessTerminatedListener.attach(processHandler);
                return processHandler;
            }
        };
    }

    @Override
    public void readExternal(@NotNull Element element) throws InvalidDataException {
        super.readExternal(element);
        for (Element child : element.getChildren()) {
            String tt_home = child.getAttributeValue("TEXTTEST_HOME");
            if (tt_home != null) {
                setTextTestHome(tt_home);
            }
            String tt_home_env = child.getAttributeValue("TEXTTEST_HOME_ENV");
            if (tt_home_env != null) {
                setUseTextTestHomeEnv(Boolean.parseBoolean(tt_home_env));
            }
        }
    }

    @Override
    public void writeExternal(@NotNull Element element) {
        String tt_home = getTextTestHome();
        if (tt_home != null) {
            Element tt_home_child = new Element("option");
            tt_home_child.setAttribute("TEXTTEST_HOME", tt_home);
            element.addContent(tt_home_child);
        }

        String tt_home_env = "" + useTextTestHomeEnv();
        if (tt_home_env != null) {
            Element tt_home_env_child = new Element("option");
            tt_home_env_child.setAttribute("TEXTTEST_HOME_ENV", tt_home_env);
            element.addContent(tt_home_env_child);
        }
        super.writeExternal(element);
    }
}
