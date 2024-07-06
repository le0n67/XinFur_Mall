package com.leon.xinfur.dao;

import com.leon.xinfur.entity.Furn;

import java.util.List;

/**
 * Date：2024/7/3  18:15
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */
public interface FurnDAO {
    List<Furn> queryFurns();
    int addFurn(Furn furn);
    int deleteFurnById(int id);
    Furn queryFurnById(int id);
    int updateFurn(Furn furn);
}
