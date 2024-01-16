// book.js T20240115.html에 링크

//페이지 오픈되면서 데이터를 목록에 출력
fetch('dataT20240116.json?userId='+userId+'&name='+ name, { //겟 방식인 경우 여기에 파라미터 (변수 선언해서 들고오기)
    method:'get', 

    //겟 방식은 헤더랑 바디가 들어오면 안된다~잠시 주석묶기
    headers:{
        'Content-Type':'application/x-www-form-urlencode'
    },
    body: 'bcode=' + bcode + 'bname=' + name +'&bauthor=우리출판사' //포스트 방식인 경우 여기에 파라미터


})
.then(result => result.json())
.then(data => {
    console.log(data);
    data.forEach(book =>{
        document.querySelector('tbody').appendChild(makeTr(book));
    })
})
.catch(err => console.log(err));



// id 값으로 요소선택
document.querySelector('#delSelected').addEventListener('click', function(){
    // 대상
    let target = document.querySelectorAll('td input[type="checkbox"]:checked');
    target.forEach(chk => {
        chk.parentElement.parentElement.remove();
    })
})


document.querySelector('#saveBtn').addEventListener('click', function(){
    const bcode = document.querySelector('input[name="bcode"]').value;
    const bname = document.querySelector('input[name="bname"]').value;
    const bauthor = document.querySelector('input[name="bauthor"]').value;
    const bpress = document.querySelector('input[name="bpress"]').value;
    const bprice = document.querySelector('input[name="bprice"]').value;
    
    console.log(bcode, bname, bauthor, bpress, bprice);
    const userVal = {bcode, bname, bauthor, bpress, bprice} //bcode:bcode처럼 이렇게 속성과 값이 같으면 속성을 생략해줘도 얘가 알아듣는다~

    // tr 생성함수
    let tr = makeTr(userVal);



    console.log(tr);
    document.querySelector('tbody').appendChild(tr);
})



// tr 생성함수
function makeTr(val = {}){

    // tr생성 > td*6 
    const fieldAry = ['bcode', 'bname', 'bauthor', 'bpress', 'bprice']; 
    let tr = document.createElement('tr');

    //checkbox
    let td = document.createElement('td');
    let inp = document.createElement('input');
    inp.setAttribute('type', 'checkbox');
    td.appendChild(inp);
    tr.appendChild(td);

    fieldAry.forEach(field => {
        let td = document.createElement('td');
        td.innerText = val[field];
        tr.appendChild(td);
    });

    //삭제버튼
    td = document.createElement('td');
    inp = document.createElement('button');
    inp.innerText = '삭제';
    inp.addEventListener('click', function(){
        console.log(this.parentElement.parentElement);
        this.parentElement.parentElement.remove();
    });
    td.appendChild(inp);
    tr.appendChild(td);

    return tr; //생성한 tr반환

}