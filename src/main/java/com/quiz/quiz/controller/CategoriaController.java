package com.quiz.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.quiz.quiz.entity.Categoria;
import com.quiz.quiz.service.CategoriaServicio;

import jakarta.validation.Valid;

@Controller
public class CategoriaController {
    
    @Autowired
    private CategoriaServicio servicio;

    @GetMapping({"/categorias", "/", ""})
    public String listarCategorias(Model modelo) {
        modelo.addAttribute("categorias", servicio.listarTodasLasCategorias());
        return "index";
    }

    @GetMapping("/categorias/nuevo")
    public String formularioRegistroCategoria(Model modelo) {
        modelo.addAttribute("categoria", new Categoria());
        return "crear_categoria";
    }

    @PostMapping("/categorias")
    public String guardarCategoria(@ModelAttribute("categoria") @Valid Categoria categoria, BindingResult resultado) {
        if(resultado.hasErrors()) {
            return "crear_categoria";
        }
        servicio.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/editar/{codigo}")
    public String mostrarFormActualizar(@PathVariable long codigo, Model modelo) {
        modelo.addAttribute("categoria", servicio.obtenerCategoriaPorId(codigo));
        modelo.addAttribute("categorias", servicio.listarTodasLasCategorias());
        return "editar_categoria";
    }

    @PostMapping("/categorias/{codigo}")
    public String actualizarCategoria(@PathVariable long codigo, @ModelAttribute("categoria") @Valid Categoria categoria, BindingResult resultado, Model modelo) {
        if(resultado.hasErrors()) {
            modelo.addAttribute("categoria", servicio.obtenerCategoriaPorId(codigo));
            modelo.addAttribute("categorias", servicio.listarTodasLasCategorias());
            return "editar_categoria";
        }
        Categoria c = servicio.obtenerCategoriaPorId(codigo);
        c.setCodigo(codigo);
        c.setNomProducto(categoria.getNomProducto());
        c.setDescripcion(categoria.getDescripcion());

        servicio.actualizarCategoria(c);

        return "redirect:/categorias";
    }

    @GetMapping("/categorias/eliminar/{codigo}")
    public String eliminarCategoria(@PathVariable long codigo) {
        servicio.eliminarCategoria(codigo);
        return "redirect:/categorias";
    }

}
