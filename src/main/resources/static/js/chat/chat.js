console.log("chat.js")

let nickName = `익명${Math.floor(Math.random() * 1001) + 1}`

// JS 클라이언트 웹 소켓
let clientSocket = new WebSocket("ws://192.168.30.239:8080/chat/conn")
console.log(clientSocket)

// 1. clientSocket의 onClose, onError, onMessage, onOpen 정의
// 1) WebSocket 객체 내 onopen 속성은 서버 소켓과 접속을 성공했을 때 발동되는 함수 정의해서 대입
clientSocket.onopen = (e) => {
    // console.log("서버 소켓과 연결 성공");

    // 1. 클라이언트 서버와 접속을 성공했을 때 (알림) 메세지
    // type 은 메세지 식별을 위해 만들어놓은 것
    let msg = {
        "type": "alarm",
        "message": `${nickName}님이 입장하셨습니다.`
    }
    clientSocket.send(JSON.stringify(msg));
}

// 3) WebSocket 접속 해제했을 때 발동되는 함수 정의
// clientSocket.onclose = (e) => {
//     let msg = {
//         "type": "alarm",
//         "message": `${nickName}님이 퇴장하셨습니다.`
//     }
//     clientSocket.send(JSON.stringify(msg));
// }

// 2) WebSocket 객체 내 onmessage 속성은 서버 소켓이 메세지를 보내왔을 때 발동되는 함수 정의
clientSocket.onmessage = (e) => {
    console.log(e)
    // 1. 받은 메세지를출력할 HTML 호출
    let msgBox = document.querySelector(".msgBox");
    let msg = JSON.parse(e.data)

    if (msg.type == "alarm") {
        msgBox.innerHTML += `<div class ="alarmMsgBox">
                                <span>
                                    ${msg.message}
                                </span>
                            </div>`;
        return
    }
    // 2. 받은 메시지를 HTML에 대입

    // 내가 보낸 메세지
    if (msg.from == nickName) {
        msgBox.innerHTML += `<div class = "fromMsgBox"> 
                           <div>
                            ${msg.from} 
                            </div>
                            <div>
                                <span>
                                    ${msg.date.split(" ")[4]}
                                </span>
                                <span>
                                    ${msg.message}
                                </span>
                            </div>
                        </div>`
    } else {
        // 남이 보낸 메세지
        msgBox.innerHTML += `<div class = "toMsgBox"> 
                           <div>
                            ${msg.from} 
                            </div>
                            <div>
                                <span>
                                    ${msg.message}
                                </span>
                                <span>
                                    ${msg.date.split(" ")[4]}
                                </span>
                            </div>
                        </div>`
    }
}


// 2. 메세지 전송 이벤트
function onMsgSend() {
    // 
    let msgInput = document.querySelector(".msgInput")

    // 일반 메세지 type 은 메세지 식별을 위해 만들어놓은 것
    let msg = {
        "type": "msg",
        "message": msgInput.value,
        "from": nickName,
        "date": new Date().toLocaleString()
    }
    // console.log('onMsgSend() Called')
    // - 현재 클라이언트 소켓과 연결 유지된 서버 소켓에게 메시지를 전송

    // JSON.stringify() -> msg 가 object 이기 때문에 
    // JSON 객체 타입을 문자열 타입으로 변환
    // {"message":"ㅁㅁㅁㅁ","from":"익명739","date":"2024. 9. 12. 오후 12:18:03"}
    clientSocket.send(JSON.stringify(msg));
    msgInput.value = "";
}