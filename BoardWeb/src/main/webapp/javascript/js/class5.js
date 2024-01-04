//class5.js

// Map, Set
const map = new Map();
map.set('홍길동', 20);
map.set('김민수', 22);
map.set('최성우', 25);
map.set('홍길동', 21); //기존에 있던 홍길동을 이 값으로 변경시켜버린다!

map.delete('최성우');

console.log(map.get('김민수'));
// map.clear();

console.log(map.keys());
for(let key of map.keys()){
    console.log(`key는 ${key}, value는 ${map.get(key)}`);
};
console.log(map.values()); //map의 값만
console.log(map.entries()); //map의 키와 값
for(let obj of map.entries()){
    console.log(obj); //entries는 배열로 값을 가져온다
}
for(let [item, value] of map.entries()){
    console.log(item, value); //배열로 선언해서 entries의 값 받아옴
}

// 첫번째 매개값이 값, 두번째 매개값이 키
map.forEach((val, key)=> console.log('key: ' + key+ ' val: ' + val));

//Set
const set = new Set();
set.add('홍길동');
set.add('김민수');
set.add('홍성길');
set.add('홍길동');

set.delete('김민수');

console.clear(); //콘솔창 깨끗하게~
console.log(set.size); //3출력...set은 중복값을 허용하지 X...김민수 delete하면 2출력

set.forEach(name => console.log(name));

const numAry = [10, 14, 12, 10]
const num = new Set(numAry); //배열 -> Set
num.forEach(number => console.log(number));



console.clear();
map.clear();

map.set('김명철', 80);
map.set('김익수', 70);
map.set('이명철', 80);
map.set('이익수', 85);
map.set('홍길동', 80);

// 김씨 점수의 합계
let sum = 0;
map.forEach((score, name) => {
    if(name.indexOf('김') == 0){
        sum += score;
    }
});
console.log(`합계점수: ${sum}`);
