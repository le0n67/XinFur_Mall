package com.leon.xinfur.service;

import com.leon.xinfur.entity.Member;

/**
 * Date：2024/7/1  17:46
 * Description：TODO
 *
 * @author Leon
 * @version 1.0
 */
public interface MemberService {
    boolean registerMember(Member member);
    boolean isExistsUserName(String username);
}
