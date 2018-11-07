package com.xidian.thriftshop.Serives;

import com.xidian.thriftshop.domain.Area;

import java.util.List;

public interface AreaSerives {
    List<Area> queryArea();
    boolean insertArea(Area area);
    Area queryAreaById(int areaId);
    boolean updataArea(Area area);
    boolean deleteArea(int areaId);
}
