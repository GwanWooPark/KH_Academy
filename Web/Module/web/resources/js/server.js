//node.js에서는 모듈을 변수에 저장하여 해당 모듈을 사용

const session = require('express-session') //사용한 서버의 session 기능
const express = require('express')//사용한 서버 구축 모듈
const app = express()// 모듈을 사용해서 생성한 서버의 이름(app 서버)
const fs = require('fs') //fileStream 모듈로, https를 구현하기 위해 파일 경로를 읽어오는 모듈을 사용
const { v4: uuidV4 } = require('uuid') //uuid를 사용하여 방이 겹치지 않게 해준다.

const serveroption = { //서버 옵션을 정해준다. https 서버를 사용하기 위해 key와 cert 위치를 정해줌
    key: fs.readFileSync('./keys/private.key'),
    cert: fs.readFileSync('./keys/private.crt')
}

const server = require('https').createServer(serveroption, app) // app 서버를 https로 생성
const io = require('socket.io')(server) //해당 서버를 기준으로 socket.io 기능을 사용할 모듈을 설정, io라는 변수명칭을 지어줌


app.use(session({ //session을 사용하되 옵션을 정해준다
    secret: 'keyboard cat', //비밀번호는 랜덤(keyboard cat)
    resave: false, //  변경되지 않아도 세션을 저장할 지 정하는 값
    saveUninitialized: true //세션이 저장되기 전에 uninitialized 상태로 미리 만들어서 저장
}))

app.set('view engine','ejs') //사용할 템플릿 문서 엔진 : ejs : 
//Embedded JavaScript Template의 약자로 nodejs 진영에서 많이 사용하는 템플릿엔진이다. 문법이 단순하다
app.use(express.static('public')) //public 이라는 폴더에 있는 파일을 static 형태로 사용
app.use(express.json()); //json 사용
app.use(express.urlencoded({ extended: false })) //body 안의 데이터가 'application/x-www.form-urlencoded' 방식으로 인코딩 

//get방식으로 접근시 주소 루트값으로 접근하면 uuid4를 붙여서 보낸다
app.get('/',(req, res) => { 
    res.redirect(`/${uuidV4()}`)
})

//get방식으로 접근시 주소 루트값 + uuid를 가지고 온 경우 해당 룸 id를 저장해서 room으로 보낸다.
app.get('/:room', (req, res) => {
    console.log(req.session.member)
    console.log(req.session.business)
    res.render('room',{ roomId: req.params.room,
    member:  req.session.member,
    business:  req.session.business})
})


//post 방식으로 접근시 주소 루트값으로 접근하면 req데이터 세션에 저장하고 uuid4를 붙여서 보낸다(get방식)
app.post('/',(req, res)=>{
   req.session.member = req.body.member
   req.session.business = req.body.business
   console.log("m"+req.session.member)
   console.log("b"+req.session.business)
   res.redirect(`/${uuidV4()}`)
})

//socket.io에서 connection 에 성공했을 때 소캣 값에 body내용을 처리해준다
//이부분은 잘 모르겠습니다...
io.on('connection', socket =>{
    //join-room 일시에
    socket.on('join-room',(roomId,userId)=>{
        socket.join(roomId) //roomid를 기준으로 소켓을 조인해주고
        socket.broadcast.to(roomId).emit("user-connected", userId) //해당 roomid를 가진 방에 userid를 가진 사람의 소캣을 전체송출 해준다

        socket.on('disconnect', ()=>{ //소캣이 연결 끊기면
            socket.broadcast.to(roomId).emit('user-disconnected', userId) //해당 roomid를 가진 방에 userid를 가진 사람의 끊는다.
        })
    })
})

//3000 포트를 이용한다.
server.listen(3000)
