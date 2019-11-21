			let currentUser;

function newRequestSubmit(event) {
    event.preventDefault(); // stop page from refreshing
    console.log('submitted');
    
    const request = getRequestFromInputs();

    fetch('http://localhost:8080/RequestApi/requests/submit', {
        method: 'POST',
        body: JSON.stringify(request),
        headers: {
            'content-type': 'application/json'
        }
    })
    .then(res => res.json())
    .then(data => {
        
        console.log(data);
    })
    .catch(err => console.log(err));

    
}

function logout() {
    
    console.log('logout function')
    fetch('http://localhost:8080/ReimbursementApi/auth/logout', {
        method: 'POST',
        headers: {
            'content-type': 'application/json'
        },
        
        credentials: 'include', 
    })
        .then(resp => {
           
            getCurrentUserInfo();
          
        })
}
function getRequestFromInputs() {
    const requestName = document.getElementById('Request-name-input').value;
    const requestValue = document.getElementById('request-value-input').value;
    const memo = document.getElementById('request-memo-input').value;
    const requestType = document.getElementById('Request-type-select').value;

    const request = {
        req_name: requestName,
        req_value: requestValue,
        memo: memo,
        req_type_id_name: requestType
        
    }
    return request;
}

async function getCurrentUserInfo() {
    const response = await fetch('http://localhost:8080/RequestApi/auth/session-user', {
        credentials: 'include'
    }).then(resp => resp.json());

    console.log(response);
    // .then(resp => {
    //     console.log(resp)
    //     return resp.json();
    // })
   
    // .then(data => {
    //     console.log("What is in data" + data);
    //     document.getElementById('users-name').innerText = data.username
    //     // refreshTable();
    //     currentUser = data;
    // })
    // .catch(err => {
    //     console.log(err);
    //     //window.location = '/RequestApi/API/Login.html';
    // })
} 

getCurrentUserInfo();

