<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>272p~273p</title>
</head>
<body>
	<p>실습</p>
	<ul id="friends">
		<li class="animal">라이언</li>
		<li class="fruit">어피치</li>
		<li class="animal">프로도</li>
		<li class="alien">콘
			<ul class="keyword">
				<li>3세</li>
				<li>숏다리</li>
				<li>초록괴수</li>
			</ul>
		</li>
	</ul>
	
	<ul class="icons">
		<li>
			<span>스몰</span>
			<span>미디엄</span>
			<span>거대</span>
		</li>
	</ul>
	<ul id ="newfriends">
	</ul>
	
	<script>
	// 새 <li> 엘리먼트 생성
	let li = document.createElement('li');
	let litext = document.createTextNode('무지');
	li.appendChild(litext);
	
	// 새 <li> 엘리먼트를 붙일 대상 부모 선택
	let targetul = document.getElementById('friends');
	targetul.appendChild(li); //friends ID를 가진 ul 자식들 맨끝에 새로 만든 <li> 태그를 붙임
	
	
	//이동할 엘리먼트 선택
	let sourceli = document.querySelector('ul#friends li:first-child');
	//삽입할 위치 기준 엘리먼트 선택
	let targetli = document.querySelector('ul#friends li:last-child');
	targetli.after(sourceli);
	
	var appendli = document.createElement("li");
	appendli.append("왕눈이");
	document.querySelector('ul li ul').append(appendli);
	
	let selected = document.querySelector('.icons li span:last-child');
	let newspan = document.createElement('span');
	let newspantext = document.createTextNode('빅');
	newspan.appendChild(newspantext);
	selected.parentNode.insertBefore(newspan,selected);
	
	let items = document.querySelectorAll('.animal');
	document.querySelector('#newfriends').prepend(...items);
	
	
	</script>
	
	
</body>
</html>