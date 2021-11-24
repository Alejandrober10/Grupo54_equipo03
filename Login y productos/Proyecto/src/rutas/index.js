//Almacena las rutas principales, como mi controller
const express = require('express');
const router = express.Router();

const passport = require('passport');
const csvModelo = require('../models/csv');
const multer = require('multer');
const csv = require('csvtojson');

//Ruta inicial 
router.get('/', (req,res,next) => {
    res.render('index');
});

//Registrarse
router.get('/singup', (req, res, next) => {
    res.render('registrar');
});

//Para escuchar y recibir los datos que ingresa el usuario al registrarse en la ruta de arriba
router.post('/singup', passport.authenticate('local-singup',{
    successRedirect: '/inicio', 
    failureRedirect: '/singup',
    passReqToCallback: true
}));

//Ingresar
router.get('/singin', (req, res, next) => {
    res.render('ingresar');

});

//Escucha datos, para validar
router.post('/singin', passport.authenticate('local-singin', {
    successRedirect: "/inicio",
    failureRedirect: "/singin",
    passReqToCallback: true
}));

//salir
router.get('/logout',(req, res, next)=>{
    req.logout();
    res.render('index');
})

/*
//Página de inicio luego de autenticarse
router.get('/inicio', isAuthenticated, (req, res, next) => {
    res.render('inicio');
});*/

// para que no pueda ir a inicio sin logear
function isAuthenticated(req, res, next){
    if(req.isAuthenticated()){
        return next();
    }res.redirect('/singin');
};

router. use((req, res, next) => {
    isAuthenticated(req, res, next);
    next();
});

//Página de inicio luego de autenticarse
router.get('/inicio', (req, res, next) => {
    res.render('inicio');
});


//Para el csv
router.get('/productos', (req, res, next) =>{
    /*csvModelo.find((err, data)=>{
        if(err){
            console.log(err);
        }else{
            if(data!=''){
                res.render('productos',{data:data});
            }else{
                res.render('productos',{data:''});
            }
        }
    });*/
    res.render('productos');
});

const storage = multer.diskStorage({
    destination:(req, file, cb)=>{
        cb(null, './public/uploads');
    },
    filename: (req, file, cb)=>{
        cb(null, file.originalname);
    }
});
const uploads = multer({storage: storage});
//pasar csv a jsonArray
router.post('/productos', uploads.single('csv'),(req,res)=>{  
   csv()
   .fromFile(req.file.path)
   .then((jsonObj)=>{
       console.log(jsonObj);
       for(var x=0;x<jsonObj;x++){
            temp = parseFloat(jsonObj[x].codigo_producto)
            jsonObj[x].codigo_producto = temp;
            temp = parseFloat(jsonObj[x].nitproveedor)
            jsonObj[x].nitproveedor = temp;
            temp = parseFloat(jsonObj[x].precio_compra)
            jsonObj[x].precio_compra = temp;
            temp = parseFloat(jsonObj[x].ivacompra)
            jsonObj[x].ivacompra = temp;
            temp = parseFloat(jsonObj[x].precio_venta)
            jsonObj[x].precio_venta = temp;
        }
        csvModelo.insertMany(jsonObj,(err,data)=>{
               if(err){
                   console.log(err);
               }else{
                   res.redirect('/');
               }
        });
      });
   });

//Para usar las rutas en otros archivos la exportamos
module.exports = router;

