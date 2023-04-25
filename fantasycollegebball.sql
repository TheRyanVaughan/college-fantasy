CREATE TABLE LEAGUE(
    LeagueName        VarChar(20)       NOT NULL,
    LeagueID    Int               NOT NULL,
    ManagerID   Int               NOT NULL,
    Max_No_Players  Int           NOT NULL,
    CONSTRAINT League_PK PRIMARY KEY(LeagueID)
    );

CREATE TABLE APP_USERS(
    UserID  Int NOT NULL,
    FirstName VarChar(15)   NOT NULL,
    Minit   VarChar(1),
    LastName    VarChar(20) NOT NULL,
    Username    VarChar(20) NOT NULL,
    DOB Date NOT NULL,
    CONSTRAINT UserID_PK PRIMARY KEY(UserID)
    );

CREATE TABLE FANTASY_TEAM(
    TeamID  Int NOT NULL,
    UserID Int   NOT NULL,
    LeagueID  Int NOT NULL,
    TeamName  VarChar(20) NOT NULL,
    Wins Int,
    Losses Int,
    Draws Int,
    CONSTRAINT TID_PK PRIMARY KEY(TeamID, UserID, LeagueID)
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
    CONSTRAINT PT_PK PRIMARY KEY(PlayerID, TeamID, UserID, LeagueID)
    );

CREATE TABLE Match_Up(
    MatchID INT NOT NULL,
    LeagueID INT NOT NULL,
    HomeID  INT NOT NULL,
    AwayID  INT NOT NULL,
    WeekNum INT NOT NULL,
    HomeWon Number(1) NOT NULL,
    CONSTRAINT MU_PK PRIMARY KEY(MatchID, LeagueID, HomeID, AwayID)
    );
    
ALTER TABLE LEAGUE
ADD CONSTRAINT FK_MID
FOREIGN KEY (ManagerID) references APP_USERS(UserID);


ALTER TABLE FANTASY_TEAM
ADD CONSTRAINT UID_FK
FOREIGN KEY (UserID) references APP_USERS(UserID);
ALTER TABLE FANTASY_TEAM
ADD CONSTRAINT LID_FK
FOREIGN KEY (LeagueID) references League(LeagueID);

ALTER TABLE Players_on_Team
ADD CONSTRAINT PID_FK
FOREIGN KEY (PlayerID) references COLLEGE_PLAYERS(PlayerID);
ALTER TABLE Players_on_Team
ADD CONSTRAINT TID_FK
FOREIGN KEY (TeamID) references FANTASY_TEAM(TeamID);
ALTER TABLE Players_on_Team
ADD CONSTRAINT UID_FK
FOREIGN KEY (UserID) references APP_USERS(UserrID);
ALTER TABLE Players_on_Team
ADD CONSTRAINT LID_FK
FOREIGN KEY (LeagueID) references LEAGUE(LeagueID);

ALTER TABLE Match_Up
ADD CONSTRAINT LID_FK
FOREIGN KEY (LeagueID) references League(LeagueID);
ALTER TABLE Match_Up
ADD CONSTRAINT HID_FK
FOREIGN KEY (HomeID) references FANTASY_TEAM(TeamID);
ALTER TABLE Match_Up
ADD CONSTRAINT AID_FK
FOREIGN KEY (AwayID) references FANTASY_TEAM(TeamID);


DROP TABLE LEAGUE;
DROP TABLE APP_USERS;
DROP TABLE FANTASY_TEAM;
DROP TABLE COLLEGE_PLAYERS;
DROP TABLE Players_on_Team;
DROP TABLE Match_Up;