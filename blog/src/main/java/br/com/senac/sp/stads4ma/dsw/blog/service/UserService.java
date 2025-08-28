package br.com.senac.sp.stads4ma.dsw.blog.service;

import br.com.senac.sp.stads4ma.dsw.blog.domainmodel.repositories.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
