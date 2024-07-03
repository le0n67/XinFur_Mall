package com.leon.xinfur.dao.impl;

import com.leon.xinfur.dao.BasicDAO;
import com.leon.xinfur.dao.FurnDAO;
import com.leon.xinfur.entity.Furn;

import java.util.List;

/**
 * Date：2024/7/3  18:16
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class FurnDAOImpl extends BasicDAO<Furn> implements FurnDAO {
    @Override
    public List<Furn> queryFuns() {
        String sql="SELECT `id` , `name` , `maker` , `price` , `sales` , `stock` , `img_path` imgPath from furn;";
        return queryMulti(sql,Furn.class);
    }
}
