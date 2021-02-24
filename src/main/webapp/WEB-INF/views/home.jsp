<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<style>
	table {
	border-collapse: collapse; /* 테이블테두리 내부 간격 없애기 */
	margin: 0 auto; /*가운데 정렬*/
	border: 1px solid black;
	}
	tr, th, td {border:1px solid black;}
	div {text-align:center;}
	</style>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<div>
	<h3>회원등록</h3>
		<form action="/memberInsert">
			<div>
				<label>아이디</label>
				<input name="userid" type="text" required />
				<label>암호</label>
				<input name="userpw" type="password" required />
				<label>사용자</label>
				<input name="username" type="text" required />
				<label>이메일</label>
				<input name="email" type="text" required />
				<button type="submit">회원등록</button>
			</div>
		</form>
		
	<h3>회원리스트</h3>
		<table>
			<tr>
				<th>사용자 ID</th>
				<th>암호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>등록일</th>
				<th>수정일</th>
				<th>수정/삭제</th>
			</tr>
			<tr>
				<td>user2</td>
				<td>4321</td>
				<td>아무개</td>
				<td>bgsmsyl@aka.com</td>
				<td>2021.02.24</td>
				<td>2021.02.24</td>
				<td>
				<button type="button">수정</button>
				<button type="button">삭제</button>
			</tr>
		</table>	
	</div>
</body>
</html>
