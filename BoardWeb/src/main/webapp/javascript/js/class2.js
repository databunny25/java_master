// class2.js
let year = 2024;
let month = 1;

let today = new Date(year, month-1, 1); // new Object(); 데이트 타입 객체를 하나 만듦
// today = new Date(year, month, 0);
console.log(today.getDate(), today.getDay());

// console.log(today.getFullYear());
// console.log(today.getMonth()); //1월은 0으로 반환
// console.log(today.getDate()); 
// console.log(today.getDay()); //일요일은 0, 수요일은 3

// let today2 = new Date(2023, 0, 1); 
// console.log(today2.getDay()); //2023년 1월 1일은 일요일

// let today3 = new Date(2023, 1, 0); //2월의 전달의 마지막날
// console.log(today3.getDate()); //1월 31일

class Calendar{
    constructor(year, month){ //연도와 월 정보를 담아두기 위해 생성자 하나 만듦
        this.year = year;
        this.month = month;
    }
    days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];

    makeCalendar(){
        console.log('달력생성');
        this.makeTitle(document.getElementById('theader'));
        this.makeBody(document.getElementById('tbody'));
        
    }    
    
    makeTitle (pos){ 
        let tr = document.createElement('tr');
        this.days.forEach(function(field){
            let th = document.createElement('th');
            th.innerText = field;
            tr.appendChild(th);
        })
        pos.appendChild(tr);
    }
    
    makeBody(pos = {}){ // pos = {} '돔 객체'를 의미
        let tr = document.createElement('tr');
        
        // 공백
        let firstDay = this.getFirstDay();
        for(let i = 0; i < firstDay; i++){
            let td = document.createElement('td');
            td.innerText = "";
            tr.appendChild(td);
        }
        //날짜
        let lastDate = this.getLastDate();
        for(let i=1; i<= lastDate;i++){
            
            // 토요일: pink, 일요일: aqua
            let td = document.createElement('td');
            // td의 속성을 추가
            if((firstDay+i) % 7 == 1){
                td.setAttribute('style', 'background-color:pink');
            }else if((firstDay+i) % 7 == 0){
                td.setAttribute('style', 'background-color:aqua');
            }
            td.innerText = i;
            tr.appendChild(td);
            
            if((firstDay+i) % 7 == 0){
                pos.appendChild(tr);
                tr = document.createElement('tr');
            }
        }
        pos.appendChild(tr);
    }
    getFirstDay(){
        return new Date(this.year, this.month -1, 1).getDay(); // this.month -1 주의!
    }
    getLastDate() {
        //년, 월 : this.year, this.month
        return new Date(this.year, this.month, 0).getDate(); // this.month 주의!
    }
    
}
const cal = new Calendar(year, month);
cal.makeCalendar();


