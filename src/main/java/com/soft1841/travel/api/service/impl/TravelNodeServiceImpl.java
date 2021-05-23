package com.soft1841.travel.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1841.travel.api.common.Result;
import com.soft1841.travel.api.domain.dto.PageDto;
import com.soft1841.travel.api.domain.entity.AttractionsInfo;
import com.soft1841.travel.api.domain.entity.TravelNode;
import com.soft1841.travel.api.domain.vo.TravelNodeVo;
import com.soft1841.travel.api.mapper.TravelNodeMapper;
import com.soft1841.travel.api.service.TravelNodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanghuanle
 * @since 2021-05-16
 */
@Service
public class TravelNodeServiceImpl extends ServiceImpl<TravelNodeMapper, TravelNode> implements TravelNodeService {

    @Resource
    private TravelNodeMapper travelNodeMapper;

    /**
     * 根据游记的id查询游记详细信息，包括发表该游记的作者昵称和头像
     * @param id
     * @return
     */
    @Override
    public Result getTravelNodeById(Integer id) {
        TravelNodeVo travelNode = travelNodeMapper.getTravelNodeById(id);
        return Result.success(travelNode);
    }

    /**
     * 分页查询游记信息
     * @param pageDto
     * @return
     */
    @Override
    public Result getByPage(PageDto pageDto) {
        QueryWrapper<TravelNode> wrapper = new QueryWrapper<>();
        if (pageDto.getCurrentPage() == 0 && pageDto.getPageSize() == 0){
            List<TravelNode> travelNodes = travelNodeMapper.selectList(wrapper);
            return Result.success(travelNodes);
        }else {
            Page<TravelNode> page = new Page<>(pageDto.getCurrentPage(),pageDto.getPageSize());
            IPage<TravelNode> iPage = travelNodeMapper.selectPage(page, wrapper);
            return Result.success(iPage);
        }
    }

    /**
     * 模糊查询游记信息，根据游记标题
     * @param field
     * @return
     */
    @Override
    public Result blurSelect(String field) {
        QueryWrapper<TravelNode> wrapper = new QueryWrapper<>();
        wrapper.like("notes_title",field);
        List<TravelNode> travelNodes = travelNodeMapper.selectList(wrapper);
        return Result.success(travelNodes);
    }

    /**
     * 查询热门游记,点赞数超过15个则为热门游记
     * @return
     */
    @Override
    public Result getTopTravelNodeInfo() {
        QueryWrapper<TravelNode> wrapper = new QueryWrapper<>();
        wrapper.ge("notes_like",15);
        List<TravelNode> travelNodes = travelNodeMapper.selectList(wrapper);
        return Result.success(travelNodes);
    }
}
