package com.ay.ayblog.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * label
 * @author 
 */
@Data
public class Label implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签ID
     */
    private Integer labelId;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 标签内容
     */
    private String labelContent;

    /**
     * 标签状态
     */
    private String labelStatus;


}