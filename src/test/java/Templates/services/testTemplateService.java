package Templates.services;
import Templates.App;
import Templates.domain.Template;
import Templates.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testTemplateService extends AbstractTestNGSpringContextTests{
    @Autowired
    private TemplateRepository repository;
    @Autowired
    private TemplateImpl service;

    private String id;
    private List<Template> templates;
    @BeforeMethod
    public void setUp()
    {
        templates = new ArrayList<Template>();
        id = "12345";
    }

    @Test
    public void testCreateTemplates()
    {
        Template template = new Template.Builder("12345")
                .templateType("123")
                .build();
        Template templatetwo = new Template.Builder("12346")
                .templateType("1234")
                .build();

        templates.add(template);
        repository.save(template);
        Assert.assertNotNull(template);

        templates.add(templatetwo);
        repository.save(templatetwo);
        Assert.assertNotNull(templatetwo);




    }
    @Test(dependsOnMethods = "testCreateTemplates")
    public void testGetPassengerTemplates()
    {
        List<Template> templates = service.getTemplates(id);
        Assert.assertTrue(templates.size() == 1);
    }
}
