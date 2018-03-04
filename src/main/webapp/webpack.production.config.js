const webpack = require('webpack')
const ExtractTextPlugin = require('extract-text-webpack-plugin')

//loaders
const babelLoader ={
    test: /.js[x]?$/,
    loader: 'babel-loader',
    exclude: /node_modules/,
    query: {
        presets: ['es2015', 'react'],
        plugins: ['transform-object-rest-spread']
    }
}

const extractTextPluginLoaders =  {
    test: /\.css$/,
    loader: ExtractTextPlugin.extract('style-loader', 'css-loader')
}

const fileLoader = {
    test: /\.woff|.woff2|.ttf|.eot|.svg|.png|.jpg*.*$/,
    loader: 'file'
}

const loaders = [ babelLoader, extractTextPluginLoaders, fileLoader ]

//enviroment
const environment = {
    'process.env':{
        NODE_ENV : JSON.stringify('production'),
        SERVICE_URL : JSON.stringify('https://mymoneyapp.herokuapp.com')
    }
}

//plugins
const definePlugin = new webpack.DefinePlugin(environment)
const extractTextPlugin = new ExtractTextPlugin('app.css')
const uglifyJsPlugin = new webpack.optimize.UglifyJsPlugin()
const providePlugin = new webpack.ProvidePlugin({ $: 'jquery', jQuery: 'jquery', 'window.jQuery': 'jquery'})

const plugins = [ providePlugin, extractTextPlugin, uglifyJsPlugin, definePlugin ]

module.exports = {
    entry: './src/index.jsx',
    output: {
        path: '../resources/public',
        filename: './appbundle.js'
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