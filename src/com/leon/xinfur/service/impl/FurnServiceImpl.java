package com.leon.xinfur.service.impl;

import com.leon.xinfur.dao.FurnDAO;
import com.leon.xinfur.dao.impl.FurnDAOImpl;
import com.leon.xinfur.entity.Furn;
import com.leon.xinfur.entity.Page;
import com.leon.xinfur.service.FurnService;

import java.util.List;

/**
 * Date：2024/7/3  18:17
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class FurnServiceImpl implements FurnService {
    FurnDAO furnDAO=new FurnDAOImpl();
    @Override
    public List<Furn> getAllFurn() {
        return furnDAO.queryFurns();
    }

    @Override
    public Boolean addFurn(Furn furn) {
        return furnDAO.addFurn(furn)!=0;
    }

    @Override
    public Boolean deleteFurnById(int id) {
        return furnDAO.deleteFurnById(id)!=0;
    }

    @Override
    public Furn queryFurnById(int id) {
        return furnDAO.queryFurnById(id);
    }

    @Override
    public Boolean updateFurn(Furn furn) {
        return furnDAO.updateFurn(furn)!=0;
    }

    @Override
    public Page<Furn> Page(int pageNo, int pageSize) {
        Page<Furn> page=new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int totalRow = furnDAO.getTotalRow();
        page.setTotalRow(totalRow);
        int totalPage = (totalRow + pageSize - 1) / pageSize;
        page.setTotalPage(totalPage);
        List<Furn> pageItems = furnDAO.getPageItems(pageNo, pageSize);
        page.setItems(pageItems);
        return page;
    }

    @Override
    public Page<Furn> PageByName(int pageNo, int pageSize, String name) {
        Page<Furn> page=new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        int totalRow = furnDAO.getTotalRowByName(name);
        page.setTotalRow(totalRow);
        int totalPage = (totalRow + pageSize - 1) / pageSize;
        page.setTotalPage(totalPage);
        List<Furn> pageItems = furnDAO.getPageItemsByName(pageNo, pageSize,name);
        page.setItems(pageItems);
        return page;
    }
}
