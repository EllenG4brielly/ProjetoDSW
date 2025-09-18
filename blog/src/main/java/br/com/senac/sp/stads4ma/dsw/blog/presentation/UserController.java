package br.com.senac.sp.stads4ma.dsw.blog.presentation;

import br.com.senac.sp.stads4ma.dsw.blog.domainmodel.repositories.User;
import br.com.senac.sp.stads4ma.dsw.blog.service.UserService;
import br.com.senac.sp.stads4ma.dsw.blog.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController //Todos os métodos retornam JSON/XML, e não pag HTML
@RequestMapping("/api/users") // rota base do recurso de usuários (boa prática: plural)
public class UserController {

    //injeção de dependência via construtor
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8080/api/users
    @GetMapping //mapeia requisições HTTP GET em /users
    public ResponseEntity<List<User>> findAllUsers() { // sempre retornamos ResponseEntity (não apenas List<User>)
        return ResponseEntity.ok(this.userService.findAll());
    }

    //http://localhost:8080/api/users/1234-12345-1234-12345
    @GetMapping("/{id}")
    public ResponseEntity<User> findAllUsersById(@PathVariable UUID id){
        User user = this.userService.findById(id);
        if( user != null)
            return ResponseEntity.ok(user);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable UUID id){
        if(this.userService.deleteById(id))
            return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }


}
