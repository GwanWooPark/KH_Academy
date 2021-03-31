package com.mvclogin.dao;

import com.mvclogin.dto.MVCLoginDto;

import java.util.List;

public interface MVCLoginDao {


    String SELECT_LIST_SQL = " SELECT MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
                           + " FROM MVCMEMBER "
                           + " ORDER BY MYID DESC ";
    String SELECT_LIST_ENABLED_SQL = " SELECT MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
                                   + " FROM MVCMEMBER "
                                   + " WHERE MYENABLED = 'Y' ";
    String LOGIN_SQL = " SELECT MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
                     + " FROM MVCMEMBER "
                     + " WHERE MYID = ? AND MYPW = ? ";


    /*
      관리자 기능
      1. 회원 전체 정보 (모든 회원)
      2. 가입된 회원의 전체 정보 (MYENABLED = 'Y'인 회원)
      3. 회원 등급 조정
    */

    public List<MVCLoginDto> selectList();

    public List<MVCLoginDto> selectEnabledList();

    public int updateRole(int myNo, String role);

    /*
      사용자 기능
      1. 로그인
      2. 회원가입
      3. 내 정보 조회
      4. 내 정보 수정
      5. 탈퇴
     */

    public MVCLoginDto login(String myId, String myPw);

    public int regist(MVCLoginDto dto);

    public MVCLoginDto selectOne(String myId);

    public int updateMyRole(String myId);

    public int signOut(String myId);
}
