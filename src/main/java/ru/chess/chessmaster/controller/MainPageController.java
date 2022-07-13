package ru.chess.chessmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.chess.chessmaster.entity.GameWithBot;

@Controller
@RequestMapping({ "/", "/index" })
public class MainPageController {


    @GetMapping
    public String playChess(Model model) {
        model.addAttribute("GameWithBot", new GameWithBot());
        return "index";
    }

    @PostMapping
    public String playChessWithBot(GameWithBot GameWithBot, Model model){
        model.addAttribute("game", GameWithBot);
        System.out.println(GameWithBot);
        return "chessboard";
    }
}