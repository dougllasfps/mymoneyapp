
const configuration = require('./webpack-defaultconfig')

const {loaders, plugins} = configuration;

module.exports = {
    entry: './src/index.jsx',
    output: {
        path: '../resources/public',
        filename: './appbundle.min.js'
    },
    devServer: {
        port: 8081,
        contentBase: '../resources/public',
    },
    resolve: {
        extensions: ['', '.js', '.jsx'],
        alias: {
            modules: __dirname + '/node_modules',
            jquery: 'modules/admin-lte/plugins/jQuery/jquery-2.2.3.min.js',
            bootstrap: 'modules/admin-lte/bootstrap/js/bootstrap.js'
        }
    },
    plugins: plugins,
    module: { loaders: loaders }
}