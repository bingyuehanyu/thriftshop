package com.xidian.thriftshop.SerivesImpl;

import com.xidian.thriftshop.Dao.AreaDao;
import com.xidian.thriftshop.Serives.AreaSerives;
import com.xidian.thriftshop.domain.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class AreaSerivesImpl implements AreaSerives {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }
    @Transactional
    @Override
    public boolean insertArea(Area area) {
        if(area.getAreaName()!=null&&"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int number=areaDao.insertArea(area);
                if(number>0){
                    return true;
                }else{
                    throw new RuntimeException("插入区域信息失败");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("插入区域信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("插入信息不能为空");
        }

    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    public boolean updataArea(Area area) {
        if(area.getAreaId()!=null&&"".equals(area.getAreaId())){

            area.setLastEditTime(new Date());
            try {
                int number=areaDao.updataArea(area);
                if(number>0){
                    return true;
                }else{
                    throw new RuntimeException("更新区域信息失败");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("更新区域信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("更新信息不能为空");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try {
                int number=areaDao.deleteArea(areaId);
                if(number>0){
                    return true;
                }else{
                    throw new RuntimeException("删除区域信息失败");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("删除区域信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("删除信息不能为空");
        }
    }
}
