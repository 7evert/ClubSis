package com.clubsis.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**n
 * Created by Sebastian on 13-Jun-16.
 */

@RestController
@RequestMapping("/api/hola")
public class HolaController {

//    @RequestMapping(value = "/mensaje", method = RequestMethod.GET)
//    public HolaRespuesta hola(Principal principal) {
//        return new HolaRespuesta("Hola " + principal.getName());
//    }

    @RequestMapping(value = "/mensaje", method = RequestMethod.GET)
    public ResponseEntity<HolaRespuesta> hola(Principal principal) {
        return new ResponseEntity<HolaRespuesta>(new HolaRespuesta("Hola " + principal.getName()), HttpStatus.OK);
    }

    public static class HolaRespuesta {
        private String mensaje;

        public HolaRespuesta(String mensaje) {
            this.mensaje = mensaje;
        }

        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }
    }
}
