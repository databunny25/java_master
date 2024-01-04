// class 4.js
// 정렬: ctrl+k, ctrl+f

const friend = {
    name: "홍길동",
    age: 20,
    hobbies: ['독서', '운동', '영화'],
    pets: [{ 
        name: '야옹이', 
        gender: 'M',
        friends:['검양이', '빨양이']
    }, { 
        name: '멍멍이', 
        gender: 'F' 
    }],
    showHobby() {
        return `${this.hobbies[0]}, ${this.hobbies[1]}, ${this.hobbies[2]}`;
    }
}
console.log(friend.pets);
friend['pets'][0]['friends'][2] = '노랑이';
console.log(friend['pets'][0]['friends'][2]);
console.log(friend.showHobby());

delete friend.age; //속성을 지우고자 할대 delete사용!
// console.log(friend); //age속성이 사라진걸 볼수있다
friend.ages = 20; //ages속성 추가!
// console.log(friend); //ages:20 이 추가된걸 볼수있다

friend.showFriends = function(){ //showFriends 라는 메소드 추가!
    console.log(this); //this는 객체인 friend 가르킴
}
console.log(friend); //showFriends라는 메소드 추가된것 볼수있다


//참조값을 복사
const fcopy = friend; //friend의 주소값을  fcopy에 담아준다는 의미
fcopy.age = 22; //friend의 age도 22로 바뀌어버린다
console.log(fcopy);

//객체를 복사
//assign(초기화할 객체, 복사할 대상)...복사할 객체를 카피해서 새로운 객체를 만듦...
const fcopy2 = Object.assign({bloodType:'0'}, friend); //{bloodType:'0'}라고 넣으면 새로운 객체에는 friend에 없는 새로운 속성이 생김
fcopy2.age = 24;
console.log(fcopy2); //friend와 fcopy의 나이는 안 변했다!

//속성추가
Object.defineProperty(friend, 'height', {
    get:function(){
        return this._height;
    },
    set: function(value){
        if(value <= 0){
            alert('error');
        }else{
            this._height = value; //this.height = value;로 했더니 friend.height로 값을 넣을때 자기자신을 계속 불러내면서 무한루프를 돈다..._height로 이름을 살짝 바꿔서 무한루프 피해감
        }
    }
}); //메소드가 아니고, 걍 defineProperty로 추가하는 방식이 getter setter로 이런 방식으로 추가
//getter가 없으면 값을 불러오지 못해서 콘솔로그 찍으면 undefined출력
friend.height = 162;
console.log(friend.height);
