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
        // SERVICE_URL : JSON.stringify('http://localhost:8080')
    }
}

//plugins
const definePlugin = new webpack.DefinePlugin(environment)
const extractTextPlugin = new ExtractTextPlugin('app.css')
const uglifyJsPlugin = new webpack.optimize.UglifyJsPlugin()
const providePlugin = new webpack.ProvidePlugin({ $: 'jquery', jQuery: 'jquery', 'window.jQuery': 'jquery'})

const plugins = [ providePlugin, extractTextPlugin, uglifyJsPlugin, definePlugin ]


module.exports = {
    loaders : loaders,
    plugins: plugins,
    environment: environment
}