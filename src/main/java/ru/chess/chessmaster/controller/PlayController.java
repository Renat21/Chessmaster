package ru.chess.chessmaster.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.chess.chessmaster.entity.GameWithBot;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class PlayController {

    @GetMapping("/play")
    public String playChess(Model model) {
        model.addAttribute("game", new GameWithBot());
        return "chessboard";
    }
}

