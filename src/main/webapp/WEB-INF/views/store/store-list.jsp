<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style>
            label {
                display: block;
            }

            .score-list>li {
                margin-bottom: 10px;
            }

            .score-list>li:first-child {
                font-size: 1.2em;
                color: blue;
                font-weight: 700;
                border-bottom: 1px solid skyblue;
            }

            .del-btn {
                width: 10px;
                height: 10px;
                background: red;
                color: #fff;
                border-radius: 5px;
                margin-left: 5px;
                text-decoration: none;
                font-size: 0.7em;
                padding: 6px;
            }

            .del-btn:hover {
                background: orangered;
            }

            section.score {
                /* padding: 200px 50px 100px; */
                font-size: 1.5em;
            }
        </style>
</head>
<body>
    <div class="wrap">


        <section class="score">
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
                <li>총 제품 수: ${products.size()}개</li>

                <c:forEach var="p" items="${products}">
                    <li>
                        # 품번: ${p.productNo}, 제품명: <a href="/store/detail?productNo=${p.productNo}">${p.productName}</a>, 가격:
                        ${p.price}원,
                        수량: ${p.amount}개, 총가격: ${p.total}원

                        <a class="del-btn" href="/store/delete?productNo=${p.productNo}">삭제</a>
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