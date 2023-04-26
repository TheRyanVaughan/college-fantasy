----INPUT FOR THE APP_USERS TABLE----
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Rafael', 'B', 'Velasquez', 'rafaelbvelasquez', to_date('2002-06-17', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Caleb', 'X', 'Magoola', 'guccigoola', to_date('2002-08-15', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Ryan', 'Y', 'Vaughan', 'ryanvaughan', to_date('2001-07-11', 'yyyy-mm-dd'));
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
    'Dillon', 'P', 'Ryan', 'dryan', to_date('2002-08-07', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Emily', 'J', 'McFadden', 'emcfadden', to_date('2002-04-26', 'yyyy-mm-dd'));
    
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Venkat', 'G', 'Margapuri', 'vkat', to_date('1995-12-12', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Kristin', 'B', 'Obermeyer', 'kobermeyer', to_date('1990-09-10', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Daniel', 'J', 'Joyce', 'djoyce', to_date('1985-03-15', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(seqUID.nextVal, 
    'Frank', 'I', 'Klassner', 'klassnerrrr', to_date('1985-06-03', 'yyyy-mm-dd'));


----INPUT FOR THE LEAGUE TABLE----
INSERT INTO LEAGUE VALUES('Ballers', seqLID.nextVal, 1, 6);
INSERT INTO LEAGUE VALUES('Dunkers', seqLID.nextVal, 5, 6);
INSERT INTO LEAGUE VALUES('Champions', seqLID.nextVal, 11, 6);


---INPUT FOR FANTASY_TEAM TABLE----
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 1, 1, 'Team Raf', 2, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 2, 1, 'Team Caleb', 2, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 3, 1, 'Team Ryan', 0, 2, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 4, 1, 'Team Katie', 0, 2, 0);

INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 5, 2, 'Team Jacob', 1, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 6, 2, 'Team Jack', 0, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 7, 2, 'Team Gabe', 0, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 8, 2, 'Team Lauren', 1, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 9, 2, 'Team Dillon', 1, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 10, 2, 'Team Emily', 0, 1, 0);

INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 11, 3, 'Team Venkat', 2, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 12, 3, 'Team Kristin', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 13, 3, 'Team Dan', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(seqTID.nextVal, 14, 3, 'Team Klassner', 0, 2, 0);


----INPUTS FOR MATCH_UP TABLE----
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 1, 1, 4, 1, 1);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 1, 2, 3, 1, 1);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 1, 3, 1, 2, 0);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 1, 4, 2, 2, 0);

INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 2, 5, 6, 1, 1);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 2, 7, 8, 1, 0);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 2, 9, 10, 1, 1);

INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 3, 11, 14, 1, 1);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 3, 12, 13, 1, 0);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 3, 13, 11, 2, 0);
INSERT INTO MATCH_UP VALUES(seqMID.nextVal, 3, 14, 12, 2, 0);
