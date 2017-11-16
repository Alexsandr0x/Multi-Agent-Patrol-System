var express    = require('express');        // call express
var app        = express();                 // define our app using express
var bodyParser = require('body-parser');
var map		   = require('./lib/Map.js')	 

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var port = process.env.PORT || 80;

var router = express.Router();

var map = new map('plain_map.csv');

router.get('/random_location', function(req, res) {
    res.json({ message: 'hooray! welcome to our api!' });   
});

router.get('/neighbours', function(req, res) {
    res.json({ message: 'hooray! welcome to our api!' });   
});

router.get('/', function(req, res) {
    res.json({ message: 'hooray! welcome to our api!' });   
});

app.use('/api', router);

app.listen(port);
console.log('Magic happens on port ' + port);
