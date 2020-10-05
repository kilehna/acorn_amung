<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="/../resources/header.jsp"%><!-- header -->

<div class="content">
	<h2>호텔 일상</h2>
		<a href="${pageContext.request.contextPath }/gallery/admin/upload_form.do"><button>새 글 작성</button></a>
		<div class="left">
			<a href="upload_form.do"
				class="btn-a">
				새 글 작성
			</a>
		</div>
		<ul class="gallery-list">
			<c:forEach var="tmp" items="${list }">
				<li>
					<div class="gallery-img">
						<a href="content.do?num=${tmp.num }">
							<img src="${pageContext.request.contextPath }${tmp.imagePath}"/>
						</a>
					</div>
					
					<div class="caption">
						<p>${tmp.caption }</p>
						<strong class="sub">${tmp.subCaption}</strong><br/>
						<span class="date">${tmp.regdate }</span>
					</div>
					
				</li>
			</c:forEach>
		</ul>
		
		<c:if test="${totalRow gt 6 }">
			<div class="btn-down">
				<a href="javascript:void(0);" id="nextBtn" ><i class="fas fa-chevron-down"></i></a>
			</div><!-- btn-down -->		
		</c:if>


</div>
<script>
	var currentPage = 1;
	var totalPageCount = ${totalPageCount};
	
	$("#nextBtn").on("click", function(){
		
		currentPage++;
		
			$.ajax({
				method : "GET",
				url : "ajax_list.do",
				data : {pageNum : currentPage},
				success : function(data){
					$(".gallery-list").append(data).fadeIn(1000);
				}
			});	
	});
	
</script>
<%@include file="/../resources/footer.jsp"%><!-- footer -->