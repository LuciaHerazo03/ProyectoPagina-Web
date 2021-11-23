/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoReto3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lucia Herazo
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorMensaje {
    
    @Autowired
    private ServiciosMensaje servicio;
    @GetMapping("/all")
    public List<Mensaje> getMessages(){
        return servicio.getAll();
    }
    
    @GetMapping("/(id)")
    public Optional<Mensaje> getMesaage(@PathVariable("id") int messageId) {
        return servicio.getMessage(messageId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje save(@RequestBody Mensaje message) {
        return servicio.save(message);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje update(@RequestBody Mensaje message) {
        return servicio.update(message);
    }
     
    @DeleteMapping("/(id)")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delate(@PathVariable("id") int messageId) {
        return servicio.deleteMessage(messageId);
    
    }
}