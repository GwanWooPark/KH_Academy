import com.my.biz.MyBoardBiz;
import com.my.dto.MyBoardDto;

public class test {

    public static void main(String[] args) {

        int myno = 1;

        MyBoardBiz biz = new MyBoardBiz();
        MyBoardDto dto = new MyBoardDto();
        dto.setMyno(10);
        dto.setMyname("수정");
        dto.setMytitle("수정");
        dto.setMycontent("수정");

        int res = biz.update(dto);

        if (res > 0) {
            System.out.println("성공");
        } else {
            System.out.println("실패");
        }
    }
}
