package Templates.domain;

import Templates.conf.TemplateFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class testTemplate {
    private Template template;
    private Template newTemplate;
    @Before
    public void setUp()
    {
        template = TemplateFactory.createTemplate("123","123");
    }
    @Test
    public void testCreateTemplate() throws Exception
    {
        Assert.assertEquals("123",template.getID());
    }
    @Test
    public void testUpdateTemplate()
    {
        newTemplate = new Template
                .Builder(template.getID())
                .copy(template)
                .templateType("12345").build();

        Assert.assertEquals("123",newTemplate.getID());
        Assert.assertEquals("12345",newTemplate.getTemplateType());
    }
    @After
    public void tearDown()
    {

    }
}
