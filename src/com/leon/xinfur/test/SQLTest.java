package com.leon.xinfur.test;

import com.leon.xinfur.dao.FurnDAO;
import com.leon.xinfur.dao.MemberDAO;
import com.leon.xinfur.dao.impl.FurnDAOImpl;
import com.leon.xinfur.dao.impl.MemberDAOImpl;
import com.leon.xinfur.entity.Furn;
import com.leon.xinfur.entity.Member;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Date：2024/7/1  17:11
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class SQLTest {
    MemberDAO memberDAO=new MemberDAOImpl();
    FurnDAO furnDAO=new FurnDAOImpl();
    @Test
    void queryMemberByUsername(){
        Member member = memberDAO.queryMemberByUsername("roo1");
        System.out.println(member==null);
    }

    @Test
    void saveMember(){
        Member root = new Member(404, "root", "root", "root@root.com");
        int i = memberDAO.saveMember(root);
        System.out.println(i);
    }

    @Test
    void queryFurns(){
        List<Furn> furns = furnDAO.queryFuns();
        for (int i = 0; i < furns.size(); i++) {
            System.out.println(furns.get(i));
        }
    }
}
