package com.leon.xinfur.service.impl;

import com.leon.xinfur.dao.MemberDAO;
import com.leon.xinfur.dao.impl.MemberDAOImpl;
import com.leon.xinfur.entity.Member;
import com.leon.xinfur.service.MemberService;

/**
 * Date：2024/7/1  17:47
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class MemberServiceImpl implements MemberService {

    MemberDAO memberDAO = new MemberDAOImpl();

    /**
     * 用户注册
     *
     * @param member 用户对象
     * @return 成功?
     */
    @Override
    public boolean registerMember(Member member) {
        //ctrl + alt + b 直接定位实现类而不是父类
        return memberDAO.saveMember(member) == 1;
    }

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 真值
     */
    @Override
    public boolean isExistsUserName(String username) {
        return memberDAO.queryMemberByUsername(username) != null;
    }

    @Override
    public Member login(String username, String password) {
        return memberDAO.queryMemberByUsernameAndPassword(username, password);
    }
}
