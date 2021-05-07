package com.soft1841.travel.api.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-06
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
    @TableField("travel_notes_title")
    private String travelNotesTitle;

    /**
     * 游记的封面
     */
    @TableField("travel_notes_cover")
    private String travelNotesCover;

    /**
     * 发表游记的作者
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 发表游记的时间
     */
    @TableField("travel_notes_time")
    private String travelNotesTime;

    /**
     * 游记的预览人数
     */
    @TableField("travel_notes_view")
    private String travelNotesView;

    /**
     * 游记点赞人数
     */
    @TableField("travel_notes_like")
    private String travelNotesLike;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
