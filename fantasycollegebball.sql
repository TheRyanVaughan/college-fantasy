--need to update data types and make sure they are consistent
--need to make sure all fields are in each table
--need to add foreign keys

CREATE TABLE LEAGUE(
    Name        VarChar(20)       NOT NULL,
    LeagueID    Int               NOT NULL,
    ManagerID   Int               NOT NULL,
    Max_No_Players  Int           NOT NULL,
    CONSTRAINT League_PK PRIMARY KEY(LeagueID)
    );

CREATE TABLE USER(
    UserID  Int NOT NULL,
    FirstName VarChar(15)   NOT NULL,
    Minit   VarChar(1),
    LastName    VarChar(20) NOT NULL,
    Username    VarChar(20) NOT NULL,
    DOB Date NOT NULL,
    CONSTRAINT UserID_PK PRIMARY KEY(UserID)
    );

CREATE TABLE FANTASY_TEAM(
    LeagueID  Int NOT NULL,
    ManagerID Int   NOT NULL,
    LeagueName  VarChar(20) NOT NULL,
    Max_No_Players  Int NOT NULL,
    CONSTRAINT LeagueID_PK PRIMARY KEY(LeagueID)
    );

CREATE TABLE COLLEGE_PLAYERS(
    PlayerID  Int NOT NULL,
    FirstName VarChar(15)   NOT NULL,
    Minit  VarChar(1),
    LastName  VarChar(20) NOT NULL,
    University VarChar(20) NOT NULL,
    CONSTRAINT PlayerID_PK PRIMARY KEY(PlayerID)
    );

CREATE TABLE Players_on_Team(
    PlayerID    INT NOT NULL,
    TeamID      INT NOT NULL,
    UserID      INT NOT NULL,
    LeagueID    INT NOT NULL,
    University  VarChar(20) NOT NULL,
    CONSTRAINT PT_PK PRIMARY KEY(PlayerID, TeamID, UserID, LeagueID)
    );


CREATE TABLE Match_Up(
    MatchID INT NOT NULL,
    LeagueID INT NOT NULL,
    HomeID  INT NOT NULL,
    AwayID  INT NOT NULL,
    WeekNum INT NOT NULL,
    HomeWon VarChar(20) NOT NULL,
--What is homewon?
    CONSTRAINT MU_PK PRIMARY KEY(MatchID, LeagueID, HomeID, AwayID)
    );
    
    
    