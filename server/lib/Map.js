const fs = require('fs');

var rawMap = [];
var availableNodes = [];

module.exports = class Map {
	constructor(file_name) {
		this.file_path = __dirname + '/maps/' + file_name;
        let fileData = fs.readFileSync(this.file_path, 'utf-8');
        rawMap = fileData.toString().split('\n');

        rawMap.map(function(item) {
            return item.toString().split(',');
        });

        rawMap.forEach(function (item, i) {
            rawMap[i] = item.split(',').map(Number);
            rawMap[i].forEach(function (node, j) {
                if(node != -1){
                    availableNodes.push({x: i, y: j})
                }
            })
        });

        console.log(rawMap);
	}

	applyPhero(x, y, phero) {
	    if (rawMap[x][y] == -1) {
	        return null
        } else if (rawMap[x][y] - phero < 0) {
            rawMap[x][y] = 0
        } else {
            rawMap[x][y] += phero
        }
    }

    decayMapPhero(phero_decay) {
        rawMap.forEach(function(row, x) {
            row.forEach(function (item, y) {
                applyPhero(x, y, phero_decay)
            });
        });
    };

	getNeighbours(x, y) {
	    let _response = {};
	    console.log(rawMap.length, rawMap[0].length);
	    if(y != 0) _response.up = rawMap[y - 1][x];
	    if(y < rawMap.length - 1) _response.down = rawMap[y + 1][x];
	    if(x != 0) _response.left = rawMap[y][x - 1];
        if(x < rawMap[0].length - 1) _response.right = rawMap[y][x + 1];
        return _response
    }

	getRandomLocation() {
        return availableNodes[Math.floor(Math.random() * availableNodes.length)];
    }
};