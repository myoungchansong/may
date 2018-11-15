<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	button {
		border: none;
		background: white;
		position: relative;
		right: -100px;
	}
</style>
</head>
<body>

		<%-- 	<span>댓글 ${replyList.size()}</span> --%>
			<c:if test="${replyList.size()} == 0">
				등록된 댓글이 없습니다 
			</c:if>
				<div id ="reply_div">
			<c:forEach items="${replyList}" var="replyview">
					<div id="rad">
						<img src="img/011.jpg" id="rad_img">
						<span id="name">${replyview.writer}</span> 
						<span id="time">작성일:<fmt:formatDate pattern="HH:mm:ss" value="${replyview.regdate}"/></span>
						<span id="reply">${replyview.content}</span>
						
						<c:if test="${sessionScope.loginUser.id == replyview.writer}">
						
							<div id="del"><button id="del_btn" data_num="${replyview.rno}">삭제</button></div>
						
						</c:if>
					</div>
			</c:forEach>
				</div>
</body>
</html>