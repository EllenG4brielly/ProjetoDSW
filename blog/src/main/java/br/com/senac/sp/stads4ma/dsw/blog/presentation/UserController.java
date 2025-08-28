package br.com.senac.sp.stads4ma.dsw.blog.presentation;

import br.com.senac.sp.stads4ma.dsw.blog.domainmodel.repositories.User;
import br.com.senac.sp.stads4ma.dsw.blog.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Todos os métodos retornam JSON/XML, e não pag HTML
@RequestMapping("/users") // rota base do recurso de usuários (boa prática: plural)
public class UserController {

    //injeção de dependência via construtor
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping //mapeia requisições HTTP GET em /users
    public ResponseEntity<List<User>> findAllUsers (){ // sempre retornamos ResponseEntity (não apenas List<User>)
        return ResponseEntity.ok(this.userService.findAll());
    }
}
