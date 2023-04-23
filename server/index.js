const express = require('express');

const PORT = 55000;
const app = express();

app.get("/", (req, res) => {
    console.log('received a request at health.');
    res.send("success!");
});

app.listen(PORT, () => {
    console.log("server started on port " + PORT);
});