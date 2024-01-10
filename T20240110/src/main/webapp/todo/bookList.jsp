<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>책목록</h3>
	
	
	<script>
	
	
	
	
	



	// table 생성 start
		const obj =['도서코드', '도서명', '저자', '출판사', '가격', '삭제']
	        let tbl = document.createElement('table');
	        tbl.setAttribute('border', 1); //attribute 추가
	        tbl.setAttribute('id', 'list');
	        tbl.appendChild(makeHead());
	        tbl.appendChild(makeBody());
	        document.querySelector('body').appendChild(tbl);

	// table 생성 end



	        function makeHead(obj){       

	            // thead 시작
	            let thd = document.createElement('thead');

	            // tr 생성
	            let tr = document.createElement('tr');
	            
	            let th = document.createElement('th');
	            let input = document.createElement('input')
	            th.appendChild(input);
	            tr.appendChild(th);
	            
	            // th*3 생성
	            for(let prop in obj){
	                let th = document.createElement('th');
	                th.innerText = prop;
	                tr.appendChild(th);
	            }

	            //삭제
	            th = document.createElement('th');
	            th.innerText = '삭제';
	            tr.appendChild(th);


	            thd.appendChild(tr);
	            return thd;
	        }//end of makeHead()


	        // tbody 생성
	        function makeBody(){
	            
	            let tbd = document.createElement('tbody');            
	            
	            for(let book of books){    
	                tbd.appendChild(makeTr(book));
	            }
	            return tbd;
	        } //end of makeBody()
	        

	        // tr 생성
	        function makeTr(obj={}){
	        	
	        	// 체크박스 생성
	            // <input type="checkbox" name="" id=""></input>
	            td = document.createElement('td');
	            let chkbox = document.createElement('input');
	            chkbox.addEventListener('click', function(e){ //addEventListener는 자동으로 event라는 변수를 받는다
	                e.stopPropagation(); //상위요소로 이벤트 전파 차단
	                console.log(e);
	            })
	            chkbox.setAttribute('type', 'checkbox');            
	            td.appendChild(chkbox);
	            trb.appendChild(td);
	            
	            // tr            
	            let trb = document.createElement('tr'); 

	            // td
	            for(let prop in obj){
	                let td = document.createElement('td');
	                td.innerText = obj[prop];
	                trb.appendChild(td);
	            }
	            
	            // 삭제 버튼 만들기
	            let td = document.createElement('td');
	            let btn = document.createElement('button');
	            btn.innerText = '삭제';

	            td.appendChild(btn);
	            trb.appendChild(td);


	            

	            
	            return trb;

	        }//end of makeTr()

	
	        function bookList(){
	    		fetch('bookList.do')
	    		.then(str => str.json())
	    		.then(result => {
	    			result.forEach(book => {
	    				let head = makeHead(obj);
	    				let body = makeBody();
	    				tr = makeTr(book);			
	    				body.appendChild(tr);
	    			});
	    		})
	    		.catch(reject => console.log(reject));
	    	}
	    	bookList();
	        
	        
	</script>
</body>
</html>