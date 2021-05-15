package com.soft1841.travel.api.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/
@Data
@NoArgsConstructor
@Builder
public class RestCommentsVo {

//    private Integer userId;

    private String comments;

    private LocalDateTime commentsTime;



    private String user_name;

    private String avatar;

    public RestCommentsVo(String comments, LocalDateTime commentsTime, String userName, String avatar) {
        this.comments = comments;
        this.commentsTime = commentsTime;
        this.user_name = userName;
        this.avatar = avatar;
    }

//    public RestCommentsVo(String comments, LocalDateTime commentsTime) {
//        this.comments = comments;
//        this.commentsTime = commentsTime;
//    }

//
//    public RestCommentsVo(Integer userId, String comments, LocalDateTime commentsTime) {
//        this.userId = userId;
//        this.comments = comments;
//        this.commentsTime = commentsTime;
//    }
}
