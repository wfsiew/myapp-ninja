package helpers;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;

public class ConfigUtil {

    private static Configuration cfg;

    static {
        cfg = new Configuration(Configuration.VERSION_2_3_23);
        ClassTemplateLoader loader = new ClassTemplateLoader(ConfigUtil.class, "/templates");
        cfg.setTemplateLoader(loader);
        cfg.setDefaultEncoding("UTF-8");
    }

    public static Configuration getConfiguration() {
        return cfg;
    }
}
