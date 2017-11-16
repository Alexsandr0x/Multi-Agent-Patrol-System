const fs = require('fs')

module.exports = class Map {

	constructor(file_name) {
		this.file_path = __dirname + '/maps/' + file_name
		this.map = []
		let raw_map = []
		this.map = fs.readFile(this.file_path, function (err, fileData) {
			let map = fileData.toString().split('\n');
			map = raw_map.map(function(item) {
				return item.toString().split(',').map(function(item) {
					return {'phero': item}
				});
			});
			return map
		});
		console.log(this.map);
		// this.width = this.map.length;
		// console.log(this.width)
		//this.height = this.map[0].length;
	}
}