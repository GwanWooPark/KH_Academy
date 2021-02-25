package com.join.biz;

import com.join.dao.JoinDaoImpl;
import com.join.dto.JoinDto;

import java.util.List;

public class JoinBizImpl implements JoinBiz {

    private JoinDaoImpl dao = new JoinDaoImpl();

    @Override
    public List<JoinDto> selectList() {
        return dao.selectList();
    }

    @Override
    public JoinDto selectOne(int m_no) {
        return dao.selectOne(m_no);
    }

    @Override
    public int insertScore(JoinDto dto) {

        int sum = this.getSum(dto.getS_kor(), dto.getS_eng(), dto.getS_math());
        double avg = this.getAvg(sum);
        String grade = this.getGrade(avg);
        dto.setS_sum(sum);
        dto.setS_avg(avg);
        dto.setS_grade(grade);

        return dao.insertScore(dto);
    }

    @Override
    public int updateScore(JoinDto dto) {
        return dao.updateScore(dto);
    }

    @Override
    public int deleteScore(String name) {
        return dao.deleteScore(name);
    }

    @Override
    public int insertMember(JoinDto dto) {
        return dao.insertMember(dto);
    }

    @Override
    public int updateMember(JoinDto dto) {
        return dao.updateMember(dto);
    }

    @Override
    public int deleteMember(String name) {
        return dao.deleteMember(name);
    }

    public int getSum(int kor, int eng, int math) {
        return kor + eng + math;
    }

    public double getAvg(int sum) {
        return (double)sum / 3.0D;
    }

    public String getGrade(double avg) {
        switch((int)avg / 10) {
            case 6:
                return "D";
            case 7:
                return "C";
            case 8:
                return "B";
            case 9:
            case 10:
                return "A";
            default:
                return "F";
        }
    }

    @Override
    public JoinDto topNproc(int n) {
        return dao.topNproc(n);
    }
}


