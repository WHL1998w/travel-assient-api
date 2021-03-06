package com.soft1841.travel.api.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("travel_node")
public class TravelNode extends Model<TravelNode> {

    private static final long serialVersionUID = 1L;

    /**
     * 游记主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 游记的标题
     */
    @TableField("notes_title")
    private String notesTitle;

    /**
     * 游记的封面
     */
    @TableField("notes_cover")
    private String notesCover;

    /**
     * 发表游记的作者
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 发表游记的时间
     */
    @TableField("notes_time")
    private LocalDateTime notesTime;

    /**
     * 游记的预览人数
     */
    @TableField("notes_view")
    private Integer notesView;

    /**
     * 游记点赞人数
     */
    @TableField("notes_like")
    private Integer notesLike;

    /**
     * 游记内容
     */
    @TableField("content")
    private String content;

    /**
     * 游记中的图片
     */
    @TableField("image")
    private String image;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
