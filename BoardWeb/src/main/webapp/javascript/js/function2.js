//function2.js

let members = `[{"id":1,"first_name":"Aloin","last_name":"Juszkiewicz","email":"ajuszkiewicz0@ning.com","gender":"Male","salary":1561},
{"id":2,"first_name":"Cookie","last_name":"Whitebread","email":"cwhitebread1@vistaprint.com","gender":"Female","salary":1686},
{"id":3,"first_name":"Margi","last_name":"Walliker","email":"mwalliker2@marketwatch.com","gender":"Female","salary":6739},
{"id":4,"first_name":"Dorri","last_name":"Hutchason","email":"dhutchason3@go.com","gender":"Female","salary":6643},
{"id":5,"first_name":"Morton","last_name":"Elder","email":"melder4@jiathis.com","gender":"Male","salary":5345},
{"id":6,"first_name":"Myrtice","last_name":"Pakes","email":"mpakes5@ucla.edu","gender":"Female","salary":1225},
{"id":7,"first_name":"Gerardo","last_name":"Guillart","email":"gguillart6@nps.gov","gender":"Male","salary":7415},
{"id":8,"first_name":"Robbert","last_name":"Bowen","email":"rbowen7@intel.com","gender":"Male","salary":9046},
{"id":9,"first_name":"Jule","last_name":"Thrower","email":"jthrower8@time.com","gender":"Male","salary":5343},
{"id":10,"first_name":"Adriane","last_name":"Treen","email":"atreen9@addtoany.com","gender":"Female","salary":5332},
{"id":11,"first_name":"Patricio","last_name":"Matterface","email":"pmatterfacea@dailymotion.com","gender":"Male","salary":8614},
{"id":12,"first_name":"Roarke","last_name":"Giacoboni","email":"rgiacobonib@gmpg.org","gender":"Male","salary":9371},
{"id":13,"first_name":"Anne-marie","last_name":"Prickett","email":"aprickettc@goodreads.com","gender":"Female","salary":8305},
{"id":14,"first_name":"Edan","last_name":"Howsin","email":"ehowsind@ucoz.ru","gender":"Male","salary":3160},
{"id":15,"first_name":"Winn","last_name":"Hatherall","email":"whatheralle@xing.com","gender":"Male","salary":9780}]`;


let memberAry = JSON.parse(members); //문자열 -> 객체변환
console.log(memberAry[14]);

let titles = ['아이디', '이름', '성씨', '이메일', '성별', '급여'];

function makeHeader(fields=[], pos={}){ //태그 만들기 위한 데이터, 만들어진 데이터를 여기(position의 줄임말)다가 붙이겠음
    let tr = document.createElement('tr');
    fields.forEach(function(field){
        // console.log(field);
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    })
    pos.appendChild(tr);
}
makeHeader(titles, document.getElementById('theader'));


function makeBody(data=[], pos = {}){
    data.forEach(function(item){
        let tr = document.createElement('tr');
        // console.log(item);

        //tr에 속성지정
        if(item.gender == 'Male'){
            tr.setAttribute('style', 'background-color: aqua');
        }else if(item.gender == 'Female'){
            tr.setAttribute('style', 'background-color:pink');
        }

        for(let prop in item){
            let td = document.createElement('td');
            td.innerText = item[prop];            
            // console.log(item[prop]);
            // if(td.innerText == 'Male'){
            //     tr.setAttribute('style', 'background-color: blue');
            // }else if(td.innerText == 'Female'){
            //     tr.setAttribute('style', 'background-color: yellow');
            // } 내가 한거...
            tr.appendChild(td);
            
                   
        }
        pos.appendChild(tr);
    })
}
makeBody(memberAry, document.getElementById('tbody'));