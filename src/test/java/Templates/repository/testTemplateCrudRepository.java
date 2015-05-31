package Templates.repository;

import Templates.App;
import Templates.domain.Template;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class testTemplateCrudRepository extends AbstractTestNGSpringContextTests{
    private String id;

    @Autowired
    TemplateRepository repository;

    @Test
    public void testCreate()  throws Exception
    {
        Template template = new Template.Builder("123")
                .templateType("123")
                .build();
        repository.save(template);
        id = template.getID();
        Assert.assertNotNull(template);
    }

    @Test(dependsOnMethods = "testCreate")
    public void testRead()  throws Exception
    {
        Template template = repository.findOne(id);
        Assert.assertEquals("123",template.getID());
    }

    @Test(dependsOnMethods = "testRead")
    public void testUpdate()  throws Exception
    {
        Template template = repository.findOne(id);
        Template newTemplate = new Template.Builder(template.getID())
                .templateType("12345")
                .build();
        repository.save(newTemplate);

        Template updatedTemplate = repository.findOne(id);
        Assert.assertEquals("123",updatedTemplate.getTemplateType());
    }

    @Test(dependsOnMethods = "testUpdate")
    public void testDelete()  throws Exception
    {
        Template template = repository.findOne(id);
        repository.delete(template);
        Template newTemplate = repository.findOne(id);
        Assert.assertNull(newTemplate);
    }

}
