package es.salesianos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

import es.salesianos.service.IWordleService;

@Controller
public class IndexController {
    @Autowired
    IWordleService wordleService;
    
    //juego
    @GetMapping("/")
    public ModelAndView wordle(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("wordle", wordleService.getWordle());
        modelAndView.addObject("longitud", wordleService.getWordle().getLongitudPalabra());
        modelAndView.addObject("lista_palabras", wordleService.getWordle().getLista_palabras());
		modelAndView.addObject("intentosPalabra", wordleService.getWordle().getLista_palabras().size());
        //Comprobar que cada letra de la palabra está en verde y, si es asi, el juego ha terminado
        if (wordleService.getWordle().getLista_palabras().size() > 0) {
			if (wordleService.getWordle().getLista_palabras().get(wordleService.getWordle().getLista_palabras().size()-1).getLista_letras().size() > 0) {
				for (int i = 0; i < wordleService.getWordle().getLista_palabras().get(wordleService.getWordle().getLista_palabras().size()-1).getLista_letras().size(); i++) {
					if (wordleService.getWordle().getLista_palabras().get(wordleService.getWordle().getLista_palabras().size()-1).getLista_letras().get(i).getColor_letra() != "bg-success") {
						break;
					}
					if (i == wordleService.getWordle().getLista_palabras().get(wordleService.getWordle().getLista_palabras().size()-1).getLista_letras().size()-1) {
						modelAndView.addObject("FinalBueno", true);
					}
				}
			}
		}
		//Si llega al numero maximo de intentos, se acaba el juego
		if (wordleService.getWordle().getLista_palabras().size() >= wordleService.getWordle().getIntentos()) {
			modelAndView.addObject("FinalMalo", true);
		}
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView wordlePost(@ModelAttribute("palabra") String palabra, ModelAndView modelAndView) {
        wordleService.wordle(palabra); //se encarga de hacer todas las funcione, coge la palabra, compureba, etc
        modelAndView.setViewName("index");
        modelAndView.addObject("wordle", wordleService.getWordle());
        modelAndView.addObject("longitud", wordleService.getWordle().getLongitudPalabra());
        modelAndView.addObject("lista_palabras", wordleService.getWordle().getLista_palabras());
		modelAndView.addObject("intentosPalabra", wordleService.getWordle().getLista_palabras().size());
        //Comprobar que cada letra de la palabra está en verde y, si es asi, el juego ha terminado
        if (wordleService.getWordle().getLista_palabras().size() > 0) {
			if (wordleService.getWordle().getLista_palabras().get(wordleService.getWordle().getLista_palabras().size()-1).getLista_letras().size() > 0) {
				for (int i = 0; i < wordleService.getWordle().getLista_palabras().get(wordleService.getWordle().getLista_palabras().size()-1).getLista_letras().size(); i++) {
					if (wordleService.getWordle().getLista_palabras().get(wordleService.getWordle().getLista_palabras().size()-1).getLista_letras().get(i).getColor_letra() != "bg-success") {
						break;
					}
					if (i == wordleService.getWordle().getLista_palabras().get(wordleService.getWordle().getLista_palabras().size()-1).getLista_letras().size()-1) {
						modelAndView.addObject("FinalBueno", true);
					}
				}
			}
		}
		//Si llega al numero maximo de intentos, se acaba el juego
		if (wordleService.getWordle().getLista_palabras().size() >= wordleService.getWordle().getIntentos()) {
			modelAndView.addObject("FinalMalo", true);
		}
        return modelAndView;
    }

    //busqueda intentos
    @GetMapping("/BuscarIntento")
	public ModelAndView searchTry(ModelAndView modelAndView) {
		modelAndView.setViewName("buscarIntento");
		modelAndView.addObject("intentos", wordleService.getWordle().getLista_palabras().size()); //largura de la lista
		modelAndView.addObject("longitud", wordleService.getWordle().getLongitudPalabra());
        if (wordleService.getWordle().getLista_palabras().size() > 1) {
			modelAndView.addObject("intento", 1);
			modelAndView.addObject("buscarIntento", wordleService.getWordle().getLista_palabras().get(0).getLista_letras());
		}
		return modelAndView;
	}

	@PostMapping("/BuscarIntento")
	public ModelAndView searchTryPost(@ModelAttribute("intento") int intentoBusqueda, ModelAndView modelAndView) {
		modelAndView.setViewName("buscarIntento");
		modelAndView.addObject("longitud", wordleService.getWordle().getLongitudPalabra());
        modelAndView.addObject("buscarIntento", wordleService.getWordle().getLista_palabras().get(intentoBusqueda - 1).getLista_letras());
		modelAndView.addObject("intentos", wordleService.getWordle().getLista_palabras().size()); //largura de la lista
		modelAndView.addObject("intento", intentoBusqueda);
		return modelAndView;
	}
    
	//Reset de la partida
	@GetMapping("/Reset")
	public String reset() {
		wordleService.getWordle().getLista_palabras().clear();
		return "redirect:/";
	}

    
}
