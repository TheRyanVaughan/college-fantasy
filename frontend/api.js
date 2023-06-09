async function hello() {
    const response = await fetch("http://localhost:8080/hello");
    let json = await response.json();
    console.log(json)
}

async function getTeamsInLeague() { 
    const select = document.getElementById("league1");

    const leagueID = select.value;
    console.log(leagueID)

    const response = await fetch(`http://localhost:8080/teams?leagueID=${leagueID}`);
    let json = await response.json();
    console.log(json)
    displayData('getTeamsTable', json);
}

async function getUsers() {

    const response = await fetch("http://localhost:8080/users");
    let json = await response.json();
    displayData('getAllUsersTable', json);
}

async function getTeamsForUser() { //Caleb
    const userID = document.getElementById("getTeamsUserID").value;

    const response = await fetch(`http://localhost:8080/user/teams?userID=${userID}`);
    let json = await response.json();
    console.log(json)
    displayData('getUsersTeams', json);
}

async function getRoster() { //Caleb
    const teamID = document.getElementById("getRosterTeamID").value; //Should this be teamID or team name?

    const response = await fetch(`http://localhost:8080/players?teamID=${teamID}`);
    let json = await response.json();
    console.log(json)
    displayData('getRoster', json);
}

async function getPlayer() { //Caleb

    const firstName = document.getElementById("getPlayerFirstName").value;
    const lastName = document.getElementById("getPlayerLastName").value;

    const response = await fetch(`http://localhost:8080/player?firstName=${firstName}&lastName=${lastName}`);
    let json = await response.json();
    console.log(json)
    displayData('getPlayer', json);
}

async function addTeam() {
    console.log("called addteam")
   const userID = document.getElementById("userID").value;
    const leagueID = document.getElementById("teamLeagueID").value;
    const name = document.getElementById("teamName").value;
    const wins = document.getElementById("wins").value;
    const losses = document.getElementById("losses").value;
    const draws = document.getElementById("draws").value;

    const team = {
       userID: userID,
        leagueID: leagueID, 
        name: name,
        wins: wins,
        losses: losses,
        draws: draws
    };
    console.log(team)
    const response = await fetch("http://localhost:8080/team", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(team)
    });
    console.log(response);

    let json = await response.json();

    console.log(json);
}

async function addLeague() {
    const name = document.getElementById("leaguename").value;
    const  managerid = document.getElementById("managerid").value;
    const maxNum = document.getElementById("maxNoPlayers").value;

    const league = {
        leaguename: name,
        managerID: managerid,
        maxNumPlayers: maxNum,
    };

    console.log(league)
    const response = await fetch("http://localhost:8080/league", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(league)
    });

    if (response.ok) {
        alert("Success!")
    }
    else {
        alert("Fail!")
    }    
    
    loadLeaguesIntoOption();

}

function displayData(tableId, objectArr) {
    // if not an array, make it an array with one element
    if (!Array.isArray(objectArr)) {
        objectArr = [objectArr]
    }

    let table = document.getElementById(tableId)
    // clear table
    const rows = table.rows.length;
    for (let i = 1; i < rows; i++) {
        table.deleteRow(1);
    }   

    // map objects into new rows
    for (const objectIdx in objectArr) {
        const object = objectArr[objectIdx]
        console.log('object is ', object);
        let row = table.insertRow(-1);
    
        let colIdx = 0
        for (const property in object) {
            let newCell = row.insertCell(colIdx);
            newCell.innerText = object[property];
            colIdx+=1;
        }
    }
    
}

var hasLoaded = false;
async function loadLeaguesIntoOption() {

    let select = document.getElementById("league1")
    select.innerHTML = ''
    let response = await fetch("http://localhost:8080/leagues")
    let json = await response.json()

    
    // clear previous options

    json.forEach(obj => {
        console.log(obj.leagueID)
        let option = new Option(`${obj.leaguename} (${obj.leagueID})`, obj.leagueID)
        select.add(option);
    })
}

document.addEventListener("DOMContentLoaded", () => {
    loadLeaguesIntoOption()
})

async function dropTeamFromLeague() {
    let teamId = document.getElementById("dropTeamID").value;

    const response = await fetch(`http://localhost:8080/team?teamID=${teamId}`, {
        method: "DELETE"
    });

}

async function dropLeague() {
    let leagueID = document.getElementById("dropLeagueID").value;

    const response = await fetch(`http://localhost:8080/league?leagueID=${leagueID}`, {
        method: "DELETE"
    })

    loadLeaguesIntoOption()
}

async function addPlayerToTeam() {
    let playerID = document.getElementById("addPlayerToTeamPID").value;
    let teamID = document.getElementById("addPlayerToTeamTID").value;

    const res = await fetch(`http://localhost:8080/rosters/addPlayer?teamID=${teamID}&playerID=${playerID}`, {
        method: "POST"
    })
}