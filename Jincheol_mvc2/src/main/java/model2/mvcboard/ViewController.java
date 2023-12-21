package model2.mvcboard;


import com.example.musthave.HelloServlet;
import com.example.mybatis_mvc2.mybatis.dao.MVCBoardDAO;
import com.example.mybatis_mvc2.mybatis.dto.MVCBoardDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebServlet("/mvcboard/view.do")
public class ViewController extends HelloServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 게시물 불러오기
        MVCBoardDAO dao = new MVCBoardDAO();
        String idx = req.getParameter("idx"); // 요청 파라미터에서 게시물 번호 가져오기
        dao.updateVisitCount(idx); // 조회수 1 증가
        MVCBoardDTO dto = dao.selectView(idx);

        // 줄바꿈 처리
        dto.setContent(dto.getContent().replaceAll("\r\n", "<br/>"));

        // 첨부 파일 확장자 추출 및 이미지 타입 확인
        String ext = null, fileName = dto.getSfile();
        if(fileName!=null) {
            ext = fileName.substring(fileName.lastIndexOf(".")+1); // .뒤의 문자열을 기준으로 파일의 확장자를 얻음
        }
        String[] mimeStr = {"png","jpg","gif"};
        List<String> mimeList = Arrays.asList(mimeStr); // 배열을 list로 변환
        boolean isImage = false;
        if(mimeList.contains(ext)) {
            isImage = true;
        }

        // 게시물 (dto) 저장
        req.setAttribute("dto", dto);
        req.setAttribute("isImage", isImage);
        req.getRequestDispatcher("/14MVCBoard/View.jsp").forward(req, resp);
    }
}
