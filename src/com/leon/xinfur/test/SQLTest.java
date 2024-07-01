package com.leon.xinfur.test;

import com.leon.xinfur.dao.MemberDAO;
import com.leon.xinfur.dao.impl.MemberDAOImpl;
import com.leon.xinfur.entity.Member;
import org.junit.jupiter.api.Test;

/**
 * Date：2024/7/1  17:11
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class SQLTest {
    MemberDAO memberDAO=new MemberDAOImpl();
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
}
