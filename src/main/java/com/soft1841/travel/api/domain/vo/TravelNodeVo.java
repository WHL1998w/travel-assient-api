package com.soft1841.travel.api.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
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
public class TravelNodeVo{

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

    private  String user_name;
    private  String avatar;

    public TravelNodeVo(Integer id, String notesTitle, String notesCover, Integer userId, LocalDateTime notesTime, Integer notesView, Integer notesLike, String content, String image, String user_name, String avatar) {
        this.id = id;
        this.notesTitle = notesTitle;
        this.notesCover = notesCover;
        this.userId = userId;
        this.notesTime = notesTime;
        this.notesView = notesView;
        this.notesLike = notesLike;
        this.content = content;
        this.image = image;
        this.user_name = user_name;
        this.avatar = avatar;
    }
}

