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
    }


    applyPhero(x, y, phero) {
        if (rawMap[y][x] == -1) {
            return null
        } else if (rawMap[y][x] - phero < 0) {
            rawMap[y][x] = 0
        } else {
            rawMap[y][x] += phero
        }
    }

    decayMapPhero(phero) {
        rawMap.forEach(function(row, y) {
            row.forEach(function (item, x) {
                if (rawMap[y][x] == -1) {
                    return null
                } else if (rawMap[y][x] - phero < 0) {
                    rawMap[y][x] = 0
                } else {
                    rawMap[y][x] += phero
                }
            });
        });
    };

	getNeighbours(x, y) {
	    let _response = {};
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