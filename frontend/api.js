async function hello() {
    const response = await fetch("http://localhost:8080/hello");
    let json = await response.json();
    console.log(json)
}
