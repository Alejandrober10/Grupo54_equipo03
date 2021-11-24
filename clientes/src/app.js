const path = require('path');
const express = require('express');
const morgan = require('morgan'); //muestra datos por consulta
const mongoose = require('mongoose');

const app = express();//inicializar express

//conectar base de datos 
mongoose.connect('mongodb://localhost/tienda')
.then(db => console.log('database conectada')) //promesa si conecta muestrame este mensaje
.catch(err => console.log(err));//si no conecta muestrame este error
//importar rutas (routes)
const indexRoutes = require('./routes/index'); //traemos las rutas


//configuraciones
app.set('port',process.env.PORT || 3000); //definimos la variable port 
app.set('views',path.join(__dirname, 'views')); //ubica las vistas
app.set('view engine','ejs');//motor de plantillas ejs view engine


//middlewares funcion antes de legar a las rutas en
app.use(morgan('dev'));//sirve para ver el mensaje corto 
app.use(express.urlencoded({extended:false})); //se encrga de entendr los datos que envia un html

//rutas 

app.use('/' , indexRoutes);


//iniciando el servidor
app.listen(3000, () => { //puerto del servidor 

console.log(`servidor en puerto ${app.get('port')}`);

});