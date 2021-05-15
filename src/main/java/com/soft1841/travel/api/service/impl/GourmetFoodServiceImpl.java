package com.soft1841.travel.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.common.ResultCode;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.entity.*;
import com.soft1841.travel.api.domain.vo.PoiTicketVo;
import com.soft1841.travel.api.domain.vo.RestCommentsVo;
import com.soft1841.travel.api.mapper.GourmetFoodMapper;
import com.soft1841.travel.api.mapper.SysAdminMapper;
import com.soft1841.travel.api.mapper.UserMapper;
import com.soft1841.travel.api.service.GourmetFoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>
 *  美食服务实现类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-15
 */
@Service
public class GourmetFoodServiceImpl extends ServiceImpl<GourmetFoodMapper, GourmetFood> implements GourmetFoodService {
    @Resource
    private GourmetFoodMapper gourmetFoodMapper;
    private UserMapper userMapper;

    /**
     * 根据id查询详细信息
     * @param id
     * @return
     */
    @Override
    public Result getGourmentFoodById(Integer id) {
        GourmetFood gourmetFood = gourmetFoodMapper.getGourmetFoodById(id);
        if (gourmetFood != null){
            Map<String, Object> map = new TreeMap<>();
            map.put("id",gourmetFood.getId());
            map.put("RestaurantName", gourmetFood.getRestaurantName());
            map.put("Position", gourmetFood.getPosition());
            map.put("Image", gourmetFood.getImage());
            map.put("Introduction", gourmetFood.getIntroduction());
            map.put("Consumption", gourmetFood.getConsumption());
            map.put("Traffic", gourmetFood.getTraffic());
            map.put("ReviewsNum", gourmetFood.getReviewsNum());
            map.put("Phone",gourmetFood.getPhone());
            map.put("Score",gourmetFood.getScore());
            List<RestCommentsVo> list = new ArrayList<>();
            List<RestComments> restComments = gourmetFood.getRestCommentsList();
            System.out.println(restComments);
            for (RestComments r : restComments) {
                System.out.println(r.getUserId());
                RestCommentsVo restCommentsVo = new RestCommentsVo(r.getComments(), r.getCommentsTime(),r.getUser_name(),r.getAvatar());
                list.add(restCommentsVo);
            }
            map.put("Comments", list);
            return Result.success(map);
        }else {
            return Result.failure(ResultCode.DATABASE_ERROR);
        }

    }

    /**
     * 分页查询
     * @param pageDto
     * @return
     */
    @Override
    public Result getByPage(PageDto pageDto) {
        return null;
    }

    /**
     * 模糊查询
     * @param field
     * @return
     */
    @Override
    public Result blurSelect(String field) {
        return null;
    }

    /**
     * 查询热门餐厅
     * @return
     */
    @Override
    public Result getTopGourmentFood() {
        return null;
    }
}
