<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="contents">

	<div id="mainRight">
		<div id="rightWrap">
			<h1>
				<b>김민김민김민김민김민김민김민김민김민김민김민김민김민김민김민김민김민김민김민</b>
			</h1>
			<form action="writeBoard" method="post" enctype="multipart/form-data">
				<textarea rows="8" cols="65" name="contents" id="contents"></textarea>
				<br> <input type="file" name="file"> <input
					type="submit" value="게시하기">
			</form>
			
		</div>
		
	</div>
	<c:forEach var="boards" items="${boards}">
 			 	ID: <c:out value="${boards.writerId}" /><br>
 			 	글쓴이: <c:out value="${boards.subject}" /><br>
 			 	내용: <c:out value="${boards.content}" /><br>
				제목: <c:out value="${boards.file}" /><br>
				<img src="${pageContext.request.contextPath}/upload/${boards.file}">
				
			</c:forEach>

</div>