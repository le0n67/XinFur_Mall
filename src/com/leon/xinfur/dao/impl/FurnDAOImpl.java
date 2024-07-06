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
    public List<Furn> queryFurns() {
        String sql="SELECT `id` , `name` , `maker` , `price` , `sales` , `stock` , `img_path` imgPath from furn;";
        return queryMulti(sql,Furn.class);
    }

    @Override
    public int addFurn(Furn furn) {
        String sql="INSERT INTO furn(`id`,`name`,`maker`,`price`,`sales`,`stock`,`img_path`) VALUES(null,?,?,?,?,?,?)";
        return update(sql,furn.getName(),furn.getMaker(),furn.getPrice(),furn.getSales(),furn.getStock(),furn.getImgPath());
    }

    @Override
    public int deleteFurnById(int id) {
        String sql="DELETE FROM furn WHERE id=?";
        return update(sql,id);
    }

    @Override
    public Furn queryFurnById(int id) {
        String sql="SELECT `id` , `name` , `maker` , `price` , `sales` , `stock` , `img_path` imgPath from furn where id=?";
        return querySingle(sql, Furn.class,id);
    }

    @Override
    public int updateFurn(Furn furn) {
        String sql="UPDATE furn SET name=?,maker=?,price=?,sales=?,stock=?,img_path=? WHERE id=?";
        return update(sql,furn.getName(),furn.getMaker(),furn.getPrice(),furn.getSales(),furn.getStock(),furn.getImgPath(),furn.getId());
    }

    @Override
    public int getTotalRow() {
        String sql="SELECT COUNT(*) from `furn`";
        return ((Number)queryScalar(sql)).intValue();
    }

    @Override
    public List<Furn> getPageItems(int pageNo, int pageSize)  {
        String sql="SELECT `id` , `name` , `maker` , `price` , `sales` , `stock` , `img_path` imgPath from furn LIMIT ? , ? ;";
        return queryMulti(sql,Furn.class,(pageNo-1)*pageSize,pageSize);
    }
}
