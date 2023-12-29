//table.js

// for(let prop in obj1) { }



// table 생성 start
        let tbl = document.createElement('table');
        tbl.setAttribute('border', 1); //attribute 추가
        tbl.setAttribute('id', 'list');
        tbl.appendChild(makeHead());
        tbl.appendChild(makeBody());
        document.querySelector('body').appendChild(tbl);

// table 생성 end

//추가 버튼 클릭 이벤트
    document.getElementById('addBtn').addEventListener('click', function(){
        let id = document.getElementById('uid').value;
        let name = document.getElementById('uname').value;
        let phone = document.getElementById('uphone').value;

        if(!id || !name || !phone){
            alert('값을 입력...');
            return; //함수 안에서 return구문을 만나면 함수 종료! (click시 function인 함수 안에서 값이 없으면 여기서 return 돌려줘서 함수가 종료돼고 아래 구문들은 실행 X)
        }

        let obj = {id, name, phone}; //{id:id, name:name, phone:phone} 속성:값 ...속성과 값이 같으면 생략가능
        document.querySelector('#list>tbody').appendChild(makeTr(obj));    

        document.getElementById('uid').value = '';
        document.getElementById('uname').value = '';
        document.getElementById('uphone').value = '';
        document.getElementById('uid').focus();
    });


// 변경 버튼 클릭 이벤트
    document.querySelector('#editBtn').addEventListener('click', function(){

        //찾을 값:
        let findId = document.getElementById('uid').value;
        let phone = document.getElementById('uphone').value;

        //찾을 대상:
        let target = document.querySelectorAll('#list>tbody>tr') // #list아래 모든 tr을 가져옴 cf)#list>tr :list바로 아래 하위 tr만 가져옴. 
            // console.log(target);
        target.forEach(function(item, idx, ary){ // tr, 인덱스값, target자체
            // console.log(item, idx, ary)
            let tr = item; //헷갈릴까봐 우리가 바꾸려는 target의 실제 값인 tr로 바꿔줘서 보여줌
            if(tr.children[0].innerText == findId){
                tr.children[2].innerText = phone;
            }
        })

        // 내가 해봄
        // target.forEach(function(item, idx, ary){ // tr, 인덱스값, target자체
        //     // console.log(item, idx, ary)
        //     // let tr = item;
        //     if(item.children[0].innerText == findId){
        //         item.children[2].innerText = phone;
        //     }
        // })
    })


// 선택삭제 이벤트 시작
    document.querySelector('#delBtn').addEventListener('click', function(){
        document.querySelectorAll('#list>tbody>tr>td>input:checked').forEach(function(item){
            // console.log(item);
            item.parentElement.parentElement.remove();
        })
    });



        function makeHead(){       

            // thead 시작
            let thd = document.createElement('thead');

            // tr 생성
            let tr = document.createElement('tr');
            
            // th*3 생성
            for(let prop in obj1){
                let th = document.createElement('th');
                th.innerText = prop.toUpperCase();
                tr.appendChild(th);
            }

            //삭제
            let th = document.createElement('th');
            th.innerText = '삭제';
            tr.appendChild(th);

            th = document.createElement('th');
            th.innerText = '선택삭제';
            tr.appendChild(th);

            thd.appendChild(tr);
            return thd;
        }//end of makeHead()


        // tbody 생성
        function makeBody(){
            
            let tbd = document.createElement('tbody');            
            
            for(let friend of friends){    
                tbd.appendChild(makeTr(friend));
            }
            return tbd;
        } //end of makeBody()
        

        // tr 생성
        function makeTr(obj={}){
            // tr            
            let trb = document.createElement('tr'); 
            trb.addEventListener('click', function(){
                console.log(this.children[1].innerText); //this는 trb임!
                document.getElementById('uid').value = this.children[0].innerText;
                document.querySelector('#uname').value = this.children[1].innerText;
                document.getElementById('uphone').value = this.children[2].innerText;
            });

            // td
            for(let prop in obj){
                let td = document.createElement('td');
                td.innerText = obj[prop];
                trb.appendChild(td);
            }
            
            // 삭제 버튼 만들기
            let td = document.createElement('td');
            let btn = document.createElement('button');

            

            // button 이벤트 등록
            btn.addEventListener('click', function(){ //이벤트핸들러
                e.stopPropagation(); //상위요소로 이벤트 전파 차단
                console.log(this.parentElement.parentElement.remove());
            });
            
            btn.innerText = '삭제';

            td.appendChild(btn);
            trb.appendChild(td);


            // 체크박스 생성
            // <input type="checkbox" name="" id=""></input>
            td = document.createElement('td');
            td.setAttribute('align', 'center');
            let chkbox = document.createElement('input');
            chkbox.addEventListener('click', function(e){ //addEventListener는 자동으로 event라는 변수를 받는다
                e.stopPropagation(); //상위요소로 이벤트 전파 차단
                console.log(e);
            })
            chkbox.setAttribute('type', 'checkbox');            
            td.appendChild(chkbox);
            trb.appendChild(td);

            
            return trb;

        }//end of makeTr()

      
