let currentUser;
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

    if (req_status_id_name != 'pending') {
        const approveButton = document.createElement('button');
        approveButton.innerText = 'Approve';
        approveButton.setAttribute('onclick', 'approve(this.value)')
        approveButton.setAttribute('class', 'btn btn-lg btn-success btn-block')
        approveButton.setAttribute('value', `${request.req_status_id_name}`)
        row.appendChild(approveButton);

        const denyButton = document.createElement('button');
        denyButton.innerText = 'Deny';
        denyButton.setAttribute('onclick', 'deny(this.value)')
        denyButton.setAttribute('class', 'btn btn-lg btn-danger btn-block')
        denyButton.setAttribute('value', `${request.req_status_id_name}`)
        row.appendChild(denyButton);
    }
    // append the row into the table
    document.getElementById('request-table').appendChild(row);
}


function refreshTableAdmin() {
    removeBlock()
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
            refreshTable();
            currentUser = data;
        })
        .catch(err => {
            window.location = '/login/login.html';
        })
}

getCurrentUserInfo();