<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="header">
	<div id="logo">
		<span>SNS</span>
	</div>
	<div id="login">
		<c:if test="${empty authInfo }">
			<form id="frmLogin" action="login" method="post">
				<c:if test="${empty cookie.REMEMBER.value}">
					<label>E-mail : <input type="text" name="email" id="email" /></label>
				&nbsp;&nbsp;&nbsp;&nbsp; <label>비밀번호 : <input
						type="password" name="password" id="password" /></label>
					<br>
					<label>E-mail 기억 <input type="checkbox"
						name="rememberEmail" id="rememberEmail" />
					</label>
					<input type="submit" value="로그인">
					<button id="button">회원가입</button>
				</c:if>
				<c:if test="${! empty cookie.REMEMBER.value}">
					<label>E-mail : <input type="text" name="email" id="email"
						value="${cookie.REMEMBER.value}" /></label>
				&nbsp;&nbsp;&nbsp;&nbsp; <label>비밀번호 : <input
						type="password" name="password" id="password" /></label>
					<br>
					<label>E-mail 기억 <input type="checkbox"
						name="rememberEmail" id="rememberEmail" checked />
					</label>
					 
					<input type="submit" value="회원가입" class="btn">
				
					<button id="button">회원가입</button>
					
				</c:if>
			</form>
		</c:if>
		<c:if test="${! empty authInfo }">
			${authInfo.name }님환영합니다.
				<a href="<c:url value='/member/list'/>">[회원 조회]</a>
			<a href="<c:url value='/member/changePassword'/>">[비밀번호변경]</a>
			<a href="<c:url value='/logout'/>">[로그아웃하기]</a>
		</c:if>
	</div>
</div>
