<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>SNS</title>
<style>
#header {
	height: 10%;
	opacity: 0.7;
	background-size: 74%;
	background: linear-gradient(to bottom, #9dc0dc, #9dc0dc);
}
#header form{

}


#center {
	height: 80%;
}

#login {
	float: right;
	
}

#logo {
	color: white;
	font-size: 2em;
	font-style: italic;
	width: 400px;
	font-weight: bold;
	float: left;
}

#main {
	background-image: url('images/main.gif');
	background-color: #e3f0f1;
	height: 400px;
	opacity: 0.7;
	background-size: 68%;
}

#join {
	    float: right;
    margin-right: 13%;
}

#footer {
	background-color: #9dc0dc;
	height: 10%;
	color: white;
	position: relative:
}

a:link {
	
}

.form_style {
 	min-height: 40px;
    padding: 10px;
    font-size: 16px;
    background-clip: padding-box;
    border-color: rgba(0,0,0,0.25);
    border-radius: 5px;
    min-height: 34px;
    padding: 6px 8px;
    font-size: 14px;
    line-height: 20px;
    color: #333;
    vertical-align: middle;
    background-color: #fff;
    background-repeat: no-repeat;
    background-position: right 8px center;
    border: 1px solid #ddd;
    border-radius: 3px;
    outline: none;
    box-shadow: inset 0 1px 2px rgba(0,0,0,0.075);
}

#join .form_style{
width: 265px;
height:}

.btn {
    position: relative;
    display: inline-block;
    padding: 6px 12px;
    font-size: 14px;
    font-weight: 600;
    line-height: 20px;
    color: #333;
    white-space: nowrap;
    vertical-align: middle;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    background-color: #eee;
    background-image: -webkit-linear-gradient(#fcfcfc, #eee);
    background-image: linear-gradient(#fcfcfc, #eee);
    border: 1px solid #d5d5d5;
    border-radius: 3px;
    -webkit-appearance: none;
    -moz-appearance: none;
    appearance: none;
}
</style>
</head>
<body>
	<div id="center">
		<div id="main">
			<div id="join">
				<form action="joinSuccess" method="post">
					<p>
						<label>이메일<br> <input name="email"
							placeholder="email" class="form_style"/>
						</label>
					</p>
					
					<p>
						<label>ID<br> <input name="id" placeholder="ID" class="form_style"/>
						</label>
					</p>
					<p>
						<label>비밀번호<br> <input type="password" name="pW"
							placeholder="password" class="form_style"/>
						</label>
					</p>
					<p>
						<label>비밀번호 확인<br> <input type="password"
							name="confirmPw" placeholder="password" class="form_style"/>
						</label>
					</p>


					<input type="submit" value="회원가입" class="btn">
				</form>
			</div>
		</div>
	</div>



</body>
</html>