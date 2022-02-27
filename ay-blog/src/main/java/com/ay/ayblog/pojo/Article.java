package com.ay.ayblog.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * article
 * @author 
 */
@Data
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章ID;PK
     */
    private Integer articleId;

    /**
     * 文章标题
     */
    private String articleTittle;

    /**
     * 分类ID
     */
    private Integer categoryId;

    /**
     * 文章状态
     */
    private String articleStatus;

    /**
     * 文章内容
     */
    private String articleContent;

    /**
     * 文章点赞数
     */
    private Integer articleLikeCount;

    /**
     * 文章评论数
     */
    private Integer articleCommentCount;

    /**
     * 文章浏览数
     */
    private Integer articleViewCount;

    /**
     * 文章修改时间
     */
    private Date articleMtime;


}