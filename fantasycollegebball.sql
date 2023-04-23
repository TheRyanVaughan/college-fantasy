CREATE TABLE LEAGUE(
    LeagueName        VarChar(20)       NOT NULL,
    LeagueID    Int               NOT NULL,
    ManagerID   Int               NOT NULL,
    Max_No_Players  Int           NOT NULL,
    CONSTRAINT League_PK PRIMARY KEY(LeagueID),
    CONSTRAINT MID_FK FOREIGN KEY (ManagerID) references User(UserID)
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
    TeamID  Int NOT NULL,
    UserID Int   NOT NULL,
    LeagueID  Int NOT NULL,
    TeamName  VarChar(20) NOT NULL,
    Wins Int,
    Losses Int,
    Draws Int,
    CONSTRAINT TID_PK PRIMARY KEY(TeamID, UserID, LeagueID),
    CONSTRAINT UID_FK FOREIGN KEY (UserID) references User(UserID),
    CONSTRAINT LID_FK FOREIGN KEY (LeagueID) references League(LeagueID)
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
    CONSTRAINT PT_PK PRIMARY KEY(PlayerID, TeamID, UserID, LeagueID),
    CONSTRAINT PID_FK FOREIGN KEY (PlayerID) references COLLEGE_PLAYERS(PlayerID),
    CONSTRAINT TID_FK FOREIGN KEY (TearmID) references FANTASY_TEAM(TeamID),
    CONSTRAINT UID_FK FOREIGN KEY (UserID) references USER(UserID),
    CONSTRAINT LID_FK FOREIGN KEY (LeagueID) references LEAGUE(LeagueID)
    );

CREATE TABLE Match_Up(
    MatchID INT NOT NULL,
    LeagueID INT NOT NULL,
    HomeID  INT NOT NULL,
    AwayID  INT NOT NULL,
    WeekNum INT NOT NULL,
    HomeWon Boolean NOT NULL,
    CONSTRAINT MU_PK PRIMARY KEY(MatchID, LeagueID, HomeID, AwayID),
    CONSTRAINT LID_FK FOREIGN KEY (LeagueID) references League(LeagueID),
    CONSTRAINT HID_FK FOREIGN KEY (HomeID) references Team(TeamID),
    CONSTRAINT AID_FK FOREIGN KEY (AwayID) references Team(TeamID)
    );
    
    
    