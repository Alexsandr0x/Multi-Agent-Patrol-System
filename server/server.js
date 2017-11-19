var express    = require('express');        // call express
var app        = express();                 // define our app using express
var bodyParser = require('body-parser');
var Map		   = require('./lib/Map.js')

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var port = process.env.PORT || 80;

var router = express.Router();

var map = new Map('plain_map.csv');

router.get('/random_location', function(req, res) {
    res.json(map.getRandomLocation());
});

router.get('/neighbours', function(req, res) {
    let x = parseInt(req.param('x'));
    let y = parseInt(req.param('y'));
    res.json(map.getNeighbours(x, y));
});

app.use('/api', router);

app.listen(port);


setInterval(function () {
    if(map)
        map.decayMapPhero(-0.5)
}, 1000);
