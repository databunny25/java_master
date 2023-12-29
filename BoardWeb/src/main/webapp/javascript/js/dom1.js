// dom1.js
// [{id, name, phone}...]
const obj1 = {id: 'user1', name: '홍길동', phone: '010-1111'};
const obj2 = {id: 'user2', name: '김민수', phone: '010-2222'};
const obj3 = {id: 'user3', name: '박철호', phone: '010-3333'};
const friends = [obj1, obj2, obj3];

for(let friend of friends){
    for(let prop in friend) { //prop 속성값을
        // console.log(prop);  prop출력하면 속성값을 반환해줌
        console.log(prop.toUpperCase(), ' - ', friend[prop]); //obj1['id']
    }
}