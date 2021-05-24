package mvc.biz;

import mvc.dto.MVCDto;

import java.util.List;

public interface MVCBiz {

    public List<MVCDto> selectList();

    public MVCDto selectOne(int seq);

    public int insert(MVCDto dto);

    public int update(MVCDto dto);

    public int delete(int seq);
}
