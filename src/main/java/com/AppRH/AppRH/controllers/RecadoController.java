package com.AppRH.AppRH.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.AppRH.AppRH.models.Usuario;
import com.AppRH.AppRH.models.Recado;
import com.AppRH.AppRH.repository.RecadoRepository;
import com.AppRH.AppRH.repository.UsuarioRepository;

@Controller
public class RecadoController {

	private RecadoRepository rr;
	private UsuarioRepository ur;
	
	//CADASTRAR RECADO
	@RequestMapping(value = "/cadastrarRecado", method = RequestMethod.GET)
	public String form() {
		return "Recado/formRecado";
	}
	
	@RequestMapping(value = "/cadastrarRecado", method = RequestMethod.POST)
	public String form(@Valid Recado Recado, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos...");
			return "redirect:/cadastrarRecado";
		}
		
		rr.save(Recado);
		attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");
		return "redirect:/cadastrarRecado";
	}
	
}
