package com.mvclogin.biz;

import com.mvclogin.dao.MVCLoginDao;
import com.mvclogin.dao.MVCLoginDaoImpl;
import com.mvclogin.dto.MVCLoginDto;

import java.util.List;

public class MVCLoginBizImpl implements MVCLoginBiz{

    MVCLoginDao dao = new MVCLoginDaoImpl();

    @Override
    public List<MVCLoginDto> selectList() {
        return dao.selectList();
    }

    @Override
    public List<MVCLoginDto> selectEnabledList() {
        return dao.selectEnabledList();
    }

    @Override
    public int updateRole(int myNo, String role) {
        return dao.updateRole(myNo, role);
    }

    @Override
    public MVCLoginDto login(String myId, String myPw) {
        return dao.login(myId, myPw);
    }

    @Override
    public int regist(MVCLoginDto dto) {
        return dao.regist(dto);
    }

    @Override
    public MVCLoginDto selectOne(String myId) {
        return dao.selectOne(myId);
    }

    @Override
    public int updateMyRole(String myId) {
        return dao.updateMyRole(myId);
    }

    @Override
    public int signOut(String myId) {
        return dao.signOut(myId);
    }
}
