package com.xidian.thriftshop.Dao;

import com.xidian.thriftshop.domain.Area;

import java.util.List;

public interface AreaDao {
    List<Area> queryArea();
    int insertArea(Area area);
    Area queryAreaById(int areaId);
    int updataArea(Area area);
    int deleteArea(int areaId);

}
