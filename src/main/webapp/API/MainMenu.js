let currentUser;
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

getCurrentUserInfo();

