package com.leon.xinfur.service;

import com.leon.xinfur.entity.Furn;
import com.leon.xinfur.entity.Page;

import java.util.List;

/**
 * Date：2024/7/3  18:17
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */
public interface FurnService {
    List<Furn> getAllFurn();
    Boolean addFurn(Furn furn);
    Boolean deleteFurnById(int id);
    Furn queryFurnById(int id);
    Boolean updateFurn(Furn furn);
    Page<Furn> Page(int pageNo,int pageSize);
}
