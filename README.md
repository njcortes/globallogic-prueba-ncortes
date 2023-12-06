# Evaluación JAVA Global Logic

Aplicación que expone una API de creación de usuarios e inicio de sesión.
## Instalación

Posicionarse en alguna ruta dentro del equipo y ejecutar el siguiente comando

```bash
git clone https://github.com/njcortes/globallogic-prueba-ncortes.git
```

## Diagrama
<p>
  <img src="./images/secuencia1.png">
</p>

## Diagrama Secuencia SignUp
<p>
  <img src="./images/secuencia_signup.png">
</p>

## Diagrama Secuencia Login
<p>
  <img src="./images/secuencia_login.png">
</p>

## Modo de Uso Postman

Primero se debe realizar la peticion POST "SignUp" con los datos de la imagen para obtener el token, y luego configurar el postman para realizar las llamadas correspondientes.

## Ejecución Sign-up
<p>
  <img src="./images/postman_signup.png">
</p>

## Ingreso de Token
<p>
  <img src="./images/postman_token.png">
</p>

## Ejecución Login
<p>
  <img src="./images/postman_login.png">
</p>



## Request Sign-Up
```json
{
    "name": "nestor",
    "email": "nj0588@gmail.com",
    "password": "pwcvmklM13",
    "phone": [
        {
            "number": "987483212",
            "citycode": "32",
            "contrycode": "56"
        },
        {
            "number": "757899111",
            "citycode": "12",
            "contrycode": "52"
        }
    ]
}
```

## Response Sign-Up
```json
{
    "id": "991af747-cb48-3b4b-8c51-d04e0eabab11",
    "created": "2023-12-05T19:35:15.929575",
    "lastLogin": null,
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJHTE9CQUxMT0dJQ19KV1QiLCJzdWIiOiJuajA1ODhAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTcwMTgxNTcxNiwiZXhwIjoxNzAxOTAyMTE2fQ.GS90KvG1ptAJLxWTJXp_GwMae4sTIxUC2xJ-Yr65srCM6aiEz5ZHpznfuMk_yhEnYkoqua96w-hPcbm6yIpfXQ",
    "isactive": true,
    "name": "nestor",
    "email": "nj0588@gmail.com"
}
```

## Request Login 

```json
{
    "id": "991af747-cb48-3b4b-8c51-d04e0eabab11"
}
```

## Response Login
```json
{
    "id": "991af747-cb48-3b4b-8c51-d04e0eabab11",
    "created": "2023-12-05T19:35:15.929575",
    "lastLogin": "2023-12-05T19:36:23.065734",
    "token": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJHTE9CQUxMT0dJQ19KV1QiLCJzdWIiOiJuajA1ODhAZ21haWwuY29tIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9VU0VSIl0sImlhdCI6MTcwMTgxNTcxNiwiZXhwIjoxNzAxOTAyMTE2fQ.GS90KvG1ptAJLxWTJXp_GwMae4sTIxUC2xJ-Yr65srCM6aiEz5ZHpznfuMk_yhEnYkoqua96w-hPcbm6yIpfXQ",
    "isactive": true,
    "name": "nestor",
    "email": "nj0588@gmail.com",
    "password": "pwcvmklM13",
    "phones": [
        {
            "number": "757899111",
            "citycode": "12",
            "contrycode": "52"
        },
        {
            "number": "987483212",
            "citycode": "32",
            "contrycode": "56"
        }
    ]
}
```

## Anexos
Para que la contraseña sea aceptada, debe seguir la siguiente expresion regular configurada en archivo de propiedades:

```bash
(?=.*\d)        # almenos un digito
(?=.*[a-z])     # al menos una letra minuscula
(?=.*[A-Z])     # al menos una letra mayuscula
.{8,12}          # 8-12 caracteres de largo
```

Para que el email sea aceptado, debe seguir la siguiente expresion regular configurada en archivo de propiedades:

```bash
[A-Za-z0-9+_.-]      # nombre de la cuenta
+@                   # arroba
(.+)$                # punto mas dominio de libre ingreso
````