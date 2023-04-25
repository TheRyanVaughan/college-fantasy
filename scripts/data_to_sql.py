import json

data = json.load(open('playerdata.json', 'r'))

def get_info(player):
    player = player.replace("'", "")
    player = player.replace("&", "")
    s = player.split(' ')
    first = s[0]
    last = s[1][:-1]
    
    uni = player.split(',')[1].strip()[:20]
    return (first, last, uni)

def to_insert(id, first, last, uni):
    return f"INSERT INTO COLLEGE_PLAYERS(PlayerID, FirstName, LastName, University) VALUES ({id}, '{first}', '{last}', '{uni}');"

with open('playerInserts.sql', 'w') as file:
    for i, v in enumerate(data):
        first, last, uni = get_info(v['Player'])
        file.write(to_insert(i, first, last, uni))
        file.write('\n')


