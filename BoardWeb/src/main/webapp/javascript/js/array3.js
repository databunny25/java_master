// array3.js

import{
    members,
    titles
} from './data.js';

console.log(members);
console.log(titles);

let str = titles.reduce((acc, title, idx)=>{
    if(idx == 0){
        acc += '<tr>';
    }
    acc += '<th>' + title + '</th>';
    if(idx == titles.length -1){
        acc += '</tr>';
    }
    return acc;
}, '');
document.getElementById('theader').innerHTML = str; // innerHTML !! <th><th.../th></tr>

const tbody=document.getElementById('tbody'); //이렇게 변수로 주거나~초기값으로 주거나~선택!
members.reduce((acc, member) => {
    let tr = document.createElement('tr');
    for(let prop in member){
        let td = document.createElement('td');
        td.innerText = member[prop];
        tr.appendChild(td);
    }
    acc.appendChild(tr);
    return acc;
}, tbody);


// map(A -> A'), filter(A -> B)
let result = members.map((item, idx) =>{
    let obj = {}
    obj.id = item.id;
    obj.name = item.first_name + '-' + item.last_name;
    obj.email = item.email;
    return obj;
});
console.log(result);

result = members.filter(item => item.gender == 'Female');
// result = members.filter(item => {return item.gender == 'Female'});
console.log(result);


result = members // 메소드 체인
    .filter(item => item.gender == 'Female')
    .map((item, idx) => {
        let obj = {}
        obj.id = item.id;
        obj.name = item.first_name + '-' + item.last_name;
        obj.email = item.email;
        return obj;
    })
    .map(item => item.name);    
    
console.log(result);
console.log(result.indexOf('Roby-Rhubottom'));

result.push('charles');
result.push('Hong');
result.push('charles');
console.log(result);
console.log(result.indexOf('charles', 6)); //두번째 찰스를 찾아줌


