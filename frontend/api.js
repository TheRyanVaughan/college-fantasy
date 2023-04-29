async function hello() {
    const response = await fetch("http://localhost:8080/hello");
    let json = await response.json();
    console.log(json)
}

async function addTeam() {
    const teamID = document.getElementById("teamID").value;
    const leagueID = document.getElementById("teamLeagueID").value;
    const name = document.getElementById("teamName").value;
    const wins = document.getElementById("wins").value;
    const losses = document.getElementById("losses").value;
    const draws = document.getElementById("draws").value;

    const team = {
        teamID: teamID,
        leagueID: leagueID, 
        name: name,
        wins: wins,
        losses: losses,
        draws: draws
    };
    console.log(team)
    const response = await fetch("http://localhost:8080/team", {
        method: "POST",
        body: JSON.stringify(team)
    });

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
        name: name,
        managerid: managerid,
        maxNum: maxNum,
    };

    console.log(league)
    const response = await fetch("http://localhost:8080/league", {
        method: "POST",
        body: JSON.stringify(league)
    });

    let json = await response.json();
    console.log(json);
}