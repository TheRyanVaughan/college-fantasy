-- INPUT FOR THE LEAGUE TABLE
INSERT INTO LEAGUE VALUES('Ballers', 100, 1, 6);
INSERT INTO LEAGUE VALUES('Dunkers', 101, 5, 6);
INSERT INTO LEAGUE VALUES('Shootas', 102, 9, 6);


-- INPUT FOR THE APP_USERS TABLE
INSERT INTO APP_USERS VALUES(1, 
    'Rafael', 'B', 'Velasquez', 'rafaelbvelasquez', to_date('2002-06-17', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(2, 
    'Caleb', 'X', 'Magoola', 'guccigoola', to_date('2002--', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(3, 
    'Ryan', 'Y', 'Vaughan', 'ryanvaughan', to_date('2002--', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(4, 
    'Katie', 'Z', 'Kintzel;', 'Kkintzell', to_date('2001-12-20', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(5, 
    'Jacob', 'A', 'Beaudin;', 'jbeaudin', to_date('2001-8-22', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(6, 
    'Jack', 'G', 'Ahmed;', 'jgahmed', to_date('2002-3-15', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(7, 
    'Gabe', 'J', 'Agrama;', 'gagrama', to_date('2002-06-07', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(8, 
    'Lauren', 'C', 'Ghong;', 'lghong', to_date('2002-02-02', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(9, 
    'Venkat', 'G', 'Margapuri;', 'vkat', to_date('1995-12-12', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(10, 
    'Kristin', 'B', 'Obermeyer;', 'kobermeyer', to_date('1990-09-10', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(11, 
    'Daniel', 'J', 'Joyce;', 'djoyce', to_date('1985-03-15', 'yyyy-mm-dd'));
INSERT INTO APP_USERS VALUES(10, 
    'Frank', 'I', 'Klassner;', 'klassnerrrr', to_date('1985-06-03', 'yyyy-mm-dd'));
    

--INPUT FOR FANTASY_TEAM TABLE
INSERT INTO FANTASY_TEAM VALUES(1, 1, 100, 'Team Raf', 2, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(2, 2, 100, 'Team Caleb', 2, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(3, 3, 100, 'Team Ryan', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(4, 4, 100, 'Team Katie', 1, 1, 0);

INSERT INTO FANTASY_TEAM VALUES(5, 5, 101, 'Team Jacob', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(6, 6, 101, 'Team Jack', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(7, 7, 101, 'Team Gabe', 1, 1, 0);
INSERT INTO FANTASY_TEAM VALUES(8, 8, 101, 'Team Lauren', 1, 1, 0);

INSERT INTO FANTASY_TEAM VALUES(9, 9, 102, 'Team Venkat', 2, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(10, 10, 102, 'Team Kristin', 2, 0, 0);
INSERT INTO FANTASY_TEAM VALUES(11, 11, 102, 'Team Dan', 0, 2, 0);
INSERT INTO FANTASY_TEAM VALUES(12, 12, 102, 'Team Klassner', 0, 2, 0);
