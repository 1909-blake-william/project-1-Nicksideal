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
    const nameData = document.createElement('td');
    nameData.innerText = request.req_name;
    row.appendChild(nameData);

//    const typeData = document.createElement('td');
//    typeData.innerText = pokemon.type.name;
//    row.appendChild(typeData);
//
//    const hpData = document.createElement('td');
//    hpData.innerText = pokemon.healthPoints;
//    row.appendChild(hpData);
//
//    const levelData = document.createElement('td');
//    levelData.innerText = pokemon.level;
//    row.appendChild(levelData);
//
//    const trainerData = document.createElement('td');
//    trainerData.innerText = pokemon.trainer.username;
//    row.appendChild(trainerData);

    // append the row into the table
    document.getElementById('request-table').appendChild(row);
}
function newSubmitRequest(){


}
function refreshTable() {
    fetch('http://localhost:8080/RequestApi/requests/')
        .then(res => res.json())
        .then(data => {
            data.forEach(addRequestToTableSafe)
        })
        .catch(console.log);
}
refreshTable();
//function getCurrentUserInfo() {
//    fetch('http://localhost:8080/RequestApi/auth/session-user', {
//        credentials: 'include'
//    })
//    .then(resp => resp.json())
//    .then(data => {
//    	
//        document.getElementById('users-name').innerText = data.username
//        refreshTable();
//        currentUser = data;
//    })
//    .catch(err => {
//        window.location = '/login/login.html';
//    })
//}
//
//getCurrentUserInfo();