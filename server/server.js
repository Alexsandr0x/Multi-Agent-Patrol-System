var express    = require('express');        // call express
var app        = express();                 // define our app using express
var bodyParser = require('body-parser');
var Map		   = require('./lib/Map.js');
var path       = require("path");


app.use(bodyParser.urlencoded({ extended: true }));
// app.use(bodyParser.json());

const MAX_PHERO = 800;
const PHERO_DECAY = -MAX_PHERO * 0.005;

var port = process.env.PORT || 80;

var router = express.Router();

var map = new Map('plain_map.csv', MAX_PHERO);

router.get('/random_location', function(req, res) {
    res.json(map.getRandomLocation());
});

router.get('/neighbours', function(req, res) {
    let x = parseInt(req.param('x'));
    let y = parseInt(req.param('y'));
    res.json(map.getNeighbours(x, y));
});

router.get('/drop_phero', function(req, res) {
    let x = parseInt(req.param('x'));
    let y = parseInt(req.param('y'));
    map.applyPhero(x, y, MAX_PHERO);
    res.json({status: 'OK'});
});

router.get('/get_map', function(req, res) {
    res.json(map.getMap());
});

app.use('/api', router);

app.get('/', function (req, res) {
    res.sendfile(path.join(__dirname + '/index.html'))
});


app.listen(port);


setInterval(function () {
    if(map)
        map.decayMapPhero(PHERO_DECAY);

}, 100);
