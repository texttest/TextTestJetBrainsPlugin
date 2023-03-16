package icons;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

public interface MyIcons {
    Icon TT_LOGO = IconLoader.getIcon("/icons/logo-tt-only-16x10.png", MyIcons.class);
    Icon TT_LOGO_LARGE = IconLoader.getIcon("/icons/logo-tt-only.png", MyIcons.class);
    Icon TT_LOGO_SVG = IconLoader.getIcon("/icons/logo-tt-only.svg", MyIcons.class);
}
