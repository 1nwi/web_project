<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
        <title>Title</title>

    <style>
        li {
            list-style: none;
            margin: 0;
            padding: 0;
            font-size: 1.4em;
        }

        section.score-main {
            width: 30%;
            margin: 0 auto 150px;
            padding: 20px;
            border: 2px solid orange;
            border-radius: 10px;
            box-shadow: 2px 2px 5px orangered;
            transform: translateY(200px);
        }

        a.list-btn {
            display: block;
            width: fit-content;
            text-decoration: none;
            background: rgb(83, 189, 83);
            color: white;
            box-shadow: 1px 1px 2px rgb(146, 228, 146);
            border-radius: 5px;
            border: 1px solid white;
            padding: 5px;
        }
    </style>

</head>

<body>

    <div class="wrap">


        <section class="score-main">
            <h1>${product.productName} 제품 정보</h1>
            <ul>
                <li># 가격: ${product.price}원</li>
                <li># 수량: ${product.amount}개</li>
                <li># 총: ${product.total}원</li>

            </ul>
            <div class="btn-group">
                <a class="list-btn" href="/store/list">목록</a>
            </div>
        </section>


    </div>
</body>

</html>