package com.leon.xinfur.service.impl;

import com.leon.xinfur.dao.FurnDAO;
import com.leon.xinfur.dao.impl.FurnDAOImpl;
import com.leon.xinfur.entity.Furn;
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
        return furnDAO.queryFuns();
    }

    @Override
    public Boolean addFurn(Furn furn) {
        return furnDAO.addFurn(furn)!=0;
    }

    @Override
    public Boolean deleteFurnById(int id) {
        return furnDAO.deleteFurnById(id)!=0;
    }
}
