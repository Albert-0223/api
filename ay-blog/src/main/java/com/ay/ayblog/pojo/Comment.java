package com.ay.ayblog.pojo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * comment
 * @author 
 */
@Data
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论ID
     */
    private Integer commentId;

    /**
     * 文章ID
     */
    private Integer articleId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论点赞数
     */
    private Integer commentLikeCount;

    /**
     * 评论浏览数
     */
    private Integer commentViewCount;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 评论状态
     */
    private String commentStatus;


}