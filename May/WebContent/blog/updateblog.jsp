<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/include.jsp"%>
<%@ include file="../include/header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
* body{
	margin: 0px;
	padding: 0px;
	font-family: Quicksand;
	list-style-type: none;
}

a {
	text-decoration: none;
}


#gallery {
	width: 1650px;
	height: 900px;
	margin: 0px auto;
	margin-top: 120px;
	box-shadow: 0px 4px 10px 0 rgba(0, 0, 0, 0.2), 0px 4px 10px 0
		rgba(0, 0, 0, 0.10);
}

#imgbox {
	width: 850px;
	height: 900px;
	display: inline-block;
}

#imgbox img {
	width: 850px;
	height: 846px;
	margin: 0px;
	padding: 0px;
}

#conbox {
	width: 800px;
	height: 900px;
	
	display: inline-block;
	position: absolute;
}

#file {
	width:850px;
	height: 50px;
	
	position: relative;
}
#btn-1{
	width: 100px;
	height: 50px;
	float: right;
	color: white;
	border: none;
	background-color: #2ecc71;
	font-weight: bold;
}
#filename{
	border: none;
	width: 750px;
	height: 50px;
}
#title{
	width: 700px;
	height: 20px;
	display:block;
	margin-left: 25px;
	border: 1px solid gray;
}
#con{
	width: 750px;
	height: 600px;
	display:block;
	margin: 10px auto;
	border: 1px solid gray;
}
.contitle{
	padding: 10px;
	font-weight: bold;
	padding: 20px
}
#conwar{
	margin-top: 75px;
	width: 800px;
	height: 750px;
	
}
#btn-2{
	width: 200px;
	height: 50px;
	border: none;
	color: white;
	font-size: 20px;
	font-weight: blod;
	display: block;
	margin: 0px auto;
	background-color:  #2ecc71;
}

#err_check_msg{
		display: inline-block;
		width: 428px;
		height: 24px;
		font-size: 11px;
		font-weight: 700;
		line-height: 24px;
		color: #f46665;
		padding: 0px 15px;
		text-align: center;
	}
	
	#err_check{
		 display:none; 
	}
</style>

<script type="text/javascript" src="<%=path%>/SmartEditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

	$(document).on("click", "#btn-2", function(elClickedObj){
		var title = $("#title").val();
		
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
		
		if(title ==""){
			$("#title").focus();
			$("#err_check").css("display", "block");
			return false;
		}
		$("#frm_bin").submit();
	});



	
</script>
</head>
<body>
	<div id="gallery">
		<div id="imgbox">
				<img src="<%=path%>/img/010.jpg">
		</div>
		
		
		
		<div id="conbox">
			<div id="conwar">
				<form action="mgplayAction.bizpoll" method="post" name="frm_bin" id="frm_bin" enctype="multipart/form-data">
					<p class="contitle">제목</p>
					<input type="text" name="tilte" id="title" value="${blogview.title}">
					
					<div id="err_check">
						<span id="err_check_msg">
							제목을 입력해주세요
						</span>
					</div>
					
					<p class="contitle">내용</p>
					<textarea name="content" id="content"id="con" rows="10" cols="100">${blogview.content}</textarea>
					
					<p class="contitle">작성자</p>
					<input type="text" name="username" id="title" value="${sessionScope.loginUser.id}" readonly="readonly">
					
					
						<div><input type="file" name="uploadfile" id="uploadfile"></div>
				
					<button id="btn-2">수정하기</button>
				</form>
			</div>
		</div>

	
	
	</div>
	
	
	<script type="text/javascript">

		var oEditors = [];

		nhn.husky.EZCreator.createInIFrame({

  		oAppRef: oEditors,

   		elPlaceHolder: "content",

   		sSkinURI: "<%=path%>/SmartEditor/SmartEditor2Skin.html",

    	fCreator: "createSEditor2"

});

</script>
	
	
</body>


</html>