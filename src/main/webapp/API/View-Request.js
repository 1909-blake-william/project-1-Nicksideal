let currentUser;



function newRequestSubmit(){
	 event.preventDefault(); // stop page from refreshing
	    console.log('submitted');
	    
	    const request = getRequestFromInputs();
	    addRequestToTableSafe(pokemon);
	    console.log(request);
}
function getRequestFromInputs() {
    const requestName = document.getElementById('request-name-input').value;
    const requestValue = document.getElementById('prequest-value-input').value;
    const requestMemo = document.getElementById('request-memo-input').value;
    const requestType = document.getElementById('request-type-select').value;
    const requestAuthor = currentUser.username;
    
    const request = {
        name: requestName,
        value: requestValue,
        memo: requestMemo,
        type: requestType,
        author: requestAuthor
    }
    return request;
}
function addRequestToTableSafe(request) {

    // create the row element
    const row = document.createElement('tr');

    // create all the td elements and append them to the row
    const req_typeData = document.createElement('td');
    req_typeData.innerText = request.req_type;
    row.appendChild(nameData);

   const req_nameData = document.createElement('td');
   req_nameData.innerText = request.req_name;
   row.appendChild(typeData);

   const valueData = document.createElement('td');
   valueData.innerText = request.req_value;
   row.appendChild(hpData);

   const submittedData = document.createElement('td');
   submittedData.innerText = request.req_submitted;
   row.appendChild(levelData);

   const approvedData = document.createElement('td');
   approvedData.innerText = request.req_approved;
   row.appendChild(trainerData);

   const memoData = document.createElement('td');
   memoData.innerText = request.memo;
   row.appendChild(trainerData);

   const statusData = document.createElement('td');
   statusData.innerText = request.req_status_id_name;
   row.appendChild(trainerData);

    // append the row into the table
    document.getElementById('request-table').appendChild(row);
}
function newSubmitRequest(){


}
function refreshTable() {
    fetch(`http://localhost:8080/RequestApi/requests?user=${currentUser.username}`)
        .then(res => res.json())
        .then(data => {
            data.forEach(addRequestToTableSafe)
        })
        .catch(console.log);
}

function refreshTableAdmin() {
    fetch('http://localhost:8080/RequestApi/requests/')
        .then(res => res.json())
        .then(data => {
            data.forEach(addRequestToTableSafe)
        })
        .catch(console.log);
}


function getCurrentUserInfo() {
   fetch('http://localhost:8080/RequestApi/auth/session-user', {
       credentials: 'include'
   })
   .then(resp => resp.json())
   .then(data => {
   	
       document.getElementById('users-name').innerText = data.username
       if(currentUser.username != 'admin'){
        refreshTable();
       }else{
           refreshTableAdmin();
       }
       
       currentUser = data;
   })
   .catch(err => {
       window.location = '/login/login.html';
   })
}

getCurrentUserInfo();