
function login() {
    const username = document.getElementById("exampleUsername1").value
    const password = document.getElementById("exampleInputPassword1").value
    const credential = {
        username,
        password
    };


    event.preventDefault()
    fetch('http://localhost:8080/RequestApi/auth/login', { 

        method: 'POST',
        headers: {
            'content-type': 'application/json'
        },
        credentials: 'include',
        body: JSON.stringify(credential)
    })
        .then(resp => {
            console.log("navigate to main menu");
            
           window.location = '/RequestApi/API/MainMenu.html';
            
        })
        .catch(err=>{
            console.log(err)
        })
}
