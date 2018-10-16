package uow.codetest.tab.design.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @ClassName: Entitys
 * @Description: Based Abstruct Class for Other Entities
 * @author Tab Tu
 * @date Oct.18 2017
 * @version 1.0
 */
public class Entitys implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String toString() { return ToStringBuilder.reflectionToString(this); }
}