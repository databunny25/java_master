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
console.log(friend); //age속성이 사라진걸 볼수있다
friend.ages = 20; //ages속성 추가!
console.log(friend); //ages:20 이 추가된걸 볼수있다

friend.showFriends = function(){ //showFriends 라는 메소드 추가!
    console.log(this); //this는 객체인 friend 가르킴
}
console.log(friend); //showFriends라는 메소드 추가된것 볼수있다

