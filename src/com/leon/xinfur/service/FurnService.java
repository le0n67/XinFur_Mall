package com.leon.xinfur.service;

import com.leon.xinfur.entity.Furn;

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
}
