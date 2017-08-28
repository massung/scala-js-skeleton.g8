let webpack = require('webpack');

// load the auto-generated webpack config file
module.exports = require('./scalajs.webpack.config');

// modify the output directory where the bundle.js file is written
module.exports.output = {
    'filename': '$name;format="Camel"$-bundle.js',
    'path': '../../../../web/js',
};
