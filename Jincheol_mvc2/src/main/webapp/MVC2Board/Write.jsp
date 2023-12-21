<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>파일 첨부형 게시판</title>
    <script type="text/javascript">
        function validateForm(form) { // 필수 항목 입력 확인
            if (form.name.value == "") { // 작성자 이름 칸이 비어있다면
                alert("작성자를 입력하세요."); // 경고메시지 출력
                form.name.focus(); // 이름 필드에 포커스를 주어 채우도록 함
                return false; // 반환 중단
            }
            if (form.title.value == "") {
                alert("제목을 입력하세요.");
                form.title.focus();
                return false;
            }
            if (form.content.value == "") {
                alert("내용을 입력하세요.");
                form.content.focus();
                return false;
            }
            if (form.pass.value == "") {
                alert("비밀번호를 입력하세요.");
                form.pass.focus();
                return false;
            }
        }
    </script>
</head>
<h2>파일 첨부형 게시판 - 글쓰기(Write)</h2>
<!--method="post" enctype="multipart/form-data" : 파일 첨부를 위한 필수 작성 폼 -->
<form name="writeFrm" method="post" enctype="multipart/form-data"
      action="../mvcboard/write.do" onsubmit="return validateForm(this)"> <!--this는 이것을 적절하게 입력했는지 여부를 물어봄 -->
    <table border="1" width="90%">
        <tr>
            <td>작성자</td>
            <td>
                <input type="test" name="name" style="width: 150px;" />
            </td>
        </tr>
        <tr>
            <td>제목</td>
            <td>
                <input type="text" name="title" style="width: 90%" />
            </td>
        </tr>
        <tr>
            <td>내용</td>
            <td>
                <textarea name="content" style="width: 90%; height: 100px;"></textarea>
            </td>
        </tr>
        <tr>
            <td>첨부 파일</td>
            <td>
                <input type="file" name="ofile" />
            </td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td>
                <input type="password" name="pass" style="width: 100px" />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <button type="submit">작성 완료</button>
                <button type="reset">RESET</button>
                <button type="button" onclick="location.href='../mvcboard/list.do';">
                    목록 바로가기
                </button>
            </td>
        </tr>
    </table>
</form>
<body>

</body>
</html>
