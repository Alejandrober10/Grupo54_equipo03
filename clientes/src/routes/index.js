const express = require('express');
const router= express.Router();

const Cliente = require('../models/cliente');//me traigo el moedlo cliente y lo almaceno

router.get('/', async (req, res) => { //cuando me pidan una solicitud muestrame el mensaje
const clientes = await Cliente.find();//me traes los datos desde la bd 
  console.log(clientes);  //muestrame lo lamacenado en clientes
res.render('index', {
    clientes //traeme el arreglo 
}); //traeme el index.ejs
});


router.post('/agregarcliente' , async (req, res) => { //recibeme los datos del formulario
//console.log(new Cliente(req.body)); //aqui me almacena en mongodb los datos de mi tabla cliente 
//console.log(req.body);
const cliente = new Cliente(req.body);///aqui me almacena en mongodb los datos de mi tabla cliente 
await cliente.save(); //guardame el objeto
res.redirect('/');//llevame a la raiz nuevamente
//async y await  me permite no utilizar promesas para los mensajes de error ni acptacion
});


//para editar 

router.get('/editcliente/:id', async (req, res) => { //recibeme los datos del formulario
    const {id} =  req.params; //nos da los parametros que estamos recibiendo ene ste caso el id para borrar
   const cliente = await Cliente.findById(id); // buscame el id
    res.render('editcliente',{
        cliente
    });
   
  });


router.post('/editcliente/:id', async (req, res) =>{
const {id} = req.params;
await Cliente.findByIdAndUpdate(id, req.body)
res.redirect('/');

});

//para eliminar 

router.get('/eliminarcliente/:id', async (req, res) => { //recibeme los datos del formulario
  const {id} =  req.params; //nos da los parametros que estamos recibiendo ene ste caso el id para borrar
  await  Cliente.remove({_id:id}); //eliminame el id
  res.redirect('/');    
});

module.exports = router;