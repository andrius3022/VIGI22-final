console.log("Lets go!")

fetch("http://localhost:8080/")
    .then(res => res.json())
    .then((data) => console.log(data));