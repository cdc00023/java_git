<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %> 
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>     

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Gaegu:wght@700&family=Poor+Story&display=swap" rel="stylesheet">
    <style>
        * {
            margin : 0; /*바깥여백*/
            padding : 0; /*안 여백*/
            font-family: 'Gaegu', cursive;
            font-size: 20px;
        }
        li {
            list-style : none;
        }
        a {
           text-decoration : none; /*링크의 밑줄 제거*/
        }
        img {
            border : 0; /*그림 테두리 제거*/
        }
        #top_nav {
            width : 960px;
            height : 30px;
            margin : 0 auto; /*현재 객체를 중앙정렬*/
            position : relative;
            border : 1px solid rgb(0, 0, 0); /*실선*/
        }
        #top_nav > #main_gnb { /*top_nav 한 단계 아래의 객체 중 main_gnb를 의미*/
            position : absolute;
            right : 0; /*우측정렬*/
            top : 0;
        }
        
        #main_gnb > ul {
            overflow : hidden; /*객체를 해당영역에서 벗어나지 않도록 한다*/
        }
        #main_gnb > ul > li {
            float : left; /*오른쪽에 객체를 위치할 수 있도록 설정*/
        }
        #main_gnb > ul > li > a {
            display : block; /*오른쪽에 block : 우측에 다른 객체를 위치시키지 못함*/
                            /*반대는 inline(앵커포함 대부분 이것임)*/
            padding : 2px 10px; /*좌우 위아래*/
            border : 1px solid black;
        }
        #main_gnb > ul > li > a:hover { /*마우스 커서가 진입했을때*/
        background-color: black;
        color: white;
        }
        #main_gnb > ul > li:first-child > a {
        border-radius : 10px 0 0 10px;
        }
        #main_gnb > ul > li:last-child > a {
        border-radius : 0 10px 10px 0;
        }

        #header {
              width: 960px;
              height : 150px;
              margin : 0 auto;
              padding : 0;
              position : relative;
              border: 1px solid black;
        }
        #nav {
            width : 960px;
            height : 50px;
            margin : 0 auto; /*현재 객체를 중앙정렬*/
            position : relative;
            border : 1px solid black; /*실선*/
        }


        #nav > #main_lnb { /*top_nav 한 단계 아래의 객체 중 main_gnb를 의미*/
            position : absolute;
            right : 0; /*우측정렬*/
            top : 0;
        }
        #main_lnb > ul {
            overflow : hidden;
        }
        #main_lnb > ul > li {
            float : left; 
        }
        #main_lnb > ul > li > a {
            display : block; 
            padding : 2px 10px;
            border : 1px solid black;    
        }
        #main_lnb > ul > li > a:hover { 
        background-color: black;
        color: white;
        }
        #main_lnb > ul > li:first-child > a {
        border-radius : 10px 0 0 10px;
        }
        #main_lnb > ul > li:last-child > a { /*시계방향으로*/
        border-radius : 0 10px 10px 0;
        }


        #contents { /* 현재 객체 내부에 모든 객체를 포함*/
            overflow : hidden;
            width: 960px;
            margin : 0 auto;
            position : relative;
            border : 1px solid black;
        }
        #aside {
            float : left; /*우측에 객체가 위치하도록 설정*/
            width : 200px;
            /* border : 1px solid black; */
        }

        #contents > #aside > p:first-child { /*맨 위의 객체의 윗여백 설정*/
            margin-top : 10px;
        }
        #contents > #aside > p { /*모든 객체의 아래여백설정*/
            margin-bottom : 10px;
        }
        #contents > #aside > p > a:hover { /*마우스 커서가 영역에 진입했을때*/
            background-color: rgb(10, 64, 95);
            color: rgb(112, 245, 255);
        }
        #contents > #section {
            float: right;
            width: 750px;
            /* border: 1px solid black; */
        }
        #contents > #section > #article {
            margin : 10px;
            /* border : 1px solid black; */
        }


        #contents > #section > #article > form > table {
            /* border: 1px solid black; */
            border-collapse : collapse; /*선이 겹칠 경우 한개로 정리*/
        }

        #contents > #section > #article > table > tr > td {
            /* border: 1px solid black; */
            text-align: center;
        }

       /* #contents > #section > #article > table > tr > td 너무 길어서 클래스로 접근*/
        .board_head1 {
            width : 100px;
            text-align: center;
        }
        .board_head2 {
            width : 270px;
            text-align: center;
        }
        .board_head3 {
            width : 100px;
            text-align: center;
        }
        .board_head4 {
            width : 150px;
            text-align: center;
        }
        .board_head5 {
            width : 100px;
            text-align: center;
        }


        .board_contents1 {
            text-align: center;
        }
        .board_contents2 {
            text-align: left;
        }
        .board_contents3 {
            text-align: center;
        }
        .board_contents4 {
            text-align: center;
        }
        .board_contents5 {
            text-align: center;
        }


		/*입력폼 디자인*/
		.board_inputA {
			width : 150px;
			height : 30px;
			text-align : center;			
		}

		.board_inputB {
			width : 500px;
			height : 30px;
			text-align : left
		}



        #footer {
            width: 960px;
            margin: 0 auto;
            position: relative;
            border: 1px solid black;
        }
        #footer > p {
            text-align: center;
            margin : 10px;
        }



    </style>
    
    <script>
    
    function sendform() {
    	alert("호출됨");
    	var b_subject = document.form.b_subject.value;
    		alert(b_subject);
    	
    }
    
    </script>
    
</head>
<body>
    <div id="top_nav">
        <div id="main_gnb">
            <ul>
                <li><a href="#">메뉴1</a></li>
                <li><a href="#">메뉴2</a></li>
                <li><a href="#">메뉴3</a></li>
                <li><a href="#">메뉴4</a></li>
                <li><a href="#">메뉴5</a></li>
            </ul>
        </div>
    </div>
    <div id="header">
        <img src="http://placeimg.com/965/150">
    </div>
    <div id="nav">
        <div id="main_lnb">
            <ul>
                <li><a href="#">메뉴1</a></li>
                <li><a href="#">메뉴2</a></li>
                <li><a href="#">메뉴3</a></li>
                <li><a href="#">메뉴4</a></li>
                <li><a href="#">메뉴5</a></li>
            </ul>
        </div>
    </div>
    <div id="contents">
        <div id="aside">
            <p class="leftmenu"><a href="#">메뉴1</a></p>
            <p class="leftmenu"><a href="#">메뉴2</a></p>
            <p class="leftmenu"><a href="#">메뉴3</a></p>
            <p class="leftmenu"><a href="#">메뉴4</a></p>
            <p class="leftmenu"><a href="#">메뉴5</a></p>
            <p class="leftmenu"><a href="#">메뉴6</a></p>
        </div>
		<div id="section">
			<div id="article">
				<p class="title">
					글입력&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="/board/list">리스트</a>
				</p>
				<form method="post" action="/board/insert">
		<!--<input type="hidden"	name="${_csrf.parameterName}"	value="${_csrf.token}">-->	
					<!-- 여기에 디자인을 한다 -->
					<table border="1">
						<tr>
							<td class="board_inputA">제목</td>
							<td class="board_inputB">
							<input type="text" name="b_subject">
							</td>
						</tr>
						<tr>
							<td class="board_inputA">내용</td>
							<td class="board_inputB">
							<input type="text" name="b_contents" cols="50" rows="12">
							</td>
						</tr>
						<tr>
							<td class="board_inputA">작성자</td>
							<td class="board_inputB">
							<input type="text" name="b_name">
							</td>
						</tr>
						<tr>
							<td class="board_inputA">비밀번호</td>
							<td class="board_inputB">
							<input type="password" name="b_password">
							</td>
						</tr>
						<tr>
							<td class="board_inputA" colspan="2">
							<input type="button" value="글 입력하기" onclick="sendform();">
							</td>
						</tr>
					</table>
					
				</form>
			</div>
		</div>
	</div>
    <div id="footer">
        <p>화면구현</p>
        <p>Copyright(c) KoreaIT. All Right Reserved.</p>
    </div>
</body>
</html>