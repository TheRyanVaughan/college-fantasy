async function hello() {
    const response = await fetch("http://localhost:8080/hello");
    let json = await response.json();
    console.log(json)
}

async function addTeam() {
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
    const leagueID = document.getElementById("leagueID").value;
    const name = document.getElementById("leaguename").value;
    const  managerid = document.getElementById("managerid").value;
    const maxNum = document.getElementById("maxNoPlayers").value;

    const league = {
        leagueID: leagueID, 
        leaguename: name,
        managerid: managerid,
        maxNumPlayers: maxNum,
    };

    console.log(league)
    const response = await fetch("http://localhost:8080/league", {
        method: "POST",
        body: JSON.stringify(league)
    });

    let json = await response.json();
    console.log(json);
}