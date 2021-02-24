package com.member.biz;

// Biz : Busniess Logic
// 연산, 처리하는 코드들만

/*
   MVC pattern

Model. 연산 / 처리 db 연결
View : 화면
Controller : 화면 제어

“유지보수의 용이”
“재사용성 크다”
 */

import com.member.dao.MemberDao;
import com.member.dto.MemberDto;

import java.util.List;
import java.util.Locale;

public class MemberBiz {

    private MemberDao dao = new MemberDao();

    public List<MemberDto> selectList() {

        return dao.selectList();

    }

    public MemberDto selectOne(int m_no) {

        return dao.selectOne(m_no);
    }

    public int insert(MemberDto dto) {

        // M_GENDER -> M, F
        // 입력된 값이 소문자라면 check 제약조건 위배
        // m_gender에 저장된 값을 가지고 와서, 대문자로 바꿔서 다시 저장

        String upperGender = dto.getM_gender().toUpperCase();
        dto.setM_gender(upperGender);

        return dao.insert(dto);
    }

    public int update(MemberDto dto) {

        String upperGender = dto.getM_gender().toUpperCase();
        dto.setM_gender(upperGender);
        return dao.update(dto);
    }

    public int delete(int m_no) {

        return dao.delete(m_no);
    }
}
