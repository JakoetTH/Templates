package Templates.services;

import Templates.domain.Template;
import Templates.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class TemplateImpl implements TemplateService {
    @Autowired
    private TemplateRepository repository;
    @Override
    public List<Template> getTemplates(String ID)
    {
        Iterable<Template> ttemplates = repository.findAll();
        List<Template> templates = new ArrayList<Template>();
        for (Template template : ttemplates)
        {
                templates.add(template);
        }
        return templates;
    }

}

