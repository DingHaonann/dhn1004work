package com.kgc.controller;

import com.kgc.pojo.Goods;
import com.kgc.service.IndexService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author shkstart
 */
@Controller
public class IndexController {
    @Resource
    IndexService indexService;

    @RequestMapping("/")
    public String xiacha() {
        return "sel";
    }

    @RequestMapping("/xiacha")
    public String index(HttpServletRequest request, Model model) {
        Integer xia = Integer.parseInt(request.getParameter("xia"));
        List<Goods> xiacha = indexService.xiacha(xia);
        model.addAttribute("list", xiacha);
        return "index";
    }

    @RequestMapping("/toupd/{id}")
    public String toupd(@PathVariable Long id, Model model, HttpSession session) {
        session.setAttribute("id", id);
        Goods upd = indexService.toupd(id);
        model.addAttribute("goods", upd);
        return "upd";
    }

    @RequestMapping("/upd")
    public String upd(HttpSession session, Model model,Goods goods) {
        Long id = (Long) session.getAttribute("id");
        indexService.upd(goods, id);
        return "redirect:/";
    }
}
