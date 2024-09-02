console.log("index9.js")

read();
function create() {
    let accexp = document.querySelector("#accexp").value;
    let accmoney = document.querySelector("#accmoney").value;
    $.ajax({
        async: false,
        method: "post",
        url: "/acc/create",
        data: { accexp: accexp, accmoney: accmoney },
        success: function response(result) {
            console.log(result);
            if (result == 1) {
                alert("가계부 등록 성공")
                read();
            } else {
                alert("가계부 등록 실패")
            }
        }
    })
}

function read() {
    $.ajax({
        async: false,
        method: "get",
        url: "/acc/read",
        success: function response(result) {
            console.log(result)
            let read = document.querySelector("#read");
            let html = ``;
            result.forEach(r => {
                html += `<tr>
                            <td>
                                ${r.accnum}
                            </td>
                            <td>
                                ${r.accexp}
                            </td>
                            <td>
                                ${r.accmoney}
                            </td>
                            <td>
                                ${r.accdate}
                            </td>
                            <td>
                            <button type="button" onclick="update(${r.accnum})"> 수정 </button><br>
                            <button type="button" onclick="_delete(${r.accnum})"> 삭제 </button>
                            </td>
                        </tr>`
            })
            read.innerHTML = html;
        }
    })
}


function update(accnum) {
    let accexp = prompt("수정할 설명 입력");
    let accmoney = prompt("수정할 금액 입력");
    let accdate = prompt("수정할 날짜 입력");
    $.ajax({
        async: false,
        method: "put",
        url: "/acc/update",
        data: { accnum: accnum, accexp: accexp, accmoney: accmoney, accdate: accdate },
        success: function response(result) {
            console.log(result);
            if (result == 1) {
                alert("가계부 수정 성공");
                read();
            } else {
                alert("가계부 수정 실패")
            }
        }
    })
}

function _delete(accnum) {
    $.ajax({
        async: false,
        method: "delete",
        url: "/acc/delete",
        data: { accnum: accnum },
        success: function response(result) {
            console.log(result);
            if (result == 1) {
                alert("가계부 삭제 성공");
                read();
            } else {
                alert("가계부 삭제 실패")
            }
        }
    })
}