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

function getCurrentUserInfo() {
    fetch('http://localhost:8080/RequestApp/auth/session-user', {
        credentials: 'include'
    })
    .then(resp => resp.json())
    .then(data => {
        console.log(data);
        document.getElementById('users-name').innerText = data.username
        //refreshTable();
        currentUser = data;
    })
    .catch(err => {
        console.log(err);
        window.location = '/RequestApp/API/Login.html';
    })
}

// getCurrentUserInfo();

