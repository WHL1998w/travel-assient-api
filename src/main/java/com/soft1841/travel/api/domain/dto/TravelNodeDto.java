package com.soft1841.travel.api.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName
 * @Description TODO
 * @Author wanghuanle
 * @Date
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TravelNodeDto {
    /**
     * 游记主键
     */
    private Integer id;

    /**
     * 游记的标题
     */
    private String notesTitle;

    /**
     * 游记的封面
     */
    private String notesCover;

    /**
     * 发表游记的作者
     */
    private Integer userId;

    /**
     * 发表游记的时间
     */
    private Date notesTime;
    /**
     * 游记内容
     */
    private String content;

    /**
     * 游记中的图片
     */
    private String image;

}
