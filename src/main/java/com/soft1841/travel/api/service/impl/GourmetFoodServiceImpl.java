package com.soft1841.travel.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.common.ResultCode;
import com.soft1841.travel.api.domain.dto.AppointmentGourmetFoodDto;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.dto.RestCommentsDto;
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
        //每浏览一次浏览次数增加1
        gourmetFood.setReviewsNum(gourmetFood.getReviewsNum() + 1);
        gourmetFoodMapper.updateById(gourmetFood);
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
        QueryWrapper<GourmetFood> wrapper = new QueryWrapper<>();
        if (pageDto.getCurrentPage() == 0 && pageDto.getPageSize() == 0){
            List<GourmetFood> gourmetFoodList = gourmetFoodMapper.selectList(wrapper);
            return Result.success(gourmetFoodList);
        }else {
            Page<GourmetFood> page = new Page<>(pageDto.getCurrentPage(),pageDto.getPageSize());
            IPage<GourmetFood> iPage = gourmetFoodMapper.selectPage(page, wrapper);
            return Result.success(iPage);
        }
    }

    /**
     * 模糊查询
     * @param field
     * @return
     */
    @Override
    public Result blurSelect(String field) {
        QueryWrapper<GourmetFood> wrapper = new QueryWrapper<>();
        wrapper.like("restaurant_name",field).or().like("position",field);
        List<GourmetFood> gourmetFoodList = gourmetFoodMapper.selectList(wrapper);
        return Result.success(gourmetFoodList);
    }

    /**
     * 查询热门餐厅，浏览量达到600以上
     * @return
     */
    @Override
    public Result getTopGourmentFood() {
        QueryWrapper<GourmetFood> wrapper = new QueryWrapper<>();
        wrapper.ge("reviews_num",600);
        List<GourmetFood> gourmetFoodList = gourmetFoodMapper.selectList(wrapper);
        return Result.success(gourmetFoodList);
    }

    /**
     * 预约餐厅
     * @param foodDto
     * @return
     */
    @Override
    public Result insertAppoinFood(AppointmentGourmetFoodDto foodDto) {
        gourmetFoodMapper.insertAppoinGourmetFood(foodDto);
        return Result.success(foodDto);
    }

    /**
     * 点评餐厅
     * @param commentsDto
     * @return
     */
    @Override
    public Result insertComments(RestCommentsDto commentsDto) {
        gourmetFoodMapper.insertComments(commentsDto);
        return Result.success(commentsDto);
    }
}
