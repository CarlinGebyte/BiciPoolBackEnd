/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.bicipool.service;

import com.usa.bicipool.model.User;
import com.usa.bicipool.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Luis Baquero
 * @version 1.0
 */
@Service
/**
 * Clase ServiciosUser
 */
public class ServiciosUser {

    private UserRepository metodCrud;

    public ServiciosUser(UserRepository metodCrud) {
        this.metodCrud = metodCrud;
    }

    public List<User> getAll() {
        return metodCrud.getAll();

    }

    public Optional<User> getUser(int id) {
        return metodCrud.getUser(id);
    }

    public User save(User user) {
        if (user.getIddocument() == null) {
            return metodCrud.save(user);
        } else {
            Optional<User> example = metodCrud.getUser(user.getIddocument());
            if (example.isEmpty()) {
                return metodCrud.save(user);
            } else {
                return user;
            }
        }
    }

    public User update(User user) {
        if (user.getIddocument() != null) {
            Optional<User> emp = metodCrud.getUser(user.getIddocument());
            if (emp.isPresent()) {
                if (user.getIddocument() != null) {
                    emp.get().setIddocument(user.getIddocument());
                }
                if (user.getTipodocumento() != null) {
                    emp.get().setTipodocumento(user.getTipodocumento());
                }
                if (user.getApellidouno() != null) {
                    emp.get().setApellidouno(user.getApellidouno());
                }
                if (user.getApellidodos() != null) {
                    emp.get().setApellidodos(user.getApellidodos());
                }
                if (user.getAge() != null) {
                    emp.get().setAge(user.getAge());
                }
                if (user.getAddress() != null) {
                    emp.get().setAddress(user.getAddress());
                }
                if (user.getGender() != null) {
                    emp.get().setGender(user.getGender());
                }
                if (user.getCity() != null) {
                    emp.get().setCity(user.getCity());
                }
                if (user.getEmail() != null) {
                    emp.get().setEmail(user.getEmail());
                }
                if (user.getTelefonouno() != null) {
                    emp.get().setTelefonouno(user.getTelefonouno());
                }
                if (user.getTelefonodos() != null) {
                    emp.get().setTelefonodos(user.getTelefonodos());
                }
                if (user.getFacebook() != null) {
                    emp.get().setFacebook(user.getFacebook());
                }
                if (user.getInstagram() != null) {
                    emp.get().setInstagram(user.getInstagram());
                }
                if (user.getTiposangre() != null) {
                    emp.get().setTiposangre(user.getTiposangre());
                }
                if (user.getPassword() != null) {
                    emp.get().setPassword(user.getPassword());
                }
                if (user.getBirthdate() != null) {
                    emp.get().setBirthdate(user.getBirthdate());
                }
                if (user.getReservations() != null) {
                    emp.get().setReservations(user.getReservations());
                }
                if (user.getFavorites() != null) {
                    emp.get().setFavorites(user.getFavorites());
                }
            }
            metodCrud.save(emp.get());
            return emp.get();
        } else {
            return user;
        }
    }

    public boolean deleteUser(int id) {
        Boolean aBoolean = getUser(id).map(user -> {
            metodCrud.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
