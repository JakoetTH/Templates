package Templates.domain;

import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by student on 2015/04/24.
 */
@Entity
public class Template implements Serializable{
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String ID;
    private String templateType;

    private Template()
    {

    }

    public Template(Builder builder)
    {
        this.ID=builder.ID;
        this.templateType=builder.templateType;

    }
    public String getID()
    {
        return this.ID;
    }
    public String getTemplateType()
    {
        return this.templateType;
    }


    public static class Builder
    {
        private String ID;
        private String templateType;

        public Builder(String ID)
        {
            this.ID=ID;
        }

        public Builder templateType(String templateType)
        {
            this.templateType=templateType;
            return this;
        }


        public Builder copy(Template template)
        {
            this.ID=template.getID();
            return this;
        }

        public Template build()
        {
            return new Template(this);
        }
    }
}
