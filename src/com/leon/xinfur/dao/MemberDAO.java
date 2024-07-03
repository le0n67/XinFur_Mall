package com.leon.xinfur.dao;

import com.leon.xinfur.entity.Member;

/**
 * Date：2024/7/1  16:22
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */
public interface MemberDAO {
    //通过用户名返回对应Member
    Member queryMemberByUsername(String username);

    //保存Member到表
    int saveMember(Member member);

    //通过用户名和密码返回对应Member
    Member queryMemberByUsernameAndPassword(String username, String password);

}
