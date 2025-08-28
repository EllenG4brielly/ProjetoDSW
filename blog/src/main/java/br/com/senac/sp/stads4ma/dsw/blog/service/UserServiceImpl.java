package br.com.senac.sp.stads4ma.dsw.blog.service;

import br.com.senac.sp.stads4ma.dsw.blog.domainmodel.repositories.User;
import br.com.senac.sp.stads4ma.dsw.blog.domainmodel.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    //injeção de dependencia(simulando o BD)
    private final UserRepository userRepository; //"final" garante que não será modificado e será injetado pelo construtor

    @Override
    public List<User> findAll() {

        List<User> resultset = new ArrayList<>();

        resultset.addAll(this.userRepository.findAll());//Adiciona todos os usuários retornados pelo repositório na lista
        return resultset;

    }
}
