<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <div class="wrap">


        <section class="store">
            <h1>제품 등록</h1>
            <form action="/store/register" method="POST">
                <label>
                    # 제품 이름: <input type="text" name="productName">
                </label>
                <label>
                    # 제품 가격: <input type="text" name="price">
                </label>
                <label>
                    # 제품 수량: <input type="text" name="amount">
                </label>

                <label>
                    <button type="submit">확인</button>
                    <button id="go-home" type="button">홈화면으로</button>
                </label>
            </form>

            <hr>

            <ul class="score-list">
                <li>총 학생 수: ${scores.size()}명</li>

                <c:forEach var="s" items="${product}">
                    <li>
                        # 품번: ${s.productNo}, 제품명: <a href="/store/detail?productNo=${s.productNo}">${s.productName}</a>, 가격:
                        ${s.price}점,
                        수량: ${s.amount}점, 총가격: ${s.total}점

                        <a class="del-btn" href="/score/delete?productNo=${s.productNo}">삭제</a>
                    </li>
                </c:forEach>
            </ul>

        </section>
    </div>

        <script>
            const $ul = document.querySelector('.score-list');

            $ul.addEventListener('click', e => {
                if (!e.target.matches('a.del-btn')) return;

                e.preventDefault();
                //console.log('클릭이벤트 발동!');

                if (confirm('정말로 삭제하시겠습니까?')) {
                    //삭제 진행
                    location.href = e.target.getAttribute('href');
                } else {
                    //삭제 취소
                    return;
                }

            });

            //홈화면으로 버튼 이벤트
            const $homeBtn = document.getElementById('go-home');
            $homeBtn.onclick = e => {
                location.href = '/';
            };
        </script>

</body>

</html>