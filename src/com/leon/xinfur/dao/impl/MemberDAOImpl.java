package com.leon.xinfur.dao.impl;

import com.leon.xinfur.dao.BasicDAO;
import com.leon.xinfur.dao.MemberDAO;
import com.leon.xinfur.entity.Member;

/**
 * Date：2024/7/1  16:54
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */

public class MemberDAOImpl extends BasicDAO<Member> implements MemberDAO {
    /**
     * 通过用户名返回对应Member
     *
     * @param username 用户名
     * @return 对应用户对象
     */
    @Override
    public Member queryMemberByUsername(String username) {
        String sql = "SELECT `id`,`username`,`password`,`email` FROM `member` " +
                " WHERE `username`=?";
        return  querySingle(sql, Member.class, username);
    }

    /**
     * 将Member保存到Member表
     *
     * @param member 保存用户
     * @return 返回保存状态
     */
    @Override
    public int saveMember(Member member) {
        String sql = "INSERT INTO `member`(`username`,`password`,`email`) " +
                " VALUES(?,MD5(?), ?)";
        return update(sql, member.getUsername(),
                member.getPassword(), member.getEmail());
    }

    @Override
    public Member queryMemberByUsernameAndPassword(String username, String password) {

        String sql = "SELECT `id`,`username`,`password`,`email` FROM `member` " +
                " WHERE `username`=? and `password`=md5(?)";
        return  querySingle(sql, Member.class, username, password);
    }
}
