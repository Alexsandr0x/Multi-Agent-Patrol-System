const fs = require('fs');

var rawMap = [];
var availableNodes = [];
var maxPhero;

module.exports = class Map {
	constructor(file_name, phero) {
		this.file_path = __dirname + '/maps/' + file_name;
		maxPhero = phero;
        let fileData = fs.readFileSync(this.file_path, 'utf-8');
        rawMap = fileData.toString().split('\n');

        rawMap.map(function(item) {
            return item.toString().split(',');
        });

        rawMap.forEach(function (item, i) {
            rawMap[i] = item.split(',').map(Number);
            rawMap[i].forEach(function (node, j) {
                if(node != -1){
                    availableNodes.push({x: j, y: i})
                }
            })
        });
    }


    applyPhero(x, y, phero) {
        rawMap[y][x] = phero;
    }

    decayMapPhero(phero) {
        rawMap.forEach(function(row, y) {
            row.forEach(function (item, x) {
                if (rawMap[y][x] == -1) {
                } else if (rawMap[y][x] + phero < 0) {
                    rawMap[y][x] = 0
                } else {
                    rawMap[y][x] += phero
                }
            });
        });
    };

	getMap() {return rawMap}

	getNeighbours(x, y) {
	    let _response = {};
	    if(y != 0) _response.up = {phero: rawMap[y - 1][x], x: x, y: y - 1};
	    if(y < rawMap.length - 1) _response.down = {phero: rawMap[y + 1][x], x: x, y: y + 1};
	    if(x != 0) _response.left = {phero: rawMap[y][x - 1], x: x-1, y: y};
        if(x < rawMap[0].length - 1) _response.right = {phero: rawMap[y][x + 1], x: x + 1, y: y};
        return _response
    }

	getRandomLocation() {
        return availableNodes[Math.floor(Math.random() * availableNodes.length)];
    }
};