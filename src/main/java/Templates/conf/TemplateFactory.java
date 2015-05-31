package Templates.conf;

import Templates.domain.Template;
public class TemplateFactory {

    public static Template createTemplate(String ID,String templateType)
    {
        Template aircraft = new Template
                .Builder(ID)
                .templateType(templateType)
                .build();
        return aircraft;
    }
}
