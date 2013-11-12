<%-- 
    Document   : cambiarEstado
    Created on : 5/11/2013, 08:37:41 AM
    Author     : 201
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/libs/jquery-1.9.0/jquery.min.js"></script>
        <script src="js/libs/jquery-validate-1.10.0/jquery.validate.min.js"></script>
        <style>
            .error{
                color: red;
                
            }
            input.error{
                background-color: crimson;
            }
        </style>
    </head>
    <body>
        <form id="form1" name="formulario" method="post" action="CEstado1?a=guardar"> 
            <center>
                Buscar: <input type="text" name="buscar"><br>
            <p>Estado del documento</p><br>
            <input type="radio" name="Nuevoestado" value="perdido" />Pérdido<br>
            <input type="radio" name="Nuevoestado" value="Encontrado"/>Encontrado<br>
            <input type="submit" value="Actualizar" name="Actualizar"/>
            </center>
        </form>
        <script>
             $("#form1").validate(                
        {
    errorLabelContainer:"#messagebox",
    wrapper:"li",
         rules:
                 {
                  Nuevoestado:
             {
         required: true
             
            },
          buscar:{
              required:true
          },  
                      
        },
        messages:
                         {
                     Nuevoestado:{
                         required: "por favor seleccione el nuevo estado",               
            },
            buscar:{
                required: "por favor indique que documento va a actualizar",
            }
                     }                         
                         }
           );          
        </script>
    </body>
</html>
