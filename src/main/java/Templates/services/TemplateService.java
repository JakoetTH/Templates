package Templates.services;

import Templates.domain.Template;

import java.util.List;

public interface TemplateService {
    public List<Template> getTemplates(String ID);

}