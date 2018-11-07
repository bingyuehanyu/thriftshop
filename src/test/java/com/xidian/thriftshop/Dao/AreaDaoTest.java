package com.xidian.thriftshop.Dao;

import com.xidian.thriftshop.domain.Area;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao1;
    @Test
    public void queryArea() {
        List<Area> ls=areaDao1.queryArea();
        assertEquals(2,ls.size());
    }

    @Test
    @org.junit.Ignore
    public void insertArea() {
    }

    @Test
    @org.junit.Ignore
    public void queryAreaById() {
    }

    @Test
    @org.junit.Ignore
    public void updataArea() {
    }

    @Test
    @org.junit.Ignore
    public void deleteArea() {
    }
}