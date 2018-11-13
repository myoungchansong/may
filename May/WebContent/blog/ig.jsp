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
	*{
		margin:0px;
		padding: 0px;
		font-family: Quicksand;
	}
	
	#gallery{
		
		width: 1650px;
		height: 900px;
		margin: 0px auto;
		margin-top: 120px;
		box-shadow: 0px 4px 10px 0 rgba(0, 0, 0, 0.2),
					0px 4px 10px 0 rgba(0, 0, 0, 0.10);	
		border: 1px solid black;
	}
	#infor{
		
		width: 400px;
		height: 900px;
		background-color: white;
		float: right;
		border-left: 1px solid black;
	}
	
	#user_box{
	
	height: 50px;
	width: 400px;
	border-bottom: 1px solid gray;
	
	}
	#user{
		height: 50px;
		width: 100px;
		float: right;
		text-align: center;
		display: inline-block;
		line-height: 50px;
		font-weight: bold;
		
	}
	#title{
		height: 50px;
		width: 300px;
		text-align: center;
		line-height: 50px;
		font-weight: bold;
	}
	#content{
		width: 400px;
		height: 400px;
		border-bottom: 1px solid gray;
		
	}
	#content_div{
		width: 400px;
		height: 330px;
		line-height: 50px;
		font-weight: bold;
		border-bottom: 1px solid gray;
	}
	#file{
		width: 400px;
		height: 20px;
		text-align: right;
		
	}
	#file span{ margin-right: 10px; font-size: 10px; }
	
	
	#war{
		height: 50px;
		margin: 0px auto;
		
	}
	
	#good, #lookup, #share{
		display: block;
		width: 100px;
		height: 50px;
		float: right;
		line-height: 50px;
		text-align: center;
	}
	
	#reply_war{
		width: 400px;
		height: 370px;
		margin-bottom: 10px;
	}
	
	
	#lingk{
		width: 400px;
		height: 60px;
		border-top: 1px solid gray;
	}
	
	#photo_border{
		width:1000px;
		height:700px;
		
	}
	#photo{
		width:1200px;
		height:900px;
		box-shadow: 0px 4px 10px 0 rgba(0, 0, 0, 0.2),
					0px 4px 10px 0 rgba(0, 0, 0, 0.10);	
	}
	
	.a{
		display: inline-block;
		line-height: 50px;
		font-weight: bold;
		width: 70px;
		height: 60px;
		line-height: 60px;
		text-align: center;
		float: right;
	}
	
	#rad {
		border-bottom: 1px solid gray;
		height: 60px;
	}
	#rad img{
	margin: 10px 0px 0px 10px;
	display: inline-block;
	width: 40px;
	height: 40px;
	border-radius: 50%;
	}
	#name {
	position:absolute;
	
	font-weight: bold;
	}
	#time {
	position:relative;
	font-size: 10px;
	right: -80px;
	top: -12px;
	}
	#reply{
		width: 400px;
		height: 60px;
		position: relative;
		top: 15px;
		left: -130px;
		font-size:12px;
	}
	
	#serch_war{
		width: 400px;
		height: 60px;
		margin-bottom: 10px;
		border: 1px solid gray;
	}
	#reply_div{
		width: 400px;
		height: 310px;
		
	}
	#reply_insert{
		width: 390px;
		height: 35px;
	}
	#keywordInput{
		width: 398px;
		height: 30px;
		border: none;
		border-bottom: 1px solid gray;
	}
	#btn_input1{
		width: 100px;
		height: 28px;
		display: inline-block;
		background-color:white;
		color: gray;
		float:right;
		font-weight:bold;
		border: none;
		border-left: 1px solid gray;
	}
	#er{
		color:red;
		font-size: 10px;
		font-weight: bold;
		line-height: 10px;
		float: center;
	}
	.btn4 {
	
    width: 80px;
	height: 40px;
	background-color:#f8585b;
   	border: none;
    color:white;
    padding: 15px 0;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
    margin: 4px;
    cursor: pointer;
	border-radius:10px;
	
	line-height: 10px;
	}
	.container{
		display: inline;
		padding: 0px;
	}
	

</style>
<script type="text/javascript" src="<%=path%>/SmartEditor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
		
		$(document).on("click", "#blogupdate", function(){
			location.href="blogupdate.bizpoll?bno=${blogview.bno}"
			
		});
</script>


</head>
<body>
	<div id="gallery"> 
	
		<div id="infor">
			<div id="user_box">
				<div id="user"><p>${blogview.writer}</p></div>
				<div id="title"><p>${blogview.title}</p></div>
			</div>
			
			
				<div id="content">
					<div  id=content_div>
						<p>${blogview.content}<p>
					</div>
						<div id="file">
							<a href="download.bizpoll?file=${blogview.filename}">${blogview.filename}
							(<fmt:formatNumber type="number" pattern="0.0" value="${blogview.filesize /12}"/>)kb</a>
						</div>
					
					<div id="war">
						<div id="lookup">
							<span>조회수 : ${blogview.viewcnt}</span>
						</div>
						<div id="good">
							<button class="btn4">good</button>
						</div>
						<div id="share">
							<button class="btn4">share</button>
						</div>
					</div>
				</div>
			
			
			
			
			
			
			
			<div id="reply_war">
				<div id ="reply_div">
					<div id="rad">
						<img src="img/011.jpg" id="rad_img">
						<span id="name">${blogview.writer}</span> 
						<span id="time">${blogview.regdate}</span>
						
						<span id="reply">내용</span>
					</div>
				</div>
				
		<c:choose>
			<c:when test="${empty sessionScope.loginUser}">
				<!-- 로그인 안됐을때  -->
				<input type="text" name="keyword" id="keywordInput" readonly="readonly">
				<button id="btn_input1">댓글달기</button>
				<span id="er">로그인 후 사용 가능합니다 </span>
			</c:when>
			<c:otherwise>
				<!--로그인 됬을때  -->
		<div id="serch_war">
			<div id="reply_insert">
				<input type="text" name="keyword" id="keywordInput" value="${cri.keyword}" placeholder="">
				<button id="btn_input1">한줄평남기기</button>
			</div>	
		</div>
			</c:otherwise>
		</c:choose>		
				
		
		
	</div>	
			
		<div id="lingk">
			<c:if test="${sessionScope.loginUser.id == blogview.writer}">
			<!-- 	<button class="btn4">삭제</button> -->
				<button class="btn4" id="blogupdate">수정</button>
					<div class="container">
						<!-- Button to Open the Modal -->
						<button type="button" class="btn btn-primary btn4" data-toggle="modal"
							data-target="#myModal">삭제</button>

						<!-- The Modal -->
						<div class="modal fade" id="myModal">
							<div class="modal-dialog modal-sm">
								<div class="modal-content">

									<!-- Modal Header -->
									<div class="modal-header">
										<h4 class="modal-title">게시글 삭제</h4>
										<button type="button" class="close" data-dismiss="modal">&times;</button>
									</div>

									<!-- Modal body -->
									<div class="modal-body">게시글을 삭제하시겠습니까?</div>

									<!-- Modal footer -->
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal" style="background-color: blue">삭제</button>
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">취소</button>
									</div>

								</div>
							</div>
						</div>

					</div>
					
				</c:if>
			<button class="btn4">답변</button>
			<button class="btn4">목록</button>
		</div>
			
		</div>
		
		<div id="photo_border">
			<img src="img/${blogview.filename}" id="photo">
		</div>
		
		
	</div>
	
</body>
</html>