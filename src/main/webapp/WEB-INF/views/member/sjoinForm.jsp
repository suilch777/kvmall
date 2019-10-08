<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	margin: 0 auto;
}

form {
	margin-top: 100px;
	border-radius: 10px;
	width: 460px;
}

input {
	text-align: center;
}

p {
	margin: 20px;
}

span {
	float: left;
	margin-left: 120px;
	font-size: 10px;
}

#sample4_postcode{
display: none;
}
#sample4_extraAddress{
display: none;
}
</style>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/common.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/common.js"></script>
<script>
	$(function() {
		$("#f1").submit(
				//var str = $("input[name='addr3']").val();
				//alert(str); 
			function() {
				$(".error").css("display", "none");
				$(".error2").css("display", "none");

				//빈 input태그가 존재하면 submit을 막도록 한다.
				if (checkInputEmpty($("input[name]")) == false) {
					return false;
				}

				//id 입력 확인
				var idReg = /^[a-z0-9]{6,15}$/i;
				var id = $("input[name='smid']").val();
				if (idReg.test(id) == false) {
					$("input[name='smid']").next().css("display",
							"inline");
					return false;
				}

				/* 	//name 확인
					//===========================================
						$("input[name='name']").focusin(function{
					if(checkInputEmpty( $("input[name='name']") ) == false){
						 alert("이름을 입력해 주세요.");
						return false;
					}
						})
						//============================================ */
				var nameReg = /^[가-힣]{2,5}$/;
				var name = $("input[name='name']").val();
				if (nameReg.test(name) == false) {
					$("input[name='name']").next().css("display",
							"inline");
					return false;
				}

				//password 확인
				var passReg = /^[a-z0-9!@#$%^&]{8,20}$/;
				var pass = $("input[name='password']").val();
				if (passReg.test(pass) == false) {
					$("input[name='password']").next().css(
							"display", "inline");
					return false;
				}

				//password일치하지 않을때
				if ($("input[name='password']").val() != $(
						"input[name='confirmPassword']").val()) {
					$("input[name='confirmPassword']").next()
							.next().css("display", "inline");
					return false;
				}
				
				var telReg = /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;
				var tel =$("input[name='tel']").val();
				if (telReg.test(tel) == false) {
					$("input[name='tel']").next().css("display",
							"inline");
					return false;
				}
				
				var emailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
				var email =$("input[name='email']").val();
				if (emailReg.test(email) == false) {
					$("input[name='email']").next().css("display",
							"inline");
					return false;
				}
				

			});
	})

	//---------------------------------------------------------	
	var idck = 0;
		
	$(function() {
		//idck 버튼을 클릭했을 때 
		$("#btn1").click(function() {
			//=====================
			if (checkInputEmpty($("input[name='smid']")) == false) {
				alert("ID를 입력해 주세요.");
				return false;
			}
			var idReg = /^[a-z0-9]{6,15}$/i;
			var id = $("input[name='smid']").val();
			if (idReg.test(id) == false) {
				$("span[id='idchk']").css("display", "inline");
				return false;
			}
			//===================

			//userid 를 param.
			var smid = $("input[name='smid']").val();

			$.ajax({
				async : true,
				type : 'POST',
				data : {
					"userid" : smid
				},
				url : "idCheck",
				dataType : "json",

				success : function(data) {

					if (data.cnt > 0) {

						alert("이미사용중인 ID입니다.");
						
						
						//아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
						$("#divInputId").addClass("has-error")
						$("#divInputId").removeClass("has-success")
						$("#userid").focus();

					} else {
						alert("사용가능한 ID입니다.");
						           				
						//아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
						$("#divInputId").addClass("has-success")
						$("#divInputId").removeClass("has-error")
						
						//아이디가 중복하지 않으면  idck = 1 
						idck = 1;

					}
				},
				error : function(data) {

					alert("알수없는 오류가 발생했습니다.\n관리자에게 문의해 주시기 바랍니다.");
                    return false;
				}
			});
		});
	});
	
	
	
	//========================================주소검색 script=========================
	
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function sample4_execDaumPostcode() {
		new daum.Postcode({
			oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
	            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	            var roadAddr = data.roadAddress; // 도로명 주소 변수
	            var extraRoadAddr = ''; // 참고 항목 변수
	
	            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                extraRoadAddr += data.bname;
	            }
	            // 건물명이 있고, 공동주택일 경우 추가한다.
	            if(data.buildingName !== '' && data.apartment === 'Y'){
	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	            if(extraRoadAddr !== ''){
	                extraRoadAddr = ' (' + extraRoadAddr + ')';
	            }
	
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            document.getElementById('sample4_postcode').value = data.zonecode;
	            document.getElementById("sample4_roadAddress").value = roadAddr;
	          //  document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
	            
	            // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
	            if(roadAddr !== ''){
	                document.getElementById("sample4_extraAddress").value = extraRoadAddr;
	                
	              
	                
	            } else {
	                document.getElementById("sample4_extraAddress").value = '';
	            }
	
	            var guideTextBox = document.getElementById("guide");
	            // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
	            if(data.autoRoadAddress) {
	                var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
	                guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
	                guideTextBox.style.display = 'block';
	
	            } else if(data.autoJibunAddress) {
	                var expJibunAddr = data.autoJibunAddress;
	                guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
	                guideTextBox.style.display = 'block';
	            } else {
	                guideTextBox.innerHTML = '';
	                guideTextBox.style.display = 'none';
	            }
	            
	         var addrall = data.zonecode+roadAddr+$("input[name='addr2']").val();
	         
	         alert(addrall);
	            
	        }
	    }).open();
	}
	
	
</script>
</head>

<!-- ------------===============body 시작 ==============------------- -->
<body>
	<div>
		<form action="sregister" method="post" id="f1">
			<p>
				<label>아이디</label> <input type="text" name="smid" value="${param.id }">
				<button type ="button" id="btn1">중복확인</button>
				<br> <span class="error" id="idchk">ID(영어,숫자 6~15)를
					입력하세요</span>

				<c:if test="${duplicatedId == true }">
					<span class="error2">이미 사용중인 ID입니다</span>
				</c:if>
			</p>
			<p>
				<label>이름</label> <input type="text" name="name" id="username"
					value="${param.name }"> <span class="error">이름(한글
					2~5)을 입력하세요</span>
			</p>
			<p>
				<label>비밀번호</label> <input type="password" name="password" id="userpwd">
				<span class="error">암호(영어,숫자,특수문자 8~20)를 입력하세요</span>
			</p>
			<p>
				<label>비밀번호 확인</label> <input type="password" name="confirmPassword">
				<span class="error">암호 확인란을 입력하세요</span> <span class="error">암호가
					일치하지 않습니다</span>
			</p>
			<p>
				<label>전화번호</label>  <input type="text" name="tel"
					value="${param.tel }">
					<span class="error">전화번호를 정확하게 입력해 주세요</span>
			</p>
			<p>
				<label>E-mail</label> <input type="text" name="email"
					value="${param.email }">
					<span class="error">E-mail 형식이 맞지 않습니다</span>
			</p>
			
			<p>
				<label>계좌번호</label> <input type="text" name="accno"
					value="${param.accno }">
					<span class="error">계좌번호를 입력하세요</span>
			</p>
		
		<!-- ===================== 주소팝업 가져오기 ========================= -->	
	
	
		<p>
				<label>주소1</label> <input type="text" name="addr1"
					value="${param.addr1 }">
					<span class="error">주소를 입력 하세요</span>
			</p>
	
	<p>
				<label>주소2</label> <input type="text" name="addr2"
					value="${param.addr1 }">
					<span class="error">상세주소를 입력 하세요</span>
			</p>
		<!-- 
			<p>		
	
	                 <span class="daum_addr">
	                    <input type="text" id="sample4_postcode" placeholder="우편번호">
						<input type="button" onclick="sample4_execDaumPostcode()" value="주소찾기"><br>
						<input type="text" id="sample4_roadAddress" placeholder="도로명주소" name="addr1">
				 	<input type="text" id="sample4_jibunAddress" placeholder="지번주소" name="addr2">
						<span id="guide" style="color:#999;display:none"></span>
						 
						<input type="text" id="sample4_detailAddress" placeholder="상세주소" name="addr2">
						 <input type="text" id="sample4_extraAddress" placeholder="참고항목" name="addr4"> 
						
					</span>
					
			</p> 
			
			 -->
			<p>
				<input type="submit" value="가입" id="btnsmt">
			</p>
		</form>
		
	</div>
</body>
</html>