/**
 * service.js
 */

function makeLi(reply = {}) {
	//start
	let li = document.createElement('li');
	let span = document.createElement('span');
	span.innerText = '글번호 ' + reply.replyNo;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' ' + reply.reply;
	li.appendChild(span);
	span = document.createElement('span');
	span.innerText = ' ' + reply.name;
	li.appendChild(span);

	//삭제버튼
	let btn = document.createElement('button');
	btn.addEventListener('click', async function() {
	// btn.oncliick = async function(){ //이렇게 쓸수도 있지만 위 방법 권장
		// 댓글번호 삭제 후 화면에서 제거		
		const promise = await fetch('delReplyJson.do?rno=' + reply.replyNo)
		const json = await promise.json();		
		try{			
				if (json.retCode == 'OK') {
					alert('삭제됨');
					showList(pageInfo);					
				} else if (result.retCode == 'NG') {
					alert('처리중 에러');
				}
		}catch(err){
			console.error('예외=>', err)
		}
		
		/*let delHtp = new XMLHttpRequest();
		delHtp.open('get', 'delReplyJson.do?rno=' + reply.replyNo);
		delHtp.send();
		delHtp.onload = function() {
			let result = JSON.parse(delHtp.responseText);
			console.log(result);
			if (result.retCode == 'OK') {
				alert('삭제됨');
				// btn.parentElement.remove();
				// bno, page => 페이지리스트, 페이징리스트
				showList(pageInfo);	
				
			} else if (result.retCode == 'NG') {
				alert('처리중 에러');
			}
		}*/
		
		
	}, true);
	btn.innerText = '삭제';
	li.appendChild(btn); //end
	
	return li;

}