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
	    if(x != 0) _response.up= rawMap[x][y - 1];
	    if(x < rawMap[0].length) _response.up= rawMap[x][y + 1];
	    if(y !=0) _response.left = rawMap[x - 1][y];
        if(y < rawMap.length) _response.right = rawMap[x + 1][y];
        return _response
    }

	getRandomLocation() {
        return availableNodes[Math.floor(Math.random() * availableNodes.length)];
    }
};