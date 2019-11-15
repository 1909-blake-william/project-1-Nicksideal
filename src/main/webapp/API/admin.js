let currentUser;

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