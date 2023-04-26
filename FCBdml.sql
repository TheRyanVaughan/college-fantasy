----INPUT FOR THE APP_USERS TABLE----
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Rafael', 'B', 'Velasquez', 'rafaelbvelasquez', to_date('2002-06-17', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Caleb', 'X', 'Magoola', 'guccigoola', to_date('2002-08-15', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Ryan', 'Y', 'Vaughan', 'ryanvaughan', to_date('2001-11-27', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Katie', 'Z', 'Kintzel', 'Kkintzell', to_date('2001-12-20', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Jacob', 'A', 'Beaudin', 'jbeaudin', to_date('2001-8-22', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Jack', 'G', 'Ahmed', 'jgahmed', to_date('2002-3-15', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Gabe', 'J', 'Agrama', 'gagrama', to_date('2002-06-07', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Lauren', 'C', 'Ghong', 'lghong', to_date('2002-02-02', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Venkat', 'G', 'Margapuri', 'vkat', to_date('1995-12-12', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Kristin', 'B', 'Obermeyer', 'kobermeyer', to_date('1990-09-10', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Daniel', 'J', 'Joyce', 'djoyce', to_date('1985-03-15', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Frank', 'I', 'Klassner', 'klassnerrrr', to_date('1985-06-03', 'yyyy-mm-dd'));

----INPUT FOR THE LEAGUE TABLE----
INSERT INTO LEAGUE VALUES('Ballers', 100, 1, 6);
INSERT INTO LEAGUE VALUES('Dunkers', 101, 5, 6);
INSERT INTO LEAGUE VALUES('Shootas', 102, 9, 6);


---INPUT FOR FANTASY_TEAM TABLE----
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 1, 100, 'Team Raf', 2, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 2, 100, 'Team Caleb', 2, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 3, 100, 'Team Ryan', 0, 2, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 4, 100, 'Team Katie', 0, 2, 0);

INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 5, 101, 'Team Jacob', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 6, 101, 'Team Jack', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 7, 101, 'Team Gabe', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 8, 101, 'Team Lauren', 1, 1, 0);

INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 9, 102, 'Team Venkat', 2, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 10, 102, 'Team Kristin', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 11, 102, 'Team Dan', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 12, 102, 'Team Klassner', 0, 2, 0);


----INPUTS FOR MATCH_UP TABLE----
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 100, 1, 4, 1, 1);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 100, 2, 3, 1, 1);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 100, 3, 1, 2, 0);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 100, 4, 2, 2, 0);

INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 101, 5, 8, 1, 1);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 101, 6, 7, 1, 1);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 101, 7, 5, 2, 1);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 101, 8, 6, 2, 1);

INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 102, 9, 12, 1, 1);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 102, 10, 11, 1, 0);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 102, 11, 9, 1, 0);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 102, 12, 10, 1, 0);


--DELETE FROM APP_USERS;
--DELETE FROM LEAGUE;

--ALTER SEQUENCE seqUID RESTART;
--ALTER SEQUENCE seqMID RESTART;
--ALTER SEQUENCE seqLID RESTART;
--ALTER SEQUENCE seqTID RESTART;